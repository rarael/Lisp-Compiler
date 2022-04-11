package logical;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;

public class OrEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		SExpression expression = arg0.getTail();
		SExpression current = expression;
		while (!current.getTail().isNIL()) {
			if (!current.getHead().eval(arg1).isNIL()) {
				return current.getHead().eval(arg1);
			}
			current = current.getTail();
		}
		return current.getHead().eval(arg1);
	}	
}
