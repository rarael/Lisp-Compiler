package expression;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.interpreter.InterpreterModelSingleton;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;

public class LoadEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression arg0, Environment arg1) {
		// figure out how to fix path
		try {
			String string = arg0.getTail().getHead().eval(arg1).toString();
			// remove quotations from string
			string = string.substring(1);
			string = string.substring(0, string.length()-1);
			
			Path path = Paths.get(string);
			
			List<String> lines = Files.readAllLines(path, Charset.forName("ISO-8859-1"));
			for (String line: lines) {
				InterpreterModelSingleton.get().newInput(line);
			}
			return new TAtom();
		} catch (IOException e) {
			e.printStackTrace();
			return NilAtomicExpressionFactory.newInstance();
		}
	}

}
