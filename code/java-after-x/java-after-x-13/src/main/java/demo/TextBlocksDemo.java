package demo;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * See:https://openjdk.java.net/jeps/355
 */
public class TextBlocksDemo {

    public static void main(String[] args) throws ScriptException {

        String htmlClassic = "<html>\n" +
                "    <body>\n" +
                "        <p>Hello, world</p>\n" +
                "    </body>\n" +
                "</html>\n";

        System.out.println(htmlClassic);




























        /*
         * javac --enable-preview --source 13 demo/TextBlocksDemo.java
         * java -cp . --enable-preview demo.TextBlocksDemo
         */
        String html = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;

        System.out.println(html);


        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        engine.eval("""
                         function hello() {
                             print('"Hello, world"');
                         }

                         hello();
                         """);
    }
}
