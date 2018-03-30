import java.util.Scanner;

public class Complex {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] data = new int [n];
		for (int i=0; i < n; i++) {
			data[i] = kb.nextInt();
		}
		kb.close();

		int maxPrime = 0; // 음이 아닌 정수이므로 
		for (int i=0; i < n; i++) { // 구간의 시작점 
			for (int j=i; j < n; j++) { // 구간의 끝점 

				int val = 0;
				for (int k=i; k<=j; k++) // 하나의 정수로 환산 
					val = val*10 + data[k];

				boolean isPrime = true;
				for (int p=2; p*p<=val; p++) {
					if (val%p == 0) {
						isPrime = false;
						break;
					}
				}

				if (isPrime && val > 1 && val > maxPrime)
					maxPrime = val;
			}
		}
		if (maxPrime > 0)
			System.out.println(maxPrime);
		else
			System.out.println("No Prime");
	}
}