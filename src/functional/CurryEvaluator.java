package functional;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.Function;
import main.lisp.evaluator.function.Lambda;
import main.lisp.evaluator.function.LambdaFactory;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.QuoteAtom;
import main.lisp.parser.terms.SExpression;

public class CurryEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		SExpression expression = arg0.getTail();
		SExpression FLambda = expression.getHead().eval(arg1);
		if(FLambda instanceof Lambda) {
			Lambda lambda = (Lambda) FLambda;
			IdentifierAtom[] curryLambdaArgs = lambda.getArgumentNames();
			SExpression lambdaBody = ExpressionFactory.newInstance(lambda, new QuoteAtom(expression.getTail()));
			return LambdaFactory.newInstance(curryLambdaArgs, lambdaBody);
		} else if (FLambda instanceof Function) {
			Function function = (Function) FLambda;
			IdentifierAtom[] curryLambdaArgs = function.getLambda().getArgumentNames();
			SExpression lambdaBody = ExpressionFactory.newInstance(function, new QuoteAtom(expression.getTail()));
			return LambdaFactory.newInstance(curryLambdaArgs, lambdaBody);
		}
		// should only take in functions or lambdas
		return null;
	}

}
