package ua.kiev.minaeva.ocp.enums;

public enum OnlyOnce {
    FIRST;

    OnlyOnce() {
        System.out.println("Constructor is called");
    }

    public static void main(String[] args) {
        OnlyOnce first = OnlyOnce.FIRST;
        OnlyOnce second = OnlyOnce.FIRST;
    }
}
