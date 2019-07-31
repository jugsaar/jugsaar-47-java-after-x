package demo;

public class Example040_RuntimeVersion {

    public static void main(String[] args) {

        var v = Runtime.Version.parse("1.2.3.4+5");

        String version = v.feature() + " " + v.interim() + " " + v.update() + " " + v.patch() + " " + v.build();

        System.out.println(version);
    }
}
