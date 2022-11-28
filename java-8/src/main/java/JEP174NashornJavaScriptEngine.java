import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JEP174NashornJavaScriptEngine {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        // JEP 174: Nashorn JavaScript Engine
        // https://openjdk.org/jeps/174

        // https://docs.oracle.com/javase/8/docs/api/javax/script/ScriptEngine.html
        ScriptEngineManager factory = new ScriptEngineManager();

        System.out.println("registered engines:");
        factory.getEngineFactories().forEach(System.out::println);
        ScriptEngine engine = factory.getEngineByName("nashorn"); // registered engine in maven

        engine.eval("print('Hello World!');");

        engine.eval("function greeting(name) {" +
                "return 'Hello ' + name" +
                "}");

        Invocable invocable = (Invocable) engine;
        Object funcResult = invocable.invokeFunction("greeting", "İbrahim ATAY");
        System.out.println(funcResult);

        engine.eval("print(__FILE__, __LINE__, __DIR__);");
    }
}
