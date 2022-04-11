package evaluators;

import expression.CondEvaluator;
import expression.EvalEvaluator;
import expression.ListEvaluator;
import expression.LoadEvaluator;
import expression.QuoteEvaluator;
import functional.FuncallEvaluator;
import functional.FunctionEvaluator;
import functional.LambdaEvaluator;
import functional.LetEvaluator;
import functional.SetqEvaluator;
import logical.AndEvaluator;
import logical.NotEvaluator;
import logical.OrEvaluator;
import main.lisp.evaluator.BuiltinOperationManagerSingleton; 
import main.lisp.evaluator.OperationRegisterer;
import relational.GreaterThanEqualEvaluator;
import relational.GreaterThanEvaluator;
import relational.LessThanEqualEvaluator;
import relational.LessThanEvaluator;



public class LispOperationRegisterer implements OperationRegisterer{
	
	@Override
	public void registerOperations() {
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("quote", new QuoteEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("list", new ListEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("eval", new EvalEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("<", new LessThanEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("<=", new LessThanEqualEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew(">", new GreaterThanEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew(">=", new GreaterThanEqualEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("cond", new CondEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("load", new LoadEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("and", new AndEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("or", new OrEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("not", new NotEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("setq", new SetqEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("lambda", new LambdaEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("funcall", new FuncallEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("function", new FunctionEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluatorIfNew("let", new LetEvaluator());

	}

}
