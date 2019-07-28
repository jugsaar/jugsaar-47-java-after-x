package demo;

import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.teeing;

public class Example010_Streams_NewMethods {

    public static void main(String[] args) {
        
        // The teeing(..) operator creates an additional stream with duplicates of the initial stream
        double average = Stream.of(1, 4, 2, 7, 4, 6, 5)
                .collect(teeing(
                        summingDouble(i -> i), // uses stream 1
                        counting(),  // uses stream 2
                        (sum, n) -> sum / n) // bi-function to combine the results of both streams
                );

        System.out.println(average);
    }
}
