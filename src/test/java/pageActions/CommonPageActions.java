package pageActions;

import static automationFramework.Constant.*;
import static automationFramework.DataReader.geturl;
import static automationFramework.DynamicWebElements.*;
import static automationFramework.PageActions.*;
import static automationFramework.PageActions.log;
import static automationFramework.StartDriver.driver;
import static automationFramework.Waits.*;
import static pageActions.HSLandingPageActions.getCurrentTime;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DataMapping.readWriteExcel;
import DataMapping.testDataMapping;
import automationFramework.CommonFunctions;
import automationFramework.PageActions;
import automationFramework.Waits;
import pageLocators.CommonPageLocators;
import pageLocators.OttawaPageLocators;
import static DataMapping.testDataMapping.configProperties;

public class CommonPageActions {
    CommonPageLocators commonPageLocators = new CommonPageLocators();
	OttawaPageLocators ottawaPageLocators = new OttawaPageLocators();
    PageActions pageActions = new PageActions();
    public static Logger log = Logger.getLogger(PageActions.class);
  
    public CommonPageActions() {
    }

    /*------------------------------------------------------------------------------------------------------
	 * Author		: Chandrakant
	 * Date			: 
	 * Method Name	: navigateToApplication
	 * Description	: To get the URLa nd navigate to the application
	 ---------------------------------------------------------------------------------------------------------*/
    public void navigateToApplication()
            throws InterruptedException, IOException, ParseException {
        driver.get(geturl());
        waitTillPageLoad();
        //if (configProperties.getProperty("server.site").equalsIgnoreCase("Homeserve"))
        //	signupPopupClose();
		closeCookiesBottom();
    }

    /*------------------------------------------------------------------------------------------------------
	 * Author		: Chandrakant
	 * Date			: 
	 * Method Name	: handlePopups
	 * Description	: To handle any pop-ups
	 ---------------------------------------------------------------------------------------------------------*/
    public void handlePopups() throws Exception {
        System.out.println("handleing Popups if any");   // //a[contains(text(),'Do Not Have Code')]
        waitTillPageLoad();
        if (configProperties.getProperty("server.site").equalsIgnoreCase("sanjose") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("wvwachoice") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("lasanitation")||
                configProperties.getProperty("server.site").equalsIgnoreCase("buffalowaternipcnew")||
                configProperties.getProperty("server.site").equalsIgnoreCase("Slwofa")||
                configProperties.getProperty("server.site").equalsIgnoreCase("ottawa")){
        	
        }else{
            WebElement entercodepopupClose = getWebElementByContainsText("Do Not Have Code");
            if (waitForElementavailblilityboolean(entercodepopupClose,"Enter Code popup",30)) {
                clickElement(entercodepopupClose, "Enter Code popup",false);
                waitTillPageLoad();
            }
        }


    }

    /*------------------------------------------------------------------------------------------------------
	 * Author		: Chandrakant
	 * Date			: 
	 * Method Name	: enterZipCodeAndSubmit
	 * Description	: To enter the zip code in landing page and click on view plans
	 ---------------------------------------------------------------------------------------------------------*/
    public void enterZipCodeAndSubmit() throws InterruptedException, IOException {
    	zipCode = testDataMapping.getValue(inputDataMapping,"Zipcode");
    	zipLocation = testDataMapping.getValue(inputDataMapping,"ZipLocation");
    	
    	testDataMapping.setValue(outputData, "zipCode", zipCode);
    	switch(zipLocation) {
    		case "header":
    			clickElement(commonPageLocators.enterZipHeaderLink, "Enter Zip", false);
                waitTillPageLoad();
                typeText(commonPageLocators.txtZipCodeHearder, zipCode, "ZipCode field");
                log.info("Enter the zipcode: "+zipCode+"\n");
                clickElement(commonPageLocators.header_viewPlans, "View Plans", false);
                waitTillPageLoad();
                clickElement(commonPageLocators.viewAvailablePlans, "View available plans", false);
                break;
    		case "LandingPage":
                clickElement(commonPageLocators.txtZipCode, "Enter Your ZIP Code", false);
                typeText(commonPageLocators.txtZipCode, zipCode, "Enter Your ZIP Code");
                log.info("Enter the zipcode: "+zipCode+"\n");
                switch(configProperties.getProperty("server.site")) {
	                case "slwofa":
	                	clickElement(commonPageLocators.buttonShopNow, "Shop Now", false);
	                	break;
	                case "slwofc":
	                	clickElement(commonPageLocators.buttonGetAQuote, "Get a quote", false);
	                	break;
	                case "Homeserve":
	                	clickElement(commonPageLocators.buttonGO, "GO", false);
	                	  waitTillPageLoad();
	                	if (verifyWebElementVisibleWebElementBoolean(commonPageLocators.view_Plan))
	                		clickElement(commonPageLocators.view_Plan, "View Plans", false);
	                	break;
                }
                waitTillPageLoad();
                break;
            default:
            	throw new IllegalArgumentException("Invalid Enter ZipLocation: " + zipLocation);
    	}
    }
    
