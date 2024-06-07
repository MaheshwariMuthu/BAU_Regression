package pageActions;

import automationFramework.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import DataMapping.testDataMapping;
import automationFramework.CommonFunctions;
import automationFramework.PageActions;
import pageLocators.CommonPageLocators;
import static automationFramework.DataReader.*;
import static automationFramework.Constant.*;
import static automationFramework.DynamicWebElements.*;

import static automationFramework.PageActions.*;
import static automationFramework.Waits.*;
import static automationFramework.Waits.verifyWebElementVisibleWebElementBoolean;
import static automationFramework.Waits.waitTillPageLoad;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import static DataMapping.testDataMapping.configProperties;

public class HSLandingPageActions {

    public static String currentDateandTime;
    public static Logger log = Logger.getLogger(HSLandingPageActions.class);
    CommonPageLocators commonPageLocators = new CommonPageLocators();
    CommonFunctions commonFunctions = new CommonFunctions();
    Utils Utils = new Utils();


    CommonPageActions commonPageActions = new CommonPageActions();

    public static String BrowserorderNumberTexts;


    public HSLandingPageActions() {
    }


    public void enterZipcode(String zipCode) throws InterruptedException {
        clickElement(commonPageLocators.txtZipCode, "Enter Zipcode textbox", false);

    }

    /**
     * Description: Adding Product inside the cart and click on proceed to checkout.
     *
     * @throws InterruptedException
     * @throws IOException 
     */
    public void addProductToCartAndProceedToCheckout() throws InterruptedException, IOException {
        int i = 0;
        String product = "";
        if (commonPageLocators.buttonAddToCart.isEnabled()) {
                scrollToElement(commonPageLocators.buttonAddToCart);
                product = commonPageLocators.buttonAddToCart.getText();
                clickElement(commonPageLocators.buttonAddToCart, "Add to cart", false);
                waitTillPageLoad();
                String CartPage = driver.getTitle();

                if (CartPage.equalsIgnoreCase("Checkout Empty Cart")) {
                    Assert.fail("Your Cart is Empty");
                } else {
                    log.info(product+ "product is added to Cart successfully");
                    verifyWebElementVisibleWebElementBoolean(commonPageLocators.buttonProceedToCheckout);
                    clickElement(commonPageLocators.buttonProceedToCheckout, "Proceed To Checkout", false);

                    waitTillPageLoad();
                    System.out.println(configProperties.getProperty("server.site"));
                    if (configProperties.getProperty("server.site").equalsIgnoreCase("Homeserve")){
	                    if (verifyWebElementVisibleWebElementBoolean(commonPageLocators.addOn_linkCheckout)) {
	                    	clickElement(commonPageLocators.addOn_linkCheckout, "Checkout", false);
	                    }else if(verifyWebElementVisibleWebElementBoolean(getWebElementByText("Proceed To Checkout"))) {
	                    	clickElement(getWebElementByText("Proceed To Checkout"), "Proceed To Checkout", false);
	                    }
                    }
                    if (configProperties.getProperty("server.site").equalsIgnoreCase("slwofc") ||
                            configProperties.getProperty("server.site").equalsIgnoreCase("aepindianamichigan") ||
                            configProperties.getProperty("server.site").equalsIgnoreCase("kypower-tabs") ||
                            //	configProperties.getProperty("server.site").equalsIgnoreCase("firstenergy-fundle")||
                            configProperties.getProperty("server.site").equalsIgnoreCase("sanjose") ||
                            configProperties.getProperty("server.site").equalsIgnoreCase("wvwachoice")
                    ) {
                    	if (verifyWebElementVisibleWebElementBoolean(commonPageLocators.linkProceedToCheckout))
                    		clickElement(getWebElementByText("Proceed To Checkout"), "Proceed To Checkout", false);
                    }
                }
        } else {
        	testDataMapping.setValue(outputData, "Status", "FAIL");
            testDataMapping.setValue(outputData, "Reason", "addToCart --- button Not displayed");
            Assert.fail("ERROR:  --- addToCart --- button Not displayed");
        }
        waitTillPageLoad();
    }


    /**
     * Description: Entering the Contact details inside the form.
     *
     * @throws InterruptedException
     * @throws ParseException
     * @throws IOException
     * @throws FileNotFoundException
     */


    public void enter_Zipcode_and_City_Details(String Zipcode, String City) throws IOException {
    	testDataMapping.setValue(outputData, "zipCode", Zipcode);
        if (configProperties.getProperty("server.site").equalsIgnoreCase("aepindianamichigan")) {
            typeText(commonPageLocators.txtZipCode, Zipcode, "Zipcode");
            typeText(commonPageLocators.city_Details, City, "Zipcode");

        }

    }

