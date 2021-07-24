package PageUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Utils  {
	
	public static Object[][] ReadData(String sheetname) throws IOException {
	File excel= new  File("C:\\Users\\isha2\\eclipse-workspaceNew\\GitRepository\\Login Credentials.xlsx");
	FileInputStream fis= new FileInputStream(excel);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
	XSSFSheet sheet=workbook.getSheetAt(0);
	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++ ) {
		for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		}
	}
	return data;
	}
	
}