import java.awt.*;
import java.swing.*;
import java.awt.event.*;

public class TreeGUI extends JFrame {
	@Override
	  public void paintComponent(Graphics g) {
	        // Draw Tree Here
		super.paintComponent(g);
	       draw1(g);
	    }
	
	private void draw1(Graphics g) {
			
		g2d.setPaint(Color.CYAN);
		int w = getWidth();
		int h = getHeight();

		setBackground(Color.black);
		g2d.drawLine (0, 0, w, h);
		g2d.drawOval((w / 2) - 25, 5, 50, 50);
		g2d.drawString(Integer.toString(root.data), 20, 20);
		
	}
}
