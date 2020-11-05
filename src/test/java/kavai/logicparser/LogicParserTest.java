
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Map;
import java.util.HashMap;

/**
 * Unit test for simple App.
 */
public class LogicParserTest
{
    /*
     * Testing of commandline parser
     */
    @Test
    public void testCommandLineParser() {
      Map<String, String> param_types = new HashMap<>();
      param_types.put("-e", "expression");
      param_types.put("-s", "substitute");
      CommandLineParser parser = new CommandLineParser(param_types);

      String[] args = {"-e", "hello world"};
      Map<String, String> params = parser.GetParams(args);
      assertEquals("hello world", params.get("expression"));
      assertEquals(false, params.containsKey("substitute"));
      
      String[] args2 = {"hello world"};
      Map<String, String> params2 = parser.GetParams(args2);
      assertEquals(0, params2.size());
      param_types.put("main", "expression");
      parser = new CommandLineParser(param_types);
      Map<String, String> params3 = parser.GetParams(args2);
      assertEquals("hello world", params.get("expression"));
    }

    @Test
    public void testLogicParser() {
      LogicParser parser = new LogicParser();
    }
}
