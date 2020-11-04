# logic_parser
A simple logic parser that is mainly used to check if a given input matches certain conditions in a specific state.
It is not mainly designed to parse "normal" expressions.
A simple example would be the following: 
Evaluator evaluator = new Evaluator();
evaluator.set_substitutes({"time":current_time()};
evaluator.evaluate("time = 09:00")
The function will check for a substitue for "time" and replace it with the given value. 

More complex expressions should also be possible, f.e.
`(time > 23 || (time < 00:00 && day > 1))`  
