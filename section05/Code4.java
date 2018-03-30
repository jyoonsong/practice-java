import java.util.Scanner;

public class Code4 {

    public Polynomial [] polys = new Polynomial[100]; // 여러 개의 다항식 저장
    public int n = 0;

    public void processCommand() {

        Scanner kb = new Scanner( System.in );
        while(true) {
            System.out.print("$ ");
            String command = kb.next();
            if ( command.equals("create") ) {
                char name = kb.next().charAt(0); // String 타입을 받은 후, charAt으로 가져와줌. 꼼수.

                // initialize. class file에서 해줘도 됨.
                polys[n++] = new Polynomial(name);
            }
            else if ( command.equals("add") ) {
                char name = kb.next().charAt(0); // String 타입을 받은 후, charAt으로 가져와줌. 꼼수.

                int index = find(name);

                if (index == -1) {
                    System.out.println("No such polynomial exists.");
                }
                else {
                    int c = kb.nextInt();
                    int e = kb.nextInt();

                    polys[index].addTerm(c, e);
                }
            }
            else if ( command.equals("calc") ) {
                char name = kb.next().charAt(0);

                int index = find(name);

                if (index == -1) {
                    System.out.println("No such polynomial exists.");
                }
                else {
                    int x = kb.nextInt();

                    System.out.println( polys[index].calcPolynomial(x) );
                }
            }
            else if ( command.equals("print") ) {
                char name = kb.next().charAt(0);

                int index = find(name);

                if (index == -1) {
                    System.out.println("No such polynomial exists.");
                }
                else {
                    System.out.println( polys[index].toString() );
                }
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

    public static void main(String[] args) {
        Code4 app = new Code4();
        app.processCommand();
        // (new Code4()).processCommand();
    }


    private int find(char name) {
        for (int i=0; i<n; i++) {
            if (polys[i].name == name) {
                return i;
            }
        }
        return -1;
    }
}
