package ua.kiev.minaeva.ocp.access_modifiers.cat;

public class BigCat {

    public String name = "cat";
    protected boolean hasFur = true;
    boolean hasPaws = true;
    private int id;

    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name); //public
        System.out.println(cat.hasFur); // protected
        System.out.println(cat.hasPaws); // default
        System.out.println(cat.id); //private
    }
}
