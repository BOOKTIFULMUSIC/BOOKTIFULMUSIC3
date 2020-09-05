package com.web.jsp.allSearch.model.dao;

import static com.web.jsp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

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
		int blistCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("blistCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			pstmt.setString(3, keyword);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				blistCount = rset.getInt(1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return blistCount;
	}

	public int getSearchmListCount(Connection con, String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

}
