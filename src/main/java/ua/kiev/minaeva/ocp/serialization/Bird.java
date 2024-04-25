package ua.kiev.minaeva.ocp.serialization;

import java.io.*;

class Tail {
    private int length;

    public Tail(int length) {
        this.length = length;
    }
}

public class Bird implements Serializable {
    private String name;
    private transient int age;
    private Tail tail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTail(Tail tail) {
        this.tail = tail;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Bird newBird = new Bird();
        newBird.setName("anna");
        newBird.setAge(3);
        newBird.setTail(new Tail(10));

        try (InputStream is = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream("/Users/svetaminaeva/Desktop/files/birds.dat")))) {
//            Bird bird = is.readObject(); // Cannot resolve method 'readObject' in 'InputStream'
//            Bird bird = is.read();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}