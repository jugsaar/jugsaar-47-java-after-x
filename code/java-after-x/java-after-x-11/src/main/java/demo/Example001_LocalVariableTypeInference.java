package demo;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Local Variable type inference style-guide: https://openjdk.java.net/projects/amber/LVTIstyle.html
 */
public class Example001_LocalVariableTypeInference {

    public static void main(String[] args) {
        new Demo().run();
    }

    static class Demo {

        void run() {

            String var1 = "Hello Java 9";
            var var2 = "Hello Java 10";

            var var3 = "Hello Java 11";
//            var3 = 23;  // Incompatible types -> inferred type is String

            // var combined with final
            final var var4 = "Banana";
            //var4 = "Joe";   // Cannot assign a value to final variable 'text'


            // Some problematic examples
            // Cannot infer type:
//                    var a;
//                    var nothing = null;
//                    var lambda = () -> System.out.println("Pity!"); // which functional interface?
//                    var method = this::someMethod;


            // Local variable type inference really shines with generics involved.
            var myList = new ArrayList<Map<String, List<Integer>>>();

            for (var current : myList) {
                // current is infered to type: Map<String, List<Integer>>
                System.out.println(current);
            }


            //as of Java 11 the var keyword is also allowed for lambda
            // parameters which enables you to add annotations to those parameters
            Predicate<String> predicate = (@Nullable var a) -> true;

            // Non denotable types - var can handle types that cannot be represented on the left hand side of a declaration.
            var foo = new Foo<>();
            var op = foo.op();
            System.out.println(op);

            var o = new Object(){
                int a;
                int b;
                int c;
            };
            System.out.println(o.a);

        }

        void someMethod() {

        }

        class Foo<X extends Object & A & B> {
            X op(){
                return null;
            }
        }

        interface A{
            void a();
        }
        interface B{
            void b();
        }
    }
}
