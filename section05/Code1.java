import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code1 {

    static Person [] members = new Person[100]; // 배열 생성 까먹지 말 것. 참조변수만 있을 땐 데이터 넣을 수 없음 PointerError
    static int n = 0;

    public static void main( String [] args ) {
        // members = new Person[100];

        try {
            Scanner in = new Scanner(new File("input.txt"));

            while( in.hasNext() ) {
                String nm = in.next();
                String nb = in.next();

                members[n] = new Person(); // 객체 생성 까먹지 말 것. 참조변수만 있을 땐 데이터 넣을 수 없음 PointerError
                members[n].name = nm;
                members[n].number = nb;
                n++;
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("No File Found");
        }

        bubbleSort();

        for (int i=0; i<n; i++) {
            System.out.println(members[i].name + " " + members[i].number);
        }
    }

    private static void bubbleSort() {

        for (int i=n-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                if ( members[j].name.compareToIgnoreCase( members[j+1].name ) > 0 ) {
                    Person tmp = members[j];
                    members[j] = members[j+1];
                    members[j+1] = tmp;
                }
            }
        }
    }

}
