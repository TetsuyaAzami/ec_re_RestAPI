package com.example.ec_re.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ec_re.common.Page;
import com.example.ec_re.domain.Item;
import com.example.ec_re.mapper.ItemListMapper;

@RestController
@RequestMapping("/items")
public class ItemListController {
	@Autowired
	ItemListMapper itemListMapper;

	@RequestMapping("")
	public List<Item> index(String offset, String limit) {
		var offsetInt = Page.offset(offset);
		var limitInt = Page.limit(limit);
		var items = itemListMapper.findAll(new RowBounds(offsetInt, limitInt));
		return items;
	}

	@RequestMapping("/search")
	public Map<String, List<Item>> search(String itemName, String offset, String limit) {
		var offsetInt = Page.offset(offset);
		var limitInt = Page.limit(limit);
		var items = itemListMapper.findByName(itemName, new RowBounds(offsetInt, limitInt));
		return Collections.singletonMap("items", items);
	}
}
