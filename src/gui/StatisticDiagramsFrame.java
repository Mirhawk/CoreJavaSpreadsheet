package gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import handlers.WindowHandler;

public class StatisticDiagramsFrame extends Frame {
	
	int sum[];
	boolean flag;
	
	public StatisticDiagramsFrame(String name, int[] sum, boolean flag) {

		super(name);
		this.sum = new int [sum.length];
		this.flag = flag;
		System.arraycopy(sum, 0, this.sum, 0, sum.length);
		setBounds(100, 100, 600, 600);
		addWindowListener(new WindowHandler());
		
		setVisible(true);
			
	}

	@Override
	public void paint(Graphics g)
	{
		Color[] colorArray = {new Color(138,43,226), new Color(75,0,130), new Color(0,0,255),
				new Color (0,128,0), Color.YELLOW, Color.ORANGE, Color.RED, new Color(138,43,226), new Color(75,0,130), new Color(0,0,255),
				new Color (0,128,0), Color.YELLOW, Color.ORANGE, Color.RED};
		
		if(flag)
		{
			g.drawLine(50, 80, 50, 550);
			g.drawLine(50, 550, 550, 550);
			
			for(int itemp=0 ; itemp<sum.length ; itemp++)
			{
				g.setColor(Color.CYAN);
				g.drawRect(100+(itemp*40), 550-sum[itemp], 20, sum[itemp]);
				g.fillRect(100+(itemp*40), 550-sum[itemp], 20, sum[itemp]);
			}
		}
		else
		{
			int total = 0;
			int startAngle=0;
			double currAngle = 0.0D;
			for(int val : sum)
			{
				total += val;
			}
			if(total == 0)
			{
				return;
			}
			int colorIndex = 0;
			for(int value : sum)
			{		
				startAngle = (int) ((currAngle*360)/total);
				int arcAngle = ( 360 * value) / total;
				g.setColor(colorArray[colorIndex++]);
				g.fillArc(50, 50, 400, 400, startAngle, arcAngle);
				
				startAngle += arcAngle;
				currAngle += value;
			}
		}	
	}
}
