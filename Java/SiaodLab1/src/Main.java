import java.awt.*;
import javax.swing.*;

class Vertex {
	public int data;

	public Vertex Left;
	public Vertex Right;

}

class Tree {
	Vertex root;

	public Vertex CreateISPD(int l, int r, int[] a) {
		if (l > r)
			return null;
		else {
			int m = (l + r) / 2;
			Vertex p = new Vertex();
			p.data = a[m];
			p.Left = CreateISPD(l, m - 1, a);
			p.Right = CreateISPD(m + 1, r, a);
			return p;
		}
	}

	public void Obhod1(Vertex p) {
		if (p != null) {
			Obhod1(p.Left);
			System.out.print(p.data + " ");
			Obhod1(p.Right);
		}

	}

	public int Size(Vertex p) {
		if (p == null)
			return 0;
		else
			return 1 + Size(p.Left) + Size(p.Right);

	}

	public int Sum(Vertex p) {
		if (p == null)
			return 0;
		else
			return p.data + Sum(p.Left) + Sum(p.Right);
	}

	public int Sumlength(Vertex p, int l) {
		if (p == null)
			return 0;
		else
			return l + Sumlength(p.Left, l + 1) + Sumlength(p.Right, l + 1);
	}

	public int Height(Vertex p) {
		if (p == null)
			return 0;
		else
			return 1 + Math.max(Height(p.Left), Height(p.Right));
	}

}

class Board extends JPanel {
	Vertex root;
	
	@Override
	  public void paintComponent(Graphics g) {
	        // Draw Tree Here
		super.paintComponent(g);
	       draw1(g);
	    }
	
	private void draw1(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(Color.CYAN);
		int w = getWidth();
		int h = getHeight();

		setBackground(Color.black);
		g2d.drawLine (0, 0, w, h);
		g2d.drawOval((w / 2) - 25, 5, 50, 50);
		g2d.drawString(Integer.toString(root.data), 20, 20);
		
	}
}

public class Main {
	public static void main(String[] args) {
		Tree tree = new Tree();
		int n = 5;
		int[] m = new int[n];

		for (int i = 0; i < n; i++) 
			m[i] = i + 1;


		Vertex root = tree.CreateISPD(0, n - 1, m);

		System.out.println("Обход дерева: ");
		tree.Obhod1(root);

		System.out.print("\nСредняя высота: ");
		double h_middle = (double) tree.Sumlength(root, 1) / (double) tree.Size(root);
		System.out.println(h_middle);

		System.out.println("Размер дерева: " + tree.Sum(root));
		System.out.println("Высота дерева: " + tree.Height(root));
		System.out.println("Количество вершин: " + tree.Size(root));
		

		   JFrame jFrame = new JFrame("Tree");
	        jFrame.add(new Board(), root);
	        jFrame.setSize(1300, 750);
	        jFrame.setVisible(true);

	}
	
}
