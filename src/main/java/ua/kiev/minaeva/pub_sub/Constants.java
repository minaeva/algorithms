package ua.kiev.minaeva.pub_sub;

public class Constants {

    public static final Integer POISON_PILL = Integer.MIN_VALUE;

    public static final int PRODUCER_QUANTITY = 8;
    public static final int CONSUMER_QUANTITY = 15;
    public static final int BUFFER_CAPACITY = 5;

    public static final int PRODUCER_TIMEOUT = 5000;
    public static final int CONSUMER_TIMEOUT = 5000;
    public static final int MANAGER_TIMEOUT = 9000;
}
