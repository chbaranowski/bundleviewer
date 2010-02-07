package de.propix.zest.bundleviewer;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

import de.propix.zest.bundleviewer.model.Bundle;
import de.propix.zest.bundleviewer.model.Service;

public class ContentProvider extends ArrayContentProvider implements IGraphEntityContentProvider {

	public Object[] getConnectedTo(Object entity) {
		if (entity instanceof Bundle) {
			ArrayList<Object> connections = new ArrayList<Object>();
			Bundle bundle = (Bundle) entity;
			connections.addAll(bundle.getUseServices());
			connections.addAll(bundle.getProvidedServices());
			return connections.toArray();
		}
		if (entity instanceof Service) {
			Service service = (Service) entity;
			return new Object[]{};
		}
		throw new RuntimeException("Type not supported");
	}

}
