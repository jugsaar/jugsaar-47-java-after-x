package demo;

public class Example006_Strings {

    public static void main(String[] args) {

        // some nice helper methods...

//        " fhjkfhdfsjkhf ";

        " ".isBlank();                // true

        "     ".isBlank();                // true

        "   \n     \t   ".isBlank();                // true

        " Foo Bar ".strip();          // "Foo Bar"

        " Foo Bar ".stripTrailing();  // " Foo Bar"

        " Foo Bar ".stripLeading();   // "Foo Bar "

        "Java".repeat(3);             // "JavaJavaJava"

        "A\nB\nC".lines().count();    // 3


//        christmasTreeOld();

        christmasTreeNew();
    }


    public static void christmasTreeOld() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (2 * i + 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }























    public static void christmasTreeNew() {

        for (int i = 0; i < 10; i++) {
            System.out.print(" ".repeat(10 - i));
            System.out.print("*".repeat(2 * i + 1));
            System.out.println();
        }
    }
}
