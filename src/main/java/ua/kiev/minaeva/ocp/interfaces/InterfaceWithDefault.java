package ua.kiev.minaeva.ocp.interfaces;

import java.util.function.Predicate;

public interface InterfaceWithDefault extends Predicate<String> {

    @Override
    default boolean test(String s) {
        return false;
    }
}
