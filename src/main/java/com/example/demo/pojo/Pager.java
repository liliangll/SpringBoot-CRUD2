package com.example.demo.pojo;

public class Pager {
	private int currPage=1;
	private int pageSize=5;
	private int totalCounts;
	private int totalPages;
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCounts() {
		return totalCounts;
	}
	public void setTotalCounts(int totalCounts) {
		this.totalCounts = totalCounts;
		//�����ܼ�¼��ʱ��˳�������ҳ��
		this.totalPages=this.totalCounts%this.getPageSize()==0?
						this.totalCounts/this.getPageSize():
						this.totalCounts/this.getPageSize()+1;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
}
