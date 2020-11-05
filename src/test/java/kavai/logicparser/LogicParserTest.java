
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Map;
import java.util.HashMap;
import java.util.*;
import org.javatuples.*;

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

    /**
     * test functions of Evaluator
     */
    @Test
    public void testEvaluator() {
      Evaluator logic = new Evaluator();       
      assertEquals("x=y", logic.EraseSurroundingBrackets("(x=y)"));
      assertEquals("x=y", logic.EraseSurroundingBrackets("((x=y))"));
      assertFalse("x=y" == logic.EraseSurroundingBrackets("((x=y)"));
  
      Triplet<String, Character, String> vals = logic.GetOperatorValues("x=y");
      assertEquals("x", vals.getValue0());
      assertTrue('=' == vals.getValue1());
      assertEquals("y", vals.getValue2());
      vals = logic.GetOperatorValues("test~evaluator");
      assertEquals("test", vals.getValue0());
      assertTrue('~' == vals.getValue1());
      assertEquals("evaluator", vals.getValue2());

      assertEquals(13, logic.MatchingBracket("((a=b)&&(c=d))"));
      assertEquals(4, logic.MatchingBracket("(a=b)&&((c=d || d=e))"));

      Triplet<String, Character, String> konjs = logic.GetKonjuctsValues("(x=y)|(y=x)");
      assertEquals("x=y", konjs.getValue0());
      assertTrue('|' == konjs.getValue1());
      assertEquals("(y=x)", konjs.getValue2());
    }

    @Test
    public void testLogicParser() {
      LogicParser parser = new LogicParser();
    }
}
