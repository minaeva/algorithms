package ua.kiev.minaeva.ocp.in_out;

import java.io.*;

public class ObjectInputOutputStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Counter ctr = new Counter("a");
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("/Users/svetaminaeva/Desktop/Counter1.txt"))) {
            oos.writeObject(ctr);
        }

        new Counter("b");
        new Counter("c");

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("/Users/svetaminaeva/Desktop/Counter1.txt"))) {
            ctr = (Counter) ois.readObject();
//            System.out.println(ctr.getCount()); // warning, static method is accessed via reference
            System.out.println(Counter.getCount()); // 3
            System.out.println(ctr.getName()); // "a"
        }
    }
}

class Counter implements Serializable {
    private static int count = 0;
    private String name;

    public Counter(String name) {
        count++;
        this.name = name;
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return this.name;
    }
}