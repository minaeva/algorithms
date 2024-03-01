package ua.kiev.minaeva.ocp.final_keyword;

public class ImplicitFinalForInnerClass {

    public static void main(String[] args) {

        int a = 42;
        //using ++a in any of the following cases would bring an error
        //1. inner class
        class Inner {
            {
                System.out.println(a);
            }
        }
        new Inner();

        //2. anonymous class
        InterfaceForAnonymous obj = new InterfaceForAnonymous() {
            {
                System.out.println(a);
            }
        };

        //3. lambda
        InterfaceForLambda lambda = () -> System.out.println(a);
        lambda.run();

    }

}

interface InterfaceForAnonymous {
}

interface InterfaceForLambda {
    void run();
}
