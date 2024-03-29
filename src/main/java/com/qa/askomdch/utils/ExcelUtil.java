package com.qa.askomdch.utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	private static final String TEST_DATA_SHEET_PATH = "./src/test/resources/testdata/AskomdchTestData.xlsx";

	public static Object[][] getTestData(String sheetName) {
		Workbook book = null;
		Sheet sheet = null;
		System.out.println("reading data from sheet: " + sheetName);
		Object[][] data = null;

		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				book.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}
}
