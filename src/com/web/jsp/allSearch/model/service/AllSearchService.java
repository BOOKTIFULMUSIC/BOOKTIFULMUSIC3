package com.web.jsp.allSearch.model.service;

import static com.web.jsp.common.JDBCTemplate.close;
import static com.web.jsp.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.web.jsp.allSearch.model.dao.AllSearchDao;

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

}
