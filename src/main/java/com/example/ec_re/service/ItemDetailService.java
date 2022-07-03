package com.example.ec_re.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ec_re.domain.Item;
import com.example.ec_re.domain.Order;
import com.example.ec_re.domain.OrderItem;
import com.example.ec_re.domain.OrderStatus;
import com.example.ec_re.domain.OrderTopping;
import com.example.ec_re.domain.Topping;
import com.example.ec_re.mapper.ItemDetailMapper;
import com.example.ec_re.mapper.ItemRegisterMapper;
import com.example.ec_re.mapper.OrderQueryMapper;
import com.example.ec_re.mapper.OrderRegisterMapper;
import com.example.ec_re.mapper.OrderToppingRegisterMapper;
import com.example.ec_re.mapper.ToppingDetailMapper;

@Service
public class ItemDetailService {
	@Autowired
	ItemDetailMapper itemDetailMapper;
	@Autowired
	ToppingDetailMapper toppingDetailMapper;
	@Autowired
	OrderRegisterMapper orderRegisterMapper;
	@Autowired
	OrderQueryMapper orderQueryMapper;
	@Autowired
	ItemRegisterMapper itemRegisterMapper;
	@Autowired
	OrderToppingRegisterMapper orderToppingRegisterMapper;

	public Item detail(Integer itemId) {
		Item item = itemDetailMapper.detail(itemId);
		List<Topping> itemToppingList = toppingDetailMapper.findAll();
		item.setToppingList(itemToppingList);
		return item;
	}

	public Order saveNewShoppingCart(Order newShoppingCart, OrderItem orderItem) {
		orderRegisterMapper.saveNewShoppingCart(newShoppingCart);
		orderItem.setOrderId(newShoppingCart.getId());

		// itemの登録
		itemRegisterMapper.addItemToCart(orderItem);

		// 登録したorderItemのidをorderToppingに追加
		List<OrderTopping> orderToppingList = orderItem.getOrderToppingList();
		orderToppingList.stream().forEach(ot -> ot.setOrderItemId(orderItem.getId()));

		// toppingの登録
		orderToppingRegisterMapper.addOrderToppingToCart(orderToppingList);
		// 作成したショッピングカートをreturn
		return orderQueryMapper.findShoppingCartByUserId(3, OrderStatus.inShoppingCart);
	}

}
