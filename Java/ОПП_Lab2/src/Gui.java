import java.awt.*;
import javax.swing.*;

class MyPanel extends JPanel {
	private Node stack, queue;
	private int h, w;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw1(g);
		draw2(g);
	}

	private void draw1(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Font font = new Font("Verdana", Font.PLAIN, 20);
		
		int i = 150;
		int x = i, y = 170;

		g2d.setFont(font);
		g2d.setColor(Color.white);
		g2d.drawString("Stack", 70, 70);
		
		
		if (stack != null) {
			g2d.drawString("Tail", i - 70, y - 10);
		}

		g2d.setColor(Color.cyan);
		setBackground(Color.black);
	

		for (Node p = stack; p != null; p = p.next) {
			if (i + 100 < w) {
				g2d.fillRect(i, 100, 70, 100);
				// g2d.setFont(font);
				// g2d.drawString(Byte.toString(p.data), x + 100, y + 100);
				g2d.setStroke(new BasicStroke(3));
				g2d.setColor(Color.red);
				g2d.drawLine(i + 20, y, i + 40, y - 10);
				g2d.drawLine(i + 20, y, i + 40, y + 10);
			
				g2d.drawLine(i + 20, y, i + 120, y);
				
				i += 100;
			} else
				System.out.print("Right side are max!");
			g2d.setColor(Color.cyan);
		}
		g2d.setColor(Color.white);
		
		if (stack != null) {
			g2d.drawString("Head", i, y - 10);
		}

	
		
	
	}
	
	public void draw2(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Font font = new Font("Verdana", Font.PLAIN, 20);

		int i = 150;
		int x = i, y = 470;
		
		g2d.setFont(font);
		g2d.setColor(Color.white);
		g2d.drawString("Queue", 70, 370);
		
		if (queue != null) {
			g2d.drawString("Head", i - 70, y - 10);
		}
		

		g2d.setColor(Color.cyan);
		setBackground(Color.black);
	
		
	
		for (Node p = queue; p != null; p = p.next) {
			if (i + 100 < w) {
				g2d.fillRect(i, 400, 70, 100);
				g2d.setStroke(new BasicStroke(3));
				g2d.setColor(Color.red);
				g2d.drawLine(i + 100, y, i + 80, y - 10);
				g2d.drawLine(i + 100, y, i + 80, y + 10);
				g2d.drawLine(i + 20, y, i + 100, y);
				
				// g2d.setFont(font);
				// g2d.drawString(Byte.toString(p.data), x + 100, y + 100);
			
				
				i += 100;
			} else
				System.out.print("Right side are max!");
			g2d.setColor(Color.cyan);
		}
		g2d.setColor(Color.white);
		if (queue != null) {
			g2d.drawString("Tail", i, y - 10);
		}
		
	}

	public MyPanel(Node stack, Node queue, int w, int h) {
		this.stack = stack;
		this.queue = queue;
		this.h = h;
		this.w = w;
	}
}

public class Gui extends JFrame {

	public Gui(Node stack, Node queue) {
		int w = 1300, h = 750;

		JFrame myWindow = new JFrame("Graphics");
		myWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
		myWindow.setSize(w, h);
		myWindow.setVisible(true);
		myWindow.setContentPane(new MyPanel(stack, queue, w, h));
		myWindow.setLocationRelativeTo(null);

	}

}
