import java.util.Scanner;

public class Shift {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] data = new int [n];
		for (int i=0; i < n; i++) {
			data[i] = kb.nextInt();
		}
		kb.close();
		
		int num = data[n-1];
		for (int i = n-1; i > 0; i--) {
			data[i] = data[i-1];
		}
		data[0] = num;
		
		for (int i=0; i<n; i++) {
			System.out.println(data[i]);
		}
	}
}