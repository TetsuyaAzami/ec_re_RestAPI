package com.example.ec_re.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ec_re.domain.Item;
import com.example.ec_re.domain.Order;
import com.example.ec_re.domain.OrderItem;
import com.example.ec_re.domain.OrderStatus;
import com.example.ec_re.exception.SessionIdNotFoundException;
import com.example.ec_re.service.ItemDetailService;
import com.example.ec_re.service.OrderConfirmService;

@RestController
@RequestMapping("/items")
public class ItemDetailController {
	@Autowired
	OrderConfirmService orderConfirmService;
	@Autowired
	ItemDetailService itemDetailService;

	@RequestMapping("/detail/{itemId}")
	public Item detail(@PathVariable(value = "itemId") Integer itemId) {
		return itemDetailService.detail(itemId);
	}

	// itemをOrderに入れて、Orderを返す
	@RequestMapping("/addItemToCart")
	public Order addItemToCart(@CookieValue(name = "sessionId") String sessionId,
			@RequestBody OrderItem orderItem) {
		if (sessionId == null)
			throw new SessionIdNotFoundException();

		Order shoppingCart =
				orderConfirmService.findShoppingCartByUserId(3, OrderStatus.inShoppingCart);
		if (shoppingCart == null) {
			// insert処理
			Order newShoppingCart = createNewShoppingCart(3, orderItem);
			Order result = itemDetailService.saveNewShoppingCart(newShoppingCart, orderItem);
			return result;
		}
		// 更新処理
		// Orderの返却
		return orderConfirmService.findShoppingCartByUserId(3, OrderStatus.ordered);
	}

	private Order createNewShoppingCart(Integer userId, OrderItem orderItem) {
		Order newShoppingCart = new Order();
		newShoppingCart.setUserId(userId);
		newShoppingCart.setStatus(OrderStatus.inShoppingCart);
		newShoppingCart.setTotalPrice(orderItem.getSubTotalPrice());
		return newShoppingCart;
	}
}
