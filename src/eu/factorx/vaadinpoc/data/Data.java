package eu.factorx.vaadinpoc.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import eu.factorx.vaadinpoc.dto.DTO;

public class Data {
	
	static String t="je suis une phrease";

	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static final List<DTO> data = new ArrayList<DTO>(Arrays.asList(
			new DTO("article 1", parseDate("2015-01-07")), new DTO(
					"article 2", parseDate("2015-01-03")), new DTO(
					"article 3", parseDate("2015-01-05")), new DTO(
					"article 4", parseDate("2015-01-02"))));

	public static List<DTO> getAllData() {

		return data;
	}

	public static DTO add(DTO dto) {
		dto.setDate(new Date());
		data.add(dto);
		return dto;
	}
	
	public static Date parseDate(String date){
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static String getT() {
		return t;
	}

	public static void setT(String t) {
		Data.t = t;
	}
	
	

}
