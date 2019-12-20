package otherscene;

import javax.swing.*;

import scene.Client;
import scene.Record;
import scene.Scene;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;


public class Otherscene extends JPanel implements ActionListener,KeyListener{
	public int iAim=0;
	public int iMoney=0;
	public int iTime=60;
	public int iCount=1;
	public int iMoney1=0;
	public int iMoney2=0;
	public int gameState=1;//0:玩游戏状态 1:不玩游戏状态
	public Integer Thcount=0;
	public File filesingle=new File("filesingle2.txt");
	public File fileteam=new File("fileteam.txt");
	public TreeSet<Record> treesingle=new TreeSet<Record>();
	public TreeSet<Record> treeteam=new TreeSet<Record>();
	public boolean flag=false;
	
	boolean start_flag=false;
	Thing2[] bonus;//至少14: 5 个黄金，4 个石头，3 个干扰物和 2 个”?”口袋
	boolean[] is_exist;
	int amount;
	JButton start=new JButton("开始");
	JLabel jlAim=new JLabel("目标钱数: "+iAim);
	JLabel jlMoney=new JLabel("共获金钱: "+iMoney);
	JLabel jlTime=new JLabel("剩余时间: "+iTime);
	JLabel jlMoney_1=new JLabel("$"+iMoney1);
	JLabel jlMoney_2=new JLabel("$"+iMoney2);

	JLabel[] jlscore=new JLabel[5];
	JLabel[] jlteam=new JLabel[5];

	JButton jlstop=new JButton("暂停");
	JLabel jstop=new JLabel("对方暂停");

	JLabel jp2=new JLabel("玩家二：");
	JLabel jp1=new JLabel("玩家一：");
	JButton jn=new JButton("下一关");
	JButton je=new JButton("退出");
	
	Timer timer;
	Server server;
	//Music music;
	int hook1flag=0;
	int hook2flag=0;
	Hook Hhook1;
	Hook Hhook2;
	
	int[] pigNum;
	int pigCount;
	Pig Tp;
	double v=1;
	public int idd;

	public Otherscene(int id) throws Exception{
		this.idd=id;
		JFrame myframe=new JFrame();
		myframe.setTitle("黄金矿工-server");
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myframe.setContentPane(this);
		this.setLayout(null);
		this.setOpaque(false);
		
		ImageIcon bg=new ImageIcon("主界面.PNG");
		JLabel label=new JLabel(bg);
		label.setBounds(-3,-3,bg.getIconWidth(),bg.getIconHeight());
		myframe.getLayeredPane().add(label,new Integer(-30001));
		myframe.setBounds(0, 0, bg.getIconWidth()+11,bg.getIconHeight()+30);
		
		jlAim.setBounds(5, 10, 100, 30);
		jlMoney.setBounds(5, 50, 100, 30);
		jlTime.setBounds(120,10,100,30);
	
		jlstop.setBounds(610, 20,80,20);
		jlstop.addActionListener(this);
		jstop.setBounds(610, 20,160,20);
		jlMoney_1.setBounds(305,90,100,20);
		jlMoney_1.setFont(new Font("隶书",Font.BOLD,20));
		jlMoney_2.setBounds(490,90,100,20);
		jlMoney_2.setFont(new Font("隶书",Font.BOLD,20));
		jp1.setBounds(300,110,400,50);
		jp1.setFont(new Font("隶书",Font.BOLD,20));
		jp2.setBounds(490,110,400,50);
		jp2.setFont(new Font("隶书",Font.BOLD,20));
		jn.setBounds(290,200,120,50);
		jn.setFont(new Font("隶书",Font.BOLD,20));
		jn.addActionListener(this);
		je.setBounds(490,200,120,50);
		je.setFont(new Font("隶书",Font.BOLD,20));
		je.addActionListener(this);
	
		je.setFont(new Font("隶书",Font.BOLD,20));
		
		start.setBounds(300,300, 80, 40);
		this.add(start);
		start.addActionListener(this);
		//start_flag=true;
		
		//this.remove(start);
		for(int i=0;i<5;i++) {
			jlscore[i]=new JLabel();
			jlteam[i]=new JLabel();
			jlscore[i].setBounds(50, 250+i*15, 300, 300);
			jlteam[i].setBounds(400, 250+i*15, 300, 300);
		}
		this.addKeyListener(this);
		this.add(jlAim);
		this.add(jlMoney);
		this.add(jlTime);
	
		this.add(jlstop);
		this.add(jlMoney_1);
		this.add(jlMoney_2);
		
		read();
		//myframe.setVisible(true);
		
		start_flag=true;
		while(!start_flag) System.out.println("&&&&&");
		
		server=new Server(this);
		
		server.start();
		
		this.start();
		
		//
		//music=new Music();
	    //music.play(this);
		
		timer=new Timer();
		timer.schedule(new TimerTask() {
			int a=-1;
			public void run() {
				if(gameState==0) {
					//try{server.sendhook();}catch(Exception e) {}
					a++;
					if(a==4) {
						a=0;
						iTime--;
					    //if(iTime==-1) { gameState=1;try{server.sendexit();}catch(Exception e) {}}
					    if(gameState==0) jlTime.setText("剩余时间: "+iTime);
					}
				}
			}
		},0,250);
		
		
		
		while(true) {
			if(gameState==0) {
				this.requestFocus();
				repaint();
			}
			else if(gameState==1){
				//music.stop();
				clear();
				if(iAim<=iMoney) { 
					
					iCount++;
				}
				else { 
					
					setrecord();
					display();
					jn.setText("重来");
					iCount=1;
					iMoney=iMoney1=iMoney2=0;
					iAim=0;
				}
			
				this.remove(jlstop);
				
				this.add(jp1);
				this.add(jp2);
				this.add(je);
				this.add(jn);
				//music.chainstop();
				repaint();
				while(gameState!=0){ try{Thread.sleep(20);}catch(Exception e) {}}
				this.start();
				//music.start();
			}
			//else music.chainstop();
			try {Thread.sleep(5);}catch(Exception e) {};
		}
	}
	
