package com.dao;

import com.dao.page.IPage;

public abstract class BasePage implements IPage {

	public abstract String getPage(String baseSQL, int from, int pageSize);

	public String synthesisPage(String baseSQL, int from, int pageSize) {
		return this.getPage(baseSQL, from, pageSize);
	}

}
