package functional;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class LetEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		Environment childEnvironment = arg1.newChild();
		SExpression currentDeclare = arg0.getTail().getHead();
		SExpression currentBody = arg0.getTail().getTail();
		while (!currentDeclare.getTail().isNIL()) {
			childEnvironment.assign((IdentifierAtom)currentDeclare.getHead().getHead(), currentDeclare.getHead().getTail().getHead());
			currentDeclare = currentDeclare.getTail();
		}
		if (!currentDeclare.isAtom()) {
			childEnvironment.assign((IdentifierAtom) currentDeclare.getHead().getHead(), currentDeclare.getHead().getTail().getHead().eval(arg1));
		}
		SExpression currentEval = currentBody.getHead().eval(childEnvironment);
		while(!currentBody.getTail().isNIL()) {
			currentEval = currentBody.getHead().eval(childEnvironment);
			currentBody = currentBody.getTail();
		}
		return currentEval;
	}

}
