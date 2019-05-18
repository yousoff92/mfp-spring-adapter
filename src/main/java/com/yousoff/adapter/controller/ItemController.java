package com.yousoff.adapter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yousoff.adapter.response.JsonResponse;
import com.yousoff.adapter.vm.ItemVM;
import com.yousoff.spring.entity.Item;
import com.yousoff.spring.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "Item Controller")
@Path("/rest/v1/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@ApiOperation(value = "Retrieve items")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getItems")
//	@OAuthSecurity(enabled = false)
	public JsonResponse getItems() {
		
		try {
			
			List<Item> items = itemService.getAllItems();
			List<ItemVM> results = new ArrayList<ItemVM>();
			
			for(Item item : items) {
				results.add(new ItemVM(item));
			}
			
			return new JsonResponse("200", "Success", results);
		} catch (Exception e) {
			return new JsonResponse("500", "Failed to retrieve item", null);
		}
	}
	
}
