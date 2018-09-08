package com.dts.aoc.dto;

public class AddSubjectDto {
	private String subjectid;
	private String subjectname;
	private String aaddate;
	private String totalnoQuestion;
	private String testname;
	private String sno;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getTestname() {
		return testname;
	}
	public void setTestname(String testname) {
		this.testname = testname;
	}
	public String getTotalnoQuestion() {
		return totalnoQuestion;
	}
	public void setTotalnoQuestion(String totalnoQuestion) {
		this.totalnoQuestion = totalnoQuestion;
	}
	public String getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getAaddate() {
		return aaddate;
	}
	public void setAaddate(String aaddate) {
		this.aaddate = aaddate;
	}

}
