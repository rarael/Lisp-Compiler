package a5;

import environments.EnvironmentImplementation;
import evaluators.LispOperationRegisterer;
import evaluators.StringFormats;
import expression.CondEvaluator;
import expression.EvalEvaluator;
import expression.ListEvaluator;
import expression.LoadEvaluator;
import expression.QuoteEvaluator;
import functional.LambdaEvaluator;
import functional.SetqEvaluator;
import gradingTools.comp524f21.assignment6.ClassRegistryA6;
import logical.AndEvaluator;
import logical.NotEvaluator;
import logical.OrEvaluator;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.OperationRegisterer;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;
import relational.GreaterThanEqualEvaluator;
import relational.GreaterThanEvaluator;
import relational.LessThanEqualEvaluator;
import relational.LessThanEvaluator;;

public class LispClassRegistry implements ClassRegistryA6{
	@Override
	public Class getAndEvaluator() {
		return AndEvaluator.class;
	}
	@Override
	public Class getCondEvaluator() {
		return CondEvaluator.class;
	}
	@Override
	public Class getCustomOperationRegisterer() {
		return LispOperationRegisterer.class;
	}
	@Override
	public Class getEvalEvaluator() {
		return EvalEvaluator.class;
	}
	@Override
	public Class getGTEEvaluator() {
		return GreaterThanEqualEvaluator.class;
	}
	@Override
	public Class getGTEvaluator() {
		return GreaterThanEvaluator.class;
	}
	@Override
	public Class getLTEEvaluator() {
		return LessThanEqualEvaluator.class;
	}
	@Override
	public Class getLTEvaluator() {
		return LessThanEvaluator.class;
	}
	@Override
	public Class getListEvaluator() {
		return ListEvaluator.class;
	}
	@Override
	public Class getLoadEvaluator() {
		return LoadEvaluator.class;
	}
	@Override
	public Class getMain() {
		return RunLisp.class;
	}
	@Override
	public Class getNotEvaluator() {
		return NotEvaluator.class;
	}
	@Override
	public Class getOrEvaluator() {
		return OrEvaluator.class;
	}
	@Override
	public Class getQuoteEvaluator() {
		return QuoteEvaluator.class;
	}
	@Override
	public Class getStringFormattingSExpression() {
		return StringFormats.class;
	}
	@Override
	public Class<? extends SExpression> getFunctionCallingSExpression() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Class<? extends Evaluator> getFunctionEvaluator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Class<? extends Evaluator> getLetEvaluator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Class<? extends Evaluator> getBasicFuncallEvaluator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Class<? extends IdentifierAtom> getIdentifierAtomWithLookup() {
		return VariableEval.class;
	}
	@Override
	public Class<? extends SExpression> getLambdaCallingSExpression() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Class<? extends Evaluator> getLambdaEvaluator() {
		return LambdaEvaluator.class;
	}
	@Override
	public Class<? extends Environment> getNestedLexicalEnvironment() {
		return EnvironmentImplementation.class;
	}
	@Override
	public Class<? extends Evaluator> getSetqEvaluator() {
		return SetqEvaluator.class;
	}
	@Override
	public Class<? extends OperationRegisterer> getStatefulOperationRegisterer() {
		// TODO Auto-generated method stub
		return null;
	}
}
