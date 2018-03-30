import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Code3 {

//    static String [] items.word = new String [100000];
//    static int [] items.count = new int [100000]; // 0으로 자동 초기화됨. C에서는 해줘야 함.
    static Item [] items = new Item [100000];
    static int n = 0;

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        while (true) {

            System.out.print("$ ");
            String command = kb.next();
            if ( command.equals("read") ) {
                // file name을 받으면
                String filename = kb.next();
                // read하여 index를 만든다
                makeIndex( filename );
            }
            else if ( command.equals("find") ) {
                String query = kb.next();
                int i = findWord( query );
                if (i != -1) {
                    System.out.println("The word " + items[i].word + " appears " + items[i].count + " times.");
                }
                else {
                    System.out.println("The word " + query + " does not appear.");
                }
            }
            else if ( command.equals("saveas") ) {
                // file name을 받으면
                String filename = kb.next();
                // index를 그 이름의 파일로 저장한다
                saveAs( filename );
            }
            else if ( command.equals("exit") ) {
                break;
            }
            else {
                System.out.println("Unknown Command");
            }
        }
        kb.close();

    }

    static void makeIndex( String filename ) {
        // file이 없는 경우를 대비하여 try-catch 사용
        try {
            Scanner inFile = new Scanner( new File(filename) );
            while( inFile.hasNext() ) { // file을 끝까지 읽고 싶을 때 전형적 방식
                String str = inFile.next();
                addWord( str );
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println(filename + " not found");
            return;
        }
    }

    static void addWord( String str ) {
        int index = findWord( str ); // boolean으로 할 경우 위치는 모르므로 또 찾아야 함
        if (index != -1) { // found items.word[index] == str
            items[index].count++;
        }
        else { // not found
            int i = n-1;
            System.out.println(i);
            while ( i >= 0 && items[i].word.compareToIgnoreCase(str) > 0 ) {
                items[i+1] = items[i];
                i--;
            }
            items[i+1] = new Item();
            items[i+1].word = str; // C에서는 재사용 시 strdup() 해줘야 함.
            items[i+1].count = 1;
            n++;
        }
    }

    static int findWord( String str ) {
        for (int i=0; i<n; i++)
            if ( items[i].word.equalsIgnoreCase(str) )
                return i;
        return -1;
    }

    static void saveAs( String filename ) {
        // file이 없는 경우를 대비하여 try-catch 사용
        try {
            PrintWriter outFile = new PrintWriter(new FileWriter(filename));
            for (int i=0; i<n; i++) {
                outFile.println(items[i].word + " " + items[i].count);
            }
            outFile.close();
        } catch (IOException e) {
            System.out.println("Save failed. Don't ask me why!");
            return; //사실 어차피 마지막. 다시 가도 끝남. but 혹시 모르니 해주자.
        }
    }

}
