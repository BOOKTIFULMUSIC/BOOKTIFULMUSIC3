package com.web.jsp.Review.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class MusicReview implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5615648675815490035L;

	private String mRno;             // 뮤직리뷰번호
	private String userId;        // 유저아이디
	private String musicNo;          // 뮤직넘버
	private String musicReview;   // 뮤직리뷰
	private Date mrDate;           // 뮤직리뷰 작성일

	
	public MusicReview() {}


	public MusicReview(String userId, String musicNo, String musicReview) {
		super();
		this.userId = userId;
		this.musicNo = musicNo;
		this.musicReview = musicReview;
	}


	public MusicReview(String mRno, String userId, String musicNo, String musicReview, Date mrDate) {
		super();
		this.mRno = mRno;
		this.userId = userId;
		this.musicNo = musicNo;
		this.musicReview = musicReview;
		this.mrDate = mrDate;
	}


	public String getmRno() {
		return mRno;
	}


	public void setmRno(String mRno) {
		this.mRno = mRno;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getMusicNo() {
		return musicNo;
	}


	public void setMusicNo(String musicNo) {
		this.musicNo = musicNo;
	}


	public String getMusicReview() {
		return musicReview;
	}


	public void setMusicReview(String musicReview) {
		this.musicReview = musicReview;
	}


	public Date getMrDate() {
		return mrDate;
	}


	public void setMrDate(Date mrDate) {
		this.mrDate = mrDate;
	}


	@Override
	public String toString() {
		return "musicReview [mRno=" + mRno + ", userId=" + userId + ", musicNo=" + musicNo + ", musicReview="
				+ musicReview + ", mrDate=" + mrDate + "]";
	}

	
	
}
