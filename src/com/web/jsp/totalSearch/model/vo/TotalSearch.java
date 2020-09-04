package com.web.jsp.totalSearch.model.vo;

import java.io.Serializable;

public class TotalSearch implements Serializable{

	private static final long serialVersionUID = -5874476073111096860L;
	
	private String bTitle;
	private String author;
	private String publisher;
	private String bStory;
	private String mName;
	private String mArtist;
	
	public TotalSearch() {}
	
	public TotalSearch(String bTitle, String author, String publisher, String bStory, String mName, String mArtist) {
		this.bTitle = bTitle;
		this.author = author;
		this.publisher = publisher;
		this.bStory = bStory;
		this.mName = mName;
		this.mArtist = mArtist;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getbStory() {
		return bStory;
	}

	public void setbStory(String bStory) {
		this.bStory = bStory;
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

	@Override
	public String toString() {
		return "bTitle=" + bTitle + ", author=" + author + ", publisher=" + publisher + ", bStory="
				+ bStory + ", mName=" + mName + ", mArtist=" + mArtist;
	}
}
