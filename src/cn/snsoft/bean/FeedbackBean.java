package cn.snsoft.bean;

import java.sql.Timestamp;

public class FeedbackBean {
	private String id;
	private String studentId;
	private Timestamp time;
	private String message;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public Timestamp getTime() {
		return time;
	}
	public String getMessage() {
		return message;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
