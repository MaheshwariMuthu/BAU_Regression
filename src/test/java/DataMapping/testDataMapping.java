package DataMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;



public class testDataMapping {
	
	public static Properties configProperties;
	
	
	/*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari Muthu
	* Date			: 08-05-2024
	* Method Name	: getTestData
	* Description	: To get input data from Excel
	---------------------------------------------------------------------------------------------------------*/
		public static void getTestData(String TC_ID, String sheetName) throws IOException {
		
			readWriteExcel.readExcel(TC_ID, sheetName);
		}
		
	/*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari Muthu
	* Date			: 08-05-2024
	* Method Name	: getValue
	* Description	: To get the value from Hash map for the corresponding key
	---------------------------------------------------------------------------------------------------------*/
		public static String getValue(HashMap<String,String> mapName, String key) throws IOException {
			
			return mapName.get(key);
		}
			
	/*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari Muthu
	* Date			: 08-05-2024
	* Method Name	: setValue
	* Description	: To set the value to Hash map for the corresponding key
	---------------------------------------------------------------------------------------------------------*/
		public static void setValue(HashMap<String,String> mapName, String key, String value) throws IOException {
				
			mapName.put(key, value);
		}
	
	/*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari Muthu
	* Date			: 08-05-2024
	* Method Name	: clearValue
	* Description	: To set the value to Hash map for the corresponding key
	---------------------------------------------------------------------------------------------------------*/
		public static void clearValue(HashMap<String,String> mapName) throws IOException {
					
			mapName.clear();
		}
		
	/*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari Muthu
	* Date			: 08-05-2024
	* Method Name	: getTestData
	* Description	: To get input data from Excel
	---------------------------------------------------------------------------------------------------------*/
		public static void writeTestResult(String sheetName) throws IOException {
			
			readWriteExcel.writeExcel(sheetName);
		}
			
		
		public static void readConfigProp() throws FileNotFoundException, IOException {
			configProperties = new Properties();
	        configProperties.load(new FileInputStream((new File(System.getProperty("user.dir") + "/src/test/resources/config.properties"))));
		}
	/*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari Muthu
	* Date			: 08-05-2024
	* Method Name	: testDataMapping
	* Description	: Instance object method creation
	---------------------------------------------------------------------------------------------------------*/
		 public static testDataMapping getInstance() {
			 testDataMapping insObj = null;
				if(insObj == null) {
					insObj = new testDataMapping();
				}
				return insObj;
		};
	

}
