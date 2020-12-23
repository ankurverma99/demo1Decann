package org.qsp.genric;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Xl {
	public static String readCell(String xlPath, String sheetname, int r, int c) throws Exception {
		FileInputStream fis = new FileInputStream(xlPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		String celValue = sh.getRow(r).getCell(c).toString();
		return celValue;
	}

	@DataProvider
	public String[][] readData(String path, String sheetname) throws Exception {
		String[][] st;
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int rCount = sh.getPhysicalNumberOfRows();
		int cCount = sh.getRow(0).getLastCellNum();
		st = new String[rCount - 1][cCount];
		for (int i = 1; i < rCount; i++) {
			for (int j = 0; j < cCount; j++) {
				st[i - 1][j] = sh.getRow(i).getCell(j).toString();
			}
		}
		return st;
	}

}
