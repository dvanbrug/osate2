/*
 * generated by Xtext
 */
package org.osate.expr.ui.outline;

import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.expr.expr.ExprLibrary;
import org.osate.expr.expr.ExprSubclause;

/**
 * Customization of the default outline structure.
 *
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline
 */
public class ExprOutlineTreeProvider extends org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider {

	protected void _createChildren(IOutlineNode parentNode, DefaultAnnexLibrary defaultAnnexLibrary) {
		if (defaultAnnexLibrary.getParsedAnnexLibrary() instanceof ExprLibrary) {
			_createChildren(parentNode, defaultAnnexLibrary.getParsedAnnexLibrary());
		}
	}

	protected void _createChildren(IOutlineNode parentNode, DefaultAnnexSubclause defaultAnnexSubclause) {
		if (defaultAnnexSubclause.getParsedAnnexSubclause() instanceof ExprSubclause) {
			_createChildren(parentNode, defaultAnnexSubclause.getParsedAnnexSubclause());
		}
	}

}
