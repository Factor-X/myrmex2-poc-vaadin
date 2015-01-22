package eu.factorx.vaadinpoc.ui.window;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import eu.factorx.vaadinpoc.data.Data;
import eu.factorx.vaadinpoc.dto.DTO;

public class Test extends MyWindowTemplate {

	public Test() {
		super("créer un nouvel article");
		/*
		 * setModal(true); center();
		 */
		setWidth(500, Unit.PIXELS);
		setHeight(200, Unit.PIXELS);

		VerticalLayout verticalLayout = new VerticalLayout();

		addCompenementToContent(verticalLayout);

		final TextField field = new TextField();
		verticalLayout.addComponent(field);

		Button b = new Button("add article");

		b.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				/*
				DTO dto = new DTO(field.getValue());
				DTO dto2 = Data.add(dto);
				Notification.show("Article added !!");
				field.setValue("");
				// MyWindow.this.close();
				addArticleInterface.addArticle(dto2);
				*/
			}
		});
		verticalLayout.addComponent(field);
		this.addCompenementToFooter(b);
	}

}
