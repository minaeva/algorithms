package ua.kiev.minaeva.ocp.inner_classes;

public class Anonymous {

    public static void main(String[] args) {
        Parent obj = new Parent() {
            @Override
            void run() {
                System.out.println("new run");
            }
        };
        obj.run();

        Parentable obj2 = () -> System.out.println("new 2");
        obj2.run();
    }
}

class Parent {
    void run() {
        System.out.println("old");
    }
}
interface Parentable {
    void run();
}
