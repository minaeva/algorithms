package ua.kiev.minaeva.ocp.interfaces;

public class InheritSameVariable extends Clazz implements Inter {

    public static void main(String[] args) {
//        System.out.println(name); //won't work
        System.out.println(Inter.name); //"Sasha"
        System.out.println(new Clazz().name); //"Misha"
    }
}

interface Inter {
    String name = "Sasha";
}

class Clazz {
    String name = "Misha";
}
