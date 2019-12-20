package draw;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

//继承抽象类MouseAdapter
public class MyMouseAdapter extends MouseAdapter{
	private Graphics g;
	private String command;
	private int x1,x2,y1,y2;
	private int flag = 0;	
	DrawingFrame df;	
	
	//构造方法，接收DrawingFrame对象
	public MyMouseAdapter(DrawingFrame df){
		this.df = df; 				   
		//创建画布
		g = df.getGraphics();	
		
		
	}

	//鼠标按下
	public void mousePressed(MouseEvent e) {
		//得到鼠标按下时的坐标
		x1 = e.getX();
		y1 = e.getY();
		flag = 0;			//实现铅笔使用的标志位	
	}
	//鼠标释放
	public void mouseReleased(MouseEvent e) {
		//得到鼠标释放时的坐标		
		x2 = e.getX();
		y2 = e.getY();	
		flag = 0;			//实现铅笔使用的标志位	
		//获取按钮值
		this.command = df.command;	
		 						
	}			
	//鼠标拖拽（鼠标按下并移动时，不断触发，直到鼠标释放）
	public void mouseDragged(MouseEvent e){
		//获取按钮值
		this.command = df.command;
		//铅笔
	  if("铅笔".equals(command)){	
	  	//flag==0 表示点击面板		  	  						
			if(flag == 0){			
				x1 = e.getX();
				y1 = e.getY();
			}else{
				//交换坐标
				x2 = e.getX();
				y2 = e.getY();
				g.drawLine(x1, y1, x2, y2);	
				x1 = x2;
				y1 = y2;
				//g.clearRect(0,100,800,600);
				
			}
			flag = 1;	 //改变标志位，下次触发时表示拖动而不是点击 		  	
	  }

	}
		
}