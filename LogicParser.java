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
    CommandLineParser cmd_parser = new CommandLineParser(param_types);
    Map<String, String> params = cmd_parser.GetParams(args);

    if (params.size() == 0) {
      System.out.println("No params set. Use -e to set expression");
      return;
    }
    if (params.containsKey("expression") == true) {
      System.out.println("Expression: " + params.get("expression"));
    }
    if (params.containsKey("substitute") == true) {
      System.out.println("Substitute: " + params.get("substitute"));
    }
  }
}
