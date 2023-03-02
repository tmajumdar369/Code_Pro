package com.stock.stockAF;

public class StockDeets {
	String Name;
	String Sector;
	double Price;
	double investedPercentage;
	static double total = 0;
	
	StockDeets(String Name, String Sector, double Price) {
		this.setName(Name);
		this.Sector = Sector;
		this.Price = Price;
		total += Price;
		investedPercentage = Price * 100 / total;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
