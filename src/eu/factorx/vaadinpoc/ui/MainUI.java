package eu.factorx.vaadinpoc.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.XAxis;
import com.vaadin.addon.charts.model.YAxis;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import eu.factorx.vaadinpoc.data.Data;
import eu.factorx.vaadinpoc.dto.DTO;
import eu.factorx.vaadinpoc.ui.window.AddArticleInterface;
import eu.factorx.vaadinpoc.ui.window.MyWindow;
import eu.factorx.vaadinpoc.ui.window.Test;

@SuppressWarnings("serial")
@Theme("vaadinpoc")
public class MainUI extends UI implements AddArticleInterface{

	//list of components
	Table articleTable;
	HorizontalLayout mainLayout;
	Table table;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MainUI.class, widgetset = "eu.factorx.vaadinpoc.ui.widgetset.VaadinpocWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {

		//initialize main components
		mainLayout = new HorizontalLayout();
		setContent(mainLayout);
		
		tableTest();
		bindingTest();
		chartTest();
		tTest();
	}
	private void tableTest(){
		
		VerticalLayout  verticalLayout = new VerticalLayout();
		mainLayout.addComponent(verticalLayout);
		
		// build button
		Button button = new Button("Open modal");
		verticalLayout.addComponent(button);
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {

				// build modal
				final MyWindow modal = new MyWindow(MainUI.this);
				MainUI.this.addWindow(modal);

			}
		});

		// build article list
		articleTable = new Table("My articles");
		articleTable.setCaption("articleTable");
		articleTable.addContainerProperty("Name", String.class, null);
		articleTable.addContainerProperty("date", Date.class, null);
		verticalLayout.addComponent(articleTable);

		// add data into data
		refreshTable(new ArrayList<DTO>(Data.getAllData()));
	}
	
	private void bindingTest(){
		
		VerticalLayout  verticalLayout = new VerticalLayout();
		mainLayout.addComponent(verticalLayout);
		
		//
		// binding test
		//
		ObjectProperty<String> property = new ObjectProperty<String>(Data.getT());
		
		TextField textField = new TextField(" je suis l'éditeur de T");
		textField.setImmediate(true);
		textField.setPropertyDataSource(property);
		
		Label l = new Label();
		l.setPropertyDataSource(property);
		
		verticalLayout.addComponent(textField);
		verticalLayout.addComponent(l);

	}

	
	private void chartTest(){
		
		VerticalLayout  verticalLayout = new VerticalLayout();
		mainLayout.addComponent(verticalLayout);
		
		verticalLayout.addComponent(new Label(System.getProperty("user.home")));
		
		//
		// chart test
		//
		Chart chart = new Chart(ChartType.BAR);
		chart.setWidth("400px");
		chart.setHeight("300px");
		        
		// Modify the default configuration a bit
		Configuration conf = chart.getConfiguration();
		conf.setTitle("Planets");
		conf.setSubTitle("The bigger they are the harder they pull");
		conf.getLegend().setEnabled(false); // Disable legend

		// The data
		ListSeries series = new ListSeries("Diameter");
		series.setData(4900,  12100,  12800,
		               6800,  143000, 125000,
		               51100, 49500);
		conf.addSeries(series);

		// Set the category labels on the axis correspondingly
		XAxis xaxis = new XAxis();
		xaxis.setCategories("Mercury", "Venus",   "Earth",
		                    "Mars",    "Jupiter", "Saturn",
		                    "Uranus",  "Neptune");
		xaxis.setTitle("Planet");
		conf.addxAxis(xaxis);

		// Set the Y axis title
		YAxis yaxis = new YAxis();
		yaxis.setTitle("Diameter");
		yaxis.getLabels().setFormatter(
		  "function() {return Math.floor(this.value/1000) + \' Mm\';}");
		yaxis.getLabels().setStep(2);
		conf.addyAxis(yaxis);
        
        verticalLayout.addComponent(new Label("tient, voilà un graph 2"));
        verticalLayout.addComponent(chart);

	}

	
	private void tTest(){
		
		VerticalLayout  verticalLayout = new VerticalLayout();
		mainLayout.addComponent(verticalLayout);
		
		Test t = new Test();
		
		verticalLayout.addComponent(t);
		
	}

	/**
	 * add item
	 * @param dto
	 */
	public void addArticle(DTO dto) {
		articleTable.addItem(convertDTOToObjects(dto),articleTable.size());
	}

	/**
	 * refresh all data
	 * @param l
	 */
	public void refreshTable(List<DTO> l) {
		articleTable.removeAllItems();

		for (DTO dto : l) {
			addArticle(dto);
		}
	}

	/**
	 * convet DTO to object[]
	 * @param dto
	 * @return
	 */
	public Object[] convertDTOToObjects(DTO dto) {
		Object[] o = new Object[] { dto.getContent(),
				dto.getDate()};
		return o;
	}

}