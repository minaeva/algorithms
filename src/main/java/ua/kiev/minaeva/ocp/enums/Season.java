package ua.kiev.minaeva.ocp.enums;

public enum Season {
    SPRING(false),
    SUMMER(true),
    FALL(true),
    WINTER(false) {
        @Override
        public void printIsFavorable() {
            System.out.println("Winter is too cold, " + this.isFavorable);
        }
    };

    final boolean isFavorable;

    Season(boolean isFavorable) {
        this.isFavorable = isFavorable;
    }

    public void printIsFavorable() {
        System.out.println(isFavorable);
    }

    public static void main(String[] args) {
        Season.SPRING.printIsFavorable();
        Season.SUMMER.printIsFavorable();
        Season.FALL.printIsFavorable();
        Season.WINTER.printIsFavorable();
    }

}
