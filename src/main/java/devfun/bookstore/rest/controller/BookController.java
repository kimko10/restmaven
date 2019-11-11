package devfun.bookstore.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import devfun.bookstore.common.BookService;
import devfun.bookstore.common.domain.Book;
import devfun.bookstore.rest.domain.BookList;

@Controller
@RequestMapping(value="/books")
public class BookController {

	@Autowired BookService bookService;
	
	/**
	 * 도서 조회	
	 * @param id
	 * @return
	 */
	/* BookControllerTest.java 용 method
	 * @RequestMapping(value="/{id}", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public String getBook(@PathVariable("id") int id) { Book book =
	 * bookService.getBook(id); return String.format("결과 값은 %s 입니다",
	 * String.valueOf(book)); }
	 */
	
	/**
	 * 도서 목록 조회
	 * @return
	 */
	/* BookControllerAsJsonTest.java 용 json용 xml에서는 List<E>형태를 사용할 수 없음
	 * @RequestMapping(method = RequestMethod.GET)
	 * 
	 * @ResponseBody public List<Book> getBooks(){ List<Book> books =
	 * bookService.getBooks(); return books; }
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public BookList getBooks(){
		List<Book> books = bookService.getBooks();
		return new BookList(books);
	}
	
	/**
	 * 도서 상세 조회
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Book getBook(@PathVariable("id") int id) {
		Book book = bookService.getBook(id);
		return book;
	}
	
	/**
	 * 도서 정보 등록
	 * @param book
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Book createBook(@RequestBody Book book) {
		bookService.createBook(book);
		Book selectedBook = bookService.getBook(book.getId());
		return selectedBook;
	}
	
	/**
	 * 도서 정보 수정
	 * @param id
	 * @param book
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Book updateBook(@PathVariable("id") int id, @RequestBody Book book) {
		bookService.updateBook(book);
		Book selectedBook = bookService.getBook(book.getId());
		return selectedBook;
	}
	
	/**
	 * 도서 정보 삭제
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Book deleteBook(@PathVariable("id") int id) {
		bookService.deleteBook(id);
		Book deletedBook = new Book();
		deletedBook.setId(id);
		return deletedBook;
	}
}
