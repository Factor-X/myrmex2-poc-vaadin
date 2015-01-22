package eu.factorx.vaadinpoc.ui;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.communication.ServerRpc;

public interface MyComponentServerRpc extends ServerRpc {
	public void clicked(String buttonName);
}
