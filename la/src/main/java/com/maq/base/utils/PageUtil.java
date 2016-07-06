package com.maq.base.utils;

public class PageUtil {
	private int recordcount;
	private int currentpage;
	private int prepage;
	private int nextpage;
	private int pagesize;
	private int pageCount;
	private String url;

	public int getRecordcount() {
		return recordcount;
	}

	public void setRecordcount(int recordcount) {
		this.recordcount = recordcount;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getPrepage() {
		return prepage;
	}

	public void setPrepage(int prepage) {
		this.prepage = prepage;
	}

	public int getNextpage() {
		return nextpage;
	}

	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPageCount() {
		return recordcount % pagesize == 0 ? recordcount / pagesize : (recordcount / pagesize + 1);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public PageUtil() {

	}

	public PageUtil(int recordcount, int currentpage, int prepage, int nextpage, int pagesize, String url) {
		super();
		this.recordcount = recordcount;// 记录数
		this.currentpage = currentpage;
		this.prepage = prepage;
		this.nextpage = nextpage;
		this.pagesize = pagesize;
		this.url = url;

	}

	public String toString() {

		// 一共有多少页
		pageCount = recordcount % pagesize == 0 ? recordcount / pagesize : (recordcount / pagesize + 1);
		String firstP = "<a href=\"" + url + "&page=1\">首页</a>&nbsp";
		String lastP = "<a href=\"" + url + "&page=" + pageCount + "\">尾页</a>&nbsp";
		String nextp = "";
		if (currentpage == pageCount) {
			nextp = "<a>下一页</a>&nbsp";
		} else {
			nextp = "<a href=\"" + url + "&page=" + (currentpage + 1) + "\">下一页</a>&nbsp";
		}
		String preP = "";
		if (currentpage == 1) {
			preP = "<a>上一页</a>&nbsp";
		} else {
			preP = "<a href=\"" + url + "&page=" + (currentpage - 1) + "\">上一页</a>&nbsp";
		}

		return firstP + preP + nextp + lastP + "<span>当前第" + currentpage + "页&nbsp</span>" + "<span>共" + pageCount
				+ "页&nbsp</span>" + "<span>" + recordcount + "条记录</span>";

	}

	synchronized public static int formatPager(String page, PageUtil pager, int recordCount, int PAGESIZE) {
		int _page;
		if (page == null) {
			_page = 1;
		} else {
			_page = Integer.parseInt(page);
			if (_page < 1) {
				_page = 1;
			}
		}
		pager.setCurrentpage(_page);
		pager.setPagesize(PAGESIZE);// 每页显示5个记录，根据需要设置PAGESIZE
		pager.setRecordcount(recordCount);
		return _page;
	}
}
