package org.osate.ui.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.osate.core.AadlNature;

/**
 * Abstract root class for handlers that generate multiple independent jobs and that shows a single
 * result dialog at the end showing their status.
 *
 * NB. This is not fully formed right now but I am leaving it as a placeholder for future work to
 * abstract the commonalities between {@link InstantiationHandler} and {@link ReinstantiationHandler}.
 * Really the only thing in here right now is the class used for storing job results.
 * @since 3.0
 */
public abstract class AbstractMultiJobHandler extends AbstractHandler {

	/**
	 * Records the state of one of the jobs, i.e, was it successful, was it cancelled, did it have
	 * an error of some sort?
	 *
	 * <p>The job is <i>cancelled</i> if the user cancelled it via the progress monitor.  When {@link #cancelled}
	 * is non-{@code true}, {@link #successful} must be {@code false}.
	 *
	 * <p>An <i>error</i> is a message that was generated by internals of the job when
	 * the job found something wrong.  When {@link #errorMessage} is non-{@code null}, {@link #successful}
	 * must be {@code false}.
	 *
	 * <P>An <i>exception<i> is an exception that was thrown during execution of the job.  Here we expect
	 * this to be some low-level eclipse craziness that the job is not equipped to deal with.  It is expected
	 * that a job either has an error, an exception, or neither, but never both.  When {@link #exception} is
	 * non-{@code null}, {@link #successful} must be {@code false}.
	 */
	public static final class Result {
		/**
		 * The result value for a job that has not been schedule or executed yet.  This is used to
		 * initialize the set of results for a set of jobs.  It identifies a job as cancelled
		 * because a job that is cancelled by the user before it runs never updates its state
		 * in the shared list of jobs, so we must make its initial state as cancelled.
		 */
		public static final Result NOT_EXECUTED = new Result(false, true, null, null);

		/* Make everything final here so that this class is thread-safe immutable */
		public final boolean successful;
		public final boolean cancelled;
		public final String errorMessage;
		public final Exception exception;

		public Result(final boolean successful, final boolean cancelled, final String errorMessage,
				final Exception exception) {
			this.successful = successful;
			this.cancelled = cancelled;
			this.errorMessage = errorMessage;
			this.exception = exception;
		}

		public static boolean allSuccessful(final Collection<Result> results) {
			boolean allSuccessful = true;
			for (final Result r : results) {
				allSuccessful &= r.successful;
			}
			return allSuccessful;
		}
	}

	/**
	 * Ask to save all the dirty editors that belong to open AADL projects.
	 * @return {@code true} If the action should continue; {@code false} if the user
	 * selected the cancel option in the save dialog.
	 */
	protected boolean saveDirtyEditors() {
		/* Find all the open AADL projects */
		final IProject[] allProjects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		final List<IProject> openAADLProjects = new ArrayList<>(allProjects.length);
		for (final IProject project : allProjects) {
			if (project.isOpen() && AadlNature.hasNature(project)) {
				openAADLProjects.add(project);
			}
		}

		final AtomicBoolean result = new AtomicBoolean();
		PlatformUI.getWorkbench().getDisplay().syncExec(() -> {
			result.set(IDE.saveAllEditors(openAADLProjects.toArray(new IProject[openAADLProjects.size()]), true));
		});
		return result.get();
	}

	protected AbstractMultiJobHandler() {
		super();
	}
}
