package demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Example007_Files {

    public static void main(String[] args) throws IOException {

        var destPath = Path.of("output.txt");

        Files.writeString(destPath, "First line\n");
        Files.writeString(destPath, "Second line\n", StandardOpenOption.APPEND);

        String content = Files.readString(destPath);

        content.lines().forEach(System.out::println);
    }
}
