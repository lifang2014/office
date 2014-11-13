package com.common.oa.utils;


public class PageUtils {
	public static Page createPage(Integer everyPage,Integer totalCount,Integer currentPage){
		everyPage=getEveryPage(everyPage);
		currentPage=getCurrentPage(currentPage);
		Integer totalPage=getTotalPage(everyPage,totalCount);
		Integer beginIndex=getBeginIndex(everyPage,currentPage);
		boolean hasPrePage=getHasPrePage(currentPage);
		boolean hasNextPage=getHasNextPage(currentPage,totalPage);
		return new Page(currentPage, everyPage,totalPage,
				totalCount,beginIndex, hasPrePage,hasNextPage);
	}
	public static Integer getEveryPage(Integer everyPage){
		return everyPage==0?10:everyPage;//当用户设置为0时，默认显示10条记�?
	}
	public static Integer getCurrentPage(Integer currentPage){
		return currentPage==0?1:currentPage;
	}
	public static Integer getTotalPage(Integer everyPage,Integer totalCount){
		return (totalCount+everyPage-1)/everyPage;
	}
	public static Integer getBeginIndex(Integer everyPage,Integer currentPage){
		return (currentPage-1)*everyPage;
	}
	public static boolean getHasPrePage(Integer currentPage){
		return currentPage<=1?false:true;
	}
	public static boolean getHasNextPage(Integer currentPage,Integer totalPage){
		return (currentPage==totalPage || totalPage==0)?false:true;
	}
}
