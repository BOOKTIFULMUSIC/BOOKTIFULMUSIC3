package com.web.jsp.allSearch.model.dao;

import static com.web.jsp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.web.jsp.allSearch.model.vo.AllSearch;

public class AllSearchDao {
	
	private Properties prop = null;
	
	public AllSearchDao(){
		prop = new Properties();
		String filePath = AllSearchDao.class
						 .getResource("/config/allSearch-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public int getSearchbListCount(Connection con, String keyword) {
		int bListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("bListCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			pstmt.setString(3, keyword);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bListCount = rset.getInt(1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return bListCount;
	}

	public int getSearchmListCount(Connection con, String keyword) {
		int mListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("mListCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mListCount = rset.getInt(1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return mListCount;
	}

	public ArrayList<AllSearch> searchbList(Connection con, String keyword, int bcurrentPage, int blimit) {
		
		ArrayList<AllSearch> bList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchBookList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			int bstartRow = (bcurrentPage-1)*blimit +1; // 3-1*10 21
			int bendRow = bstartRow + blimit -1; // 30
			
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			pstmt.setString(3, keyword);
			pstmt.setInt(4, bendRow);
			pstmt.setInt(5, bstartRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				AllSearch as = new AllSearch();
				
				as.setbRnum(rset.getInt(1));
				as.setbImage(rset.getString("bimage"));
				as.setbTitle(rset.getString("btitle"));
				as.setPublisher(rset.getString("publisher"));
				as.setbLikeCount(rset.getInt("blikecount"));
				as.setbReview(rset.getInt("breviewcount"));
				as.setBprice(rset.getInt("price"));
				
				bList.add(as);			
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return bList;
	}

	public ArrayList<AllSearch> searchmList(Connection con, String keyword, int mcurrentPage, int mlimit) {
		ArrayList<AllSearch> mList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchMusicList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			int mstartRow = (mcurrentPage-1)*mlimit +1; // 3-1*10 21
			int mendRow = mstartRow + mlimit -1; // 30
			
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			pstmt.setInt(3, mendRow);
			pstmt.setInt(4, mstartRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				AllSearch as = new AllSearch();
				
				as.setmRnum(rset.getInt(1));
				as.setmImage(rset.getString("music_image"));
				as.setmName(rset.getString("music_nm"));
				as.setmArtist(rset.getString("music_artist"));
				as.setmLikeCount(rset.getInt("like_music"));
				as.setaReview(rset.getInt("review_album"));
				
				mList.add(as);			
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return mList;
	}

}
