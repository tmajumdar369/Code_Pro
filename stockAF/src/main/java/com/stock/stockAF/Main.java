package com.stock.stockAF;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
	public static int countStocks = 0;
	public static void main(String[] args) throws IOException, Exception {
		//Bring the driver code. The first step is just uploading the file here
		File file = new File("D:\\JavaProjects\\stockAF\\src\\main\\resources\\static\\Stock_AF.csv");
		Scanner sc = new Scanner(file);
		sc.useDelimiter(",");
		
		//Add diffrent funtion in the system
		Map<String, List<StockDeets>> map = PutValuesInAMap.addToMap(sc);
		
		//Add values to csv file
		AddValuesToTheFile.addValues(file, map);
	}
}
