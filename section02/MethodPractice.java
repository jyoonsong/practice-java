package section02;

import java.util.Scanner;

public class MethodPractice {
	static int n;
	static int [][] grid;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		grid = new int [n][n];
		for (int i=0; i < n; i++) {
			for (int j=0; j < n; j++)
				grid[i][j] = kb.nextInt();
		}
		kb.close();
				
		// 만들 수 있는 모든 수열을 구한다
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				for (int dir=0; dir<8; dir++) {
					for (int length=1; length<=n; length++) {
						int value = computeValue(i, j, dir, length);
						if ( isPrime( value ) ) {
							System.out.println(value);
						}
					}
				}
			}
		}
	}

	static int computeValue(int x, int y, int dir, int leng) {
		int value = 0;
		for (int i=0; i<leng; i++) {
			int digit = getDigit(x,y,dir,i);
			if (digit == -1)
				return -1;
			value = value*10 + digit;
		}
		return value;
	}
	
	static int getDigit(int x, int y, int dir, int i) {
		int newX = x, newY = y;
		/* method 1 */
		int [] offsetX = {0, 1, 1, 1, 0, -1, -1, -1};
		int [] offsetY = {-1, -1, 0, 1, 1, 1, 0, -1};
		newX += offsetX[dir]*i;
		newY += offsetY[dir]*i;
		/* method 2 */
//		switch(dir) {
//			case 0: newY+=i; break;
//			case 1: newX+=i; newY+=i; break;
//			case 2: newX+=i; break;
//			case 3: newX+=i; newY-=i; break;
//			case 4: newY-=i; break;
//			case 5: newX-=i; newY-=i; break;
//			case 6: newX-=i; break;
//			case 7: newX-=i; newY+=i; break;
//		}
		if (newX < 0 || newX >= n || newY < 0 || newY >= n)
			return -1;
		return grid[newX][newY];
	}
	
	static boolean isPrime(int k) {
		if (k<2) 
			return false;
		for (int i=2; i*i<=k; i++)
			if (k % i == 0)
				return false;
		return true;
	}
}
