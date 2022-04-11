package functional;

import java.util.Optional;

import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.Function;
import main.lisp.evaluator.function.Lambda;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;

public class FuncallEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		ExpressionFactory.newInstance(NilAtomicExpressionFactory.newInstance(), NilAtomicExpressionFactory.newInstance());
		SExpression current = arg0.getTail();
		
		SExpression lambdaOrFunction = null;
		if (!current.getHead().isAtom()) {
			lambdaOrFunction = current.getHead().eval(arg1);
		}
		if (lambdaOrFunction instanceof Lambda) {
			Environment childEnvironment = arg1.newChild();
			return evaluateLambda((Lambda) lambdaOrFunction, childEnvironment, arg1, current.getTail());
		} else if(lambdaOrFunction instanceof Function) {
			return evaluateLambda (((Function) lambdaOrFunction).getLambda(), ((Function) lambdaOrFunction).getEnvironment().newChild(), ((Function) lambdaOrFunction).getEnvironment(),current.getTail() );
		} else {
			final Optional<SExpression> isLambda = arg1.lookup((IdentifierAtom) current.getHead());
			if (!isLambda.isEmpty() && isLambda.get() instanceof Lambda) {
				Environment childEnvironment = arg1.newChild();
				return evaluateLambda((Lambda) isLambda.get(), childEnvironment, arg1, current.getTail());
			} else if (!isLambda.isEmpty() && isLambda.get() instanceof Function) {
				
				return evaluateLambda (((Function) isLambda.get()).getLambda(), ((Function) isLambda.get()).getEnvironment().newChild(), ((Function) isLambda.get()).getEnvironment(),current.getTail() ); 
			}
			
			return ExpressionFactory.newInstance(NilAtomicExpressionFactory.newInstance(), NilAtomicExpressionFactory.newInstance());
		}
	}
	
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
