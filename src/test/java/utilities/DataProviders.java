package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviders {
	@DataProvider(name="loginData")
	@Test
	public String[][] getData() throws IOException {
		//taking excel from test data
		String file=".\\TestData\\OrangeHRMTestData.xlsx";
		
		//creating object for ExcelUtility class		
		ExcelUtility xl=new ExcelUtility(file);
		
		int totalRows=xl.getRow(file, "LoginPage");
		System.out.println(totalRows);
		int totalCol=xl.getCellCount(file, "LoginPage", 0);
		System.out.println(totalCol);
		
		//creating loginData two dimensional array
		String[][] loginData = new String[totalRows][totalCol];
		
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCol;j++) {
				loginData[i-1][j]=xl.getCellData(file, "LoginPage", i, j);
				System.out.println(loginData[i-1][j]);
			}
		}	
		
		return loginData;
	}
}
