package org.training.bankapplication.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	
	public LocalDate dateConverter(String date) {

		date = date.trim();
		date = date.replaceAll("\\s+", " 01,");
		String str = date.substring(0, date.indexOf(' '));
		DateTimeFormatter formatter;

		if (str.length() == 3)
			formatter = DateTimeFormatter.ofPattern("MMM d,yyyy");
		else
			formatter = DateTimeFormatter.ofPattern("MMMM d,yyyy");

		LocalDate convertedDate = LocalDate.parse(date, formatter);

		return convertedDate;
	}

	public String localDateFormatter(String date) {
		 DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		 DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 return LocalDate.parse(date, dateFormatter).format(localDateFormatter);
	}

}
