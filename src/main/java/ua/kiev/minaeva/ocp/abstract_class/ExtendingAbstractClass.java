package ua.kiev.minaeva.ocp.abstract_class;


abstract class Cat {
    // 1. nothing
    // 2. abstract
//    abstract void clean();
    // 3. default
    void clean() {}
}

public class ExtendingAbstractClass extends Cat {
    void clean() {}
}
