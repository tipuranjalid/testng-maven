package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	public String file;

	public ExcelUtility(String file) {
		this.file=file;
	}

	public static int getRow(String xlFile, String xlSheet) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}

	public static int getCellCount(String xlFile, String xlSheet, int rownum) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rownum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}

	public static String getCellData(String xlFile, String xlSheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		String cellData;
		try {
			DataFormatter formatter = new DataFormatter();
			cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			cellData = "";
		}

		wb.close();
		fi.close();
		return cellData;
	}

	public static void setCellData(String xlFile, String xlSheet, int rownum, int colnum, String data)
			throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		;
		cell.setCellValue(data);
		fo = new FileOutputStream(xlFile);
		wb.write(fo);
		fi.close();
		fo.close();
	}

	public static void fillGreenColour(String xlFile, String xlSheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fo = new FileOutputStream(xlFile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}

	public static void fillRedColour(String xlFile, String xlSheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fo = new FileOutputStream(xlFile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}

}
