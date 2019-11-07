package devfun.bookstore.common.service.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import devfun.bookstore.common.BookService;
import devfun.bookstore.common.domain.Book;
import devfun.bookstore.common.mapper.BookMapper;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {
	
	@Autowired BookMapper bookMapper;

	/**
	 * 도서 정보 목록 조회
	 */
	@Override
	public List<Book> getBooks() {
		return bookMapper.select();
	}

	/**
	 * 도서 정보 조회
	 */
	@Override
	public Book getBook(int id) {
		return bookMapper.selectByPrimaryKey(id);
	}

	/**
	 * 도서 정보 등록
	 * 트랜잭션 처리 추가
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public int createBook(Book book) {
		return bookMapper.insert(book);
	}

	/**
	 * 도서 정보 수정
	 * 트랜잭션 처리 추가
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public int updateBook(Book book) {
		return bookMapper.updateByPrimaryKey(book);
	}

	/**
	 * 도서 정보 삭제
	 * 트랜잭션 처리 추가
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public int deleteBook(int id) {
		return bookMapper.deleteByPrimaryKey(id);
	}
	
	

}
