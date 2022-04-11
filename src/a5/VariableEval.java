package a5;

import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.scanner.tokens.Token;
import main.lisp.parser.terms.IdentifierAtomFactory;

public class VariableEval extends IdentifierAtom {

	public VariableEval(String string) {
		super(string);
	}
	public VariableEval(Token token) {
		super(token);
	}
	
	@Override
	public SExpression eval(Environment arg0) {
		IdentifierAtomFactory.setClass(this.getClass());
		if (arg0.lookup(this).isEmpty() && arg0.getParent() != null) {
			return arg0.getParent().lookup(this).get();
		}
		return arg0.lookup(this).get();
	}

}
