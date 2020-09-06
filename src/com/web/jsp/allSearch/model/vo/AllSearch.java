package com.web.jsp.allSearch.model.vo;

import java.io.Serializable;

public class AllSearch implements Serializable{

	private static final long serialVersionUID = -5874476073111096860L;
	
	private int bRnum;
	private String bImage;
	private String bTitle;
	private String publisher;
	private int bLikeCount;
	private int bReview;
	private int bprice;
	
	private int mRnum;
	private String mImage;
	private String mName;
	private String mArtist;
	private int mLikeCount;
	private int aReview;
	
	
	
	public AllSearch() {}

	public AllSearch(int bRnum, String bImage, String bTitle, String publisher, 
					 int bLikeCount, int bReview, int bprice) {
		this.bRnum = bRnum;
		this.bImage = bImage;
		this.bTitle = bTitle;
		this.publisher = publisher;
		this.bLikeCount = bLikeCount;
		this.bReview = bReview;
		this.bprice = bprice;
	}

	public AllSearch(int mRnum, String mImage, String mName, String mArtist, int mLikeCount, int aReview) {
		this.mRnum = mRnum;
		this.mImage = mImage;
		this.mName = mName;
		this.mArtist = mArtist;
		this.mLikeCount = mLikeCount;
		this.aReview = aReview;
	}
	
	public int getbRnum() {
		return bRnum;
	}

	public void setbRnum(int bRnum) {
		this.bRnum = bRnum;
	}

	public String getbImage() {
		return bImage;
	}

	public void setbImage(String bImage) {
		this.bImage = bImage;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getbLikeCount() {
		return bLikeCount;
	}

	public void setbLikeCount(int bLikeCount) {
		this.bLikeCount = bLikeCount;
	}

	public int getbReview() {
		return bReview;
	}

	public void setbReview(int bReview) {
		this.bReview = bReview;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}

	
	
	public int getmRnum() {
		return mRnum;
	}

	public void setmRnum(int mRnum) {
		this.mRnum = mRnum;
	}

	public String getmImage() {
		return mImage;
	}

	public void setmImage(String mImage) {
		this.mImage = mImage;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmArtist() {
		return mArtist;
	}

	public void setmArtist(String mArtist) {
		this.mArtist = mArtist;
	}

	public int getmLikeCount() {
		return mLikeCount;
	}

	public void setmLikeCount(int mLikeCount) {
		this.mLikeCount = mLikeCount;
	}

	public int getaReview() {
		return aReview;
	}

	public void setaReview(int aReview) {
		this.aReview = aReview;
	}

	@Override
	public String toString() {
		return "bRnum=" + bRnum + ", bImage=" + bImage + ", bTitle=" + bTitle + ", publisher=" + publisher
				+ ", bLikeCount=" + bLikeCount + ", bReview=" + bReview + ", bprice=" + bprice + ", mRnum=" + mRnum
				+ ", mImage=" + mImage + ", mName=" + mName + ", mArtist=" + mArtist + ", mLikeCount=" + mLikeCount
				+ ", aReview=" + aReview;
	}

	
	
	
	
	
	
	
	
	
	

	
	



	
}
