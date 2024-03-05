package ua.kiev.minaeva.ocp.inner_classes;

public class InnerStaticExample {

    public static void main(String[] args) {
        OuterStatic.Inner inner = new OuterStatic.Inner();
    }

}

class OuterStatic {
    static String init = "init message";
    static class Inner {
        {
            System.out.println(init);
        }
    }
}