    public void continueToPayment() throws Exception {
        clickElement(getWebElementByText("Continue to Payment Information"), "Continue to Payment Information", false);
        waitTillPageLoad();
        Thread.sleep(5000);
        clickElement(getWebElementByText("Yes, use this address"), "Yes, use this address", false);
        waitTillPageLoad();
    }

    /**
     * Description:
     *
     * @throws InterruptedException
     */
    public void enterPaymentDetails() throws InterruptedException {
        clickElement(getWebElementByID("select2-checkout-form__method-container"), "Payment options", false);
        clickElement(commonPageLocators.creditCardOption, "CreditCard", false);
        Thread.sleep(12000);
        waitTillPageLoad();
        driver.switchTo().frame(commonPageLocators.creditCardNumberFrame);
        System.out.println("Enter Card Number");
        Thread.sleep(5000);
        typeText(commonPageLocators.creditCardNumberFrame, "4024007168458700", "Card number");
        typeText(getWebElementByID("micro-exp-date"), "122027", "Expiratioin Date");
        driver.switchTo().defaultContent();
        clickElement(commonPageLocators.completeSecureCheckout, "Checkout", false);
        waitTillPageLoad();
        Thread.sleep(8000);
    }

    public void enterAccountDetailsAndCompleteCheckout(String Value) throws Exception {

        typeText(commonPageLocators.enter_Account_Number, Value, "account number");
        clickElement(commonPageLocators.completeSecureCheckout, "complete secure checkout", false);
        waitTillPageLoad();

    }


    /**
     * Description: Verify order conformed successfully
     *
     * @throws InterruptedException
     */
    public void verifyOrderConformedSuccessfully() throws Exception {
    	String sanity = testDataMapping.getValue(inputDataMapping,"SanityPack");
        try {
        	if (verifyWebElementVisibleWebElementBoolean(commonPageLocators.AddressNotFound)) {
        		if (commonPageLocators.AddressNotFound.getText().contains("Address not found!")) {
        			clickElement(commonPageLocators.use_This_Address, "use the address", false);
                    Thread.sleep(10000);
                    waitTillPageLoad();
        		}
        	}
                if ((configProperties.getProperty("server.site").equalsIgnoreCase("Homeserve"))||
                	(configProperties.getProperty("server.site").equalsIgnoreCase("servline-water"))||
                	(configProperties.getProperty("server.site").equalsIgnoreCase("pk-yellow-no-redirect"))||
                	(configProperties.getProperty("server.site").equalsIgnoreCase("homeserve-ca"))){
                	if ((configProperties.getProperty("server.site").equalsIgnoreCase("servline-water"))||
                			(configProperties.getProperty("server.site").equalsIgnoreCase("Homeserve"))){
	                    clickElement(commonPageLocators.hearAboutUs_Option("Other"), "Hear About Us Option", false);
	                    Thread.sleep(2000);
	                    clickElement(commonPageLocators.hearAboutUs_Finish, "Finish", false);
	                    Thread.sleep(2000);
	                    clickElement(commonPageLocators.feedback_Close, "Close", false);
	                    Thread.sleep(2000);
                	}
                    Assert.assertTrue("Order Confirmation present ", verifyWebElementPresent(commonPageLocators.orderConfirmationTitle));
                    WebElement ordertext = driver.findElement(By.xpath("//*[@id=\"site-main\"]/div[2]/div/div/div/div/div[2]/div/span[1]"));
                    scrollToElement(ordertext);
                    BrowserorderNumberTexts = ordertext.getText();
                    String[] parts = BrowserorderNumberTexts.split(" ");
                    if (parts.length >= 3) {
                        String extractedValue = parts[2];
                        System.out.println("Extracted Value: " + extractedValue);
                        BrowserorderNumberTexts = extractedValue;
                    } else {
                        System.out.println("Error: Unable to extract order number.");
                    }
                    testDataMapping.setValue(outputData, "H_RefNo", BrowserorderNumberTexts);
                    testDataMapping.setValue(outputData, "Status", "PASS");
                    log.info("Order Number is : " + BrowserorderNumberTexts+"\n");
                    log.info("Sale completed.\n");
                } else if (verifyWebElementVisibleWebElementBoolean(commonPageLocators.orderConfirmationTitle)) {
                    Assert.assertTrue("Order Confirmation not present ", verifyWebElementPresent(commonPageLocators.orderConfirmationTitle));
                    BrowserorderNumberText = commonPageLocators.orderNumber.getText();
                    System.out.println("BrowserorderNumberText:"+BrowserorderNumberText);
                    String[] parts = BrowserorderNumberText.split("\\.");
                    String extractedValue = parts[1];

                    BrowserorderNumberTexts = extractedValue.trim();
                    testDataMapping.setValue(outputData, "H_RefNo", BrowserorderNumberTexts);
                    testDataMapping.setValue(outputData, "Status", "PASS");
                    log.info("Order Number is: " + BrowserorderNumberTexts+"\n");
                    log.info("Sale completed.\n");

                }else if (verifyWebElementPresent(commonPageLocators.PaymentnotprocessedDialog)) {
                    testDataMapping.setValue(outputData, "Status", "FAIL");
                    testDataMapping.setValue(outputData, "Reason", "Payment Not Processed");
                    log.info("ERROR : ------Payment Not Processed:--------\n");
                    Assert.fail("ERROR : ------Payment Not Processed:--------\n");
                }else if (verifyWebElementVisibleWebElementBoolean(commonPageLocators.feedbackPopUpCloseBtn)) {
                    clickElement(commonPageLocators.feedbackPopUpCloseBtn, "Feedback close btn", false);
                    Assert.assertTrue("Order Confirmation not present ", verifyWebElementPresent(commonPageLocators.orderConfirmationTitle));
                    BrowserorderNumberText = commonPageLocators.orderNumber.getText();
                    String[] parts = BrowserorderNumberText.split("\\.");
                    String extractedValue = parts[1];
                    BrowserorderNumberTexts = extractedValue.trim();
                    testDataMapping.setValue(outputData, "H_RefNo", BrowserorderNumberTexts);
                    testDataMapping.setValue(outputData, "Status", "PASS");
                    log.info("Order Number is: " + BrowserorderNumberTexts+"\n");
                    Assert.assertTrue("Order Confirmation not present ", verifyWebElementPresent(getWebElementByText("Create Account")));
                    log.info("Sale completed.\n");
                }else {
                    testDataMapping.setValue(outputData, "Status", "FAIL");
                    testDataMapping.setValue(outputData, "Reason", "Sale Not Completed OR UI Latency issue");
                    log.info("ERROR : ------Sale Not Completed OR UI Latency issue, check screenshots:--------\n");
                    Assert.fail("ERROR : ------Sale Not Completed OR UI Latency issue, check screenshots:--------");
                }
        	if(sanity.equals("Yes")) {
        		commonFunctions.validateBrokenLinks("Order Confirmation Page");
        	}
        } catch (Exception e) {
            e.printStackTrace();
            testDataMapping.setValue(outputData, "Status", "FAIL");
            testDataMapping.setValue(outputData, "Reason", "Sale Not Completed OR UI Latency issue");
            log.info("ERROR : ------Sale Not Completed OR UI Latency issue, check screenshots:--------\n");
            Assert.fail("ERROR : ------Sale Not Completed OR UI Latency issue, check screenshots:--------");
        }

    }

