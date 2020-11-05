/**
 * @author: georgbuechner
 */

import java.util.Map;
import java.util.HashMap;
import java.util.*;
import org.javatuples.*;

public class Evaluator {
  private String substitutes_ = "{}";
  private char[] opts_ = {'=', '>', '<', '>', '<', '~', ':'};

  public void set_substitues (String substitutes) {
    substitutes_ = substitutes;
  }

  public boolean Evaluate (String expression) {
    System.out.println("Substitutes: " + substitutes_);
    System.out.println("Expression: " + expression);

    //Check if string is empty, if yes, return true
    if (expression == "") 
      return true;

    //Erase all surrounding brackets
    expression = EraseSurroundingBrackets(expression);

    //Check if elementary form (f.e. a==b)
    if (expression.indexOf("(") == -1) {
      Triplet<String, Character, String> opt_vals = GetOperatorValues(expression);
      System.out.println("Found: ");
      System.out.println(opt_vals.getValue0());
      System.out.println(opt_vals.getValue1());
      System.out.println(opt_vals.getValue2());
    }

    return true;
  }

  public int MatchingBracket(String str) {
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

  public String EraseSurroundingBrackets(String str) {
    //Check if elementary form but in brackets
    if (str.charAt(0) == '(' && MatchingBracket(str) == str.length()-1) {
      str = str.substring(0, str.length()-1);
      str = str.substring(1, str.length());
    }
    else 
      return str;
    if (str.charAt(0) == '(') 
      return EraseSurroundingBrackets(EraseSurroundingBrackets(str));
    return str;
  }

  public Triplet<String, Character, String> GetOperatorValues(String str) {
    char opt = ' ';
    int pos=0;
    for (pos=0; pos<str.length(); pos++) {
      for (char c : opts_) {
        if (c == str.charAt(pos)) {
          opt = c;
          break;
        }
      }
      if (opt != ' ') break;
    }
    if (pos == 0) 
      System.out.println("Serious error: No operator found!");
    String first = str.substring(0, pos);
    String second = str.substring(pos+1, str.length());
    return Triplet.with(first, opt, second);
  }
};
