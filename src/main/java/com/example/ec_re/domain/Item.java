package com.example.ec_re.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	private Integer id;
	private String name;
	private String description;
	private Integer priceM;
	private Integer priceL;
	private String imagePath;
	private Boolean deleted;
	private List<Topping> toppingList;
}
