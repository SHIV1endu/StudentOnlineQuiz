package com.dts.aoc.dto;

public class QuestionBean {

	private String subjectid;
	private String testname;
	private String sno;
	private String questionid;
	private String question;
	private String op1;
	private String op2;
	private String op3;
	private String op4;
	private String truans;
	private String addqdate;
	private String email;
	private String phone;
	private String regdate;
	private String userid;
	private String name;
	private int myans;
	private int totmarks;
	
	
	
	public int getTotmarks () {
		return totmarks;
	}
	
	
	public int getMyans() {
		return myans;
	}
	
	
	public void setMyans(int myans) {
		this.myans = myans;
	}
	public void setTotmarks(int totmarks) {
		this.totmarks = totmarks;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}
	public String getTestname() {
		return testname;
	}
	public void setTestname(String testname) {
		this.testname = testname;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getQuestionid() {
		return questionid;
	}
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOp3() {
		return op3;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public String getOp4() {
		return op4;
	}
	public void setOp4(String op4) {
		this.op4 = op4;
	}
	public String getTruans() {
		return truans;
	}
	public void setTruans(String truans) {
		this.truans = truans;
	}
	public String getAddqdate() {
		return addqdate;
	}
	public void setAddqdate(String addqdate) {
		this.addqdate = addqdate;
	}
	

}
