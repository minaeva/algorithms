package ua.kiev.minaeva.ocp.inner_classes;

class X {
    class Y {
        private void m() {
            System.out.println("INNER");
        }
    }

    public void invokeInner() {
        Y obj = new Y(); //Line 9
        obj.m(); //Line 10
    }
}

public class PrivateMethodTest {
    public static void main(String[] args) {
        new X().invokeInner(); // INNER - addressing inner method is ok
    }
}
