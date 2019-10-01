import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Arrays.*;
import java.util.Random;

public class SDP {
	
		public Vertex SDP(Vertex p, int data) {
			while (p != null) {
				if (data < p.data) {
						if (p.Left != null) 
							p = p.Left;
						else {
							p.Left = new Vertex();
							p.Left.data = data;
						}
				}	
				else {
					if (data > p.data) {
						if (p.Right != null) 
							p = p.Right;
						else {
							p.Right = new Vertex();
							p.Right.data = data;
						}
					}
					else
						break;
				}
			}
			if (p == null) {
				p = new Vertex();
				p.data = data;
				p.Left = p.Right = null;
			}
			return p;
		}
		
		
		public Vertex SDP2(Vertex p, int data) {
			if (p == null) {
				p = new Vertex();
				p.data = data;
				p.Left = p.Right = null;	
				return p; 
			}
			else 
			{
				if (data < p.data) 
					p.Left = SDP2(p.Left, data);
				else {
					if (data > p.data) 
						p.Right = SDP2(p.Right, data);					
				}
				return p;
			}
		}
	


	
	
	
	public static void main(String[] args) {
		final int n = 100;
		
		Tree tree = new Tree();
		SDP sdp = new SDP();
		Vertex root = null;
		Random random = new Random();
		
		int[] m = new int[n];
		
		

		
		root = sdp.SDP(root, m[0]);
		
		for (int i = 1; i < n; i++) {
			sdp.SDP(root, m[i]);
		}
		
		
		root = sdp.SDP2(root, m[0]);
	
		for (int i = 1; i < n; i++) {
			sdp.SDP2(root, m[i]);
		}
		
		
		tree.Obhod1(root);
		
		System.out.println();
		
		Arrays.sort(m);
		
	
		
		Vertex rootISPD = tree.CreateISPD(0, n - 1, m);
		tree.Obhod1(rootISPD);
		double h_middle_ISPD = (double) tree.Sumlength(rootISPD, 1) / (double) tree.Size(rootISPD);
		double h_middle_SDP = (double) tree.Sumlength(root, 1) / (double) tree.Size(root);
		
		
		System.out.println("\n\n n = " + n + " | Размер | Контр.сумма | Высота | Средняя Высота |");
		System.out.println("----------------------------------------------------------|");
		System.out.println("   ИСПД  |  " +  tree.Size(rootISPD) + "   |     " + tree.Sum(rootISPD) + "    |    "
		+ tree.Height(rootISPD) + "   |       " +  h_middle_ISPD + "      |");
		System.out.println("----------------------------------------------------------|");
		System.out.println("   СДП    |  " +  tree.Size(root) + "   |     " + tree.Sum(root) + "    |   "
		+ tree.Height(root) + "   |       " +  h_middle_SDP + "      |");
		
		
		
		
	}
}
