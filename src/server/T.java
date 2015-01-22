package server;

import com.vaadin.shared.ui.Connect;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Notification;

import eu.factorx.vaadinpoc.ui.MainUI;
import eu.factorx.vaadinpoc.ui.MyComponentServerRpc;

@Connect(MainUI.class)
public class T extends AbstractComponent {
	
	private MyComponentServerRpc rpc = new MyComponentServerRpc() {

		@Override
		public void clicked(String buttonName) {
			String s = "je suis le server et j'ai reçu : " + buttonName;
			Notification.show(s);
			System.out.println(s);
		}
	};
	
	public T(){
		Notification.show("initialitazeio 1");
		Notification.show("initialitazeio 2");
		registerRpc(rpc);
	}

}
