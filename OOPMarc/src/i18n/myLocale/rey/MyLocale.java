package i18n.myLocale.rey;

import java.util.Locale;

/**
 * Created by roxxi on 31-Mar-17.
 */
public class MyLocale {
	public static void main(String[] args){
		Locale locale = Locale.getDefault();
		
		System.out.println("Land: " + locale.getCountry());
		System.out.println("Sprache: " + locale.getLanguage());
		System.out.println("Variante: " + locale.getVariant());
	}
}
