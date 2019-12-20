package draw;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import main.Mysql;

import java.awt.*;

public class DrawingFrame extends JFrame{
	
	
	//默认画笔为"铅笔"
	public String command = "铅笔";
	public int idd;
	public DrawingFrame(int idd) {
		this.idd=idd;
		
		// TODO 自动生成的构造函数存根
	}
	//创建窗口
	public void showUI(){
		
		//添加标签
		JLabel jl=new JLabel();
		jl.setBounds(20, 10, 100, 20);
		jl.setText("玩家1分数：");
		this.add(jl);
		
		JLabel jl2=new JLabel();
		jl2.setBounds(120, 10, 100, 20);
		jl2.setText("0");
		this.add(jl2);
		
		JLabel jl3=new JLabel();
		jl3.setBounds(220, 10, 100, 20);
		jl3.setText("玩家2分数：");
		this.add(jl3);
		
		JLabel jl4=new JLabel();
		jl4.setBounds(320, 10, 100, 20);
		jl4.setText("0");
		this.add(jl4);
		
		JLabel jl5=new JLabel();
		jl5.setBounds(420, 10, 100, 20);
		jl5.setText("轮到玩家：");
		this.add(jl5);
		
		JLabel jl6=new JLabel();
		jl6.setBounds(520, 10, 100, 20);
		jl6.setText("1");
		this.add(jl6);
		
		JLabel jl7=new JLabel();
		jl7.setBounds(620, 10, 100, 20);
		jl7.setText("本轮题目：");
		this.add(jl7);
		
		JLabel jl8=new JLabel();
		jl8.setBounds(720, 10, 100, 20);
		jl8.setText("狗");
		this.add(jl8);
		
		JLabel jl9=new JLabel();
		jl9.setBounds(620, 40, 100, 20);
		jl9.setText("剩余时间：");
		this.add(jl9);
		
		JLabel jl10=new JLabel();
		jl10.setBounds(720, 40, 100, 20);
		jl10.setText("5");
		this.add(jl10);
		
		JButton jb=new JButton();
		jb.setBounds(0, 40, 100, 20);
		jb.setText("玩家1加分");
		this.add(jb);
		
		JLabel light1 = new JLabel("");
		light1.setBounds(20, 80, 740, 460);
		light1.setOpaque(true);  //此句是重点，设置背景颜色必须先将它设置为不透明的，因为默认是透明的。。。

		//light1.setBackground(Color.WHITE);
		this.add(light1);
		
		
		DrawingFrame that=this;
		
		
		
		jb.addActionListener(new ActionListener() {
			int p1grade=0;//玩家一分数
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				light1.getGraphics().clearRect(0, 0, 740, 460);
				Image background;
				try {
					background = ImageIO.read(new FileInputStream("img\\timg.jpg"));
					light1.getGraphics().drawImage(background,0,0,740,460,null);
				} catch (FileNotFoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				//that.getGraphics().clearRect(0,100,800,600);
				p1grade++;
				jl2.setText(String.valueOf(p1grade));
				int id=Mysql.exec("UPDATE gameresult SET drawres1 = "+p1grade+" WHERE id = "+that.idd);
				
				
			}
			
		});
		
		JButton jb2=new JButton();
		
		jb2.addActionListener(new ActionListener() {
			int p2grade=0;//玩家二分数
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				light1.getGraphics().clearRect(0, 0, 740, 460);
				
				Image background;
				try {
					background = ImageIO.read(new FileInputStream("img\\timg.jpg"));
					light1.getGraphics().drawImage(background,0,0,740,460,null);
				} catch (FileNotFoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				
				//that.getGraphics().clearRect(0,100,800,600);
				p2grade++;
				jl4.setText(String.valueOf(p2grade));
				int id=Mysql.exec("UPDATE gameresult SET drawres2 = "+p2grade+" WHERE id = "+that.idd);
				
				
			}
			
		});
		jb2.setBounds(120, 40, 100, 20);
		jb2.setText("玩家2加分");
		this.add(jb2);
		
		JButton jb3=new JButton();
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				that.setVisible(false);
				new GameRes(idd);
			}
			
		});
		jb3.setBounds(280, 40, 200, 20);
		jb3.setText("结束游戏进行结算");
		this.add(jb3);
		
		
		JButton jb4=new JButton();
		
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				light1.getGraphics().clearRect(0, 0, 740, 460);
				Image background;
				try {
					background = ImageIO.read(new FileInputStream("img\\timg.jpg"));
					light1.getGraphics().drawImage(background,0,0,740,460,null);
				} catch (FileNotFoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				new Thread() {
					int tim=60;//剩余时间
					int player=1;//玩家
					int count=1;//次数记录
					public void run() {
						
						
						while(true) {
							if(count==1) {
								jl8.setText("狗");
							}
							if(count==2) {
								jl8.setText("口红");
							}
							if(count==3) {
								jl8.setText("冰糖葫芦");
							}
							if(count==4) {
								jl8.setText("火车");
							}
							if(count==5) {
								that.setVisible(false);
								new GameRes(idd);
								break;
							}
							
							jl10.setText(String.valueOf(tim));
							tim--;
							if(tim<55&&tim>5) {
								jl8.setText("题目隐藏");
							}
							
							if(tim==0) {
								count++;
								tim=60;
								if(player==1)
									player=2;
								else if(player==2)
									player=1;
								jl6.setText(String.valueOf(player));
							}
								
							try {
								sleep(1000);
							} catch (InterruptedException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
						}
						
						
					}
				}.start();
			}
			
		});
		jb4.setBounds(500, 40, 100, 20);
		jb4.setText("开始游戏");
		this.add(jb4);
		
		
		
		
		
		
		
		
		
		
		
		
		
		//无布局
		this.setLayout(null);
	
		//按钮侦听（内部类）
		ActionListener action_listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
						command = e.getActionCommand();					
			}			
		};			
	
		

		
		//设置窗口
		this.setSize(800, 600);
		this.setTitle("你画我猜");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		//设置窗口可见
		this.setVisible(true);
		
		
		
		
		
		//鼠标动作（侦听 & 拖拽）
		MouseAdapter ma = new MyMouseAdapter(this);
		this.addMouseListener(ma);
		this.addMouseMotionListener(ma);
		
		
							
	}		
}
