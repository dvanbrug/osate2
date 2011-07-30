/*
* generated by Xtext
*/
package org.osate.xtext.aadl2.ui.outline;

import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;

/**
 * customization of the default outline structure
 * 
 */
public class Aadl2OutlineTreeProvider extends DefaultOutlineTreeProvider {

	protected void _createChildren(DocumentRootNode parentNode,
			ModelUnit aadlModel) {
		if (aadlModel instanceof AadlPackage) {
			for (Element element : aadlModel.getChildren()) {
				createNode(parentNode, element);
			}
		} else {
			createNode(parentNode, aadlModel);
		}
	}
	
	
	protected void _createChildren(DocumentRootNode parentNode,
			SystemInstance aadlModel) {
		createNode(parentNode, aadlModel);
	}
	protected boolean _isLeaf(SystemInstance feature) {
	    return false;
	}
	protected void _createChildren(DocumentRootNode parentNode,
			ComponentInstance aadlModel) {
		createNode(parentNode, aadlModel);
	}

//	protected void _createChildren(DocumentRootNode parentNode,
//			Classifier aadlModel) {
//	}
//
//	// Classifier nodes are leafs and not expandable
//	protected boolean _isLeaf(Classifier feature) {
//	    return true;
//	}
//
//	protected void _createChildren(DocumentRootNode parentNode,
//			Property aadlModel) {
//		if (aadlModel instanceof AadlPackage) {
//			for (Element element : aadlModel.getChildren()) {
//				createNode(parentNode, element);
//			}
//		} else {
//			createNode(parentNode, aadlModel);
//		}
//	}
//	// Property nodes are leafs and not expandable
//	protected boolean _isLeaf(Property feature) {
//	    return true;
//	}
//
//	protected void _createChildren(DocumentRootNode parentNode,
//			PropertyConstant aadlModel) {
//		if (aadlModel instanceof AadlPackage) {
//			for (Element element : aadlModel.getChildren()) {
//				createNode(parentNode, element);
//			}
//		} else {
//			createNode(parentNode, aadlModel);
//		}
//	}
//	// PropertyConstant nodes are leafs and not expandable
//	protected boolean _isLeaf(PropertyConstant feature) {
//	    return true;
//	}
//
//	protected void _createChildren(DocumentRootNode parentNode,
//			PropertyType aadlModel) {
//		if (aadlModel instanceof AadlPackage) {
//			for (Element element : aadlModel.getChildren()) {
//				createNode(parentNode, element);
//			}
//		} else {
//			createNode(parentNode, aadlModel);
//		}
//	}
//	// PropertyType nodes are leafs and not expandable
//	protected boolean _isLeaf(PropertyType feature) {
//	    return true;
//	}
//
	

}
