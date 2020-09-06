package com.web.jsp.book.model.service;

import static com.web.jsp.common.JDBCTemplate.close;
import static com.web.jsp.common.JDBCTemplate.commit;
import static com.web.jsp.common.JDBCTemplate.getConnection;
import static com.web.jsp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.web.jsp.Review.model.vo.BookReview;
import com.web.jsp.book.model.dao.BookDao;
import com.web.jsp.book.model.vo.Book;

public class BookService {
	
	private Connection con;
	private BookDao bDao = new BookDao();
	
	public int getListCount() {
		con = getConnection();
		int listCount = bDao.getListCount(con);
		close(con);
		return listCount;
	}

	public ArrayList<Book> selectList(int currentPage, int limit) {
		con = getConnection();
		
		ArrayList<Book> list = bDao.selectList(con,currentPage,limit);
		close(con);
		return list;
	}

	public ArrayList<Book> userGenre(String userId,int currentPage, int limit) {
		con = getConnection();
		
		ArrayList<Book> ubList = bDao.userGenre(con,userId,currentPage,limit);
		close(con);
		return ubList;
	}

	public ArrayList<Book> searchGenre(String[] gArr,int currentPage, int limit) {
		con = getConnection();
		ArrayList<Book> sList = bDao.searchGenre(con,gArr,currentPage,limit);
		close(con);
		return sList;
	}

	public int getSearchListCount(String[] gArr) {
		con = getConnection();
		int SearchlistCount = bDao.getSearchListCount(con,gArr);
		close(con);
		return SearchlistCount;
	}

	public ArrayList<Book> LikeList(int currentPage, int limit) {
con = getConnection();
		
		ArrayList<Book> list = bDao.LikeList(con,currentPage,limit);
		close(con);
		return list;
	}

	public HashMap<String,Object> selectOne(Long bno) {
		 con = getConnection();
	      
		 HashMap<String,Object> b = bDao.selectBookDetail(con,bno);
	      
	      close(con);
	      return b;
	}

	public int insertReview(HashMap<String,Object> hmap) {
		con = getConnection();
	    int reviewCnt = 0;
	    reviewCnt = bDao.insertReview(con,hmap);
	      
	    if(reviewCnt < 0) { 
	    	rollback(con); 
	    } else {
	    	commit(con);
	    }
	    
	    close(con);
		return reviewCnt;
	}
	
	public ArrayList<BookReview> selectReview(int currentPage, int limit, Long bno) {
		con = getConnection();
		ArrayList<BookReview> bList = bDao.selectReview(con,currentPage,limit,bno);
		close(con);
		return bList;
	}

	public int getReviewCount(Long bno) {
		con = getConnection();
		int listCount = bDao.getReviewCount(con,bno);
		close(con);
		return listCount;
	}

	public int updateReview(int rno, String rText) {
		con = getConnection();
		int updatCount = bDao.updateReview(con,rno,rText);
		if(!(updatCount > 0)){
			rollback(con);
		}else{
			commit(con);
		}
		close(con);
		return updatCount;
	}

}
