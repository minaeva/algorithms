package ua.kiev.minaeva.ocp.generics;

class Shirt {

    String color;
    int length;

    public Shirt(String color, int length) {
        this.color = color;
        this.length = length;
    }
}

class TShirt {

    String color;
    String logo;

    public TShirt(String color, String logo) {
        this.color = color;
        this.logo = logo;
    }
}

class ShirtBox {
    Shirt shirt;

    public ShirtBox(Shirt shirt) {
        this.shirt = shirt;
    }
}

class TShirtBox {
    TShirt tShirt;

    public TShirtBox(TShirt tShirt) {
        this.tShirt = tShirt;
    }
}

class UniBox<T> {
    T thing;

    public UniBox(T thing) {
        this.thing = thing;
    }
}

public class ShirtTShirt {

    public static void main(String[] args) {
        Shirt shirt = new Shirt("red", 20);
        TShirt tShirt = new TShirt("blue", "UA");
//        ShirtBox shirtBox = new ShirtBox(shirt);
//        TShirtBox tShirtBox = new TShirtBox(tShirt);

        UniBox shirtBox = new UniBox(shirt);
        UniBox tShirtBox = new UniBox(tShirt);
        System.out.println(((Shirt) shirtBox.thing).length);
        System.out.println(((Shirt) tShirtBox.thing).length); //typo
    }
}


