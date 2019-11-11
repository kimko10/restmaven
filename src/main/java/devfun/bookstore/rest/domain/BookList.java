package devfun.bookstore.rest.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import devfun.bookstore.common.domain.Book;

// @XmlrootElement, @XmlElement 는 자바객체 <-> XML 변환 시 필요한 정보를 설정할 수 있게 함
@XmlRootElement(name = "books")
public class BookList {
	
	private List<Book> books;
	
	// 매개변수 가진 생성자 만들려면 순수 생성자를 필히 기입해줘야 함
	public BookList() {
		
	}
	
	public BookList(List<Book> books) {
		setBooks(books);
	}
	
	@XmlElement(name = "book")
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books)  {
		this.books = books;
	}

}
