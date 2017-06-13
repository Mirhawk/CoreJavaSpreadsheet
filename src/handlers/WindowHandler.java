package handlers;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowHandler extends WindowAdapter {
	
	@Override
	public void windowClosing(WindowEvent e)
	{
		((Window)e.getSource()).dispose();
	}
	
	

}
