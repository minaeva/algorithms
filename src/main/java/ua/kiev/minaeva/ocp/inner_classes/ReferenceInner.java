package ua.kiev.minaeva.ocp.inner_classes;

import org.junit.jupiter.api.Test;

public class ReferenceInner {
    class A {
        void m() {
            System.out.println("INNER");
        }
    }

    public void reference() {
        A a1 = this.new A(); // this wouldn't have compiled from static psvm
        a1.m();

//        ReferenceInner a2 = this.new A(); // NO - different type

        A a3 = new ReferenceInner().new A();
        a3.m();
//        ReferenceInner a4 = new ReferenceInner().new A(); // NO - different type
    }

    @Test
    void test() {
        reference();
    }
}
