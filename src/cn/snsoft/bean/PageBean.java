package cn.snsoft.bean;

import java.util.List;

public class PageBean {
	private List<?> list;
	private int totalrecord;
	private int pagesize;
	private int totalpage;
	private int currentpage;
	private int previouspage;
	private int nextpage;
	private int[] pagebar;
	public List<?> getList() {
		return list;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public int getPagesize() {
		return pagesize;
	}
	public int getTotalpage() {
		if(this.totalrecord % this.pagesize==0){
			this.totalpage = this.totalrecord/this.pagesize;
		}else{
			this.totalpage = this.totalrecord/this.pagesize+1;
		}	
		return totalpage;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public int getPreviouspage() {
		if(this.currentpage-1<1){
			this.previouspage = 1;
		}else{
			this.previouspage = this.currentpage-1;
		}
		return previouspage;
	}
	public int getNextpage() {
		if(this.currentpage+1>=this.totalpage){
			this.nextpage = this.totalpage;
		}else{
			this.nextpage = this.currentpage +1;
		}
		return nextpage;
	}
	public int[] getPagebar() {
		int pagebar[] = null;
		int startpage;
		int endpage;
		if(this.totalpage<=10){
			pagebar = new int[this.totalpage];
			startpage = 1;
			endpage = this.totalpage;
		}else{
			pagebar = new int[10];
			startpage = this.currentpage -4;
			endpage = this.currentpage +5;
			if(startpage<1){
				startpage = 1;
				endpage = 10;
			}
			if(endpage>this.totalpage){
				endpage = this.totalpage;
				startpage = this.totalpage - 9;
			}
		}
		
		int index = 0;
		for(int i=startpage;i<=endpage;i++){
			pagebar[index++] = i;
		}
		
		this.pagebar = pagebar;
		return this.pagebar;
		
		
		
		/*
		int pagebar[] = new int[this.totalpage];
		for(int i=1;i<=this.totalpage;i++){
			pagebar[i-1] = i;
		}
		this.pagebar = pagebar;
		return pagebar;
		*/
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public void setPagebar(int[] pagebar) {
		this.pagebar = pagebar;
	}
}
