package evaluators;
import main.lisp.parser.terms.AbstractSExpression;
import main.lisp.parser.terms.BasicExpression;
import main.lisp.parser.terms.SExpression;
public class StringFormats extends BasicExpression{

	public StringFormats(SExpression head, SExpression tail) {
		super(head, tail);
	}
	@Override
	public String toString() {
		if(this.isNIL()) {
			return this.toStringAsSExpression();
		}
		return this.isList()? this.toStringAsList() : this.toStringAsSExpression();
	}
	@Override
	public String toStringAsSExpressionDeep() {
		return "(" + this.getHead().toStringAsSExpressionDeep() + " . " + this.getTail().toStringAsSExpressionDeep() + ")";
	}
	
	@Override
	public String toStringAsSExpression() {
		return "(" + this.getHead().toString() + " . " + this.getTail().toString() + ")";
	}
	@Override
	public String toStringAsListHelperPublic() {
		if (this.getTail().isNIL()) {
			return this.getHead().toString();
		}else {
			return this.getHead().toString() + " " + ((AbstractSExpression) this.getTail()).toStringAsListHelperPublic();
		}
		
	}
	@Override
	public String toStringAsList() {
			// does the same thing as toStringas list deep....need to change
			return "(" + this.toStringAsListHelperPublic() + ")";
	}

	@Override
	public boolean isList() {
		// if head is a non nil atom and tail is nil, is a list
		if(this.getTail().isNIL()) {
			return true;
			// if the tail is an atom but not nil, it is not a list
		} else if (this.getTail().isAtom() && !(this.getTail().isNIL())) {
			return false;
		} else 
			return this.getTail().isList();
		}

}
