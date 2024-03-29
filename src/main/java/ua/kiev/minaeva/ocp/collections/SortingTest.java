package ua.kiev.minaeva.ocp.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Name {
    String first;
    String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String toString() {
        return first + " " + last;
    }

}

public class SortingTest {
    public static void main(String[] args) {
        List<Name> names = Arrays.asList(new Name("Peter", "Lee"), new Name("John", "Smith"),
                new Name("bonita", "smith"));

        /*INSERT*/
//        Collections.sort(names, (o1, o2) -> o1.getFirst().compareToIgnoreCase(o2.getFirst())); //[bonita smith, John Smith, Peter Lee]
//        Collections.sort(names, (o1, o2) -> o1.getFirst().toUpperCase().compareTo(o2.getFirst().toUpperCase())); // [bonita smith, John Smith, Peter Lee]
        Collections.sort(names, (o1, o2) -> o1.getFirst().toLowerCase().compareTo(o2.getFirst().toLowerCase()));

        System.out.println(names);
    }


}
