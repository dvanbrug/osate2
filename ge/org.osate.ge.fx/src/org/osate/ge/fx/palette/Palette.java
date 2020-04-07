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
package org.osate.ge.fx.palette;

import java.util.ArrayList;
import java.util.Objects;

import org.osate.ge.fx.NodeApplication;

import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * Generic palette component.
 *
 */
public class Palette<G, I> extends Region {

	// TODO: Find a way to bind the width property of the palette to the window size.
	// Using a simple paletteVbox.widthProperty().bind(this.widthProperty())
	// does not work.

	private final VBox paletteVbox = new VBox();
	private final ArrayList<PaletteGroup<G, I>> paletteList = new ArrayList<PaletteGroup<G, I>>();

	public Palette(final PaletteModel<G, I> model) {
		Objects.requireNonNull(model, "model must not be null");

		paletteVbox.setFillWidth(true);

		for (I item : model.getItems(null)) {

			PaletteItem<I> grouplessItem = new PaletteItem<I>(model, item);
			paletteVbox.getChildren().add(grouplessItem);

		}

		for (G group : model.getGroups()) {


			final PaletteGroup<G, I> paletteGroup = new PaletteGroup<>(model, group);
			paletteList.add(paletteGroup);
			paletteVbox.getChildren().add(paletteGroup);

			for (PaletteGroup<?, ?> G : paletteList) {

				G.expandedProperty().addListener((observable, oldValue, newValue) -> {

					if (newValue) {

						for (PaletteGroup<?, ?> I : paletteList) {

							if (I != G) {

								I.setExpanded(false);

							}

						}

					}

				});

			}

		}
		this.getChildren().add(paletteVbox);
	}

	public static void main(final String[] args) {
		NodeApplication.run(() -> new Node[] { new Palette<>(new TestPaletteModel()) });
	}

}