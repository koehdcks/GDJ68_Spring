package com.iu.main.student;

public class StudentDTO {
	private Long stuNum;
	private String stuName;
	private Integer stuKor;
	private Integer stuEng;
	private Integer stuMath;
	private Integer stuTotal;
	private Double stuAvg;
	

	
	public Long getStuNum() {
		return stuNum;
	}
	public String getStuName() {
		return stuName;
	}
	public Integer getStuKor() {
		return stuKor;
	}
	public Integer getStuEng() {
		return stuEng;
	}
	public Integer getStuMath() {
		return stuMath;
	}
	public Integer getStuTotal() {
		return stuTotal;
	}
	public Double getStuAvg() {
		return stuAvg;
	}
	public void setStuNum(Long stuNum) {
		this.stuNum = stuNum;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public void setStuKor(Integer stuKor) {
		this.stuKor = stuKor;
	}
	public void setStuEng(Integer stuEng) {
		this.stuEng = stuEng;
	}
	public void setStuMath(Integer stuMath) {
		this.stuMath = stuMath;
	}
	public void setStuTotal(Integer stuTotal) {
		this.stuTotal = stuTotal;
	}
	public void setStuAvg(Double stuAvg) {
		this.stuAvg = stuAvg;
	}
	
	
}
