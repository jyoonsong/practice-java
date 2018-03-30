import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code2 {

    static MyRectangle [] rects = new MyRectangle[50];
    static int n = 0; // 사각형의 개수

    public static void main(String [] args) {
        try {
            Scanner in = new Scanner(new File("data.txt"));

            while ( in.hasNext() ) {
                rects[n] = new MyRectangle();
                rects[n].lu = new MyPoint(); // MyPoint도 참조변수!

                rects[n].lu.x = in.nextInt();
                rects[n].lu.y = in.nextInt();
                rects[n].width = in.nextInt();
                rects[n].height = in.nextInt();

                n++;
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No File Found");
            System.exit(1);
        }

        bubbleSort();

        for (int i=0; i<n; i++) {
            System.out.println(rects[i].lu.x + " " + rects[i].lu.y + " " + rects[i].width + " " + rects[i].height);
        }
    }

    private static void bubbleSort() {
        for (int i=n-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                if ( calcArea(rects[j]) > calcArea((rects[j+1])) ) {
                    MyRectangle tmp = rects[j];
                    rects[j] = rects[j+1];
                    rects[j+1] = tmp;
                }
            }
        }
    }

    public static int calcArea( MyRectangle r ) {
        return r.width * r.height;
    }

}
