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
	
	
	//Ĭ�ϻ���Ϊ"Ǧ��"
	public String command = "Ǧ��";
	public int idd;
	public DrawingFrame(int idd) {
		this.idd=idd;
		
		// TODO �Զ����ɵĹ��캯�����
	}
	//��������
	public void showUI(){
		
		//��ӱ�ǩ
		JLabel jl=new JLabel();
		jl.setBounds(20, 10, 100, 20);
		jl.setText("���1������");
		this.add(jl);
		
		JLabel jl2=new JLabel();
		jl2.setBounds(120, 10, 100, 20);
		jl2.setText("0");
		this.add(jl2);
		
		JLabel jl3=new JLabel();
		jl3.setBounds(220, 10, 100, 20);
		jl3.setText("���2������");
		this.add(jl3);
		
		JLabel jl4=new JLabel();
		jl4.setBounds(320, 10, 100, 20);
		jl4.setText("0");
		this.add(jl4);
		
		JLabel jl5=new JLabel();
		jl5.setBounds(420, 10, 100, 20);
		jl5.setText("�ֵ���ң�");
		this.add(jl5);
		
		JLabel jl6=new JLabel();
		jl6.setBounds(520, 10, 100, 20);
		jl6.setText("1");
		this.add(jl6);
		
		JLabel jl7=new JLabel();
		jl7.setBounds(620, 10, 100, 20);
		jl7.setText("������Ŀ��");
		this.add(jl7);
		
		JLabel jl8=new JLabel();
		jl8.setBounds(720, 10, 100, 20);
		jl8.setText("��");
		this.add(jl8);
		
		JLabel jl9=new JLabel();
		jl9.setBounds(620, 40, 100, 20);
		jl9.setText("ʣ��ʱ�䣺");
		this.add(jl9);
		
		JLabel jl10=new JLabel();
		jl10.setBounds(720, 40, 100, 20);
		jl10.setText("5");
		this.add(jl10);
		
		JButton jb=new JButton();
		jb.setBounds(0, 40, 100, 20);
		jb.setText("���1�ӷ�");
		this.add(jb);
		
		JLabel light1 = new JLabel("");
		light1.setBounds(20, 80, 740, 460);
		light1.setOpaque(true);  //�˾����ص㣬���ñ�����ɫ�����Ƚ�������Ϊ��͸���ģ���ΪĬ����͸���ġ�����

		//light1.setBackground(Color.WHITE);
		this.add(light1);
		
		
		DrawingFrame that=this;
		
		
		
		jb.addActionListener(new ActionListener() {
			int p1grade=0;//���һ����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				
				light1.getGraphics().clearRect(0, 0, 740, 460);
				Image background;
				try {
					background = ImageIO.read(new FileInputStream("img\\timg.jpg"));
					light1.getGraphics().drawImage(background,0,0,740,460,null);
				} catch (FileNotFoundException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
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
			int p2grade=0;//��Ҷ�����
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				light1.getGraphics().clearRect(0, 0, 740, 460);
				
				Image background;
				try {
					background = ImageIO.read(new FileInputStream("img\\timg.jpg"));
					light1.getGraphics().drawImage(background,0,0,740,460,null);
				} catch (FileNotFoundException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				
				
				//that.getGraphics().clearRect(0,100,800,600);
				p2grade++;
				jl4.setText(String.valueOf(p2grade));
				int id=Mysql.exec("UPDATE gameresult SET drawres2 = "+p2grade+" WHERE id = "+that.idd);
				
				
			}
			
		});
		jb2.setBounds(120, 40, 100, 20);
		jb2.setText("���2�ӷ�");
		this.add(jb2);
		
		JButton jb3=new JButton();
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				that.setVisible(false);
				new GameRes(idd);
			}
			
		});
		jb3.setBounds(280, 40, 200, 20);
		jb3.setText("������Ϸ���н���");
		this.add(jb3);
		
		
		JButton jb4=new JButton();
		
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				light1.getGraphics().clearRect(0, 0, 740, 460);
				Image background;
				try {
					background = ImageIO.read(new FileInputStream("img\\timg.jpg"));
					light1.getGraphics().drawImage(background,0,0,740,460,null);
				} catch (FileNotFoundException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				
				new Thread() {
					int tim=60;//ʣ��ʱ��
					int player=1;//���
					int count=1;//������¼
					public void run() {
						
						
						while(true) {
							if(count==1) {
								jl8.setText("��");
							}
							if(count==2) {
								jl8.setText("�ں�");
							}
							if(count==3) {
								jl8.setText("���Ǻ�«");
							}
							if(count==4) {
								jl8.setText("��");
							}
							if(count==5) {
								that.setVisible(false);
								new GameRes(idd);
								break;
							}
							
							jl10.setText(String.valueOf(tim));
							tim--;
							if(tim<55&&tim>5) {
								jl8.setText("��Ŀ����");
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
								// TODO �Զ����ɵ� catch ��
								e.printStackTrace();
							}
						}
						
						
					}
				}.start();
			}
			
		});
		jb4.setBounds(500, 40, 100, 20);
		jb4.setText("��ʼ��Ϸ");
		this.add(jb4);
		
		
		
		
		
		
		
		
		
		
		
		
		
		//�޲���
		this.setLayout(null);
	
		//��ť�������ڲ��ࣩ
		ActionListener action_listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
						command = e.getActionCommand();					
			}			
		};			
	
		

		
		//���ô���
		this.setSize(800, 600);
		this.setTitle("�㻭�Ҳ�");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		//���ô��ڿɼ�
		this.setVisible(true);
		
		
		
		
		
		//��궯�������� & ��ק��
		MouseAdapter ma = new MyMouseAdapter(this);
		this.addMouseListener(ma);
		this.addMouseMotionListener(ma);
		
		
							
	}		
}
