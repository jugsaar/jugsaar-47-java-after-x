package demo;

import java.util.Optional;

public class Example005_Optionals {

    public static void main(String[] args) {

        Optional.ofNullable(null).orElseThrow();     // NoSuchElementException

        Optional.of("foo").stream().count();  // 1

        Optional.ofNullable(null).stream().count(); // 0

        Optional.ofNullable(null)
                .or(() -> Optional.of("fallback"))
                .get();                           // fallback

        Optional<Object> opt = Optional.ofNullable(null);
        // before Java 11
        if (!opt.isPresent()) {
            // ...
        }

        // with Java 11
        if (opt.isEmpty()) {
            // inverse to isPresent
        }

        String x = "";
        if (x == null) {
            X.present(x);
        } else {
            X.missing();
        }

        Optional.ofNullable(x).ifPresentOrElse(X::present, X::missing);
    }


    static class X {
        static void present(String x) {
            System.out.println(x + " present");
        }

        static void missing() {
            System.out.println("missing");
        }
    }


}
