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

    //Check if string is empty, if yes, return true
    if (expression == "") 
      return true;

    //Check if elementary form but in brackets
    expression = EraseSurroundingBrackets(expression);
    System.out.println("Expression: " + expression);

    return true;
  }

  private int MatchingBracket(String str) {
    int num=0;
    for (int i=0; i<str.length(); i++) {
      if (str.charAt(i) == '(')
        num++;
      else if (str.charAt(i) == ')' && num == 1)
        return i;
      else if (str.charAt(i) == ')')
        num--;
    }
    System.out.println("Serious error: MatchingBracket failed!");
    return 0;
  }

  private String EraseSurroundingBrackets(String str) {
    //Check if elementary form but in brackets
    if (str.charAt(0) == '(' && MatchingBracket(str) == str.length()-1) {
      str = str.substring(0, str.length()-1);
      str = str.substring(1, str.length());
    }
    if (str.charAt(0) == '(') 
      return EraseSurroundingBrackets(EraseSurroundingBrackets(str));
    return str;
  }
};
