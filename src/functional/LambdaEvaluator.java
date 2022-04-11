package functional;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.LambdaFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class LambdaEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		IdentifierAtom[] argNames1 = new IdentifierAtom[1];
		SExpression current = arg0.getTail().getHead();
		int index = 0;
		if(current.isAtom()) {
			argNames1 = new IdentifierAtom[0];
			return LambdaFactory.newInstance(argNames1, arg0.getTail().getTail());
		}
		while(!current.getTail().isNIL()) {
			// expand size if you still need to add arg names
			argNames1 = expandArray(argNames1, index);
			argNames1[index] = (IdentifierAtom) current.getHead();
			current = current.getTail();
			index++;
		}
		//add last argument (the last argument has nil as its tail)
		if (!current.getHead().isNIL()) {
			argNames1 = expandArray(argNames1, index);
			argNames1[index] = (IdentifierAtom) current.getHead();
		}
		
		return LambdaFactory.newInstance(argNames1, arg0.getTail().getTail());
	}
	
	private IdentifierAtom[] expandArray(IdentifierAtom[] array, int index) {
		if (index == array.length) {
			int size = array.length+ 1;
			IdentifierAtom[] newArray = new IdentifierAtom[size];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			//array = newArray;
			return newArray;
		}
		return array;
		
	}

}
