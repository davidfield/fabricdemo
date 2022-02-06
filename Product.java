package com.example.fiber.demo;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	private String name;
	private String description;
	private List<CellTypes> requiredCellTypes = new ArrayList<>();
	
	public Product(String name, String description, List<CellTypes> requiredCellTypes) {
		super();
		this.name = name;
		this.description = description;
		this.requiredCellTypes = requiredCellTypes;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<CellTypes> getRequiredCellTypes() {
		return requiredCellTypes;
	}


}
