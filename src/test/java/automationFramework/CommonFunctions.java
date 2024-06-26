package automationFramework;

import static automationFramework.DynamicWebElements.getWebElementByText;
import static automationFramework.PageActions.clickElement;
import static automationFramework.PageActions.scrollToElement;
import static automationFramework.PageActions.switchWindow;
import static automationFramework.Waits.waitTillPageLoad;
import static automationFramework.StartDriver.driver;
import static automationFramework.PageActions.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonFunctions {
	
	public static Logger log = Logger.getLogger(PageActions.class);
	
	public static void takeFullPageScreenShot(WebDriver driver) throws IOException {

	    JavascriptExecutor jsExec = (JavascriptExecutor)driver;

	    jsExec.executeScript("window.scrollTo(0, 0);"); //Scroll To Top
	    Long innerHeight = (Long) jsExec.executeScript("return window.innerHeight;");
	    Long scroll = innerHeight;

	    Long scrollHeight = (Long) jsExec.executeScript("return document.body.scrollHeight;"); 

	    scrollHeight = scrollHeight + scroll;
	    do{

	        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	        //Unique File Name For Each Screenshot        
	        File destination = new File("C://Users//train//Automation//Screenshot//"+String.join("_", 
	        LocalDateTime.now().toString().split("[^A-Za-z0-9]"))+".jpg");

	        FileUtils.copyFile(screenshot, destination);

	        jsExec.executeScript("window.scrollTo(0, "+innerHeight+");");

	        innerHeight = innerHeight + scroll;

	    }while(scrollHeight >= innerHeight);
	}
	
	/*------------------------------------------------------------------------------------------------------
	 * Author		: Maheswari Muthu
	 * Date			: 03-05-2023
	 * Method Name	: randomString
	 * Description	: To generate random string with length provided
	 ---------------------------------------------------------------------------------------------------------*/
		public static String randomString(int length) {
	        Random random = new Random();
	        String ranString = "";
	        char[] word = new char[random.nextInt(8)+length];// words of length 3 through 10. (1 and 2 letter words are boring.)
	        for(int j = 0; j < word.length; j++)
	        {
	            word[j] = (char)('a' + random.nextInt(26));
	            ranString = ranString+word[j];
	        }
	        return ranString;
		}
		
		/*------------------------------------------------------------------------------------------------------
		 * Author		: Maheswari Muthu
		 * Date			: 28-05-2023
		 * Method Name	: returnTodayDate
		 * Description	: To return current date as string
		 ---------------------------------------------------------------------------------------------------------*/
		public static String returnDate(String format) {		
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		    Date date = new Date();
		    String dateToStr = dateFormat.format(date);
		    System.out.println("Date:"+dateToStr);
			return dateToStr;
		}
		
		/*------------------------------------------------------------------------------------------------------
		 * Author		: Maheswari Muthu
		 * Date			: 28-05-2023
		 * Method Name	: returnTodayDate
		 * Description	: To return current date as string
		 ---------------------------------------------------------------------------------------------------------*/
		public static String returnNextDate(String format) {		
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		    Date date = new Date();
		    date = DateUtils.addDays(date, 1);
		    String dateToStr = dateFormat.format(date);
		    System.out.println("Date:"+dateToStr);
			return dateToStr;
		}
		
	/*------------------------------------------------------------------------------------------------------
	* Author		: Chandrakant
	* Date			: 28-05-2023
	* Method Name	: changeTheLanguageIntoEnglish
	* Description	: To change the language to ENglish
	---------------------------------------------------------------------------------------------------------*/		
		public void changeTheLanguageIntoEnglish() throws InterruptedException {
			Thread.sleep(3000);
			scrollToElement(getWebElementByText("See plan details in English."));
			clickElement(getWebElementByText("See plan details in English."),"Change Language",false);
			waitTillPageLoad();
			switchWindow();
		}
		
	/*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari
	* Date			: 30-05-2023
	* Method Name	: validateBrokenLinks
	* Description	: To validate the broken links
	---------------------------------------------------------------------------------------------------------*/			
		public void validateBrokenLinks(String page) {
			// Finding all the available links on webpage
			log.info("-------------------------"+page+"-----------------------");
			List<WebElement> links = driver.findElements(By.tagName("a"));

			// Iterating each link and checking the response status
			for (WebElement link : links) {
			String url = link.getAttribute("href");
			String linkText = link.getAttribute("title");
			if((url!=null) && (!url.contains("javascript")) && (!url.contains("tel:"))) 
				verifyLink(linkText, url);
			}
			log.info("--------------------------------------------------------------");
		}
		
	/*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari
	* Date			: 30-05-2023
	* Method Name	: verifyLink
	* Description	: To validate the broken links
	---------------------------------------------------------------------------------------------------------*/					
		public static void verifyLink(String title, String url) {
			try {
				URL link = new URL(url);
				HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
				httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
				httpURLConnection.connect();
				InputStream input;
				if (httpURLConnection.getResponseCode() == 200) {}
					//log.info(title + ":" + url + " - " + httpURLConnection.getResponseMessage() + "\n");
				else {
					/*input = httpURLConnection.getErrorStream();
		            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		            String msg;
		            while ((msg =reader.readLine()) != null)
		                System.out.println("Forbitten:"+msg);*/
					log.info(title + ":" + url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link\n");}
			} catch (Exception e) {
				log.info(title + ":" + url + " - " + "is a broken link\n");
			}
		}
	
	/*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari Muthu
	* Date			: 03-05-2023
	* Method Name	: CommonFunctions
	* Description	: Instance object method creation
	---------------------------------------------------------------------------------------------------------*/
		 public static CommonFunctions getInstance() {
			 CommonFunctions commfun = null;
			if(commfun == null) {
				commfun = new CommonFunctions();
			}
			return commfun;
		 };		
	
}
