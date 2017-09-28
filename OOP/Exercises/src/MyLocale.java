import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by julia on 31-Mar-17.
 */
public class MyLocale {
    public static void main (String[] args){
        Locale[] locales = new Locale[]{Locale.ITALY, Locale.UK, Locale.CANADA, Locale.FRANCE, Locale.GERMANY, Locale.JAPAN, Locale.CHINA, Locale.TRADITIONAL_CHINESE};
        int[] dateFormats = new int[]{DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL};
        Date myDate = new Date();
        String[] formats=new String[]{"FULL","LONG","MEDIUM","SHORT"};
        for(Locale loc :locales) {
            for(int format:dateFormats){
                DateFormat dateFormatter =
                        DateFormat.getDateInstance(format, loc);
                DateFormat timeFormatter =
                        DateFormat.getTimeInstance(format, loc);
                System.out.printf("%s -- %s -- %s -- %s -- %s \n",loc.getDisplayCountry(), loc.getDisplayLanguage(), formats[format],dateFormatter.format(myDate),timeFormatter.format(myDate)); // or
            }
        }
    }

}
