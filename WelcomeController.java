package com.example.fiber.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	private Warehouse warehouse = null;
	private Map<String, Product>  products = new HashMap<>();
	
	public WelcomeController() {
		warehouse = new Warehouse();
	}



	@GetMapping("allocateCell")
	@ResponseBody
	public String allocateCell(@RequestParam String product, @RequestParam int quantity) {

		return warehouse.allocateCell(product, quantity);
	}


}
