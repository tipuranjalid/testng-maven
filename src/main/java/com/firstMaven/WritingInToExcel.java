package com.firstMaven;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingInToExcel {

	public static void main(String[] args) throws IOException {
		// Excelfile--> WorkBook--->Sheets---> rows--> cells
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\TestData\\TestData1.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet();

		// create row and update data without looping
/*
		XSSFRow row1 = sheet.createRow(0);

		row1.createCell(0).setCellValue("Name");
		row1.createCell(1).setCellValue("City");
		row1.createCell(2).setCellValue("ID");
		row1.createCell(3).setCellValue("Language");

		XSSFRow row2 = sheet.createRow(1);

		row2.createCell(0).setCellValue("ANJALI");
		row2.createCell(1).setCellValue("HYDERABAD");
		row2.createCell(2).setCellValue("0023");
		row2.createCell(3).setCellValue("TELUGU");
		*/
		Scanner sc=new Scanner(System.in);
		for(int r=0;r<=5;r++) {
			XSSFRow currentRow=sheet.createRow(r);
			for(int c=0;c<=5;c++) {
				System.out.println("ENter value");
				String value=sc.next();
				currentRow.createCell(c).setCellValue(value);
			}
		}
		
		workbook.write(file);
		workbook.close();
		
		System.out.println("Writing is done!!!");
		

	}

}
