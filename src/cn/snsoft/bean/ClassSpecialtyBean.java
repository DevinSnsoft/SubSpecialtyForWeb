package cn.snsoft.bean;

import java.util.UUID;

public class ClassSpecialtyBean {
	private String id;
	private String classCode;
	private String className;
	private String subSpecialtyCode;
	private String subSpecialtyName;
	
	public String getId() {
		return id;
	}
	public String getClassCode() {
		return classCode;
	}
	public String getClassName() {
		return className;
	}
	public String getSubSpecialtyCode() {
		return subSpecialtyCode;
	}
	public String getSubSpecialtyName() {
		return subSpecialtyName;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setSubSpecialtyCode(String subSpecialtyCode) {
		this.subSpecialtyCode = subSpecialtyCode;
	}
	public void setSubSpecialtyName(String subSpecialtyName) {
		this.subSpecialtyName = subSpecialtyName;
	}
	
	//产生全球唯一的id【UUID产生器】
		public static String generateID(){
			return UUID.randomUUID().toString();		//128位
		}

}
