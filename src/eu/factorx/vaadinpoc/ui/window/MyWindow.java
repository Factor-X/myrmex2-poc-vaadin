package eu.factorx.vaadinpoc.ui.window;

import java.util.Date;

import com.vaadin.external.org.slf4j.Logger;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import eu.factorx.vaadinpoc.data.Data;
import eu.factorx.vaadinpoc.dto.DTO;

public class MyWindow extends Window{
	
	public MyWindow(final AddArticleInterface addArticleInterface){
		super("créer un nouvel article");
		
		setModal(true);
		center();
		setWidth(500, Unit.PIXELS);
		setHeight(200, Unit.PIXELS);
		
		VerticalLayout verticalLayout = new VerticalLayout();
		
		setContent(verticalLayout);
		

		final TextField field = new TextField();
		verticalLayout.addComponent(field);
		
		Button b = new Button("add article");
		verticalLayout.addComponent(b);
		
		b.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				DTO dto = new DTO(field.getValue());
				DTO dto2 = Data.add(dto);
				Notification.show("Article added !!");
				field.setValue("");
				MyWindow.this.close();
				addArticleInterface.addArticle(dto2);
			}
		});
		verticalLayout.addComponent(field);
		verticalLayout.addComponent(b);
		
		
		
	}

}
