package gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import dataclasses.CellData;
import handlers.MouseEventHandler;
import handlers.WindowHandler;

public class SpreadsheetFrame extends Frame{
	
	public TextField textField = new TextField();
	public LinkedList<CellData> cellLinkedList = new LinkedList<>();
	public int sum[] = new int[10];
	
	
	
	public final int initXPos = 50,initYPos = 50;
	public final int xIncrement = 50, yIncrement = 50;
	public final int frameHeight = 600, frameWidth = 650;
	public final int xMax = 600, yMax = 600;
	public final int xAdjustData = 15, yAdjustData = 30;
	
	public SpreadsheetFrame()
	{
		super("SpreadSheet");
		setLayout(null);
		setBounds(initXPos,initYPos,frameWidth,frameHeight);
		
		addWindowListener(new WindowHandler());
		addMouseListener(new MouseEventHandler());
		
		Button barGraphButton = new Button("Bar Graph");
		barGraphButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new StatisticDiagramsFrame("Bar Graph",sum,true);
			}
		});
		barGraphButton.setBounds(560, 60, 80, 30);
		add(barGraphButton);
		
		
		Button pieChartButton = new Button("PIE Chart");
		pieChartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new StatisticDiagramsFrame("PIE Chart", sum, false);
			}
		});

		pieChartButton.setBounds(560, 100, 80, 30);
		add(pieChartButton);
		
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics graphicsObject){
		//int sum[] = new int[10];
		//Arrays.fill(sum, 0);
		
		for(int xpos = initXPos, ypos = initYPos;xpos<xMax;xpos+=xIncrement)
			{
			graphicsObject.drawLine(xpos, ypos,xpos ,ypos+(yMax-ypos-initYPos));
			}
		for(int ypos = initYPos, xpos = initXPos;ypos<yMax ;ypos+=yIncrement)
		{
			graphicsObject.drawLine(xpos, ypos,xpos+(xMax-xpos-initXPos) ,ypos);
		}
		
		
		for(CellData cellD : cellLinkedList)
		{
//			int xPos = cellD.getxPos();
//			int yPos = cellD.getyPos();
			
			graphicsObject.drawString(String.valueOf(cellD.getValue()), cellD.getxPos()+xAdjustData, cellD.getyPos()+yAdjustData);
			
//			switch(yPos)
//			{
//			case 50*1:
//				sum[(xPos/50)-1] += cellD.getValue();
//				break;
//			case 50*2:
//				sum[(xPos/50)-1] += cellD.getValue();
//				break;
//			case 50*3:
//				sum[(xPos/50)-1] += cellD.getValue();
//				break;
//			case 50*4:
//				sum[(xPos/50)-1] += cellD.getValue();
//				break;
//			case 50*5:
//				sum[(xPos/50)-1] += cellD.getValue();
//				break;
//			case 50*6:
//				sum[(xPos/50)-1] += cellD.getValue();
//				break;
//			case 50*7:
//				sum[(xPos/50)-1] += cellD.getValue();
//				break;
//			case 50*8:
//				sum[(xPos/50)-1] += cellD.getValue();
//				break;
//			case 50*9:
//				sum[(xPos/50)-1] += cellD.getValue();
//				break;
//			case 50*10:
//				sum[(xPos/50)-1] += cellD.getValue();
//				break;
//			case 50*11:
//				sum[(xPos/50)-1] += cellD.getValue();
//				break;
//			
//			}
			//System.out.println("val "+cellD.getValue()+"  x "+xPos+"  y "+yPos+"  index "+(yPos/50-1)+"  sum "+sum[yPos/50-1]);
			
			
			
		}
		
		for(int itemp=0;itemp<10;itemp++)
			graphicsObject.drawString(String.valueOf(sum[itemp]), initXPos+50*itemp, yMax-20);
			
		textField.requestFocusInWindow();
		
	}
}
