package com.utility;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	public static void getAllData() {
		
//		try {
//			
//		
//		File file = new File("C:\\Users\\Navaneethakrishnan\\Downloads\\DataDriven_IPT.xlsx");
//		
//		Workbook book = new XSSFWorkbook(file);
//		
//		Sheet sheet = book.getSheet("Sheet1");
//		
////		Row row = sheet.getRow(0);
//		
////		Cell cell = row.getCell(0);
//		
//		int lastRowno = sheet.getLastRowNum();
//		System.out.println("no of rows; " + lastRowno);
//		
//		short lastCellno = sheet.getRow(0).getLastCellNum();
//		System.out.println("no of coloumns; " + lastCellno);
//		
//		for (int i = 0; i < lastRowno; i++) {
//			Row row = sheet.getRow(i);
//			for (int j = 0; j < lastCellno; j++) {
//				Cell cell = row.getCell(j);
//				DataFormatter dataFormat = new DataFormatter();
//				String data = dataFormat.formatCellValue(cell);
//				System.out.println(data);
//			} 
//		}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		
////		return data;
//	}
//	
//	public static void main(String[] args) {
//		getAllData();
//	}
//	
}
	
    public static String getParticularCellData(int rowValue, int columnValue){
		String data = null;
		
		try {
			
			File file = new File("C:\\Users\\Navaneethakrishnan\\Downloads\\DataDriven_IPT.xlsx");
			
			Workbook book = new XSSFWorkbook(file);
			
			Sheet sheet = book.getSheet("Sheet1");
			
			Row row = sheet.getRow(0);
			
        	Cell cell = row.getCell(0);
        	
        	DataFormatter dataFormat = new DataFormatter();
		    data = dataFormat.formatCellValue(cell);
			
		} catch (Exception e) {
			System.out.println(e);
		}
				
    	return data;
    }
}
