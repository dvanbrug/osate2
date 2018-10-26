package org.osate.ui.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.osate.search.AadlSearchResult;
import org.osate.search.AadlSearchResultEvent;
import org.osate.search.FoundDeclarationEvent;
import org.osate.search.FoundReferenceEvent;

public final class AadlSearchResultPage implements ISearchResultListener, ISearchResultPage {
	private static final Object[] NO_CHILDREN = new Object[0];

	private AadlSearchResult searchResult;
	private IPageSite pageSite;
	private String id;

	private Composite root;
	private TreeViewer treeViewer;

	private final List<URI> declsList = new ArrayList<>();
	private final List<URI> refsList = new ArrayList<>();
	private final List[] inputNode = { declsList, refsList };

	public AadlSearchResultPage() {
		super();
	}

	@Override
	public IPageSite getSite() {
		return pageSite;
	}

	@Override
	public void init(final IPageSite site) throws PartInitException {
		pageSite = site;
	}

	@Override
	public void createControl(final Composite parent) {
		root = new Composite(parent, SWT.NULL);
		final Tree tree = new Tree(root, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tree.setLayoutData(new GridData(GridData.FILL_BOTH));
		tree.setLinesVisible(false);
		tree.setHeaderVisible(false);
		tree.setFont(parent.getFont());

		final TreeColumn column = new TreeColumn(tree, SWT.LEFT);
		final TreeColumnLayout treeLayout = new TreeColumnLayout();
		treeLayout.setColumnData(column, new ColumnWeightData(1, true));
		root.setLayout(treeLayout);

		treeViewer = new TreeViewer(tree);
		treeViewer.setLabelProvider(new TreeLabelProvider());
		treeViewer.setContentProvider(new TreeContentProvider());
		treeViewer.setInput(inputNode);
	}

	@Override
	public void dispose() {
		// nothind to do
	}

	@Override
	public Control getControl() {
		return root;
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
		// nothing to do
	}

	@Override
	public void setFocus() {
		// TODO Is there a sub component that can receive the focus?
		root.setFocus();
	}

	@Override
	public Object getUIState() {
		// TODO Something better we can do here?
		return null;
	}

	@Override
	public void setInput(final ISearchResult search, final Object uiState) {
		System.out.println("setInput: " + search);
		if (search == null) {
			// clean up old search
			if (searchResult != null) {
				searchResult.removeListener(this);
				searchResult = null;
			}
			declsList.clear();
			refsList.clear();
		} else {
			final AadlSearchResult aadlSearchResult = (AadlSearchResult) search;
			searchResult = aadlSearchResult;
			aadlSearchResult.addListener(this);
			aadlSearchResult.getFoundDeclarations().forEach(objDesc -> declsList.add(objDesc.getEObjectURI()));
			aadlSearchResult.getFoundReferences().forEach(refDesc -> refsList.add(refDesc.getSourceEObjectUri()));
			Display.getDefault().asyncExec(() -> treeViewer.refresh());
		}
	}

	@Override
	public void setViewPart(final ISearchResultViewPart part) {
		// nothing to do

	}

	@Override
	public void restoreState(IMemento memento) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveState(final IMemento memento) {
		// nothing to do

	}

	@Override
	public void setID(final String id) {
		this.id = id;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public String getLabel() {
		return searchResult.getLabel();
	}

	@Override
	public void searchResultChanged(final SearchResultEvent e) {
		if (e instanceof AadlSearchResultEvent) {
			if (e instanceof FoundDeclarationEvent) {
				final IEObjectDescription objDesc = ((FoundDeclarationEvent) e).getObjectDescription();
				final URI uri = objDesc.getEObjectURI();
				System.out.print("Found declaration in " + uri.lastSegment() + ": ");
				for (final String segment : objDesc.getName().getSegments()) {
					System.out.print("[" + segment + "]");
				}
				System.out.println(" -- " + uri);

				declsList.add(uri);
			} else if (e instanceof FoundReferenceEvent) {
				final IReferenceDescription refDesc = ((FoundReferenceEvent) e).getReferenceDescription();
				final URI sourceURI = refDesc.getSourceEObjectUri();
				System.out.println("Found reference in " + sourceURI.lastSegment() + ": " + sourceURI + " -> "
						+ refDesc.getTargetEObjectUri());

				refsList.add(sourceURI);
			}

			Display.getDefault().asyncExec(() -> treeViewer.refresh());
		}
	}

	private final class TreeContentProvider implements ITreeContentProvider {
		@Override
		public Object[] getElements(final Object inputElement) {
			return (Object[]) inputElement;
		}

		@Override
		public Object[] getChildren(final Object parentElement) {
			if (parentElement instanceof List) {
				return ((List) parentElement).toArray();
			} else {
				return NO_CHILDREN;
			}
		}

		@Override
		public Object getParent(final Object element) {
			if (element instanceof List) {
				return inputNode;
			} else if (element instanceof URI) {
				if (declsList.contains(element)) {
					return declsList;
				} else if (refsList.contains(element)) {
					return refsList;
				}
			}
			return null;
		}

		@Override
		public boolean hasChildren(final Object element) {
			if (element instanceof List) {
				return true;
			}
			return false;
		}
	}

	private final class TreeLabelProvider extends LabelProvider {
		@Override
		public Image getImage(final Object element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getText(final Object element) {
			if (element == refsList) {
				return "References";
			} else if (element == declsList) {
				return "Declarations";
			} else if (element instanceof URI) {
				return ((URI) element).toString();
			}
			return "NO LABEL";
		}

	}
}
