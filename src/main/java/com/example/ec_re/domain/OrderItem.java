package com.example.ec_re.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
	private Integer id;
	private Integer itemId;
	private Integer orderId;
	private Integer quantity;
	private Character size;
	private Item item;
	private List<OrderTopping> orderToppingList;

	public Integer getSubTotalPrice() {
		Integer orderItemPriceM = item.getPriceM();
		Integer orderItemPriceL = item.getPriceL();
		Integer totalOrderToppingPriceM =
				orderToppingList.stream().mapToInt(ot -> ot.getTopping().getPriceM()).sum();
		Integer totalOrderToppingPriceL =
				orderToppingList.stream().mapToInt(ot -> ot.getTopping().getPriceL()).sum();
		if (this.size.equals('M'))
			return (orderItemPriceM + totalOrderToppingPriceM) * quantity;
		if (this.size.equals('L'))
			return (orderItemPriceL + totalOrderToppingPriceL) * quantity;
		throw new RuntimeException("サイズがMでもLでもありません");
	}
}
