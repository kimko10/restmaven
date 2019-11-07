package devfun.bookstore.common;

import java.util.List;

import devfun.bookstore.common.domain.Book;

public interface BookService {

	/**
	 * 도서 정보 목록 조회
	 * @return
	 */
	List<Book> getBooks();
	
	/**
	 * 도서 상세정보 조회
	 * @param id
	 * @return
	 */
	Book getBook(int id);
	
	/**
	 * 도서 정보 등록
	 * @param book
	 * @return
	 */
	int createBook(Book book);
	
	/**
	 * 도서 정보 수정
	 * @param book
	 * @return
	 */
	int updateBook(Book book);
	
	/**
	 * 도서 정보 삭제
	 * @param id
	 * @return
	 */
	int deleteBook(int id);
}
