package com.test.automation.uiAutomation.excelReader;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
		
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public Excel_Reader(String path){
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public String[][] getDataFromSheet(String sheetName, String excelName){
		String[][] dataSets = null;
		XSSFSheet sheet = workbook.getSheet(sheetName);																		
		int totalrow = sheet.getLastRowNum() + 1;
		int totalcolumn = sheet.getRow(0).getLastCellNum();
		dataSets = new String[totalrow - 1][totalcolumn];
		for(int i = 1; i < totalrow; i++){
			XSSFRow rows = sheet.getRow(i);
		for(int j = 0; j < totalcolumn; j++){
			XSSFCell cell = rows.getCell(j);
			if(cell.getCellType() == Cell.CELL_TYPE_STRING)
				dataSets[i-1][j] = cell.getStringCellValue(); 
		}
			}
		return dataSets;
	}
	 }
