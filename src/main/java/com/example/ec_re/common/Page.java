package com.example.ec_re.common;

public class Page {
	private static Integer offset = 0;
	private static Integer limit = 10;
	private static Integer page = 1;

	public static Integer offset(String offset) {
		if (offset == null)
			return Page.offset;
		return Integer.parseInt(offset);
	}

	public static Integer limit(String limit) {
		if (limit == null) {
			return Page.limit;
		}
		return Integer.parseInt(limit);
	}

	public static Integer page(String page) {
		if (page == null) {
			return Page.page;
		}
		return Integer.parseInt(page);
	}
}
