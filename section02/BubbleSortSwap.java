package section02;

import java.util.Scanner;

public class BubbleSortSwap {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int [] data = new int [n];
		for (int i=0; i < n; i++) {
			data[i] = kb.nextInt();
		}
		kb.close();
		
		bubbleSort( data );
		
		System.out.println("Sorted Data:");
		for (int i=0; i<n; i++)
			System.out.println(data[i]);
	}
	
	static void bubbleSort( int [] data ) {
		int n = data.length;
		for (int i=n-1; i>0; i--) {
			for (int j=0; j<i; j++) {
				if (data[j] > data[j+1]) {
					swap( data[j], data[j+1] );
				}
			}
		}
	}
	
	// 오류 - 값에 의한 호
	static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}
}
