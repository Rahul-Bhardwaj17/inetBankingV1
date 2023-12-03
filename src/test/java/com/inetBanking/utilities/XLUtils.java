package com.inetBanking.utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLUtils {
	public static FileInputStream fi;
	public static FileOutputStream fO;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlFile, String xlSheet) throws Exception {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlSheet);
		int rowCount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}

	public static int getColumnCount(String xlFile, String xlSheet, int rowNum) throws Exception {
		fi=new FileInputStream(xlFile);
		wb= new XSSFWorkbook(fi);
		ws= wb.getSheet(xlSheet);
		row=ws.getRow(rowNum);
		int cellCount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}
	
	public static String getCellData(String xlFile,String xlSheet, int rowCount, int colCount) throws Exception {
		fi=new FileInputStream(xlFile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		
		row = ws.getRow(rowCount);
	    cell = row.getCell(colCount);

	    String cellData = "";

	    if (cell.getCellType() == CellType.NUMERIC) {
	        // If the cell contains numeric value
	        cellData = String.valueOf((int) cell.getNumericCellValue());
	    } else if (cell.getCellType() == CellType.STRING) {
	        // If the cell contains string value
	        cellData = cell.getStringCellValue();
	    } else if (cell.getCellType() == CellType.BLANK) {
	        // If the cell is blank
	        cellData = "";
	    }

	    wb.close();
	    fi.close();

	    return cellData;

	}
}
