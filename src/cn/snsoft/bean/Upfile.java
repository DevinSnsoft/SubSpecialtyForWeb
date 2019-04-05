package cn.snsoft.bean;

import java.util.Date;
public class Upfile {
	private String id;
	private String uuidname;	
	private String filename;	
	private String savepath;	
	private Date uptime;		
	public String getId() {
		return id;
	}
	public String getUuidname() {
		return uuidname;
	}
	public String getFilename() {
		return filename;
	}
	public String getSavepath() {
		return savepath;
	}
	public Date getUptime() {
		return uptime;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setUuidname(String uuidname) {
		this.uuidname = uuidname;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
}
