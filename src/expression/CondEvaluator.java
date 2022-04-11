package expression;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;

public class CondEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		SExpression condition = arg0.getTail();
		if(condition.isNIL()) {
				return NilAtomicExpressionFactory.newInstance();
		}
		if (!condition.getHead().isAtom() &&!condition.getHead().getHead().eval(arg1).isNIL()) {
			if (condition.getHead().getTail().isNIL()) {
				return condition.getHead().getHead().eval(arg1);
			} else {
				return condition.getHead().getTail().getHead().eval(arg1);
			}
		}else if (condition.getHead().isAtom()) {
			return condition.getHead().eval(arg1);
		}else {
			return eval(condition, arg1);
		}			
	}			
	
}
