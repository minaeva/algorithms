package ua.kiev.minaeva.ocp.interfaces;

public class OverrideDefaultAndStatic implements InterfaceDefaultAndStatic {


    public static void main(String[] args) {
        OverrideDefaultAndStatic o = new OverrideDefaultAndStatic();
        o.defaultMethod();
        //default Own Implementation
        //default in Interface

        InterfaceDefaultAndStatic.staticMethod();
        //static in Interface

//        Interface.defaultMethod(); //won't work
    }

    @Override
    public void usual() {
        System.out.println("usual Own Implementation");
    }

    @Override
    public void defaultMethod() {
//        super.defaultMethod(); //won't work because refers to parent CLASS (Object)
        System.out.println("default Own Implementation");
        InterfaceDefaultAndStatic.super.defaultMethod(); //works not only from the first line of the method
    }
}


interface InterfaceDefaultAndStatic {

    void usual();

    default void defaultMethod() {
        System.out.println("default in Interface");
    }

    static void staticMethod() {
        System.out.println("static in Interface");
    }
}