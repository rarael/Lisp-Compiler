package logical;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtomicExpressionFactory;

public class NotEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		SExpression expression = arg0.getTail();
		if (expression.getHead().eval(arg1).isNIL()) {
			return TAtomicExpressionFactory.newInstance();
		}else {
			return NilAtomicExpressionFactory.newInstance();
		}
	}

}
