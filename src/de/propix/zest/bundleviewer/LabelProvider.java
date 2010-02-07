package de.propix.zest.bundleviewer;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.ISelfStyleProvider;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;

import de.propix.zest.bundleviewer.model.Bundle;
import de.propix.zest.bundleviewer.model.Service;


public class LabelProvider extends org.eclipse.jface.viewers.LabelProvider
		implements ISelfStyleProvider {

	Image classImage = new Image(Display.getDefault(), LabelProvider.class
			.getResourceAsStream("class_obj.gif"));

	Image bundleImage = new Image(Display.getDefault(), LabelProvider.class
			.getResourceAsStream("package_obj.gif"));
	
	@Override
	public String getText(Object element) {
		if (element instanceof Bundle) {
			Bundle bundle = (Bundle) element;
			return bundle.getName();
		}
		if (element instanceof Service) {
			Service service = (Service) element;
			return service.getInterfaceName();
		}

		if (element instanceof EntityConnectionData) {
			return "";
		}
		throw new RuntimeException("Wrong type: "
				+ element.getClass().toString());
	}

	public void selfStyleConnection(Object element, GraphConnection connection) {
		if (element instanceof EntityConnectionData) {
			EntityConnectionData connectionData = (EntityConnectionData) element;
			Service service = (Service) connectionData.dest;
			Bundle bundle = (Bundle) connectionData.source;
			if (!service.getBundle().equals(bundle)) {
				connection.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
			} else {
				connection.setLineWidth(2);
			}
		}
	}

	public void selfStyleNode(Object element, GraphNode node) {
		if (element instanceof Service) {
	//		node.setImage(classImage);
		}
		if (element instanceof Bundle) {
			node.setImage(bundleImage);
		}
	}

}
