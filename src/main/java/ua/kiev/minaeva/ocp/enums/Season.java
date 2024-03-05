package ua.kiev.minaeva.ocp.enums;

public enum Season {
    SPRING(true),
    SUMMER(true),
    FALL(true),
    WINTER(false);

    boolean isFavorable;

    Season(boolean isFavorable) {
        this.isFavorable = isFavorable;
    }
}
