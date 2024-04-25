package ua.kiev.minaeva.ocp.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Certification {
    String studId;
    String test;
    int marks;

    Certification(String studId, String test, int marks) {
        this.studId = studId;
        this.test = test;
        this.marks = marks;
    }

    public String toString() {
        return "{" + studId + ", " + test + ", " + marks + "}";
    }

    public String getStudId() {
        return studId;
    }

    public String getTest() {
        return test;
    }

    public int getMarks() {
        return marks;
    }
}

public class PartitionTest {

    public static void main(String[] args) {
        Certification c1 = new Certification("S001", "OCA", 87);
        Certification c2 = new Certification("S002", "OCA", 82);
        Certification c3 = new Certification("S001", "OCP", 79);
        Certification c4 = new Certification("S002", "OCP", 89);
        Certification c5 = new Certification("S003", "OCA", 60);
        Certification c6 = new Certification("S004", "OCA", 88);

        Stream<Certification> stream1 = Stream.of(c1, c2, c3, c4, c5, c6);
        Stream<Certification> stream2 = Stream.of(c1, c2, c3, c4, c5, c6);

        Map<Boolean, List<Certification>> map1 =
                stream1.collect(Collectors.partitioningBy(s -> s.equals("OCA")));

        Map<Boolean, List<Certification>> map2 =
                stream2.collect(Collectors.partitioningBy(s -> s.getTest().equals("OCA")));

        // []
        System.out.println(map1.get(true));
        // [{S001, OCA, 87}, {S002, OCA, 82}, {S003, OCA, 60}, {S004, OCA, 88}]
        System.out.println(map2.get(true));
    }
}
