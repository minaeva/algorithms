package ua.kiev.minaeva;

//0 1 1 2 3 5 8 13 21 34
public class Fibonacci {

    int n1 = 0, n2 = 1, n3 = 0;

    public int getFibonacciFromBottom(int count) {
        System.out.println("count = " + count + ", result = " + n3);
        if (count == 1) {
            return n3;
        }
        if (count == 2) {
            return n2;
        }
        n3 = n1 + n2;
        n1 = n2;
        n2 = n3;
        return getFibonacciFromBottom(count - 1);
    }

    public  int getFibonacci(int n) {
        System.out.println("Entering getFibonacci(n), n is " + n);
        if (n <= 2) {
            System.out.println("n <= 1, " + (n - 1) + " is returned now");
            return n - 1;
        }
        return getFibonacci(n - 1) +
                getFibonacci(n - 2);
    }
}
