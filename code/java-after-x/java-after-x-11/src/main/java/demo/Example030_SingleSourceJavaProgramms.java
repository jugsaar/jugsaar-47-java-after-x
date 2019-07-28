package demo;

public class Example030_SingleSourceJavaProgramms {

    /*

$ cat listfiles
#!$JAVA_HOME/bin/java --source 11
// name file foo; chmod a+x foo; ./foo
import java.nio.file.*;
public class Main {
 public static void main(String[] $) throws java.io.IOException {
  Files.list(Paths.get(System.getProperty("user.home"))).forEach(System.out::println);
 }
}
     */

    // /home/tom/dev/playground/java/scripts

    // java --source 9  listfiles

}
