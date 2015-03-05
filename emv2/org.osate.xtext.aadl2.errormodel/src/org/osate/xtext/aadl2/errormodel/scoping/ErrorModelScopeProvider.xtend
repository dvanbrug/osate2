/*
 * generated by Xtext
 */
package org.osate.xtext.aadl2.errormodel.scoping;

import org.eclipse.emf.ecore.*
import org.eclipse.xtext.EcoreUtil2
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet
import org.osate.xtext.aadl2.properties.scoping.PropertiesScopeProvider
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class ErrorModelScopeProvider extends PropertiesScopeProvider {
	def Iterable<ErrorType> getErrorTypesFromLib(ErrorModelLibrary lib) {
		return (#[lib.types] + lib.extends.map[it | getErrorTypesFromLib(it)]).flatten();
	}

	def Iterable<TypeSet> getTypesetsFromLib(ErrorModelLibrary lib) {
		return (#[lib.typesets] + lib.extends.map[it | getTypesetsFromLib(it)]).flatten();
	}

	def scope_ErrorType_superType(ErrorModelLibrary context, EReference reference) {
		val errorLib = EcoreUtil2.getContainerOfType(context, ErrorModelLibrary);
		return getErrorTypesFromLib(errorLib).scopeFor(delegateGetScope(context, reference));
	}

	def scope_ErrorType_aliasedType(ErrorModelLibrary context, EReference reference) {
		val errorLib = EcoreUtil2.getContainerOfType(context, ErrorModelLibrary);
		return getErrorTypesFromLib(errorLib).scopeFor(delegateGetScope(context, reference));
	}

	def scope_TypeSet_aliasedType(ErrorModelLibrary context, EReference reference) {
		val errorLib = EcoreUtil2.getContainerOfType(context, ErrorModelLibrary);
		return getTypesetsFromLib(errorLib).scopeFor(delegateGetScope(context, reference));
	}

	def scope_TypeToken_type(ErrorModelLibrary context, EReference reference) {
		val errorLib = EcoreUtil2.getContainerOfType(context, ErrorModelLibrary);
		return getErrorTypesFromLib(errorLib).scopeFor(delegateGetScope(context, reference));
	}
	
	def getErrorLibsFromContext(EObject context) {
		val errorLib = EcoreUtil2.getContainerOfType(context, ErrorModelLibrary);
		if (errorLib != null) {
			return #[errorLib];
		} else {
			val subclause = EcoreUtil2.getContainerOfType(context, ErrorModelSubclause);
			return subclause.useTypes;
		}		
	}
	
	def scope_TypeToken_type(TypeSet context, EReference reference) {
		println(context);
		//val subclause = EcoreUtil2.getContainerOfType(context, ErrorModelSubclause);
		val parentScope = delegateGetScope(context, reference);
		//val errorLibs = subclause.useTypes;
		val errorLibs = getErrorLibsFromContext(context);		
		return errorLibs.map[it | getErrorTypesFromLib(it)].flatten().scopeFor(parentScope);
		//return subclause.useTypes.map[types].flatten().scopeFor(parentScope);
		//val errorTypes = subclause.useTypes.map[types].flatten().map[new EObjectDescription(QualifiedName::create(it.name), it, null) as IEObjectDescription];
		//return new SimpleScope(parentScope, errorTypes, true)
	}
}
