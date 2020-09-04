package com.web.jsp.Review.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.web.jsp.Review.model.vo.MusicReview;
import static com.web.jsp.common.JDBCTemplate.*;

public class ReviewDao {
	
	private Properties prop = new Properties();
	public ReviewDao() {
		String filePath = 
				ReviewDao.class
				.getResource("/config/review-query.properties")
				.getPath();
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<MusicReview> selectList(Connection con, String mno) {
		ArrayList<MusicReview> rlist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mno);
			rset = pstmt.executeQuery();
			
			rlist = new ArrayList<MusicReview>();
			
			while(rset.next()) {
				MusicReview mr = new MusicReview();
				
				mr.setMusicNo(mno);
				mr.setmRno(rset.getString("M_RNO"));
				mr.setUserId(rset.getString("USERID"));
				mr.setMusicReview(rset.getString("MUSIC_REVIEW"));
				mr.setMrDate(rset.getDate("MRDATE"));
				
				rlist.add(mr);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return rlist;
	}
	public int insertReview(Connection con, MusicReview mr) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mr.getUserId());
			pstmt.setString(2, mr.getMusicNo());
			pstmt.setString(3, mr.getMusicReview());

			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	
	
}
