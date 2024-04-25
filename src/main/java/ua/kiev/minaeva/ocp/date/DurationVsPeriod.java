package ua.kiev.minaeva.ocp.date;

import java.time.Duration;
import java.time.Period;

public class DurationVsPeriod {
    public static void main(String[] args) {
        String d = Duration.ofDays(1).toString();
        String p = Period.ofDays(1).toString();
        boolean b1 = d == p;
        boolean b2 = d.equals(p);
        System.out.println(b1 + " " + b2);

        System.out.println(d); //PT24H
        System.out.println(p); //P1D
    }
}
