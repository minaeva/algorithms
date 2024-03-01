package ua.kiev.minaeva.ocp.polymorphism.class_cast;

public class Main {

    public static void main(String[] args) {
        Pet cat = new Cat();
        Dog dog = new Dog();

        dog = (Dog) cat; //stops working as soon as __final__ Dog dog = new Dog();

        if (cat instanceof Dog) {} //ok instance of Class
//        if (cat instanceof dog) {} //NOTok

    }
}
