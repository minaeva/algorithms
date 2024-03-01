package ua.kiev.minaeva.ocp.polymorphism;

public class Child extends Parent {

    String name = "child";

    @Override
    void printMyName() {
        System.out.println(name);
    }
}
