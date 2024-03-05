package ua.kiev.minaeva.ocp.inner_classes;

public class InnerNonStaticExample {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        System.out.println(inner);
    }
}

class Outer {
    String init = "hi, i'm inner";

    class Inner {
        final static int a = 0;
        {
            System.out.println(init);
        }
    }
}