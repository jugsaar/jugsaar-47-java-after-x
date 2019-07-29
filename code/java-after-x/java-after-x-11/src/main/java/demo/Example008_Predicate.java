package demo;

import java.util.function.Predicate;
import static java.util.function.Predicate.not;

public class Example008_Predicate {

    public static void main(String[] args) {

        Predicate<String> isEmpty = String::isEmpty;
        var notIsEmpty = isEmpty.negate();

        var notIsEmpty2 = ((Predicate<String>)String::isEmpty).negate();

        var notIsEmptyJdk11 = Predicate.not(String::isEmpty);

        var notIsEmptyJdk11StaticImport = not(String::isEmpty);


    }
}
