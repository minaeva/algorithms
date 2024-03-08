package ua.kiev.minaeva.ocp.interfaces;

public class CallStatic implements InterfaceStatic {


    public static void main(String[] args) {
        CallStatic clazz = new CallStatic();
//        clazz.method(); //NO
        InterfaceStatic.method();
    }
}


interface InterfaceStatic {

    static void method() {
        System.out.println("i'm static");
    }
}