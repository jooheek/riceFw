package com.rice.E001.commvo;

import java.util.List;

import com.rice.C001.boardvo.C001FileUploadVO;

public class E001CommBoardVO {
	String boNum, boRegDate, boTitle, boUpdateDate, boURL, memNum, boContent, memId, commName;

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	int boViews, boLikes;
	
	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getBoNum() {
		return boNum;
	}

	public void setBoNum(String boNum) {
		this.boNum = boNum;
	}

	public String getBoRegDate() {
		return boRegDate;
	}

	public void setBoRegDate(String boRegDate) {
		this.boRegDate = boRegDate;
	}

	public String getBoTitle() {
		return boTitle;
	}

	public void setBoTitle(String boTitle) {
		this.boTitle = boTitle;
	}

	public String getBoUpdateDate() {
		return boUpdateDate;
	}

	public void setBoUpdateDate(String boUpdateDate) {
		this.boUpdateDate = boUpdateDate;
	}

	public String getBoURL() {
		return boURL;
	}

	public void setBoURL(String boURL) {
		this.boURL = boURL;
	}

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	public String getBoContent() {
		return boContent;
	}

	public void setBoContent(String boContent) {
		this.boContent = boContent;
	}

	public int getBoViews() {
		return boViews;
	}

	public void setBoViews(int boViews) {
		this.boViews = boViews;
	}

	public int getBoLikes() {
		return boLikes;
	}

	public void setBoLikes(int boLikes) {
		this.boLikes = boLikes;
	}
	
	List<E001FileUploadVO> filelist;
	
	public List<E001FileUploadVO> getFilelist() {
		return filelist;
	}
	public void setFilelist(List<E001FileUploadVO> filelist) {
		this.filelist = filelist;
	}

}
