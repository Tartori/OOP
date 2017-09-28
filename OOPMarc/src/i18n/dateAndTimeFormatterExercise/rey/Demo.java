package i18n.dateAndTimeFormatterExercise.rey;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Demo {
	
	public static void main(String[] args) {
		Locale[] supportedLocales = { Locale.GERMANY, Locale.FRANCE, Locale.UK, Locale.CHINA, Locale.JAPAN };
		int[] formats = {DateFormat.FULL, DateFormat.LONG, DateFormat.MEDIUM, DateFormat.SHORT};
				
		Date now = new Date();
		
		for(Locale locale : supportedLocales){
			for(int format : formats){
				printDateFormatted(now, locale, format);
			}
		}
	}
	
	private static void printDateFormatted(Date date, Locale locale, int dateFormat){
		DateFormat dateFormatter = DateFormat.getDateInstance(dateFormat, locale);
		DateFormat timeFormatter = DateFormat.getTimeInstance(dateFormat, locale);
		String text = locale.getLanguage().toString() + "_" + locale.getCountry().toString() + "(" + locale.getDisplayCountry().toString() + ")" + ": " + dateFormatter.format(date) + " " + timeFormatter.format(date);
		System.out.println(text);
	}
	
}
