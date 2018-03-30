import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] data = new int [n];
		for (int i=0; i < n; i++) {
			data[i] = kb.nextInt();
		}
		kb.close();
		
		int tmp;
		int max;
		
		for (int i=(n-1); i > 0; i--) {
			tmp = 0;
			max = data[0];
			for (int j=1; j <= i; j++) {
				if (data[j] > max) {
					max = data[j]; 
					tmp = j;
				}
			}
			data[tmp] = data[i];
			data[i] = max;
		}
		
		for (int i=0; i<n; i++)
			System.out.println(data[i]);
	}
}
