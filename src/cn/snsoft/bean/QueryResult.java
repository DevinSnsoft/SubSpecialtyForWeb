package cn.snsoft.bean;

import java.util.List;

public class QueryResult {
	private List<?> list;
	private int totalrecord;
	public List<?> getList() {
		return list;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
}
