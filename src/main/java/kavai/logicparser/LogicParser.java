/**
 * @author: georgbuechner
 */
import java.util.Map;
import java.util.HashMap;

public class LogicParser{
  public static void main(String[] args) {
    //Create commandline-parser and desired command
    Map<String, String> param_types = new HashMap<>();
    param_types.put("-e", "expression");
    param_types.put("-s", "substitute");
    System.out.println(param_types.get("-e"));
    CommandLineParser cmd_parser = new CommandLineParser(param_types);
    Map<String, String> params = cmd_parser.GetParams(args);

    if (params.containsKey("expression") == false) {
      System.out.println("Expression to evaluate missing, use -e "
          + "\"[expression]\" to set expression.");
      return;
    }
    Evaluator evaluator = new Evaluator();
    if (params.containsKey("substitute") == true) {
      evaluator.set_substitues(params.get("substitute"));
    }
    System.out.println(params.get("expression") + ":");
    System.out.println(evaluator.Evaluate(params.get("expression")));
  }
}
