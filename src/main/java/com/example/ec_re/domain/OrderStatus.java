package com.example.ec_re.domain;

public enum OrderStatus {
	inShoppingCart(0), ordered(1);

	private Integer status;

	private OrderStatus(Integer status) {
		this.status = status;
	}

	public Integer status() {
		return this.status;
	}
}
