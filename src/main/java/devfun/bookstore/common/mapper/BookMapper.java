package devfun.bookstore.common.mapper;

import java.util.List;

import devfun.bookstore.common.domain.Book;

public interface BookMapper {
	
	/**
	 * 도서 정보 목록 조회
	 * @return
	 */
	List<Book> select();
	
	/**
	 * 도서 상세정보 조회
	 * @param id 도서 아이디
	 * @return
	 */
	Book selectByPrimaryKey(int id);
	
	/**
	 * 도서 정보 등록
	 * @param book
	 * @return
	 */
	int insert(Book book);
	
	/**
	 * 도서 정보 수정
	 * @return
	 */
	int updateByPrimaryKey(Book book);
	
	/**
	 * 도서 정보 삭제
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(int id);

}
