package cn.snsoft.bean;

import java.util.Date;

public class StudentBean {
	private String studentId;
	private String studentName;
	private String sex;
	private Date entryDate;
	private String faculty;
	private String className;
	private String classes;
	private String credit;
	public String getStudentId() {
		return studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public String getSex() {
		return sex;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public String getFaculty() {
		return faculty;
	}
	public String getClassName() {
		return className;
	}
	public String getClasses() {
		return classes;
	}
	public String getCredit() {
		return credit;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
}
