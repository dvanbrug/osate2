/*
 * generated by Xtext 2.17.0
 */
package org.osate.expr.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ExprAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/osate/expr/parser/antlr/internal/InternalExpr.tokens");
	}
}
