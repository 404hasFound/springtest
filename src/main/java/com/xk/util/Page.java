package com.xk.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


public class Page<T> extends PageRequest implements Iterator<T>{

	

	protected List<T> rows = null;
	protected long total = -1;

	public Page() {
	}

	public Page(PageRequest request) {
		this.pageNo = request.getPageNo();
		this.pageSize = request.getPageSize();
		this.orderBy = request.orderBy;
		this.orderDir = request.orderDir;

	}

	/**
	 * 获得页内的记录列表.
	 */
	public List<T> getRows() {
		return rows == null ? new ArrayList<T>(0) : rows;
	}

	/**
	 * 设置页内的记录列表.
	 */
	public void setRows(final List<T> rows) {
		this.rows = rows;
	}

	/**
	 * 获得总记录数, 默认值为-1.
	 */
	public long getTotal() {
		return total;
	}

	/**
	 * 设置总记录数.
	 */
	public void setTotal(long total) {
		this.total = total;
		this.totalCount = Long.valueOf(total).intValue();
	}


	/**
	 * 根据pageSize与total计算总页数.
	 */
	public int getTotalPages() {
		return (int) Math.ceil((double) total / (double) pageSize);

	}

	/**
	 * 是否还有下一页.
	 */
	public boolean hasNextPage() {
		return (getPageNo() + 1 <= getTotalPages());
	}

	/**
	 * 是否最后一页.
	 */
	public boolean isLastPage() {
		return !hasNextPage();
	}

	/**
	 * 取得下页的页号, 序号从1开始.
	 * 当前页为尾页时仍返回尾页序号.
	 */
	public int getNextPage() {
		if (hasNextPage()) {
			return getPageNo() + 1;
		} else {
			return getPageNo();
		}
	}

	/**
	 * 是否还有上一页.
	 */
	public boolean hasPrePage() {
		return (getPageNo() > 1);
	}

	/**
	 * 是否第一页.
	 */
	public boolean isFirstPage() {
		return !hasPrePage();
	}

	/**
	 * 取得上页的页号, 序号从1开始.
	 * 当前页为首页时返回首页序号.
	 */
	public int getPrePage() {
		if (hasPrePage()) {
			return getPageNo() - 1;
		} else {
			return getPageNo();
		}
	}

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	public T next() {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
