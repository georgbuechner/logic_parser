
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
    }
    @Test
    public void testLogicParser() {
      LogicParser parser = new LogicParser();
    }
}
