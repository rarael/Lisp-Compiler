package environments;

import java.util.Optional;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.environment.AbstractEnvironment;
import main.lisp.evaluator.function.Function;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;

public class EnvironmentImplementation extends AbstractEnvironment {

	public EnvironmentImplementation() {
		super();
	}
	
	public EnvironmentImplementation(Environment parent) {
		super(parent);
	}
	@Override
	public void assign(IdentifierAtom arg0, SExpression arg1) {
		this.put(arg0, arg1);
	}

	@Override
	public void assignFun(IdentifierAtom arg0, Function arg1) {
		this.getFunctionMap().put(arg0.toString(), arg1);
	}

	@Override
	public Environment copy() {
		return this;
	}

	@Override
	public Optional<SExpression> lookup(IdentifierAtom arg0) {
		if(this.get(arg0).isEmpty() && this.getParent() != null) {
			return this.getParent().get(arg0);
		}
		return this.get(arg0);
	}

	@Override
	public Optional<Function> lookupFun(IdentifierAtom arg0) {
		// TODO Auto-generated method stub
		return this.getFun(arg0);
	}

	@Override
	public Environment newChild() {
		return new EnvironmentImplementation(this);
		
	}

}
