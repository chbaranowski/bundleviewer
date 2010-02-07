package de.propix.zest.bundleviewer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.DirectedGraphLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.GridLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.HorizontalLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.HorizontalShift;
import org.eclipse.zest.layouts.algorithms.HorizontalTreeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.VerticalLayoutAlgorithm;


public class Viewer {
	
	static GraphViewer viewer = null;

	public static void run() {
		Display d = new Display();
		Shell shell = new Shell(d);
		shell.setText("Services and Bundles");
		shell.setLayout(new FillLayout(SWT.VERTICAL));
		shell.setSize(800, 800);
		viewer = new GraphViewer(shell, SWT.NONE);
		viewer.setContentProvider(new ContentProvider());
		viewer.setLabelProvider(new LabelProvider());
		viewer.setInput(new Content().getNodes());
		viewer.setLayoutAlgorithm(new VerticalLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING));
		
		shell.open();
		while (!shell.isDisposed()) {
			while (!d.readAndDispatch()) {
				d.sleep();
			}
		}

	}
	
	public static void main(String[] args) {
		run();
	}
	
}
