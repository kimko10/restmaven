package devfun.bookstore.common.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "book")
@XmlType(propOrder = {"id", "title", "creator", "type", "date"})
public class Book {

	private int id;
	private String title;
	private String creator;
	private String type;
	private Date date;
	
	public Book() {
		
	}
	
	public Book(int id, String title, String creator, String type, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.creator = creator;
		this.type = type;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", creator=" + creator + ", type=" + type + ", date=" + date
				+ "]";
	}
	
}
