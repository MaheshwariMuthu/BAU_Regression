package stepDefinations;

import automationFramework.DataReader;
import automationFramework.PageActions;
import automationFramework.StartDriver;
import automationFramework.Utils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import static automationFramework.Constant.*;
import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import DataMapping.testDataMapping;


public class Hooks extends StartDriver {

    public static File extentFile = null;
    public static String fileName;
    public static boolean flag = false;
    public static Properties configProperties;
    public static String TC_ID;
    public static Scenario scenario;
    public static long startTime;
    public static long endTime;
    public static Logger log = Logger.getLogger(PageActions.class);

    @Before
    public void beforeScenario(Scenario scenario) throws FileNotFoundException, IOException, ParseException, InterruptedException {

        System.out.println("Starting Scripts");
        startTime = System.currentTimeMillis();
        configProperties = new Properties();
        configProperties.load(new FileInputStream((new File(System.getProperty("user.dir") + "/src/test/resources/config.properties"))));
        String browser = configProperties.getProperty("browser");
        Collection<String> tags = scenario.getSourceTagNames();
        TC_ID = (tags.stream().findFirst().get()).substring(1);
        log.info(TC_ID + " - "+ scenario.getName()+ "\n");
        testDataMapping.setValue(outputData, "TestID", TC_ID);
        testDataMapping.getTestData(TC_ID, "inputData");
        testDataMapping.getTestData(TC_ID, "URL");
  
        if ((browser.equalsIgnoreCase("chrome"))) {
            //	WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("-incognito");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("start-maximized");
            options.addArguments("--force-device-scale-factor=0.8");
//			options.setExperimentalOption("excludeSwitches",
//				    Arrays.asList("disable-popup-blocking"));
            options.addArguments("--disable-popup-blocking");
            options.setBrowserVersion("117");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setAcceptInsecureCerts(true);
            caps.acceptInsecureCerts();
            //	caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
            driver = new ChromeDriver(options);
            Thread.sleep(2000);
            driver.manage().deleteAllCookies();

        } else if ((browser.equalsIgnoreCase("firefox"))) {
//			WebDriverManager.firefoxdriver().setup();
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setAcceptInsecureCerts(true);
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            driver = new FirefoxDriver(options);
        }
    }


//    @AfterStep
//    public void AddScreenshot(Scenario scenario) throws IOException {
//        if (scenario.isFailed()) {
//            byte[] imageBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            //byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
//            scenario.attach(imageBytes, "image/png", "image");
//        }
//    }

    /**
     * Description: Taking screenshot for pass and failed scenario- -creating folder
     * for both as well pass and failed scenario
     *
     * @param scenario
     * @throws IOException
     * @author aatish.slathia
     */
    @After
    public static void saveScreenShotForFailedAndPassScenario(Scenario scenario) throws IOException, InterruptedException {
        String ImagePath;
        Thread.sleep(10000);
        if (scenario.isFailed()) {
            try {

                ImagePath = "./Failed_Screenshots/" + Utils.getStringWithTimeStamp(scenario.getName()) + ".png";
                File screenshot_with_scenario_name = ScreenshotWithURL();
                byte[] fileContent = FileUtils.readFileToByteArray(screenshot_with_scenario_name);
                scenario.attach(fileContent, "image/png", "image");
                FileUtils.copyFile(screenshot_with_scenario_name, new File(ImagePath));
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        } else {
            try {

				ImagePath = "./Pass_Screenshots/" + Utils.getStringWithTimeStamp(scenario.getName()) + ".png";
                File screenshot_with_scenario_name  = ScreenshotWithURL();
                byte[] fileContent = FileUtils.readFileToByteArray(screenshot_with_scenario_name);
                scenario.attach(fileContent, "image/png", "image");
				FileUtils.copyFile(screenshot_with_scenario_name, new File(ImagePath));
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        System.out.println("After test");
        log.info("-------------------------------------------------------------------------------------------------");
    	endTime = System.currentTimeMillis();
        calculateExecutionTime();
        testDataMapping.writeTestResult("outputData");
        testDataMapping.clearValue(outputData);
        driver.manage().deleteAllCookies();
        driver.close();

    }

    public static void takeScreenshot(String featurename) {

        try {
            ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            File screenshot_with_scenario_name = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot_with_scenario_name,
                    new File("./Failed_Screenshots/" + Utils.getStringWithTimeStamp(featurename) + ".png"));
        } catch (WebDriverException | IOException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
    }
    
    public static void calculateExecutionTime() throws IOException {
        System.out.println("startTime:"+startTime);
        System.out.println("endTime:"+endTime);
        String time = "";
        long elapsedTimeInSeconds = TimeUnit.MILLISECONDS.toSeconds(endTime-startTime);
        long elapsedTimeInMins;
        System.out.println("elapsedTimeInSeconds:"+elapsedTimeInSeconds);
        if(elapsedTimeInSeconds<60) {
        	time = "00:00:"+Long.toString(elapsedTimeInSeconds);
        }else {
        	elapsedTimeInMins = elapsedTimeInSeconds/60;
        	elapsedTimeInSeconds = elapsedTimeInSeconds % 60;
        	if(Long.toString(elapsedTimeInMins).length()>1)
        		time = "00:"+Long.toString(elapsedTimeInMins);
        	else
        		time = "00:"+"0"+Long.toString(elapsedTimeInMins);
        	
        	if(Long.toString(elapsedTimeInSeconds).length()>1)
        		time = time + ":" + Long.toString(elapsedTimeInSeconds);
        	else
        		time = time + ":0" + Long.toString(elapsedTimeInSeconds);
        }
        testDataMapping.setValue(outputData, "Time",time );
    }


    public static File ScreenshotWithURL() {

        // Take screenshot
        BufferedImage screenshot = null;
        try {
            screenshot = ImageIO.read(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));

            // Create a new image with space for URL at the bottom
            BufferedImage finalImage = new BufferedImage(screenshot.getWidth(), screenshot.getHeight() + 50, BufferedImage.TYPE_INT_ARGB);

            Graphics g = finalImage.getGraphics();
            g.drawImage(screenshot, 0, 0, null);
            g.setColor(Color.RED);
            g.setFont(new Font("SansSerif", Font.BOLD, 20));

            // Get the current date and time
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String dateTimeStr = now.format(formatter);

            g.drawString(driver.getCurrentUrl(), 10, 35); // Add URL at the top

            // Draw date and time at the bottom right
            g.drawString(dateTimeStr, screenshot.getWidth() - 220, screenshot.getHeight() - 10); // Adjust position and width as per font size

            // Saving to a temp file or specific location
            File output = new File("screenshotWithUrl.png");
            ImageIO.write(finalImage, "png", output);

            System.out.println("After test - ScreenshotWithURL");

            return output;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
