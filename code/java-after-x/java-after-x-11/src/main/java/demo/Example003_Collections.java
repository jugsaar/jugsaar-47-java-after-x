package demo;

import java.util.List;
import java.util.Map;

public class Example003_Collections {

    public static void main(String[] args) {

        // Since Java 9 but usefull nevertheless
        var list = List.of("A", "B", "C");

        // Collections.unmodifiableCollection(list); // Just a view wrapper around the mutable collection

        // Since Java 10 - immutable copy of (potentially) mutable list - independent of source
        var copy = List.copyOf(list);
        System.out.println(list == copy);   // true, because list was already an immutable list

        var map = Map.of("A", 1, "B", 2);
        System.out.println(map);    // {B=2, A=1}

        Map<String, Integer> copyMap = Map.copyOf(map);

    }
}
