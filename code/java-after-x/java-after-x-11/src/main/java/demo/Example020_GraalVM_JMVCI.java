package demo;

import java.util.concurrent.TimeUnit;

public class Example020_GraalVM_JMVCI {

    public static void main(String[] args) {

        // -XX:+UnlockExperimentalVMOptions -XX:+EnableJVMCI -XX:+UseJVMCICompiler
        StringHash.main(args);
    }

    public static final class StringHash {

        public static void main(String[] args) {
            StringHash sh = new StringHash();
            sh.run();
        }

        void run() {
            for (int i=1; i<2_000; i++) {
                timeHashing(i, 'x');
            }
        }

        void timeHashing(int length, char c) {
            final StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length  * 1_000_000; j++) {
                sb.append(c);
            }
            final String s = sb.toString();
            final long now = System.nanoTime();
            final int hash = s.hashCode();
            final long duration = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - now);
            System.out.println("Length: "+ length +" took: "+ duration +" ms");
        }
    }
}
