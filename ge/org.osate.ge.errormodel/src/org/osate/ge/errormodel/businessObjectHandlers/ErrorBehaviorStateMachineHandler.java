/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.errormodel.businessObjectHandlers;

import javax.inject.Named;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.BuildCreateOperation;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.di.ValidateName;
import org.osate.ge.errormodel.ErrorModelCategories;
import org.osate.ge.errormodel.util.ErrorModelNamingUtil;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

public class ErrorBehaviorStateMachineHandler {
	private static final Graphic graphic = RectangleBuilder.create().rounded().build();

	@IsApplicable
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine bo) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration() {
		return GraphicalConfigurationBuilder.create().graphic(graphic)
				.annotation("<Error Behavior State Machine>")
				.style(ErrorModelGeUtil.topCenteredLabelStyle).build();
	}

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries() {
		return new PaletteEntry[] { PaletteEntryBuilder.create().label("Error Behavior State Machine")
				.category(ErrorModelCategories.ERROR_MODEL).build()
		};
	}

	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) AadlPackage pkg) {
		return true;
	}

	@BuildCreateOperation
	public Operation buildCreateOperation(@Named(Names.TARGET_BO) final AadlPackage pkgReadOnly,
			final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc) {
		return Operation.create(createOp -> {
			createOp.supply(() -> {
				final ErrorModelLibrary errorModelLibrary = ErrorModelGeUtil.getErrorModelLibrary(pkgReadOnly);
				final Object boToModify = errorModelLibrary == null ? pkgReadOnly : errorModelLibrary;
				return StepResult.forValue(boToModify);
			}).modifyPreviousResult(modifyBo -> {
				// Create the annex if doesn't exist. It is important for the target to be the annex library if it does exist. Otherwise modification will fail in some
				// cases such as when an Xtext document is open.
				final ErrorModelLibrary errorModelLibrary;
				if (modifyBo instanceof AadlPackage) {
					errorModelLibrary = ErrorModelGeUtil.getOrCreateErrorModelLibrary((AadlPackage) modifyBo);
				} else if (modifyBo instanceof ErrorModelLibrary) {
					errorModelLibrary = (ErrorModelLibrary) modifyBo;
				} else {
					throw new RuntimeException("Modify business object is not of expected type. BO: " + modifyBo);
				}

				// Create the ErrorBehaviorStateMachine
				final ErrorBehaviorStateMachine newBehavior = (ErrorBehaviorStateMachine)EcoreUtil.create(ErrorModelPackage.eINSTANCE.getErrorBehaviorStateMachine());
				final String newName = ErrorModelNamingUtil.buildUniqueIdentifier(errorModelLibrary, "new_state_machine");
				newBehavior.setName(newName);

				// Add the new type to the error model library
				errorModelLibrary.getBehaviors().add(newBehavior);

				return StepResultBuilder.create().showNewBusinessObject(targetBoc, newBehavior).build();
			});
		});
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine stateMachine) {
		return stateMachine.getName();
	}

	@ValidateName
	public String validateName(final @Named(Names.BUSINESS_OBJECT) ErrorBehaviorStateMachine stateMachine, final @Named(Names.NAME) String value) {
		final ErrorModelLibrary errorModelLibrary = (ErrorModelLibrary)stateMachine.eContainer();
		return ErrorModelNamingUtil.validateName(errorModelLibrary, stateMachine.getName(), value);
	}
}
