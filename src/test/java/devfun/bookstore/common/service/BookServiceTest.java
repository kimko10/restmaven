package devfun.bookstore.common.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import devfun.bookstore.common.BookService;
import devfun.bookstore.common.config.AppConfig;
import devfun.bookstore.common.domain.Book;

@RunWith(SpringJUnit4ClassRunner.class)
// 테스트 케이스가 스프링에서 설정한 Bean을 삽입 받아 사용 할 수 있다
@ContextConfiguration(classes= {AppConfig.class})
// 테스트 대상 클래스들을 스프링 컨텍스트에 적재하기 위해 사용, 구성 클래스의 정보를 설정
@TransactionConfiguration(transactionManager = "transactionManager",
defaultRollback = true)
@Transactional
public class BookServiceTest {

	Logger logger = LoggerFactory.getLogger(BookServiceTest.class);
	
	@Autowired BookService bookService;
	
	@Test
	public void testGetBooks() {
		List<Book> books = bookService.getBooks();
		assertEquals(3, books.size()); // 조회 결과 3건일 경우 테스트 통과
		
		for(Book book : books) {
			logger.info("book={}", book);
		}
	}
	
	@Test
	public void testGetBook() {
		Book selectedBook = bookService.getBook(1);
		assertNotNull("아이디가 1번인 도서 정보를 가져올 수 없습니다.", selectedBook);
		assertEquals("명예의 조각들", selectedBook.getTitle());
		assertEquals("로이스 맥마스터 부졸드", selectedBook.getCreator());
	}
	
	@Test
	@Rollback(true)
	public void testCreateBook() {
		Book selectedBook = bookService.getBook(10);
		assertNull("아이디가 10번인 도서 정보가 이미 존재합니다.", selectedBook);
		
		Book newBook = new Book(10, "스칼라 프로그래밍", "케이 호스트만", "프로그래밍 언어", new Date());
		bookService.createBook(newBook);
		
		selectedBook = bookService.getBook(10);
		assertNotNull("아이디가 10번인 도서 정보를 가져올 수 없습니다.", selectedBook);
		assertEquals("스칼라 프로그래밍", selectedBook.getTitle());
		assertEquals("케이 호스트만", selectedBook.getCreator());
	}
	
	@Test
	public void testUpdateBook() {
		Book selectedBook = bookService.getBook(3);
		assertNotNull("아이디가 3번인 도서 정보를 가져올 수 없습니다.", selectedBook);
		assertEquals("피렌체의 여마법사", selectedBook.getTitle());
		
		Book updateBook = new Book(3, "어스시의 마법사", "어슐러 K. 르귄", "판타지 소설", new Date());
		bookService.updateBook(updateBook);
		
		selectedBook = bookService.getBook(3);
		assertEquals("어스시의 마법사", selectedBook.getTitle());
	}
	
	@Test
	public void testDeleteBook() {
		Book selectedBook = bookService.getBook(3);
		assertNotNull("아이디가 3번인 도서 정보를 가져올 수 없습니다.", selectedBook);
		
		bookService.deleteBook(3);
		
		logger.info("HJLOG selectedBook : " + selectedBook.toString());
		selectedBook = bookService.getBook(3);
		logger.info("HJLOG22 selectedBook : " + selectedBook);
		
		if(selectedBook == null) {
			logger.info("HJLOG 3번 책 삭제됨");
		}
		
	}
}