    /*------------------------------------------------------------------------------------------------------
	 * Author		: Chandrakant
	 * Date			: 
	 * Method Name	: enterUserDetails
	 * Description	: To enter the user contact details in checkout page
	 ---------------------------------------------------------------------------------------------------------*/

    public void enterUserDetails() throws InterruptedException, IOException {
    	
        String generateRandomAddress = RandomStringUtils.randomNumeric(4);

        Email = configProperties.getProperty("gmusername") + "+" + RandomStringUtils.randomNumeric(3) + "@gmail.com";
        PhoneNumber = testDataMapping.getValue(inputDataMapping, "PhoneNumber");
        Address = generateRandomAddress + " " + testDataMapping.getValue(inputDataMapping, "Address");
        ApartmentNumber = RandomStringUtils.randomNumeric(4);
        firstName = testDataMapping.getValue(inputDataMapping, "FirstName")+ CommonFunctions.randomString(5);
        lastName = testDataMapping.getValue(inputDataMapping, "LastName") + CommonFunctions.randomString(5);
        city = testDataMapping.getValue(inputDataMapping, "City");
        zipCode = testDataMapping.getValue(inputDataMapping, "Zipcode");
        testDataMapping.setValue(outputData, "firstName", firstName);
        testDataMapping.setValue(outputData, "lastName", lastName);
        testDataMapping.setValue(outputData, "Email", Email);
        testDataMapping.setValue(outputData, "zipCode", zipCode);
        waitTillPageLoad();

        switch(configProperties.getProperty("server.site")) {
        	case "Homeserve":
        		typeText(commonPageLocators.firstName, firstName, "First name");
        		typeText(commonPageLocators.addressLine, Address, "Address");
        		break;
        	default:
        		typeText(getWebElementByID("first-name"), firstName, "First name");
        		typeText(getWebElementByID("address-line-1"), Address, "Address");
        		break;
        }
        typeText(getWebElementByID("email"), Email, "Email");
        typeText(getWebElementByID("email-confirm"), Email, "Confirm Email");
        typeText(getWebElementByID("last-name"), lastName, "Last name");
        typeText(getWebElementByID("address-line-2"), ApartmentNumber, "Address Second");
        typeText(getWebElementByID("home-phone"), PhoneNumber, "Home Phone");
            
        if (configProperties.getProperty("server.site").equalsIgnoreCase("ottawa") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("aepindianamichigan") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("buffalowaternipcnew") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("firstenergy-fundle") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("kypower-tabs") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("lasanitation") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("sanjose") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("HomeServe-CE") ||
                configProperties.getProperty("server.site").equalsIgnoreCase("wvwachoice")) {
            typeText(getWebElementByID("city"), city, "City");
            typeText(getWebElementByID("zip-code"), zipCode, "Zip code");
            log.info("Enter the zipcode: "+zipCode+"\n");
        }

        try {
            WebElement State = driver.findElement(By.xpath("//*[@id=\"state\"]"));
            String state = State.getAttribute("value");
            if (configProperties.getProperty("server.site").equalsIgnoreCase("aepindianamichigan")
                    && state.equalsIgnoreCase("IN")) {
            	PhoneNumber = "33131" + RandomStringUtils.randomNumeric(3) + "340";
                typeText(getWebElementByID("home-phone"), PhoneNumber, "Home phone");
            }
            Thread.sleep(2000);
        } catch (Exception e) {

        }
    }
 
    
    /*------------------------------------------------------------------------------------------------------
	* Author		: Chandrakant
	* Date			: 
	* Method Name	: selectProductProceedToCheckout
	* Description	: To select the product and proceed to checkout
	---------------------------------------------------------------------------------------------------------*/
    
