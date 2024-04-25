package ua.kiev.minaeva.ocp.enums;

enum AnimalsInPark {
    SQUIRREL, CHIPMUNK, SPARROW
}

public class ValuesTest {

    public static void main(String[] args) {
        AnimalsInPark[] animals = AnimalsInPark.values();
        System.out.println(animals[1]); //CHIPMUNK
    }
}
