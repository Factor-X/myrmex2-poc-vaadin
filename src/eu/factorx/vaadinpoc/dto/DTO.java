package eu.factorx.vaadinpoc.dto;

import java.util.Date;

public class DTO {

	private String content;
	
	private Date date;
	
	

	public DTO(String content) {
		super();
		this.content = content;
	}

	public DTO(String content,Date date) {
		this.content = content;
		this.date=date;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "DTO [content=" + content + ", date=" + date + "]";
	}
	
	
	
	

}
