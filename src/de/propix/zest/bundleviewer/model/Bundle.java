package de.propix.zest.bundleviewer.model;

import java.util.ArrayList;
import java.util.List;

public class Bundle implements Node {
	
	private String name;

	private List<Service> providedServices = new ArrayList<Service>();
	
	private List<Service> useServices = new ArrayList<Service>();
	
	public void useService(Service service){
		this.getUseServices().add(service);
	}
		
	public boolean addService(Service e) {
		return getProvidedServices().add(e);
	}

	public boolean removeService(Service o) {
		return getProvidedServices().remove(o);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Service> getProvidedServices() {
		return providedServices;
	}

	public List<Service> getUseServices() {
		return useServices;
	}
	
}