	public void paintComponent(Graphics g) {//画钩子和线
		if(gameState==0 && hook1flag==1 && hook2flag==1) {
			g.drawLine(Hhook1.hookPos[0], Hhook1.hookPos[1], Hhook1.hookPos[2]+10, Hhook1.hookPos[3]+2);
			g.drawLine(Hhook2.hookPos[0], Hhook2.hookPos[1], Hhook2.hookPos[2]+10, Hhook2.hookPos[3]+2);
		}
	}
	
	public void start() {
		gameState=0;
		Tp=new Pig(this);
		Tp.start();
		Hhook1=new Hook(1,this);
		Hhook2=new Hook(2,this);
		Hhook1.start();
		Hhook2.start();
	}
	
	public void clear(){
		while(Thcount>0){
			try {Thread.sleep(100);}catch(Exception e) {};
		}
		for(int i=0;i<amount;i++) {
			if(is_exist[i]) remove(bonus[i].a);
		}
		remove(Hhook1.jlHook);
		remove(Hhook2.jlHook);
		if(Hhook1.hookPos[4]!=-1) remove(bonus[Hhook1.hookPos[4]].a);
		if(Hhook2.hookPos[4]!=-1) remove(bonus[Hhook2.hookPos[4]].a);
		this.repaint();
	}
	
	public void restart() {
		iTime=60;
		jlMoney.setText("共获金钱: "+iMoney);
		jlTime.setText("剩余时间: "+iTime);
		jlMoney_1.setText("$"+iMoney1);
		jlMoney_2.setText("$"+iMoney2);
	
		jp1.setText("玩家一：");
		jp2.setText("玩家二：");
		repaint();
	}
	
	public void read() {
		String str="";
		try {
			Scanner in=new Scanner(filesingle);
			while(in.hasNext()) {
				str=in.nextLine();
				treesingle.add(new Record(str));
			}
			in.close();
		}
		catch(Exception e) {}
		try {
			Scanner in=new Scanner(fileteam);
			while(in.hasNext()) {
				str=in.nextLine();
				treeteam.add(new Record(str));
			}
			in.close();
		}
		catch(Exception e) {}
	}
	
	public void setrecord() {
		Record single=new Record(iMoney1);
		Record team=new Record(iMoney);
		treesingle.add(single);
		treeteam.add(team);
		String str="";
		try {
			PrintStream out=new PrintStream(filesingle);
			for(Record word:treesingle)
				str+=word.getstring()+'\n';
			out.print(str);
			out.close();
		}
		catch(Exception e) {}
	}
	
	public void display() {
	
		String str="";
		int i=0;
		for(Record word:treesingle) {
			jlscore[i].setText(word.other);
			this.add(jlscore[i]);
			i++;
			if(i==5) break;
		}
		str="";
		while(i<5) {
			jlscore[i].setText("");
			this.add(jlscore[i]);
			i++;
		}
		i=0;
		for(Record word:treeteam) {
			jlteam[i].setText(word.other);
			this.add(jlteam[i]);
			i++;
			if(i==5) break;
		}
		while(i<5) {
			jlteam[i].setText("");
			this.add(jlteam[i]);
			i++;
		}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("退出本关")) {
			gameState=1;
			//try{server.sendexit();}catch(Exception e1) {}
		}
		else if(e.getActionCommand().equals("退出")) {
			//try{server.sendchoice(true);}catch(Exception w) {};
			if(jn.getText().equalsIgnoreCase("下一关")) {
				System.out.println("9898");
				display();
				this.repaint();
				Timer time=new Timer();
				time.schedule(new TimerTask() {
					int a=0;
					public void run() {
						a++;
						if(a==4) {
							System.exit(0);
						}
					}
				},0,1000);
			}
			else System.exit(0);
		}
		else if(e.getActionCommand().equalsIgnoreCase("暂停")) {
			gameState=2;
			//try{server.sendstop();}catch(Exception e2) {}
			jlstop.setText("继续");
		}
		else if(e.getActionCommand().equals("继续")) {
			//try{server.sendcontinue();}catch(Exception e2) {}
			jlstop.setText("暂停");
			gameState=0;
		}
		else if(e.getActionCommand().equals("下一关") || e.getActionCommand().equals("重来")) {
			if(jp2.getText().equalsIgnoreCase("玩家二：选择继续")) { 
				//try{server.sendchoice(false);}catch(Exception w) {};
				
				this.remove(je);
				this.remove(jp1);
				this.remove(jp2);
				this.remove(jn);
		
				this.add(jlstop);
				if(e.getActionCommand().equals("重来")) { 
			
					for(int i=0;i<5;i++) {
						remove(jlscore[i]);
						remove(jlteam[i]);
					}
				}
				restart();
				gameState=2;
			}
			else {
				//try{server.sendchoice(false);}catch(Exception w) {};
				jp1.setText("玩家一：选择继续");
			}
		}
		else if(e.getActionCommand().equals("开始")) {
			start_flag=true;
			this.remove(start);
			
		}
		else;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_DOWN && Hhook1.state_hook==0) {
			//music.playonce();
			Hhook1.state_hook=1;
		}
	
		if(e.getKeyCode()==KeyEvent.VK_W && Hhook2.state_hook==0) {
			//music.playonce();
			Hhook2.state_hook=1;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
