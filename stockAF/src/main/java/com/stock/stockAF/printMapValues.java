package com.stock.stockAF;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class printMapValues {
	public static void printMap(Map<String, List<StockDeets>> map) {
		for (Entry<String, List<StockDeets>> me :
            map.entrySet()) {
			List<StockDeets> arr = me.getValue();
           System.out.print(me.getKey() + ":");
           for(StockDeets s: arr) {
        	   com.stock.stockAF.Main.countStocks++;
        	   System.out.print(s.getName()+" ");
        	   System.out.print(s.Sector+" ");
        	   System.out.print(s.Price+" ");
        	   System.out.print(s.investedPercentage+" ");
        	   //System.out.println();
           }
           System.out.println();
       }
	}
}
