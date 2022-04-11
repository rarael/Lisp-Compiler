package expression;

import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.SExpression;

public class QuoteEvaluator implements main.lisp.evaluator.Evaluator{

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		return arg0.getTail().getHead();
	}

}
