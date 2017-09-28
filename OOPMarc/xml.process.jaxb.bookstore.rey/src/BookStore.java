

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "store", namespace = "ch.marcrey.bfh.oop2.bookstore")
public final class BookStore {
	
	@XmlElementWrapper(name="bookList")
	@XmlElement(name="book")
	private ArrayList<Book> bookList;
	private String name;
	
	@XmlElement(name="address")
	private Address address;
	
	public BookStore() {
		bookList = new ArrayList<Book>();
		name="unknown";
		address = new Address();
	}

	public BookStore(String aName, String aCity) {
		bookList = new ArrayList<Book>();
		name=aName;
		address = new Address("",aCity);
	}

	public ArrayList<Book> getBooksList() {
		return bookList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public int getNmbOfBooks() {
		return bookList.size();
	}

	public void add(Book book) {
		bookList.add(book);
		
	}
}
