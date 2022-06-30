package com.example.ec_re.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderTopping {
	private Integer id;
	private Integer toppingId;
	private Integer orderItemId;
	private Topping topping;
}
