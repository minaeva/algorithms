package ua.kiev.minaeva.ocp.polymorphism;

class Player {
    String name;
    int age;
    Player() {
        this.name = "Virat";
        this.age = 29;
    }

    public int hashCode() {
        return 100;
    }
}

public class SoutHashCode {
    public static void main(String[] args) {
        System.out.println(new Player());
    }
}
