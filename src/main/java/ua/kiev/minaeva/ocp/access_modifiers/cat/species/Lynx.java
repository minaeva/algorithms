package ua.kiev.minaeva.ocp.access_modifiers.cat.species;

import ua.kiev.minaeva.ocp.access_modifiers.cat.BigCat;

public class Lynx extends BigCat {
    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name); //public
//        System.out.println(cat.hasFur); // protected referenced from other package
//        System.out.println(cat.hasPaws); // default
//        System.out.println(cat.id); //private

        Lynx lynx = new Lynx();
        System.out.println(lynx.hasFur); // protected referenced from subclass
    }
}
