package demo;

import java.util.List;
import java.util.Map;

public class Example003_Collections {

    public static void main(String[] args) {

        var list = List.of("A", "B", "C");
        var copy = List.copyOf(list);
        System.out.println(list == copy);   // true


        var map = Map.of("A", 1, "B", 2);
        System.out.println(map);    // {B=2, A=1}

    }
}
