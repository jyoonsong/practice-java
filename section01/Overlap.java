import java.util.Scanner;

public class Overlap {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] data = new int [n];
		for (int i=0; i < n; i++) {
			data[i] = kb.nextInt();
		}
		kb.close();
		
		for (int i=0; i < n; i++) {
			for (int j=0; j < i; j++) {
				if (data[i] == data[j])
					System.out.println( i + "(" + data[i] + "," + data[i] + ")" + j );
			}
		}
	}
}