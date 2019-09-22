package com.cm.qa.utills;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cm.cm.qa.base.TestBase;

public class ExcelReader extends TestBase{

	XSSFWorkbook workbook ;
	XSSFSheet sheet ;

	public ExcelReader (String filePath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(filePath);
			sheet = workbook.getSheet(sheetName);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public int rowCount() {
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount ;
	}

	public int columnCount() {
		int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
		return columnCount ;
	}	

	public String getCellData(int rowNum, int colNum) {
		String cellValue = null ;
		try {
			cellValue = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return cellValue ;
	}
}