	public void selectProductProceedToCheckout(String productCount) throws Exception {
		int i = 0;
		scrollToElement(commonPageLocators.buttonAddToCart);
		clickElement(commonPageLocators.buttonAddToCart, "Add to cart",false);
		for (; i < Integer.parseInt(productCount); i++) {
			scrollToElement(commonPageLocators.buttonAddToCart);
			clickElement(commonPageLocators.buttonAddToCart, "Add to cart",false);
			Thread.sleep(2000);
		}
		String messageText = driver.getTitle();

		if (messageText.contains("Checkout Empty Cart")) {
			System.out.println("Cart is empty.");
			throw new Exception("Checkout Cart is Empty");
		} else {
			System.out.println("Item added to cart.");
			waitForElement(commonPageLocators.buttonProceedToCheckout, "Proceed to checkout",30);
			clickElement(commonPageLocators.buttonProceedToCheckout, "Proceed to checkout",false);
		}
		if (verifyWebElementVisibleWebElementBoolean(commonPageLocators.linkProceedToCheckout))
			clickElement(commonPageLocators.linkProceedToCheckout, "Proceed To Checkout", false);

	}
	
	/*------------------------------------------------------------------------------------------------------
	* Author		: Chandrakant
	* Date			: 
	* Method Name	: addProductToCartAndProceedToCheckout
	* Description	: To select the product, add to cart and proceed to checkout
	---------------------------------------------------------------------------------------------------------*/
	
