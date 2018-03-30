
public class Prime {

	public static void main(String[] args) {
		int n;
		for (n=2; n < 100000; n++) {
			boolean isPrime = true; // 무죄추정의원칙처럼
			for (int i=2; i*i <= n && isPrime; i++) {
				if (n%i == 0 ) {
					isPrime = false;
					//break; //더이상돌필요없음
				}
			}
			if (isPrime)
				System.out.println(n);
		}
	}

}
