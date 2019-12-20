package com.sf.minesweeper.frame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

import com.sf.minesweeper.menu.MineMenu;
import com.sf.minesweeper.panel.MineField;
import com.sf.minesweeper.panel.MineState;
import com.sf.minesweeper.timer.Timers;
import com.sf.minesweeper.tools.Tools;

import main.Mysql;
import otherscene.Otherscene;
import scene.Scene;

public class SartFrame extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1585043387266273492L;
	/**
	 * @param args
	 */

	private MineState mineState; // 记雷数
	private MineField mineField,mineField2; // 布置labble和雷数
	private MineMenu mineMenu;
	private Timer timer;
	private Timers timers;
	/**
	 * 游戏是否开始
	 */
	private boolean isStart;
	JLabel jLabel_start = new JLabel(); // 开始图片

	public int flag;
	public int idd;
	public SartFrame(int i, int id) {
		this.flag=i;		//this.setSize(500,500);
		this.idd=id;	
		//改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		//this.setTitle("扫雷");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLocationRelativeTo(null);
		//setIconImage(Tools.iicon); // 利用tools来做的作法

		//this.setResizable(false); // 这样让窗口不会可放大
		
		
		// ..................状态栏.....................
		mineState = new MineState(this);
		this.add(mineState, BorderLayout.NORTH);

		
		// ...................雷区1......................
		mineField = new MineField(this);
		this.add(mineField, BorderLayout.CENTER);

		
		

		//jLabel_start.setIcon(Tools.start);
		//this.add(jLabel_start, BorderLayout.CENTER);

		// ....................菜单栏................
		//mineMenu = new MineMenu(this);
		//this.setJMenuBar(mineMenu);
		
		// .....................时间................
	
		Tools.time = 0;
		Tools.time11 = 0;
		timers = new Timers(mineState,flag);
		timer = new Timer(1000, timers);
		
		

		// ...................声音...................
//		AudioClip s1=loadSound("alarm1.wav");                           //AudioClip类的对象s1通过方法 loadSound()装载声音
//		public AudioClip loadSound(String filename){                        //返回一个AudioClip对象
//		   URL url=null;                                                                   //因为newAudioClip()的参数为URL型
//		   try{
//		    url=new URL("file:"+filename);                                //指定文件，“file:"不能少
//		   }
//		   catch(MalformedURLException e){ }
//		   return Applet.newAudioClip(url);                           //通过newAudioClip( )方法装载声音，此方法为JDK后添加的方法，太老的JDK里可能没有
//		}
//
//		
//		
//		
		//pack();
		//this.setVisible(true);
	}



	// 重新布局
	public void restart() {

		this.remove(mineState);

		this.remove(mineField);

		this.remove(jLabel_start);
		
		

		// ..................状态栏.....................
		mineState = new MineState(this);
		this.add(mineState, BorderLayout.NORTH);
		

		
		// ...................雷区......................
		mineField = new MineField(this);
		this.add(mineField, BorderLayout.CENTER);

		
		// .....................时间................
		Tools.time = 0;
		Timers timers = new Timers(mineState,flag);
		timer = new Timer(1000, timers);
		
		
		//pack();
		validate();//刷新窗体
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public MineState getMineState() {
		return mineState;
	}



	public MineField getMineField() {
		return mineField;
	}



	public MineMenu getMineMenu() {
		return mineMenu;
	}



	public Timer getTimer() {
		return timer;
	}



	public Timers getTimers() {
		return timers;
	}

	
	
	

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
	
	
	
	public static void main(String[] args) {
		
		Mysql.getConnection();
		int id=Mysql.exec("INSERT INTO gameresult ( username1,username2 ) VALUE ( '玩家1','玩家2' )");
		
	
		
		JPanel a=new SartFrame(1,id);
		JPanel b=new SartFrame(2,id);
		JFrame w=new JFrame();
		w.setLayout(null);
		w.setSize(800, 600);
		a.setBounds(200, 0, 200, 300);
		b.setBounds(400, 0, 200, 300);
		w.add(a);
		w.add(b);
		w.setVisible(true);
		
		Button btn=new Button();
		btn.setLabel("下个游戏");
		btn.setBounds(350, 400, 100, 50);
		
		JLabel ja=new JLabel();
		ja.setText("时间：");
		ja.setBounds(350, 350, 100, 50);
		
		JLabel sj=new JLabel();
		
		sj.setBounds(400, 350, 100, 50);
		
		
		btn.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				w.setVisible(false);
				new Thread() {
					public void run() {
						try {
							Otherscene jpScene=new Otherscene(id);
							
							
						} catch (Exception e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
						
					}
					
					
				}.start();
				
				new Thread() {
					public void run() {
						try {
							Scene jpScene1=new Scene(id);
							
							
						} catch (Exception e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
						
					}
					
					
				}.start();
			}
			
		});
		
		w.add(btn);
		
		w.add(ja);
		w.add(sj);
		
		new Thread() {
		
			public void run() {
				
				while(true) {
					try {
						sleep(1000);
						sj.setText(String.valueOf(Tools.ti));
						Tools.ti++;
					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					
				}
			}
			
			
		}.start();
	}
	
	
	
	

	
	
}
