package com.sf.minesweeper.dialog;
//Download by http://www.codefans.net
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sf.minesweeper.bean.Own;
import com.sf.minesweeper.frame.SartFrame;
import com.sf.minesweeper.tools.Tools;

import main.Mysql;

public class Win extends JDialog {
	SartFrame sartFrame;
	private JTextField text;
	TreeSet<Own> LOWER = new TreeSet<Own>();
	TreeSet<Own> MIDDLE = new TreeSet<Own>();
	TreeSet<Own> HEIGHT = new TreeSet<Own>();
	
	public Win(SartFrame sartFrame){
		this.sartFrame = sartFrame;
		//this.setTitle("��ʾ��");
		//this.setLocationRelativeTo(null);
		//this.setSize(200, 150);
		//this.init();
		//this.setVisible(true);
		if(sartFrame.flag==1) {
			System.out.print("���1ʤ��");
			int id=Mysql.exec("UPDATE gameresult SET mineres1 = "+Tools.ti+" WHERE id = "+sartFrame.idd);
			
			System.out.print(id);
		}
		
		if(sartFrame.flag==2) {
			System.out.print("���2ʤ��");
			int id=Mysql.exec("UPDATE gameresult SET mineres2 = "+Tools.ti+" WHERE id = "+sartFrame.idd);
		}
		
	}

	private void init() {
		// TODO Auto-generated method stub
		/**
		 * ��ż���
		 * 
		 */
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,1));
		JLabel label = new JLabel("��������Ĵ���");
		
		panel.add(label);
		
		text = new JTextField();
		panel.add(text);
		//times = sartFrame.getTimer().getTimes();
		JLabel labTime = new JLabel("����ʹ�õ�ʱ�䣺"+Tools.time);
		panel.add(labTime);
		
		JButton butys = new JButton("����");
		butys.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub
				if(Tools.currentLevel.equals("����")){
					if(Tools.time1>=Tools.time){
						Tools.time1 = Tools.time;
						Tools.name1=text.getText();
					}
				}
				if(Tools.currentLevel.equals("�м�")){				
					if(Tools.time2>=Tools.time){
						Tools.time2= Tools.time;
						Tools.name2=text.getText();
					}
				}
				if(Tools.currentLevel.equals("�߼�")){				
					if(Tools.time3>=Tools.time){
						Tools.time3 = Tools.time;
						Tools.name3=text.getText();
					}
				}
				
				Win.this.dispose();
				
			}
		});
		panel.add(butys);
		this.add(panel);
		
	}
	public JTextField getText() {
		return text;
	}

}

