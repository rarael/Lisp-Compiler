package relational;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.DecimalAtom;
import main.lisp.parser.terms.IntegerAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtomicExpressionFactory;

public class LessThanEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		SExpression expression = arg0.getTail();
		
		SExpression first = expression.getHead().eval(arg1);
		SExpression second = expression.getTail().getHead().eval(arg1);
		
		IntegerAtom firstInt = null;
		IntegerAtom secondInt = null;
		DecimalAtom firstDec = null;
		DecimalAtom secondDec = null;
		
		
		if (first instanceof IntegerAtom) {
			firstInt = (IntegerAtom)first;
		}
		if (first instanceof DecimalAtom) {
			firstDec = (DecimalAtom)first;
		}
		
		if (second instanceof IntegerAtom) {
			secondInt = (IntegerAtom)second;
		}
		if (second instanceof DecimalAtom) {
			secondDec = (DecimalAtom)second;
		}
		
		if (firstInt != null && secondInt != null) {
			if (firstInt.getValue()<secondInt.getValue()) {
				return TAtomicExpressionFactory.newInstance();
			}
			
		} else {
			if (firstDec.getValue()<secondDec.getValue()) {
				return TAtomicExpressionFactory.newInstance();
			}
		}
		
		return NilAtomicExpressionFactory.newInstance();

	}
	

}
