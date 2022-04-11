package logical;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;

public class AndEvaluator implements Evaluator{

	@Override
	// need to fix
	public SExpression eval(SExpression arg0, Environment arg1) {
		SExpression expression = arg0.getTail();
		SExpression current = expression;
		if(expression.getHead().isNIL()) {
			return NilAtomicExpressionFactory.newInstance();
		} else {
			while (!current.isAtom() && !current.getTail().isNIL()) {
				
				if (current.getHead().eval(arg1).isNIL()) {
					return NilAtomicExpressionFactory.newInstance();
				}
				current = current.getTail();
			}
			return current.getHead().eval(arg1);
		}
	}

}
