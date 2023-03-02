package com.stock.stockAF;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class PutValuesInAMap {

	

	public static Map<String, List<StockDeets>> addToMap(Scanner sc) throws Exception{
		// TODO Auto-generated method stub
		Map<String, List<StockDeets>> map = new HashMap<>();
		String name = null;
		String sector = null;
		double price = 0;
		double percentage;
		while(sc.hasNextLine()) {
			List<StockDeets> list = new LinkedList<>();
			String n = sc.next();
			name = n.replaceAll("\n", "");
			sector = sc.next();
			price = Double.parseDouble(sc.next());
			percentage = Double.parseDouble(sc.next());
			StockDeets st = new StockDeets(name, sector, price);
			list.add(st);
			System.out.print(list.get(0).Name + " "+list.get(0).Sector+
					"  "+list.get(0).Price+" "+list.get(0).investedPercentage);
			if(!map.containsKey(st.Sector)) {
				map.put(sector, list);
			}	else {
				list = map.get(sector);
				list.add(st);
				map.put(sector, list);
			}
		}
		printMapValues.printMap(map);
		return map;
	}
}
