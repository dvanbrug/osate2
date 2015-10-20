/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.ui;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ImvUiPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.osate.imv.ui"; //$NON-NLS-1$

	// The shared instance
	private static ImvUiPlugin plugin;

	/**
	 * The constructor
	 */
	public ImvUiPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ImvUiPlugin getDefault() {
		return plugin;
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry registry) {
	     // Add image descriptors to registry.
	     registry.put(IImageKeys.ARROW_STOP_ICON, ImvUiPlugin.imageDescriptorFromPlugin(ImvUiPlugin.PLUGIN_ID, IImageKeys.ARROW_STOP_ICON));
	     registry.put(IImageKeys.STEP_INTO_ICON, ImvUiPlugin.imageDescriptorFromPlugin(ImvUiPlugin.PLUGIN_ID, IImageKeys.STEP_INTO_ICON));
	     registry.put(IImageKeys.STEP_OUT_ICON, ImvUiPlugin.imageDescriptorFromPlugin(ImvUiPlugin.PLUGIN_ID, IImageKeys.STEP_OUT_ICON));
	     registry.put(IImageKeys.INCR_NESTING_ICON, ImvUiPlugin.imageDescriptorFromPlugin(ImvUiPlugin.PLUGIN_ID, IImageKeys.INCR_NESTING_ICON));
	     registry.put(IImageKeys.DECR_NESTING_ICON, ImvUiPlugin.imageDescriptorFromPlugin(ImvUiPlugin.PLUGIN_ID, IImageKeys.DECR_NESTING_ICON));
	     registry.put(IImageKeys.ZOOM_IN_ICON, ImvUiPlugin.imageDescriptorFromPlugin(ImvUiPlugin.PLUGIN_ID, IImageKeys.ZOOM_IN_ICON));
	     registry.put(IImageKeys.ZOOM_OUT_ICON, ImvUiPlugin.imageDescriptorFromPlugin(ImvUiPlugin.PLUGIN_ID, IImageKeys.ZOOM_OUT_ICON));
	     registry.put(IImageKeys.RESIZE_ICON, ImvUiPlugin.imageDescriptorFromPlugin(ImvUiPlugin.PLUGIN_ID, IImageKeys.RESIZE_ICON));
	     registry.put(IImageKeys.AUTO_LAYOUT_ICON, ImvUiPlugin.imageDescriptorFromPlugin(ImvUiPlugin.PLUGIN_ID, IImageKeys.AUTO_LAYOUT_ICON));
	     registry.put(IImageKeys.RESIZE_ACTUAL_ICON, ImvUiPlugin.imageDescriptorFromPlugin(ImvUiPlugin.PLUGIN_ID, IImageKeys.RESIZE_ACTUAL_ICON));
	     registry.put(IImageKeys.SHOW_ERROR_ICON, ImvUiPlugin.imageDescriptorFromPlugin(ImvUiPlugin.PLUGIN_ID, IImageKeys.SHOW_ERROR_ICON));
	     registry.put(IImageKeys.HIDE_ERROR_ICON, ImvUiPlugin.imageDescriptorFromPlugin(ImvUiPlugin.PLUGIN_ID, IImageKeys.HIDE_ERROR_ICON));
	     registry.put(IImageKeys.DIRECT_CONNECTION_ICON, ImvUiPlugin.imageDescriptorFromPlugin(ImvUiPlugin.PLUGIN_ID, IImageKeys.DIRECT_CONNECTION_ICON));
	     registry.put(IImageKeys.HIERARCHICAL_CONNECTION_ICON, ImvUiPlugin.imageDescriptorFromPlugin(ImvUiPlugin.PLUGIN_ID, IImageKeys.HIERARCHICAL_CONNECTION_ICON));

	}

}