package Exam2;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by julian on 05-Apr-17.
 */
public class CDMain {
    public static void main(String[] args) {
        try {
            URL fURL = new File("CDCatalog.xml").toURI().toURL();
            CDParser parser = new CDParser(fURL);
            ArrayList<CD> cds = parser.readCDS();
            System.out.println("Number of CDs: "+cds.size());
            int olderThan20Years = 0;

            Map<String, Integer> countries = new HashMap<String, Integer>();
            double totalPrice = 0.0;
            int currentYear = Year.now().getValue();

            for(CD cd:cds){
                olderThan20Years+=cd.getYear()<currentYear-20?1:0;
                totalPrice+=cd.getPrice();
                if(countries.containsKey(cd.getCountry())) {
                    countries.put(cd.getCountry(), countries.get(cd.getCountry()) + 1);
                }else{
                    countries.put(cd.getCountry(), 1);
                }
            }
            System.out.println("Number of CDs older than 20 years: "+olderThan20Years);
            System.out.println("Average Price per CD: " + totalPrice/cds.size());
            for(String key:countries.keySet()){
                System.out.println("Country "+ key + " has " + countries.get(key) + " CDs ");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
