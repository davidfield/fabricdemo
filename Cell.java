package com.example.fabric.demo;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	
	private List<CellTypes> cellTypes = new ArrayList<>();;
	private int occupiedCount = 0;
	private Product product = null;
	private final static int MAX_PRODUCTS_PER_CELL = 10;


	public int getSpareCapacity() {
		System.out.println(MAX_PRODUCTS_PER_CELL-occupiedCount);
		return (MAX_PRODUCTS_PER_CELL-occupiedCount);
	}
	
	public int getOccupiedCount() {
		return occupiedCount;
	}

	public List<CellTypes> getCellTypes() {
		return cellTypes;
	}

	public void setCellTypes(List<CellTypes> cellTypes) {
		this.cellTypes = cellTypes;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void placeInCell(int quantity) {
		if (occupiedCount+quantity>10) {
			throw new IllegalArgumentException();
		}
		occupiedCount = occupiedCount + quantity;
		System.out.println("occupiedCount:"+occupiedCount);
	}
	
	public void removeFromCell(int quantity) {
		if (occupiedCount+quantity<0) {
			throw new IllegalArgumentException();
		}		
		occupiedCount = occupiedCount - quantity;
	}
	
	
	

}
