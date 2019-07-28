package demo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example004_Streams {

    public static void main(String[] args) {


        /*
        Streams were introduced in Java 8 and now receive three new methods. Stream.ofNullable constructs a stream from a single element:
         */
        var cnt = Stream.ofNullable(null)
                .count();   // 0

        System.out.println(cnt);

        /*
        The methods dropWhile and takeWhile both accept a predicate to determine which elements to abandon from the stream:
         */
        Stream.of(1, 2, 3, 2, 1)
                .dropWhile(n -> n < 3)
                .collect(Collectors.toList());  // [3, 2, 1]

        Stream.of(1, 2, 3, 2, 1)
                .takeWhile(n -> n < 3)
                .collect(Collectors.toList());  // [1, 2]

    }
}
