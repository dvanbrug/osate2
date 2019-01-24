package org.osate.ui.dependencyvisualization;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkingSet;
import org.osate.ui.OsateUiPlugin;

public class ProjectDependencyVisualizationView extends AbstractDependencyVisualizationView {
	public static final String ID = "org.osate.ui.projectdependencyvisualization";

	private final Image projectImage = OsateUiPlugin.getImageDescriptor("icons/project.png").createImage();

	private final IAction showAllProjectsAction = new Action("Show All Projects in Workspace") {
		@Override
		public void run() {
			setScopeToWorkspace();
		}
	};

	private final IAction focusOnProjectAction = new Action() {
		@Override
		public void run() {
			setScope((IProject) graph.getStructuredSelection().getFirstElement());
		}
	};

	@Override
	public void dispose() {
		super.dispose();
		projectImage.dispose();
	}

	@Override
	protected void menuAboutToShow(IMenuManager manager) {
		manager.add(showAllProjectsAction);
		manager.add(new Separator());
		IStructuredSelection selection = graph.getStructuredSelection();
		if (selection.size() == 1) {
			Object selectedObject = selection.getFirstElement();
			if (selectedObject instanceof IProject) {
				IProject selectedProject = (IProject) selectedObject;
				focusOnProjectAction.setText("Show Projects Connected to '" + selectedProject.getName() + "'");
				manager.add(focusOnProjectAction);
			}
		}
	}

	@Override
	protected Image getImage(Object element) {
		if (element instanceof IProject) {
			return projectImage;
		} else {
			return null;
		}
	}

	@Override
	protected String getText(Object element) {
		if (element instanceof IProject) {
			return ((IProject) element).getName();
		} else {
			return null;
		}
	}

	@Override
	protected void setScopeToWorkspace() {
		input = new ProjectVisualizationInput();
		graph.setInput(input);
		label.setText("All Projects in Workspace");
	}

	public void setScope(IWorkingSet workingSet) {
		input = new ProjectVisualizationInput(workingSet);
		graph.setInput(input);
		label.setText("Projects in Working Set '" + workingSet.getName() + "'");
	}

	public void setScope(IProject project) {
		input = new ProjectVisualizationInput(project);
		graph.setInput(input);
		label.setText("Projects Connected to Project '" + project.getName() + "'");
	}
}