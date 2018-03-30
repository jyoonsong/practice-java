public class Polynomial {
    char name; // single character로 가정
    Term [] terms; // 항들의 배열
    int nTerms; // 배열을 쓸 때는 언제나 배열 원소의 수 기억! 항의 수

    public Polynomial() { // 매개변수는 없지만
        nTerms = 0; // 0으로 초기화
        terms = new Term[100]; // 참조변수가 가리킬 배열을 생성함
    }
    public Polynomial(char name) {
        this.name = name; // name값은 받아서 설정할 수 있음
        nTerms = 0;
        terms = new Term[100];
    }

    public int calcPolynomial(int x) {
        int sum = 0;
        for (int i = 0; i < nTerms; i++) {
            sum += terms[i].calcTerm(x);
        }
        return sum;
    }

    public void addTerm(int c, int e) {
        int isExp = findTerm(e);
        if (isExp == -1) {
            int i = nTerms-1;
            while(i>=0 && terms[i].exp < e) {
                terms[i + 1] = terms[i];
                i--;
            }
            terms[i+1] = new Term(c, e);
            nTerms++;
        }
        else {
            terms[isExp].coef += c;
            // coef 0이 되는 경우 예외처리
        }
    }

    public int findTerm(int e) {
        for (int i=0; i < nTerms && terms[i].exp >= e; i++) {
            if (terms[i].exp == e)
                return i;
        }
        return -1;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < nTerms; i++) {
            str += terms[i].toString();
            if (i != nTerms-1)
                str += " + ";
        }
        return str;
    }
}
