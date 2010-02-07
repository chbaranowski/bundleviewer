package de.propix.zest.bundleviewer;

import java.util.ArrayList;
import java.util.List;

import de.propix.zest.bundleviewer.model.Bundle;
import de.propix.zest.bundleviewer.model.Node;
import de.propix.zest.bundleviewer.model.Service;

public class Content {
	
	private final List<Node> nodes = new ArrayList<Node>();
	
	public Content() {
		
		Bundle coreBundle = new Bundle();
		coreBundle.setName("de.propix.runtimetester.core");
		
		Service testerService = new Service();
		testerService.setInterfaceName("de.propix.runtimetester.core.runner.Tester");
		testerService.setBundle(coreBundle);
		
		coreBundle.addService(testerService);
		
		getNodes().add(coreBundle);
		getNodes().add(testerService);
		
		Bundle webBundle = new Bundle();
		webBundle.setName("de.propix.runtimetester.web");
		webBundle.useService(testerService);
		getNodes().add(webBundle);
		
		
		Service integratedTestService = new Service();
		integratedTestService.setInterfaceName("de.propix.runtimetester.core.IntegratedTestService");
		getNodes().add(integratedTestService);
		
		Bundle userBundle = new Bundle();
		userBundle.setName("de.propix.runtimetester.example.component.user");
		getNodes().add(userBundle);
		
		integratedTestService.setBundle(userBundle);
		
		userBundle.addService(integratedTestService);
		
		coreBundle.useService(integratedTestService);
		
	}

	public List<Node> getNodes() {
		return nodes;
	}
	
}
