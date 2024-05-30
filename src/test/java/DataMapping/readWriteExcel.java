package DataMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DataMapping.testDataMapping;
import static automationFramework.Constant.*;

public class readWriteExcel {
	
	/*------------------------------------------------------------------------------------------------------
	 * Author		: Maheswari Muthu
	 * Date			: 08-05-2023
	 * Method Name	: readExcel
	 * Description	: To read the excel data for corresponding Test ID
	 ---------------------------------------------------------------------------------------------------------*/
		public static void readExcel(String TC_ID, String sheetName) throws IOException {
			
			File file = new File(System.getProperty("user.dir") + "/src/test/resources/TestData/inputData.xlsx");
			FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/TestData/inputData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			int rowCount = sheet.getLastRowNum();
			int columnCount = row.getLastCellNum();
			int TCrow = 0;
			String tcID = "", columnName = "", columnValue = "";
			switch(sheetName) {
				case "URL":
					for(int i=1; i<rowCount; i++) {
						columnName = sheet.getRow(i).getCell(0).getStringCellValue();
						columnValue = sheet.getRow(i).getCell(1).getStringCellValue();
						testDataMapping.setValue(URLMapping, columnName, columnValue);
					}
					break;
				case "inputData":
					for(int j=1; j<=rowCount; j++) {
						tcID = sheet.getRow(j).getCell(0).getStringCellValue();
						System.out.println("tcID:" + tcID);
						if(tcID.equals(TC_ID)) {
							TCrow = j;
							break;
						}
					}
					for(int i=0; i<columnCount; i++) {
						columnName = sheet.getRow(0).getCell(i).getStringCellValue();
						columnValue = sheet.getRow(TCrow).getCell(i).getStringCellValue();
						testDataMapping.setValue(inputDataMapping, columnName, columnValue);
					}
					break;
			}
			input.close();
		}
	
	/*------------------------------------------------------------------------------------------------------
	 * Author		: Maheswari Muthu
	 * Date			: 08-05-2023
	 * Method Name	: writeExcel
	 * Description	: To write the excel with data corresponding to Test ID
	 ---------------------------------------------------------------------------------------------------------*/
		public static void writeExcel(String sheetName) {
			
			File file = new File(System.getProperty("user.dir") + "/src/test/resources/TestData/outputData.xlsx");
			FileInputStream input;
			try {
				input = new FileInputStream(file);
				XSSFWorkbook workbook = new XSSFWorkbook(input);
				XSSFSheet sheet = workbook.getSheet(sheetName);
				XSSFRow row = sheet.getRow(0);
				int rowCount = sheet.getLastRowNum();
				int columnCount = row.getLastCellNum();
				rowCount = rowCount+1;
				sheet.createRow(rowCount);
				String tcID = "", columnName = "", columnValue = "";
				for(int i=0; i<columnCount; i++) {
					columnName = sheet.getRow(0).getCell(i).getStringCellValue();
					columnValue = testDataMapping.getValue(outputData, columnName);
					XSSFCell cell = sheet.getRow(rowCount).createCell(i);
					cell.setCellValue(columnValue);
				}
				input.close();
				FileOutputStream output = new FileOutputStream(file);
				workbook.write(output);
				workbook.close();
				output.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error in writing data in excel" +e);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error in writing data in excel" +e);
				e.printStackTrace();
			}catch (Exception e) {
				System.out.println("Error in writing data in excel" +e);
				e.printStackTrace();
			}
		}
	
		/*------------------------------------------------------------------------------------------------------
		* Author		: Maheswari Muthu
		* Date			: 08-05-2024
		* Method Name	: readWriteExcel
		* Description	: Instance object method creation
		---------------------------------------------------------------------------------------------------------*/
			 public static readWriteExcel getInstance() {
				 readWriteExcel excel = null;
					if(excel == null) {
						excel = new readWriteExcel();
					}
					return excel;
			};

}
