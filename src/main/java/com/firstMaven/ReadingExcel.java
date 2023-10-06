package com.firstMaven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	// Excelfile--> WorkBook--->Sheets---> rows--> cells

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\TestData.xlsx");
		// System.getProperty("user.dir") will return currenct project path
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		// XSSFSheet sheet=workBook.getSheetAt(0); to get sheet by index
		
		int totalRows= sheet.getLastRowNum();// will return num of rows		
		
		int NoOfColumns= sheet.getRow(1).getLastCellNum(); // will return total no of coloumns
		
		System.out.println("NumberOf rows"+ totalRows);
		System.out.println("Number of cells"+ NoOfColumns);
		
		for(int r=0;r<=totalRows;r++) {
			XSSFRow currentRow=sheet.getRow(r);
			for(int c=0;c<NoOfColumns;c++) {
				String value= currentRow.getCell(c).toString();
				System.out.print(value+"              ");
			}
			System.out.println("");
		}

	}

}
