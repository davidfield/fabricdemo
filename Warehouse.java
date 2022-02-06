package com.example.fabric.demo;

import static com.example.fabric.demo.CellTypes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {

	private Cell[][] cells = new Cell[10][10];
	private Map<String, Product> products = new HashMap<>();

	public Warehouse() {
		initializeWarhouse();
		int[][] locations = { { 1, 4 }, { 1, 2 }, { 1, 3 } };
		allocateCellType(COOLING, locations);
		initializeProducts();
	}

	private void initializeWarhouse() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				// Create cell
				Cell cell = new Cell();
				cells[i][j] = cell;
			}
		}
	}

	private void initializeProducts() {
		List<CellTypes> cellTypes = new ArrayList<>();
		cellTypes.add(COOLING);
		Product product = new Product("cheese", "", cellTypes);
		products.put(product.getName(), product);
	}

	public void allocateCellType(CellTypes cellType, int[][] locations) {

		for (int i = 0; i < locations.length; i++) {

			int[] xy = locations[i];
			cells[xy[0]][xy[1]].getCellTypes().add(CellTypes.COOLING);
		}

	}

	public synchronized String allocateCell(String productName, int quantity) {
		if (quantity > 10) {
			throw new IllegalArgumentException();
		}

		if (!products.containsKey(productName)) {
			throw new IllegalArgumentException();
		}

		Product product = products.get(productName);

		// get a cell with the product, and spare capacity
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				if (cells[i][j].getCellTypes().containsAll(product.getRequiredCellTypes())
						&& ((10 - cells[i][j].getOccupiedCount()) <= quantity) && cells[i][j].getProduct() != null
						&& cells[i][j].getProduct().equals(product)) {
					cells[i][j].placeInCell(quantity);
					return String.format("foundCell: true, cell: %d, %d", i, j);
				}
			}
		}

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				if (cells[i][j].getCellTypes().containsAll(product.getRequiredCellTypes())
						&& cells[i][j].getProduct() == null) {
					if (cells[i][j].getSpareCapacity()>= quantity) {
						cells[i][j].placeInCell(quantity);
						return String.format("foundCell: true, cell: %d, %d", i, j);
					}
				}
			}
		}

		return "foundCell: false";

	}

}