    public static void getCurrentTime() {
        // Create a SimpleDateFormat instance with the desired format
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

        // Set the time zone to IST (Indian Standard Time)
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));

        // Get the current date and time
        Date currentDate = new Date();

        // Format the current date and time
        currentDateandTime = sdf.format(currentDate);
        System.out.println("Current Date and Time : " + currentDateandTime);

        //return currentDateandTime;
    }


    /**
     * Description: Entering Zip code and click on
     *
     * @throws InterruptedException
     */
    public void enterZipCodeByLocationAndEnterZipCode(WebElement element, String zipCode) throws InterruptedException {
        // Check if element with XPath condition 1 exists
        if (verifyWebElementPresent(element)) {
            clickElement(commonPageLocators.enterZipHeaderLink, "Enter Zip", false);
            typeText(getWebElementByID("wrapout-zipcode"), zipCode, "ZipCode field");
            waitTillPageLoad();
            clickElement(getWebElementByClass("button button-blue zip-button"), "View Plans", false);
            waitTillPageLoad();
            verifyWebElementVisibleWebElementBoolean(getWebElementByText("View Plans On SLWA"));
        }
        // Check if element with XPath condition 2 exists
        else if (verifyWebElementPresent(element)) {
            typeText(getWebElementByID("home-zip-input"), zipCode, "Zipcode");
            clickElement(commonPageLocators.shopNowBannerBtn, "Shop now", false);
            waitTillPageLoad();
        } else {

        }
    }
    
    /*------------------------------------------------------------------------------------------------------
	 * Author		: Chandrakant
	 * Date			: 
	 * Method Name	: select_State
	 * Description	: To select the state for aepindianamichigan URL
	 ---------------------------------------------------------------------------------------------------------*/
    public void select_State() throws Exception {

    	String State = testDataMapping.getValue(inputDataMapping,"State");
        selectFromDropdownByVisibletext(commonPageLocators.select_States, State);
        sleep(2);
        clickElement(commonPageLocators.state_Ok_Button, "OK", false);
        waitTillPageLoad();
    }


}
