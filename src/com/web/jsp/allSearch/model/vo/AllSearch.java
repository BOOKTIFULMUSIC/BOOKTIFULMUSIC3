package com.web.jsp.allSearch.model.vo;

import java.io.Serializable;

public class AllSearch implements Serializable{

	private static final long serialVersionUID = -5874476073111096860L;
	
	private String bImage;
	private String bTitle;
	private String publisher;
	private int bLikeCount;
	
	private String mImage;
	private String mName;
	private String mArtist;
	private String mLikeCount;
	private String aReview;
	
	
	
	public AllSearch() {}



	public AllSearch(String bImage, String bTitle, String publisher, int bLikeCount) {
		this.bImage = bImage;
		this.bTitle = bTitle;
		this.publisher = publisher;
		this.bLikeCount = bLikeCount;
	}



	public AllSearch(String mImage, String mName, String mArtist, String mLikeCount, String aReview) {
		this.mImage = mImage;
		this.mName = mName;
		this.mArtist = mArtist;
		this.mLikeCount = mLikeCount;
		this.aReview = aReview;
	}
	
	
	
	
	
	

	
	



	
}
