package ua.kiev.minaeva.ocp.polymorphism;

public class Main {

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.printMyName(); //parent

        Parent child = new Child();
        child.printMyName(); //child

        System.out.println(parent.name); //parent
        System.out.println(child.name); //parent because __Parent__ child = new Child();

    }
}
