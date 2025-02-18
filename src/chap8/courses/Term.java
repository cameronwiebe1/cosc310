package chap8.courses;

public class Term {
    String name;
    String year;

    public Term(String name, String year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return name + " " + year;
    }
}