/**
 * @author: georgbuechner
 */

import java.util.Map;
import java.util.HashMap;

public class CommandLineParser {
  Map<String, String> params_;
  public CommandLineParser(Map<String, String> params) {
    params_ = params; 
  }

  Map<String, String> GetParams(String[] args) {
    Map<String, String> params = new HashMap<>();
    for (int i=0; i<args.length; i++) {
      if (params_.containsKey(args[i]) == true && args.length > i+1)
        params.put(params_.get(args[i]), args[i+1]);
    }
    return params;
  }
}
