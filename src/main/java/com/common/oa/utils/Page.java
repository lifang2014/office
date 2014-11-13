package com.common.oa.utils;

public class Page {
	
	private Integer currentPage;//当前数
	
	private Integer everyPage;//每页显示记录数
	
	private Integer totalPage;//总页数
	
	private Integer totalCount;//总记录数
	
	private Integer beginIndex;//查询起始数
	
	private boolean hasPrePage;//是否有上一页
	
	private boolean hasNextPage;//是否有下一页
	
	public Page(Integer currentPage,Integer everyPage,
			Integer totalPage,Integer totalCount,Integer beginIndex,
			boolean hasPrePage,boolean hasNextPage){
		this.currentPage=currentPage;
		this.everyPage=everyPage;
		this.totalPage=totalPage;
		this.totalCount=totalCount;
		this.beginIndex=beginIndex;
		this.hasPrePage=hasPrePage;
		this.hasNextPage=hasNextPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getEveryPage() {
		return everyPage;
	}
	public void setEveryPage(Integer everyPage) {
		this.everyPage = everyPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}
	public boolean isHasPrePage() {
		return hasPrePage;
	}
	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	
}