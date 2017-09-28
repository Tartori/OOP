package Exam2;

/**
 * Created by julian on 05-Apr-17.
 */
public class CD {

    private String title;
    private String artist;
    private String country;
    private String company;
    private double price;
    private int year;

    public CD(String title, String artist, String country, String company, double price, int year){
        this.title=title;
        this.artist=artist;
        this.country=country;
        this.company=company;
        this.price=price;
        this.year=year;
    }

    public CD(){

    }

    //region Getter and Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    //endregion

}
/*
<title>Red</title>
<artist>The Communards</artist>
<country>UK</country>
<company>London</company>
<price>7.80</price>
<year>1987</year>*/