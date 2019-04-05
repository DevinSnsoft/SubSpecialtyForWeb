package cn.snsoft.bean;

import java.sql.Timestamp;

public class EnrollBean {
	private String studentId;
	private Timestamp time;
	private String firstvoluntary;
	private String secondvoluntary;
	private String thirdvoluntary;
	private String punished;
	private String telephone;
	private String academic;
	private String performance;
	public String getStudentId() {
		return studentId;
	}
	public Timestamp getEntryDate() {
		return time;
	}
	public String getFirstVoluntary() {
		return firstvoluntary;
	}
	public String getSecondVoluntary() {
		return secondvoluntary;
	}
	public String getThirdVoluntary() {
		return thirdvoluntary;
	}
	public String getPunished() {
		return punished;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getAcademic() {
		return academic;
	}
	public String getPerformance() {
		return performance;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public void setEntryDate(Timestamp time) {
		this.time = time;
	}
	public void setFirstVoluntary(String firstVoluntary) {
		this.firstvoluntary = firstVoluntary;
	}
	public void setSecondVoluntary(String secondVoluntary) {
		this.secondvoluntary = secondVoluntary;
	}
	public void setThirdVoluntary(String thirdVoluntary) {
		this.thirdvoluntary = thirdVoluntary;
	}
	public void setPunished(String punished) {
		this.punished = punished;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setAcademic(String academic) {
		this.academic = academic;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
}
