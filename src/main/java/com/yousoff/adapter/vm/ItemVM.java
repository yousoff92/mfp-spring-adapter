package com.yousoff.adapter.vm;

import com.yousoff.spring.entity.Item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ItemVM {
	
	private String id;
	private String name;
	private String description;
	
	public ItemVM(Item item) {
		this.id = String.valueOf(item.getId());
		this.name = item.getName();
		this.description = item.getDescription();
	}
}
