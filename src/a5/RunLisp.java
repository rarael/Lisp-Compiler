package a5;

import environments.EnvironmentImplementation;
import evaluators.LambdaSExpressionEvaluator;
import evaluators.LispOperationRegisterer;
import evaluators.StringFormats;
import main.Main;
import main.lisp.evaluator.ExpressionEvaluatorFactory;
import main.lisp.evaluator.environment.EnvironmentFactory;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtomFactory;
public class RunLisp {

	public static void main(String[] args) {
		LispOperationRegisterer register = new LispOperationRegisterer();
		register.registerOperations();
		ExpressionFactory.setClass(StringFormats.class);
		EnvironmentFactory.setClass(EnvironmentImplementation.class);
		IdentifierAtomFactory.setClass(VariableEval.class);
		ExpressionEvaluatorFactory.setClass(LambdaSExpressionEvaluator.class);
		Main.main(args);
	}

}
