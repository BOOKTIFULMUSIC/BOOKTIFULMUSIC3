package com.web.jsp.Review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.web.jsp.Review.model.dao.ReviewDao;
import com.web.jsp.Review.model.vo.MusicReview;
import static com.web.jsp.common.JDBCTemplate.*;
public class ReviewService {
	
	private ReviewDao rDao = new ReviewDao();
	private Connection con;
	
	public ArrayList<MusicReview> selectList(String mno) {
		con = getConnection();
		ArrayList<MusicReview> rlist = rDao.selectList(con, mno);
		
		close(con);
		return rlist;
	}

	public int insertReview(MusicReview mr) {
		con= getConnection();
		int result = rDao.insertReview(con, mr);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}

}
