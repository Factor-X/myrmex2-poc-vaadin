package eu.factorx.vaadinpoc.ui.window;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

public class MyWindowTemplate extends Panel{
	
	CustomLayout cl;
	
	public MyWindowTemplate(String title){
		
		cl = new CustomLayout("mywindow");
		this.setContent(cl);		
		
		if(title!=null){
			addCompenementToHeader(new Label(title));
		}
		
	}
	

	public void addCompenementToHeader(Component component){
		cl.addComponent(component, "header");
	}
	
	public void addCompenementToContent(Component component){
		cl.addComponent(component, "content");
	}
	
	public void addCompenementToFooter(Component component){
		cl.addComponent(component, "footer");
	}
	

}
