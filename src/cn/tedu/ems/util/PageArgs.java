package cn.tedu.ems.util;

public class PageArgs {

	private int pageNum;
	private int pageSize = 5;
	private long maxPage;
	private int prePage;
	private int nextPage;
	private long count;
	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		maxPage = count%pageSize==0?count/pageSize:count/pageSize+1;
		prePage=pageNum-1<=1?1:pageNum-1;
		nextPage=(int)(pageNum+1>=maxPage?maxPage:pageNum+1);
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(long maxPage) {
		this.maxPage = maxPage;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	@Override
	public String toString() {
		return "PageArgs [pageNum=" + pageNum + ", pageSize=" + pageSize + ", maxPage=" + maxPage + ", prePage="
				+ prePage + ", nextPage=" + nextPage + ", count=" + count + "]";
	}
	
	
}
