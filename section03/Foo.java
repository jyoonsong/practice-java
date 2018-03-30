package section03;

public class Foo {
    public static void main(String[] args) {
		int num = 5;
        for (int i=0; i < num*2; i++) {
        		if (i < num) { // 0 1 2 3 4
        			for (int j=0; j<i; j++) {
        				System.out.print("*");
                }
        		}
        		else { // 5 6 7 8 9
        			for (int j=10-i; j>0; j--) {
        				System.out.print("*");
                }
        		}
            System.out.println();
        }
    }
}
