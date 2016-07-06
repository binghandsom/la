package com.maq.base.utils;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSON;

@SuppressWarnings("serial")
public class PageBean<T> implements Serializable {

	private Long total;
	private List<T> rows;

	private Integer pageNo;
	private Integer pageSize;
	
	private T data;

	public PageBean() {

	}

	public PageBean(Integer pageNo, Integer pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
