/**
 * 
 */
package com.stock.stockAF;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.opencsv.CSVWriter;

/**
 * @author tmaju
 *
 */
public class AddValuesToTheFile {

	public static void addValues(File file, Map<String, List<StockDeets>> map) throws IOException {
		
		System.out.println("Add the stocks you want to add in form of Name -> Sector -> Price");
		Scanner sc = new Scanner(System.in);
		
		
		String name = sc.nextLine();
		String sector = sc.nextLine();
		double price = Double.valueOf(sc.nextLine());
		List<StockDeets> list = new LinkedList<>();
		StockDeets st = new StockDeets(name, sector, price);
		list.add(st);
		if(!map.containsKey(st.Sector)) {
			map.put(sector, list);
		}	else {
			list = map.get(sector);
			list.add(st);
			map.put(sector, list);
		}
		int count = 0;
		String eol = System.getProperty("line.separator");
		com.stock.stockAF.Main.countStocks++;
		try (Writer writer = new FileWriter(file)) {
			for (Entry<String, List<StockDeets>> entry : map.entrySet()) {					
				for(StockDeets val : entry.getValue()) {
				  count++;
				  //TODO CAHNGE HARD CODED
				  if(val.Name.equals(name) || val.Name.equals("HDFC BANK")) {
						writer.append(eol);  
					 }
					writer.append(val.Name)
							.append(',')
					  		.append(val.Sector)
					  		.append(',')
					  		.append(String.valueOf(val.Price))
					  		.append(',')
					  		.append(String.valueOf(val.investedPercentage));
					
					if(com.stock.stockAF.Main.countStocks != count) {
					  writer.append(',');
					}
					
					
				}
			}
		} catch (IOException ex) {
			  ex.printStackTrace(System.err);
		}
		System.out.println("*******************************************************************************************");
		printMapValues.printMap(map);
	}	
}
