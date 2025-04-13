package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="dataprovider")
	public Object[][] readTestData(Method method){
		
		String testSheetName = method.getName();
		
		Object[][] testData = null;
		
		try {
			
			File data = new File(Constants.testDataFile);
			FileInputStream file = new FileInputStream(data);
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(testSheetName);
			
			
			int totalRows = sheet.getPhysicalNumberOfRows();
			XSSFRow row = sheet.getRow(0);
			int totalCells = row.getLastCellNum();
			
			DataFormatter formatter = new DataFormatter();
			testData = new Object[totalRows-1][totalCells-1];
			
			for(int i=1; i<totalRows; i++) {
				row = sheet.getRow(i);
				for(int j=1; j<totalCells;j++) {
					testData[i-1][j-1] = formatter.formatCellValue(row.getCell(j));
				}
			}
			workbook.close();
			file.close();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return testData;
	}

}
