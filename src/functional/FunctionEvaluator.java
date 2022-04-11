package functional;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.FunctionFactory;
import main.lisp.evaluator.function.Lambda;
import main.lisp.evaluator.function.LambdaFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class FunctionEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		IdentifierAtom[] argNames1 = new IdentifierAtom[1];
		SExpression current = arg0.getTail().getHead().getTail().getHead();
		int index = 0;
		if(current.isAtom()) {
			argNames1 = new IdentifierAtom[0];
			if (arg0.getTail().isList()) {
				SExpression body =arg0.getTail().getHead().getTail().getTail();
				Lambda lambda = LambdaFactory.newInstance(argNames1, body);
				return FunctionFactory.newInstance(lambda, arg1);
			}
			Lambda lambda = LambdaFactory.newInstance(argNames1, arg0.getTail().getTail());
			return FunctionFactory.newInstance(lambda, arg1);
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
		
		Lambda lambda =  LambdaFactory.newInstance(argNames1, arg0.getTail().getHead().getTail().getTail());		return FunctionFactory.newInstance(lambda, arg1);
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
