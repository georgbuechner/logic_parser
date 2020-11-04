/**
 * @author: georgbuechner
 */

import java.util.Map;
import java.util.HashMap;

public class Evaluator {
  private String substitutes_ = "{}";

  public void set_substitues (String substitutes) {
    substitutes_ = substitutes;
  }

  public boolean Evaluate (String expression) {
    System.out.println("Expression: " + expression);
    System.out.println("Substitutes: " + substitutes_);
    return true;
  }
};
