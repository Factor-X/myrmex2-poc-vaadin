package eu.factorx.vaadinpoc.ui;

import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.ui.AbstractComponentConnector;

public class MyComponent extends AbstractComponentConnector{
	

	//build rpc
	private MyComponentServerRpc rpc=RpcProxy.create(MyComponentServerRpc.class, this);
	
	

}
