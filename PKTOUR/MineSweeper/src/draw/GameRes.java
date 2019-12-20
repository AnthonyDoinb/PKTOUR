package draw;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sf.minesweeper.frame.SartFrame;
import com.sf.minesweeper.tools.Tools;

import main.Mysql;
import otherscene.Otherscene;
import scene.Scene;

public class GameRes {

	
	
	public GameRes(int idd) {
		Mysql.getConnection();
		
		
		JFrame jf=new JFrame();
		//�޲���
		jf.setLayout(null);
		
		//���ô���
		jf.setSize(800, 600);
		jf.setTitle("��Ϸ���");
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);
		
		//��ӱ�ǩ
		JLabel jl=new JLabel();
		jl.setBounds(20, 10, 200, 20);
		jl.setText("���1ɨ�׷�����");
		
		
		JLabel jl2=new JLabel();
		jl2.setBounds(220, 10, 200, 20);
		
		String res2=Mysql.getRes("SELECT * FROM gameresult WHERE id="+idd,"mineres1");
		if(!"".equals(res2))
			jl2.setText(res2);
		else
			jl2.setText("0");
		
		//��ӱ�ǩ
		JLabel jl3=new JLabel();
		jl3.setBounds(20, 60, 200, 20);
		jl3.setText("���2ɨ�׷�����");

		
		JLabel jl4=new JLabel();
		jl4.setBounds(220, 60, 200, 20);
		
		String res4=Mysql.getRes("SELECT * FROM gameresult WHERE id="+idd,"mineres2");
		if(!"".equals(res4))
			jl4.setText(res4);
		else
			jl4.setText("0");

		
		//��ӱ�ǩ
		JLabel jl5=new JLabel();
		jl5.setBounds(20, 110, 200, 20);
		jl5.setText("���1�ƽ�󹤷�����");

		
		JLabel jl6=new JLabel();
		jl6.setBounds(220, 110, 200, 20);
		String res6=Mysql.getRes("SELECT * FROM gameresult WHERE id="+idd,"goldres1");
		
		if(!"".equals(res6))
			jl6.setText(res6);
		else
			jl6.setText("0");

		
		//��ӱ�ǩ
		JLabel jl7=new JLabel();
		jl7.setBounds(20, 170, 200, 20);
		jl7.setText("���2�ƽ�󹤷�����");

		
		JLabel jl8=new JLabel();
		jl8.setBounds(220, 170, 200, 20);
		
		String res8=Mysql.getRes("SELECT * FROM gameresult WHERE id="+idd,"goldres2");
		if(!"".equals(res8))
			jl8.setText(res8);
		else
			jl8.setText("0");

		
		//��ӱ�ǩ
		JLabel jl9=new JLabel();
		jl9.setBounds(20, 220, 200, 20);
		jl9.setText("���1�㻭�Ҳ·�����");

		
		JLabel jl10=new JLabel();
		jl10.setBounds(220, 220, 200, 20);
		
		String res10=Mysql.getRes("SELECT * FROM gameresult WHERE id="+idd,"drawres1");
		if(!"".equals(res10))
			jl10.setText(res10);
		else
			jl10.setText("0");

		
		//��ӱ�ǩ
		JLabel jl11=new JLabel();
		jl11.setBounds(20, 270, 200, 20);
		jl11.setText("���2�㻭�Ҳ·�����");

		
		JLabel jl12=new JLabel();
		jl12.setBounds(220, 270, 200, 20);
		
		String res12=Mysql.getRes("SELECT * FROM gameresult WHERE id="+idd,"drawres2");
		if(!"".equals(res12))
			jl12.setText(res12);
		else
			jl12.setText("0");
		
		
		if("".equals(res2)||res2==null)
			res2="0";
		if("".equals(res4)||res4==null)
			res4="0";
		if("".equals(res6)||res6==null)
			res6="0";
		if("".equals(res8)||res8==null)
			res8="0";
		if("".equals(res10)||res10==null)
			res10="0";
		if("".equals(res12)||res12==null)
			res12="0";
		
		//��ӱ�ǩ
		JLabel jl13=new JLabel();
		jl13.setBounds(20, 320, 200, 20);
		jl13.setText("���1�ܷ֣�");

		
		JLabel jl14=new JLabel();
		jl14.setBounds(220, 320, 200, 20);
		

		jl14.setText(String.valueOf(Integer.valueOf(res2)+Integer.valueOf(res6)+Integer.valueOf(res10)));
		
		//��ӱ�ǩ
		JLabel jl15=new JLabel();
		jl15.setBounds(20, 370, 200, 20);
		jl15.setText("���2�ܷ֣�");

		
		JLabel jl16=new JLabel();
		jl16.setBounds(220, 370, 200, 20);
		jl16.setText(String.valueOf(Integer.valueOf(res4)+Integer.valueOf(res8)+Integer.valueOf(res12)));
		
		
		
		
		jf.add(jl);
		jf.add(jl2);
		jf.add(jl3);
		jf.add(jl4);
		jf.add(jl5);
		jf.add(jl6);
		jf.add(jl7);
		jf.add(jl8);
		jf.add(jl9);
		jf.add(jl10);
		jf.add(jl11);
		jf.add(jl12);
		jf.add(jl13);
		jf.add(jl14);
		jf.add(jl15);
		jf.add(jl16);

		
		//���ô��ڿɼ�
		jf.setVisible(true);
				
	}
	
	
	
}
