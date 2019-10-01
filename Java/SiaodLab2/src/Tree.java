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
	
	public Vertex Search(Vertex p, int key) {
		while (p != null) {
			if (key < p.data)
				p = p.Left;
			else if (key > p.data)
				p = p.Right;
				else
					break;
		}
		if (p != null) 
			return p;
		else
			return null;
	
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