	public void addProductToCartAndProceedToCheckout() throws InterruptedException, IOException {
        int i = 0;
        String product = "";
        WebElement addCart = null;
        WebElement Checkout = null;
        zipLocation = testDataMapping.getValue(inputDataMapping, "ZipLocation");
        switch(zipLocation) {
        	case "header":
        		addCart = commonPageLocators.buttonAddToCart;
        		Checkout = commonPageLocators.linkProceedToCheckout;
        		break;
        	case "LandingPage":
        	case "CheckoutPage":
        		if (configProperties.getProperty("server.site").equalsIgnoreCase("kypower-tabs")){
        			clickElement(commonPageLocators.inputTabElectrical, " Electrical Tab",false);
        		}
        		if (!configProperties.getProperty("server.site").equalsIgnoreCase("ottawa")){
	        		addCart = commonPageLocators.spanAddToCart;
	        		Checkout = commonPageLocators.buttonProceedToCheckout;
        		}else {
	        		scrollToElement(ottawaPageLocators.SelectAPlanOttawa);
	        		clickElement(ottawaPageLocators.SelectAPlanOttawa, "Select A Plan",false);
	        		addCart = commonPageLocators.addToCart;
	        		Checkout = commonPageLocators.proceedToCheckout;
        		}
        		break;
        	default:
        		 Assert.fail("Please mention valid Zip location");
        		break;
        }
        if (addCart.isEnabled()) {
                scrollToElement(addCart);
                product = addCart.getText();
                clickElement(addCart, "Add to cart", false);
                waitTillPageLoad();
                String CartPage = driver.getTitle();

                if (CartPage.equalsIgnoreCase("Checkout Empty Cart")) {
                    Assert.fail("Your Cart is Empty");
                } else {
                    log.info(product+ "product is added to Cart successfully\n");
                    verifyWebElementVisibleWebElementBoolean(Checkout);
                    clickElement(Checkout, "Proceed To Checkout", false);

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
                            configProperties.getProperty("server.site").equalsIgnoreCase("wvwachoice")||
                            configProperties.getProperty("server.site").equalsIgnoreCase("ottawa")
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
	
	/*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari M
	* Date			: 
	* Method Name	: chooseAndMakePayementType
	* Description	: To select the payment method , enter payment details and proceed to checkout
	---------------------------------------------------------------------------------------------------------*/
	
	public void chooseAndMakePayementType()throws Exception {
		paymentType = testDataMapping.getValue(inputDataMapping,"PaymentType");
		testDataMapping.setValue(outputData, "paymentType", paymentType);

		switch(paymentType) {
			case "Checking Account":
				enterCheckingAccountDetails();
				break;
			case "Credit/Debit Card":
				enterCreditDebitCardDetails();
				break;
			case "Account Number":
				enterAccountNumberDetails();
				break;
			default:
				System.err.println("PaymentType is provided incorrectly");
				break;
		}

	}

	/*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari M
	* Date			: 
	* Method Name	: closeCookiesBottom
	* Description	: To close the cookie pop-up in bottom
	---------------------------------------------------------------------------------------------------------*/
    public void closeCookiesBottom() throws InterruptedException {
    	if(Waits.verifyWebElementVisibleWebElementBoolean(commonPageLocators.cookiesClose)) {
    		clickElement(commonPageLocators.cookiesClose, "Close cookies", false);
    	}
    }
    
	/*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari M
	* Date			: 
	* Method Name	: switchToIFrame
	* Description	: To switch to IFrame window
	---------------------------------------------------------------------------------------------------------*/
    
    public void switchToIFrame(int index) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(*//iframe)["+index+"]")));
		driver.switchTo().frame(iframe);
		sleep(5);
    }
    
	/*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari M
	* Date			: 
	* Method Name	: enterCheckingAccountDetails
	* Description	: To enter the payment details using checking account and proceed to checkout
	---------------------------------------------------------------------------------------------------------*/
    
    public void enterCheckingAccountDetails() throws InterruptedException, IOException {
    	if(configProperties.getProperty("server.site").equalsIgnoreCase("Homeserve")){
			WebElement Paymenttype = driver.findElement(By.className("select2-selection__rendered"));
			Paymenttype.click();
			sleep(2);
			clickElement(commonPageLocators.checkingAccountOption, "Checking Account",false);
			waitTillPageLoad();
		}else {
			clickElement(getWebElementByText("Checking Account"), "Checking Account",false);
		}
    	switch(configProperties.getProperty("server.site")) {
		case "Homeserve":
			typeText(getWebElementByID("checking-full-name"), testDataMapping.getValue(inputDataMapping,"FullName"), "Full name");
			typeText(getWebElementByID("checking-routing-number"), testDataMapping.getValue(inputDataMapping,"RoutingNumber"), "Routing number");
			typeText(getWebElementByID("checking-account-number"), "6011000000000000", "Account number");
			typeText(getWebElementByID("checking-account-number-confirm"), "6011000000000000", "Checking account number");
			scrollToBottomOfPage();
			sleep(2);
			WebElement checkout = driver.findElement(By.xpath("//*[@id=\"checking-form\"]/div[3]/button"));
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].click();", checkout);
			break;
		default:
			typeText(getWebElementByID("full-name"), testDataMapping.getValue(inputDataMapping,"FullName"), "Full name");
			typeText(getWebElementByID("routing-number"), testDataMapping.getValue(inputDataMapping,"RoutingNumber"), "Routing number");
			typeText(getWebElementByID("checking-account"), "6011000000000000", "Account number");
			typeText(getWebElementByID("verify-checking-account"), "6011000000000000", "Checking account number");
			clickElement(commonPageLocators.completeSecureCheckout, "completeSecureCheckout",false);
			break;
    	}
    	waitTillPageLoad();
    }
    
	/*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari M
	* Date			: 
	* Method Name	: enterCreditDebitCardDetails
	* Description	: To enter the payment details using credit/ Debit card and proceed to checkout
	---------------------------------------------------------------------------------------------------------*/
    
    public void enterCreditDebitCardDetails() throws InterruptedException, IOException {
    	String paperless = testDataMapping.getValue(inputDataMapping, "Paperless");
    	if(paperless.equals("No")) {
    		scrollToElement(commonPageLocators.select_Go_PaperLess);
			clickElement(commonPageLocators.select_Go_PaperLess, "select_Go_PaperLess",false);
    	}
    	
    	if(!configProperties.getProperty("server.site").equals("Homeserve")) {
    		clickElement(commonPageLocators.choosePaymentTYpe, "Choose Payment Type",false);
    	}
    	
    	switch(configProperties.getProperty("server.site")) {
			case "slwofc":
			case "ottawa":
				//if (configProperties.getProperty("server.site").equalsIgnoreCase("ottawa"))
				switchToIFrame(1);
				//else
				//	switchToIFrame(2);
				waitForElement(commonPageLocators.card_Number,"card Number",10);
				commonPageLocators.card_Number.sendKeys(configProperties.getProperty("card.Number"));
				commonPageLocators.month_Year.sendKeys("0527");
				clickElement(commonPageLocators.add_Card, "add card",false);
				sleep(2);
				driver.switchTo().defaultContent();
				clickElement(commonPageLocators.completeSecureCheckout, "completeSecureCheckout",false);
				break;
			case "Homeserve":
				WebElement Paymenttype = driver.findElement(By.className("select2-selection__rendered"));
				Paymenttype.click();
				sleep(2);
				clickElement(commonPageLocators.creditCardOption, "creditCardOption",false);
				switchToIFrame(2);
				//typeText(commonPageLocators.inputCardNumber, configProperties.getProperty("card.Number"), "card number");
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].click();", commonPageLocators.inputCardNumber);
				commonPageLocators.inputCardNumber.sendKeys(configProperties.getProperty("card.Number"));
				driver.switchTo().defaultContent();
				typeText(getWebElementByID("micro-exp-date"), testDataMapping.getValue(inputDataMapping, "ExpiryDate"), "Expiratioin Date");
				clickElement(commonPageLocators.completeSecureCheckout, "Checkout",false);
				break;
			default:
				if (configProperties.getProperty("server.site").equalsIgnoreCase("lasanitation")||
						configProperties.getProperty("server.site").equalsIgnoreCase("slwofa"))
					switchToIFrame(1);
				else
					switchToIFrame(2);
				clickElement(commonPageLocators.cardType, "cardtype",false);
				typeText(commonPageLocators.card_Number, configProperties.getProperty("card.Number"), "card number");
				clickElement(commonPageLocators.cardExpiryMonth, "cardExpiryMonth",false);
				selectFromDropdownByValue(commonPageLocators.cardExpiryMonth, "05");
				clickElement(commonPageLocators.cardExpiryYear, "cardExpiryYear",false);
				selectFromDropdownByValue(commonPageLocators.cardExpiryYear, "2040");
				clickElement(commonPageLocators.nextButton, "Next Button",false);
				sleep(5);
				driver.switchTo().defaultContent();
				clickElement(getWebElementByClass("button js-post-message"), "Complete Secure Checkout",false);
				break;
    	}
    	getCurrentTime();
    	waitTillPageLoad();
    }
    
    /*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari M
	* Date			: 
	* Method Name	: enterAccountDetailsAndCompleteCheckout
	* Description	: To enter the payment details using account number and proceed to checkout
	---------------------------------------------------------------------------------------------------------*/
    public void enterAccountNumberDetails() throws Exception {

        typeText(commonPageLocators.enter_Account_Number, testDataMapping.getValue(inputDataMapping, "AccountNumber"), "account number");
        clickElement(commonPageLocators.completeSecureCheckout, "complete secure checkout", false);
        waitTillPageLoad();
    }
    
    /*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari M
	* Date			: 
	* Method Name	: selectBillingFrequency
	* Description	: To select the billing frequency
	---------------------------------------------------------------------------------------------------------*/    
	public void selectBillingFrequency() throws InterruptedException, IOException {
		billFrequency = testDataMapping.getValue(inputDataMapping,"BillingFrequency");
		testDataMapping.setValue(outputData, "billingFrequency", billFrequency);
		if(configProperties.getProperty("server.site").equalsIgnoreCase("Homeserve")){
			clickElement(getWebElementByClass("billing-frequency__dropdown"),"Bill Frequency",false);
			WebElement FreqDropdown = getWebElementByClass("billing-frequency__dropdown");
			if(billFrequency.equalsIgnoreCase("Monthly")) {
				selectFromDropdownByValue(FreqDropdown, "12");
			}
			if(billFrequency.equalsIgnoreCase("Quarterly")) {
				selectFromDropdownByValue(FreqDropdown, "4");
			}
			if(billFrequency.equalsIgnoreCase("Annually")) {
				selectFromDropdownByValue(FreqDropdown, "1");
			}
			log.info("Billing Frequency is selected as '" + billFrequency + "'\n");
		}else {
			clickElement(getWebElementByText(billFrequency), billFrequency,false);
			System.out.println(billFrequency+" checkbox selected");
			log.info("Billing Frequency is selected as '" + billFrequency + "'\n");
		}
	}

    /*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari M
	* Date			: 
	* Method Name	: signupPopupClose
	* Description	: To close the lightbox pop-up
	---------------------------------------------------------------------------------------------------------*/ 
    public void signupPopupClose() throws InterruptedException {
    	System.out.println("Closing SignUp popup page");
    	for (int i = 0; i<5; i++) {
    		if(waitForElementavailblilityboolean(commonPageLocators.signUpClose,"Signup Popup",30)){
    			clickElement(commonPageLocators.signUpClose, "Signup Popup", false);
    			waitTillPageLoad();
    			System.out.println("SignUp Popup Page closed");
    			break;
    		}
    	}
    }
    
    /*------------------------------------------------------------------------------------------------------
	* Author		: Maheswari M
	* Date			: 
	* Method Name	: signupPopupClose
	* Description	: To close the lightbox pop-up
	---------------------------------------------------------------------------------------------------------*/ 
	public void selectThePlanAndAddToCartAndProceedToCheckout() throws InterruptedException {
		waitTillPageLoad();
		scrollToElement(ottawaPageLocators.SelectAPlanOttawa);
		clickElement(ottawaPageLocators.SelectAPlanOttawa, "Select A Plan",false);
		clickElement(commonPageLocators.addToCart, "Add to cart",false);
		clickElement(commonPageLocators.proceedToCheckout, "Proceed to checkout",false);
		clickElement(commonPageLocators.proceedToCheckout, "Proceed to checkout",false);
		waitTillPageLoad();

	}
}
