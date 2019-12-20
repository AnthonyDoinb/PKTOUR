package otherscene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Thing2 {
	public int x;
	public int y;
	public ImageIcon image;
	public int value;
	public String type;
	public int velocity;
	public boolean is_get=false;
	public Rectangle myrec;
	public JLabel a;
	public Otherscene jp;
	Thing2(Otherscene k,String a,int k1,int k2){
		type=a;
		x=k1;
		y=k2;
		jp=k;
		switch(type) {
		case "goldsmall":
			value=100;
			velocity=6;
			image=new ImageIcon("img/小金子.PNG");
			myrec=new Rectangle(x,y,image.getIconWidth(),image.getIconHeight());
			break;
		case "stone":
			value=20;
			velocity=1;
			image=new ImageIcon("img/石头.PNG");
			myrec=new Rectangle(x+1,y+1,image.getIconWidth()-1,image.getIconHeight()-1);
			break;
		case "goldmedium":
			value=200;
			velocity=4;
			image=new ImageIcon("img/中金子.PNG");
			myrec=new Rectangle(x,y,image.getIconWidth(),image.getIconHeight());
			break;
		case "goldlarge":
			value=500;
			velocity=2;
			image=new ImageIcon("img/大金子.PNG");
			myrec=new Rectangle(x+1,y+1,image.getIconWidth()-1,image.getIconHeight()-1);
			break;
		case "pocket":
			value=(int)(Math.random()*1001);
			velocity=5;
			image=new ImageIcon("img/口袋.PNG");
			myrec=new Rectangle(x+1,y,image.getIconWidth()-1,image.getIconHeight());
			break;
		case "pig":
			value=5;
			velocity=4;
			image=new ImageIcon("img/小猪.PNG");
			myrec=new Rectangle(x+1,y+1,image.getIconWidth()-1,image.getIconHeight()-1);
			break;
		default:break;
		}
	}
	public boolean is_attack(Thing2 a) {
		return myrec.intersects(a.myrec);
	}
	public JLabel getLabel() {
		a=new JLabel(image);
		a.setBounds(x, y, image.getIconWidth(), image.getIconHeight());
		jp.add(a);
		return a;
	}
	public void moveJLabel() {
		a.setBounds(x, y, image.getIconWidth(), image.getIconHeight());
	}
	public void moverec() {
		myrec.setBounds(x, y, image.getIconWidth(), image.getIconHeight());
	}
}

