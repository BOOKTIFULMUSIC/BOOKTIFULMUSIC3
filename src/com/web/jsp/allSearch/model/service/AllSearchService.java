package com.web.jsp.allSearch.model.service;

import static com.web.jsp.common.JDBCTemplate.close;
import static com.web.jsp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.web.jsp.allSearch.model.dao.AllSearchDao;
import com.web.jsp.allSearch.model.vo.AllSearch;

public class AllSearchService {
	
	private Connection con;
	
	private AllSearchDao aDao = new AllSearchDao();
	
	public int getSearchbListCount(String keyword) {
		con = getConnection();
		int bListCount = aDao.getSearchbListCount(con, keyword);
		close(con);
		return bListCount;
	}
	
	public int getSearchmListCount(String keyword) {
		con = getConnection();
		int mListCount = aDao.getSearchmListCount(con, keyword);
		close(con);
		return mListCount;
	}

	public ArrayList<AllSearch> searchbList(String keyword, int bcurrentPage, int blimit) {
		con = getConnection();
		
		ArrayList<AllSearch> bList = aDao.searchbList(con, keyword, bcurrentPage, blimit);
		
		close(con); 
		
		return bList;
	}

	public ArrayList<AllSearch> searchmList(String keyword, int mcurrentPage, int mlimit) {
		con = getConnection();
		
		ArrayList<AllSearch> mList = aDao.searchmList(con, keyword, mcurrentPage, mlimit);
		
		close(con); 
		
		return mList;
	}

}
