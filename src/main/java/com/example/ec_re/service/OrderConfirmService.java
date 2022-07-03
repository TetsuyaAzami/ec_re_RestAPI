package com.example.ec_re.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ec_re.domain.Order;
import com.example.ec_re.domain.OrderStatus;
import com.example.ec_re.mapper.OrderQueryMapper;
import com.example.ec_re.mapper.OrderRegisterMapper;

@Service
public class OrderConfirmService {
	@Autowired
	OrderQueryMapper orderQueryMapper;
	@Autowired
	OrderRegisterMapper orderRegisterMapper;

	public Order findShoppingCartByUserId(Integer userId, OrderStatus orderStatus) {
		return orderQueryMapper.findShoppingCartByUserId(userId, orderStatus);
	}

	public Order finishingOrder(Order order) {
		Integer updatedCount = orderRegisterMapper.finishingOrder(order);
		if (updatedCount > 0) {
			return orderQueryMapper.findShoppingCartByUserId(order.getUserId(),
					OrderStatus.ordered);
		}
		throw new RuntimeException("Orderの更新中にエラーが発生しました");
	}
}
