package ua.kiev.minaeva.ocp.polymorphism;

public class EqualsAndHashCode {

    EqualsAndHashCode x;
    EqualsAndHashCode y;
    EqualsAndHashCode z;

    void contract() {
        // x.equals(x) == true
        // x.equals(y) == y.equals(x))
        // if (x.equals(y) == true && y.equals(z) == true) => x.equals(z) == true;
        // x.equals(y) the same throughout the whole life of an app
        // x.equals(null) == false

        // touch both equals and hashCode or touch none
        // hashCode's set of criteria must not be wider than that of equals'
        // pay attention if equals is overridden
    }
}
