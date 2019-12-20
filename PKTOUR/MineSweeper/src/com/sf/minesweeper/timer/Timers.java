package com.sf.minesweeper.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sf.minesweeper.panel.MineState;
import com.sf.minesweeper.tools.Tools;

public class Timers implements ActionListener{

	private int times;
	MineState mineState;
	int flag;
	public Timers(MineState mineState,int flag){
		this.mineState = mineState;
		this.flag = flag;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(flag==2)
			Tools.time11++;
		if(flag==1)
			//Tools.time++;
		if(Tools.time>999){
			Tools.time=999;
		}else{
			if(flag==1) {
				int g = Tools.time%10;
				int s = Tools.time/10%10;
				int b = Tools.time/100;
				System.out.print(Tools.time);
				Tools.time++;
				
			}
			
			
			
			
			
		}
	}
	
	

}
