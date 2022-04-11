package expression;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;

public class ListEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		
		SExpression current = arg0.getTail();
		if(current.getTail().isNIL()) {
			return ExpressionFactory.newInstance(arg0.getHead().eval(arg1), new NilAtom());
		}
		return ExpressionFactory.newInstance(current.getHead().eval(arg1), helper(current.getTail(), arg1));
		
	
	}
	
	private SExpression helper(SExpression arg0, Environment arg1) {
		
		SExpression current = arg0;
		if(current.getTail().isNIL()) {
			return ExpressionFactory.newInstance(arg0.getHead().eval(arg1), new NilAtom());
		} else {
			return ExpressionFactory.newInstance(current.getHead().eval(arg1), helper(current.getTail(), arg1));
		}
		
	}

}
