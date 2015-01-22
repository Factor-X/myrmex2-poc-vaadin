package eu.factorx.vaadinpoc.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class MainPage implements EntryPoint {
    @Override
    public void onModuleLoad() {
    	// Create a button widget
        Button button = new Button();
        
        final Label label = new Label();
        
        button.setText("Click me!");
        button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				label.setText("Hello, world!");
            }
        });
        RootPanel.get().add(button);
        RootPanel.get().add(label);
        
    }
}
