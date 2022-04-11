package functional;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class SetqEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		SExpression expression = arg0.getTail();
        SExpression E2Eval = expression.getTail().getHead().eval(arg1);
		arg1.assign((IdentifierAtom) expression.getHead(), E2Eval);
		return E2Eval;
	}
}
