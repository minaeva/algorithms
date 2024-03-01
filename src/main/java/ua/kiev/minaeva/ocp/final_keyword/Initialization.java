package ua.kiev.minaeva.ocp.final_keyword;

public class Initialization {

    final String a = "1st place";
    final String b;
    final String c;

    {
        b = "2nd place";
    }

    public Initialization(String c) {
        this.c = "3rd place";
    }
}
