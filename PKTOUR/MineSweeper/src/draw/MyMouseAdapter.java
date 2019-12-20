package draw;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

//�̳г�����MouseAdapter
public class MyMouseAdapter extends MouseAdapter{
	private Graphics g;
	private String command;
	private int x1,x2,y1,y2;
	private int flag = 0;	
	DrawingFrame df;	
	
	//���췽��������DrawingFrame����
	public MyMouseAdapter(DrawingFrame df){
		this.df = df; 				   
		//��������
		g = df.getGraphics();	
		
		
	}

	//��갴��
	public void mousePressed(MouseEvent e) {
		//�õ���갴��ʱ������
		x1 = e.getX();
		y1 = e.getY();
		flag = 0;			//ʵ��Ǧ��ʹ�õı�־λ	
	}
	//����ͷ�
	public void mouseReleased(MouseEvent e) {
		//�õ�����ͷ�ʱ������		
		x2 = e.getX();
		y2 = e.getY();	
		flag = 0;			//ʵ��Ǧ��ʹ�õı�־λ	
		//��ȡ��ťֵ
		this.command = df.command;	
		 						
	}			
	//�����ק����갴�²��ƶ�ʱ�����ϴ�����ֱ������ͷţ�
	public void mouseDragged(MouseEvent e){
		//��ȡ��ťֵ
		this.command = df.command;
		//Ǧ��
	  if("Ǧ��".equals(command)){	
	  	//flag==0 ��ʾ������		  	  						
			if(flag == 0){			
				x1 = e.getX();
				y1 = e.getY();
			}else{
				//��������
				x2 = e.getX();
				y2 = e.getY();
				g.drawLine(x1, y1, x2, y2);	
				x1 = x2;
				y1 = y2;
				//g.clearRect(0,100,800,600);
				
			}
			flag = 1;	 //�ı��־λ���´δ���ʱ��ʾ�϶������ǵ�� 		  	
	  }

	}
		
}