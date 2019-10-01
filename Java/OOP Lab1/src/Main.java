import java.util.Random;

public class Main {
	public static void main(String []args) {
		
		Random random = new Random();
		int n = 16;
		byte[][] matrix = new byte[n][n];
		
		for (int i = 0; i < n; i++) {
			random.nextBytes(matrix[i]);
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("\n\n\n");
		
		int size = 0;
		byte[]a = new byte[n*n];
		

		
		for (int k = 0; k < n * 2; k++)
		{
		   for (int j = 0; j <= k; j++)
		   {
		      int i = k - j;
		      if (i < n && j < n)
		      {
		         a[size++] = matrix[j][i];
		      }
		   }
		}
		
		System.out.println("С левого угла: ");
		for (int i = 0; i < size; i++)
			System.out.print(a[i] + " ");
		System.out.println("\n\n\n");

		size = 0;
		for (int k = n; k >= -n; k--)
		{
		  for (int j = 0; j < n - k; j++)
		  {
		    int i = k + j;
		    if (i < n && j < n && i >= 0 && j >= 0)
		    {
		    	a[size++] = matrix[j][i];
		    }
		  }
		}
		
		System.out.println("С правого угла: ");
		for (int i = 0; i < size; i++)
			System.out.print(a[i] + " ");
		
		System.out.println("\nСпираль к центру: ");
		size = 0;
		
		for (int i = 0; i < n * n; i++)
			a[i] = 0;
		
		for(int i = 0; i < n; i++) {
			a[size++] = matrix[0][i];
		}
		for(int i = 1; i < n; i++) {
			a[size++] = matrix[i][n - 1];
		}
		for(int i = n - 2; i >= 0; i--) {
			a[size++] = matrix[n - 1][i];
		}
		for(int i = n - 2; i > 0; i--) {
			a[size++] = matrix[i][0];
		}
		
		 int c = 1;
	     int d = 1;
	     
		    while (d + 1 != n - 1) {
		    	 a[size++] = matrix[c][d]; 
		    	 d++;		 
		  	 }
		     
		     while (c + 1 != n - 1) {
		    	 a[size++] = matrix[c][d];
		    	 c++;
		     }
		     
		     while (d != 1) {
		    	 a[size++] = matrix[c][d];
		    	 d--;
		     }
		     
		     while (c != 1) {
		    	 a[size++] = matrix[c][d];
		    	 c--;
		     }
		     
	     
	    if (n % 2 == 1) {
	    	a[size++] = matrix[++c][++d];
	    }
		
	    for (int i = 0; i < size; i++)
			System.out.print(a[i] + " ");
		
		System.out.println("\nСпираль от центра: ");
		size = 0;
		
		 if (n % 2 == 1) {
		   	a[size++] = matrix[c][d];
		 }
	
			   ++c;
			   while (d + 1 !=  n - 1) {
			    	 a[size++] = matrix[c][d];
			    	 d++;
			     }
			   while (c !=  1) {
			    	 a[size++] = matrix[c][d];
			    	 c--;
			     }
			   
			   while (d !=  1) {
			    	 a[size++] = matrix[c][d];
			    	 d--;
			     }
			   while (d != 0) {
				   a[size++] = matrix[c][d];
				   d--;
			   }
			   
			   for (int i = 1; i < n; i++) {
				   a[size++] = matrix[i][0];
			   }
			   for (int i = 1; i < n; i++) {
				   a[size++] = matrix[n - 1][i];
			   }
			   for (int i = n - 2; i >= 0; i--) {
				   a[size++] = matrix[i][n - 1];
			   }
			   for (int i = n - 2; i >= 0; i--) {
				   a[size++] = matrix[0][i];
			   }
			   
		 
		  for (int i = 0; i < size; i++)
				System.out.print(a[i] + " ");
		 
	}	
}
