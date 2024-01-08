package ua.kiev.minaeva.reflection;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private String name;
    private int yearOfBirth;
    private List<String> books;

    public Author() {
    }

    public Author(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public List<String> getBooks() {
        return books;
    }

    public void addBook(String title) {
        this.books.add(title);
    }
}
