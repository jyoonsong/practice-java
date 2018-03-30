public class Term {
    int coef; // 계수
    int exp; // 지수

    public Term(int c, int e) {
        coef = c;
        exp = e;
    }

    public int calcTerm(int x) {
        return (int) ( coef * Math.pow(x, exp) );
    }

    public String toString() {
        String str = "" + coef;
        if (exp != 0)
            str += "x^" + exp;
        return str;
    }

}
