package demo;

public class Example006_Strings {

    public static void main(String[] args) {

        // some nice helper methods...

        " ".isBlank();                // true

        " Foo Bar ".strip();          // "Foo Bar"

        " Foo Bar ".stripTrailing();  // " Foo Bar"

        " Foo Bar ".stripLeading();   // "Foo Bar "

        "Java".repeat(3);             // "JavaJavaJava"

        "A\nB\nC".lines().count();    // 3
    }
}
