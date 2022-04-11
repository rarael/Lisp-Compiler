package evaluators;

import main.lisp.evaluator.BasicExpressionEvaluator;
import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.Lambda;
import main.lisp.parser.terms.DecimalAtom;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtomicExpressionFactory;

public class LambdaSExpressionEvaluator extends BasicExpressionEvaluator {
	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// evaluates lambda first
		if (!expr.getHead().isAtom()) {
			SExpression eval = super.eval(expr.getHead(), environment);
			if (eval instanceof Lambda) {
				Environment childEnvironment = environment.newChild();
				return evaluateLambda((Lambda) eval, childEnvironment, environment, expr.getTail());
			}
			SExpression isExpressionNested = expr.getHead().getHead();
			if (!isExpressionNested.isAtom()) {
				eval = super.eval(isExpressionNested, environment);
				if (eval instanceof Lambda) {
					Environment childEnvironment = environment.newChild();
					return evaluateLambda((Lambda) eval, childEnvironment, environment, expr.getTail());
				}
			}
		}
			// when it is not a lambda
			return super.eval(expr, environment);
		}

	// produces your lambda evaluation
	private SExpression evaluateLambda(Lambda lambda, Environment childEnvironment, Environment environment, SExpression current) {
		IdentifierAtom[] argNames = lambda.getArgumentNames();
		for(int i = 0; i < argNames.length; i++) {
			if (current.isAtom()) {
				childEnvironment.assign(argNames[i], current);
			} else {
				childEnvironment.assign(argNames[i], current.getHead().eval(environment));
				current = current.getTail();
			}
		}
	return lambda.eval(childEnvironment);
	}
	

}

