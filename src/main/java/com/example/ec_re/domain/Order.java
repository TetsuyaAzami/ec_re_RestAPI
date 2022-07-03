package com.example.ec_re.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private Integer id;
	private Integer userId;
	private OrderStatus status;
	private Integer totalPrice;
	private LocalDate orderDate;
	private String destinationName;
	private String destinationEmail;
	private String destinationZipcode;
	private String destinationAddress;
	private String destinationTel;
	private LocalDateTime deliveryTime;
	private Integer paymentMethod;
	private User user;
	private List<OrderItem> orderItemList;
}
