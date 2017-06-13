package handlers;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import dataclasses.CellData;
import gui.SpreadsheetFrame;

public class MouseEventHandler extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int xpos = e.getX();
		int ypos = e.getY();
		if(xpos>=50 && xpos<550 && ypos>=50 && ypos<550)
		{
			setTextBox(xpos,ypos,((SpreadsheetFrame)e.getSource()));
		}
	}

	private void setTextBox(int xpos, int ypos, SpreadsheetFrame spreadsheetFrameObject) {
		
		int newTxtXPos;
		int newTxtYPos;
		
		newTxtXPos = xpos - (xpos % 50);
		newTxtYPos = ypos - (ypos % 50);
		
		int oldTxtXPos;
		int oldTxtYPos;
		boolean flagDataFound = false;
		
		dataclasses.CellData cellDataObject = null;
		
		if(!spreadsheetFrameObject.textField.getText().equals(""))
		{
			oldTxtXPos = (spreadsheetFrameObject.textField.getX());
			oldTxtYPos = (spreadsheetFrameObject.textField.getY());
			
			int data = Integer.parseInt(spreadsheetFrameObject.textField.getText());
			
			spreadsheetFrameObject.textField.setText("");
						
			for(dataclasses.CellData cellData : spreadsheetFrameObject.cellLinkedList)
			{
						
				if( oldTxtXPos == cellData.getxPos() && oldTxtYPos == cellData.getyPos() )
				{
					cellData.setData(data);
					flagDataFound = true;
				}
				else if( newTxtXPos == cellData.getxPos() && newTxtYPos == cellData.getyPos())
				{
					spreadsheetFrameObject.textField.setText(String.valueOf(cellData.getValue()));
				}
			}
			
			if(!flagDataFound)
			{
				cellDataObject = new CellData(oldTxtXPos,oldTxtYPos,data);
				spreadsheetFrameObject.cellLinkedList.add(cellDataObject);
			}			
			spreadsheetFrameObject.sum[(oldTxtXPos/50)-1] +=data;
			spreadsheetFrameObject.repaint(oldTxtXPos, spreadsheetFrameObject.yMax-spreadsheetFrameObject.yIncrement,spreadsheetFrameObject.xIncrement,spreadsheetFrameObject.yIncrement);
			
			spreadsheetFrameObject.textField.setBounds(newTxtXPos,newTxtYPos,50,50);
			
			spreadsheetFrameObject.add(spreadsheetFrameObject.textField);
			
			return;
		}
		spreadsheetFrameObject.textField.setBounds(newTxtXPos,newTxtYPos,50,50);
		spreadsheetFrameObject.add(spreadsheetFrameObject.textField);
	}



}
