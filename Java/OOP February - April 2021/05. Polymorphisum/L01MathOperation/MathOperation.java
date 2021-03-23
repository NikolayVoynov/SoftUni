package L01MathOperation;

public class MathOperation {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        int result = add(a, b);
        return result + c;
    }

    public int add(int a, int b, int c, int d) {
        int result = add(a, b, c);
        return result + d;
    }
}
