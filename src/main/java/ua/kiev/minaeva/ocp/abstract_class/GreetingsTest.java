package ua.kiev.minaeva.ocp.abstract_class;

abstract class Greetings {
    abstract void greet();
}

public class GreetingsTest {
    public static void main(String[] args) {
        Greetings obj = new Greetings() {
            @Override
            public void greet() {
                System.out.println("Hello");
            }
        };
        obj.greet(); // Hello
    }
}
