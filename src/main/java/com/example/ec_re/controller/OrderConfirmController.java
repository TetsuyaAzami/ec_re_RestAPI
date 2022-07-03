package com.example.ec_re.controller;

import java.time.LocalDate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ec_re.domain.Order;
import com.example.ec_re.domain.OrderStatus;
import com.example.ec_re.exception.SessionIdNotFoundException;
import com.example.ec_re.form.OrderForm;
import com.example.ec_re.service.OrderConfirmService;

@RestController
@RequestMapping("/order")
public class OrderConfirmController {
	@Autowired
	OrderConfirmService orderConfirmService;

	@RequestMapping("/confirm")
	public Order confirm(@CookieValue(value = "sessionId", required = false) Integer sessionId) {
		if (sessionId == null) {
			throw new SessionIdNotFoundException();
		}
		Order order =
				orderConfirmService.findShoppingCartByUserId(sessionId, OrderStatus.inShoppingCart);
		return order;
	}

	@RequestMapping("/finishing")
	public Order finishing(@RequestBody @Validated OrderForm orderForm,
			@CookieValue(value = "sessionId", required = true) Integer sessionId) {
		// 注文インスタンスの作成
		Order order = new Order();
		BeanUtils.copyProperties(orderForm, order);
		order.setOrderDate(LocalDate.now());
		order.setDeliveryTime(orderForm.generateOrderDeliveryDateTime());
		order.setPaymentMethod(Integer.parseInt(orderForm.getPaymentMethod()));
		order.setUserId(1);
		order.setStatus(OrderStatus.ordered);

		Order result = orderConfirmService.finishingOrder(order);
		return result;
	}
}
