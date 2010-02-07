package de.propix.zest.bundleviewer.model;

public class Service implements Node {

	private String interfaceName;

	private Bundle bundle;
	
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setBundle(Bundle bundle) {
		this.bundle = bundle;
	}

	public Bundle getBundle() {
		return bundle;
	}
	
}
