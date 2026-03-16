import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 1. Creezi intersecțiile (Streams)
        List<Intersection> nodes = IntStream.range(0, 10)
                .mapToObj(i -> new Intersection("V" + i))
                .collect(Collectors.toList());

        // 2. Creezi străzile
        List<Street> streets = new LinkedList<>();
        streets.add(new Street("Street 1", 500, nodes.get(0), nodes.get(1)));
        streets.add(new Street("Street 2", 200, nodes.get(1), nodes.get(2)));
        streets.add(new Street("Street 3", 800, nodes.get(2), nodes.get(3)));

        // Folosim un Comparator definit pe loc prin Lambda:
        streets.sort((s1, s2) -> Integer.compare(s1.getLength(), s2.getLength()));

        System.out.println("Strazi sortate dupa lungime:");
        streets.forEach(System.out::println);
    }
}