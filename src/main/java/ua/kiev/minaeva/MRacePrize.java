package ua.kiev.minaeva;


public class MRacePrize implements Comparable<MRacePrize> {

    private double amount;
    private int size;
    private long prizeId;

    public MRacePrize() {
    }

    public MRacePrize(double amount, int size, long prizeId) {
        this.amount = amount;
        this.size = size;
        this.prizeId = prizeId;
    }

    @Override
    public int compareTo(MRacePrize other) {
        if (null == other) {
            return -1;
        }
        return Long.compare(this.prizeId, other.prizeId);
    }
}

