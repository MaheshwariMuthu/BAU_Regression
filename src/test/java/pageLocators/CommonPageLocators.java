package pageLocators;

import static automationFramework.StartDriver.driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPageLocators {


    public CommonPageLocators() {

        PageFactory.initElements(driver, this);
    }
    
    // Enter zip-code section in HomePage
    @FindBy(xpath = "(//button[@class='button zip-button js-show-ps'])[2]")
    public WebElement buttonGO;
    
    @FindBy(xpath = "//button[@class='button zip-button js-show-ps red-theme']/span[contains(text(),'Shop Now')]")
    public WebElement buttonShopNow;
    
    @FindBy(xpath = "//button[@class='button zip-button js-show-ps']/span[contains(text(),'Get a quote')]")
    public WebElement buttonGetAQuote;
    
    @FindBy(xpath = "//input[@id='zip']")
    public WebElement inputZipcode;
    
    @FindBy(xpath = "//input[@id='tech-id']")
    public WebElement inputTechID;
    
    @FindBy(xpath = "//button[text()='Get Started']")
    public WebElement buttonGetStarted;

    // Header enter zip-code    
    @FindBy(xpath = "//div[@class='field zip-bar']/input[@name='zipcode']/following::button[@type='submit']//span[text()='View Plans']")
    public WebElement header_viewPlans;
    
    // Add-on Page    
    @FindBy(xpath = "//a[text()='Checkout']")
    public WebElement addOn_linkCheckout;
    
    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    public WebElement linkAddOnProceedToCheckout;
    
    // PLP Locators - Add To Cart
    @FindBy(xpath = "(//button[contains(text(),'Add To Cart')])[1]")
    public WebElement buttonAddToCart;
    
    @FindBy(xpath = "(//span[contains(text(),'Add To Cart')])[1]")
    public WebElement spanAddToCart;
    
    @FindBy(xpath = "(//span[contains(text(),'Select Plan')])[1]")
    public WebElement spanSelectPlan;
    
    @FindBy(xpath = "(//a[contains(text(),'Add To Cart')])[1]")
    public WebElement linkAddToCart;
    
    /* Selected  Plans X-path */
	@FindBy(xpath = "//*[contains(text(),'Selected Plans')]/following::input[@type='checkbox'][1]/following-sibling::label/span[1]")
	public WebElement SelectAPlan;

	@FindBy(xpath = "//*[contains(text(),'Plans sélectionnés')]/following::input[@type='checkbox'][1]/following-sibling::label/span[1]")
	public WebElement SelectAPlanFrench;
	
	@FindBy(xpath = "(//button[contains(text(),'See available plans')])[1]")
	public WebElement buttonSeeAvailablePlans;

	
    // Proceed To Checkout
    @FindBy(xpath = "(//span[contains(text(),'Proceed To Checkout')])[1]")
    public WebElement buttonProceedToCheckout;
    
    @FindBy(xpath = "(//a[contains(text(),'Proceed To Checkout')])[1]")
    public WebElement linkProceedToCheckout;
    
    @FindBy(xpath = "//div[contains(text(),'Proceed To Checkout')]")
    public WebElement divProceedToCheckout;
  	
    @FindBy(xpath = "//div[@class='survey__form']/label[contains(.,'Other')]")
    public WebElement hearAboutUs_Option1;
    
    @FindBy(xpath = "//a[text()='Finish']")
    public WebElement hearAboutUs_Finish;
    
    @FindBy(xpath = "//button[text()='Close']")
    public WebElement feedback_Close;
    
    // Payment Details
    @FindBy(xpath = "//input[@id='number']")
    public WebElement inputCardNumber;
    
    @FindBy(xpath = "//input[@id='CardNumber']")
    public WebElement inputCreditCardNumber;
    
    @FindBy(xpath = "//input[@id='Expiry']")
    public WebElement inputExpiry;
    
    // Category Tab    
    @FindBy(xpath = "//input[@id='electrical']/parent::div")
    public WebElement inputTabElectrical;
    
    @FindBy(xpath = "//div[@class='component generic-error-lightbox light-box js-generic-error-lb']")
    public WebElement PaymentnotprocessedDialog;
    
    // Contact details    
    @FindBy(xpath = "//*[@id=\"city\"]")
    public WebElement city_Details;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div[2]/a")
    public WebElement use_This_Address;
    
    @FindBy(xpath = "//*[@id=\"code-input\"]")
    public WebElement entercodepopup;
    
    @FindBy(xpath = "//input[@id='move-in-date']")
    public WebElement moveInDate;

    @FindBy(xpath = "//*[@id='mtw-code-form']/fieldset/div/a")
    public WebElement entercodepopupClose;

    @FindBy(xpath = "//*[@id=\"onetrust-close-btn-container\"]/button")
    public WebElement btnCookiesClose;

    @FindBy(xpath = "//*[@id=\"installmentsPerYear\"]")
    public WebElement Select_Bill_Frequency;

    @FindBy(xpath = "//*[@id=\"payment_details_lower\"]/input")
    public WebElement Add_To_Cart_Button;
    
    @FindBy(xpath = "//*[@id=\"card_expiry_year\"]")
    public WebElement cardExpiryYear;
    
    @FindBy(xpath = "//*[@id=\"payment_details_lower\"]/input")
    public WebElement nextButton;
    
    @FindBy(xpath = "//*[@class='button js-post-message']")
    public WebElement Complete_secure_CheckOut;

    @FindBy(xpath = "//*[@id=\"States\"]")
    public WebElement select_States;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div[1]/form/fieldset/div[2]/button")
    public WebElement state_Ok_Button;
    
    @FindBy(xpath = "//*[@id=\"Expiry\"]")
    public WebElement month_Year;

    @FindBy(xpath = "//*[@id=\"ContentDiv\"]/input[2]")
    public WebElement add_Card;
    
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/main/div/h2")
    public WebElement other_Customers_Purchased;

    @FindBy(xpath = "/html/body/div")
    public WebElement success_Message;
    
    @FindBy(xpath = "//*[@id=\"account-number\"]")
    public WebElement enter_Account_Number;

    @FindBy(xpath = "//div[2]/fieldset/div/div[2]/div/label")
    public WebElement select_Go_PaperLess;
    
    // Credit card number X-path
    @FindBy(xpath = "(//span[text()='Shop Now'])[1]")
    public WebElement shopNowBannerBtn;
    
    // Close button for Feedback pop X-path
    @FindBy(xpath = "//button[text()='Close']")
    public WebElement feedbackPopUpCloseBtn;

    // Title X-path
    @FindBy(xpath = "//h1[contains(text(),'Order')]")
    public WebElement orderConfirmationTitle;
    
    // Sign-Up Close BUtton
    @FindBy(xpath = "//button[contains(@class, \"email-capture-popup__close-button\")]")
    public WebElement signUpClose;
    
    @FindBy(xpath = "//button[contains(text(),\"View Plan\")]")
    public WebElement buttonViewPlans;
    
    @FindBy(xpath = "//button[contains(text(),\"VIEW PLANS\")]")
    public WebElement buttonViewPlan;
    
    @FindBy(xpath = "//div[@class=\"hero-zipin zipin\"]/*//span[contains(text(),\"View Plan\")]")
    public WebElement spanViewPlans;
    
    @FindBy(xpath = "//button[text()='Complete Secure Checkout']")
    public WebElement buttonCompleteCheckout;
    
    // Order confirmation Page
  	public WebElement hearAboutUs_Option(String option){
  		WebElement linkFooter = driver.findElement(By.xpath("//div[@class='survey__form']/label[contains(.,'" + option +"')]"));	
  		return linkFooter;
  	}
  	
  	public WebElement radioCardType(String cardType){
		 WebElement cardtype = driver.findElement(By.xpath("//label[text()='"+cardType+"']/parent::div/input"));	
		 return cardtype;
	}
  	
    @FindAll({
            @FindBy(css = "a[class='link js-header-enter-zip'] > span"),
            @FindBy(css = "div[class='component header-popup'] > div > a >span")
    })public WebElement enterZipHeaderLink;

    @FindAll({
            @FindBy(css = "input[placeholder='Enter Your ZIP Code']"),
            @FindBy(css = "div[class='wrapper-out'] * input[class='zip-input js-partner-zip zip-can zip-value']")
    })public WebElement txtZipCodeHearder;

    @FindAll({
    		@FindBy(xpath = "//input[@id='home-zip-input'][1]"),
            @FindBy(xpath = "(//input[@name='zipcode'])[3]"),
            @FindBy(xpath = "/html/body/main/section/div[2]/div/div/div/div[2]/div/form/fieldset/div/div/div[2]/div/input[1]"),
            @FindBy(xpath = "//*[@id=\"zip-code\"]"),
            @FindBy(xpath = "//input[@class=\"zip-value zip-val \"]"),
            @FindBy(xpath = "(//button[@type='submit'])[3]"),
    		@FindBy(xpath = "(//input[@class=\"zippin__field override-zip\"])[1]"),
    })public WebElement txtZipCode;

    @FindAll({
    	 	@FindBy(xpath = "//*[@class='button zip-button js-show-ps']/span[contains(text(),'GO')]"),
    	 	@FindBy(xpath = "//div[@class='field zip-bar']/input[@name='zipcode']/following::button[@type='submit']"),
    })public WebElement view_Plan;

    @FindAll({
            @FindBy(xpath = "//html/body/div[1]/div/ul/li[2]/a"),
            @FindBy(xpath = "(//a[@class='button icon js-partner-link'])[1]"),
            @FindBy(xpath = "(//a[@class='button icon js-partner-link'])[2]"),
            @FindBy(xpath = "//li[@class='provider-selection__provider']/descendant::a")
    })public WebElement viewAvailablePlans;

    @FindAll({
            @FindBy(xpath = "//*[text()='Address not found!']"),
            @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/h2"),
    })public WebElement AddressNotFound;
    
    @FindAll({
            @FindBy(xpath = "//button[@id='btn-add-to-cart-a0q6g000001JP7HAAW']"),
            @FindBy(xpath = "/html/body/main/div[4]/div/div/div/div[2]/div/div[3]/div[3]/a/span[1]"),
            @FindBy(xpath = "/html/body/main/div[2]/div/div/div/div[1]/div/div[3]/div[2]/a/span[1]"),
            @FindBy(xpath = "//button[text()='Add To Cart']"),
            @FindBy(xpath = "//*[@class='button js-add-to-cart']"),
            @FindBy(xpath = "(//span[text()='Add To Cart'])[1]"),
            @FindBy(xpath = "(//span[text()='Ajouter au panier'])[1]"),
    })public WebElement addToCart;

    @FindAll({
            @FindBy(xpath = "/html/body/div[2]/div/div[1]/div"),
            @FindBy(xpath = "/html/body/div[2]/div/div[1]")
    })public WebElement Payment_not_Processed_Alert;

    @FindAll({
            @FindBy(xpath = "/html/body/main/div[3]/div/div/div[2]/div/div/div/form/div[7]/a/div"),
            @FindBy(xpath = "/html/body/div[1]/div/div[1]/aside/div[2]/a"),
    })public WebElement Proceed_To_Cart_Button;

    @FindAll({
            @FindBy(xpath = "//*[@class='checkmark']"),
    })public List<WebElement> select_Plan;

    @FindAll({
            @FindBy(xpath = "//*[@id=\"firstName\"]"),
            @FindBy(xpath = "//*[@id=\"first-name\"]")
    })public WebElement firstName;

    @FindAll({
            @FindBy(xpath = "//*[@id=\"AddressLine1\"]"),
            @FindBy(xpath = "//*[@id=\"address-line-1\"]")
    })public WebElement addressLine;

    @FindAll({
            @FindBy(xpath = "//*[@id=\"address-line-2\"]"),
            @FindBy(xpath = "//*[@id=\"AddressLine1\"]")
    })public WebElement apartmentDetails;

    @FindAll({
            @FindBy(xpath = "//*[@id=\"card_expiry_month\"]"),
            @FindBy(xpath = "//*[@id='Expiry']"),
    })public WebElement cardExpiryMonth;

    @FindAll({
            @FindBy(xpath = "//div[3]/div[2]/div[2]/p/button"),
            @FindBy(xpath = "//*[@class='c491-add-new-payment__btn']"),
            @FindBy(xpath = "//*[@id=\"select2-checkout-form__method-container\"]"),
    })public WebElement choosePaymentTYpe;

    @FindAll({
            @FindBy(xpath = "//fieldset/div[4]/div/div[1]/fieldset/div/div[1]/input"),
            @FindBy(xpath = "//*[@id=\"card_type_001\"]"),
            @FindBy(xpath = "//*[text()='Credit or Debit Card']"),
    })public WebElement cardType;
    
    @FindAll({
    		@FindBy(xpath = "//input[@id='CardNumber']"),
            @FindBy(xpath = "/html/body/form/input[2]"),
            @FindBy(xpath = "//*[@id=\"CardNumber\"]"),
            @FindBy(xpath = "//*[@id=\"card_number\"]"),
            @FindBy(xpath = "//input[@id='number']"),
            @FindBy(xpath = "//*[@id=\"number\"]"),
    })public WebElement card_Number;

    // Proceed to checkout
    @FindAll({
            @FindBy(xpath = "//a[@class='btn btn--red product-tile__cta-button']"),
            @FindBy(xpath = "/html/body/main/div[2]/div/div/div/div[1]/div/div[3]/div[2]/a/span[2]"),
            @FindBy(xpath = "/html/body/main/div[4]/div/div/div/div[2]/div/div[3]/div[3]/a/span[2]"),
            @FindBy(xpath = "/html/body/main/div[4]/div/div/div/div[1]/div/div[3]/div[3]/a/span[2]"),
            @FindBy(xpath = "/html/body/div[2]/div/div[1]/aside/div[2]/a"),
            @FindBy(xpath = "/html/body/main/div[3]/div[1]/div[1]/div/div[2]/div[2]/a/span[2]"),
            @FindBy(xpath = "*//aside/div[2]/a"),
            @FindBy(xpath = "//div[3]/div[2]/a/span[2]"),
            @FindBy(xpath = "//*[@class='btn btn--red product-tile__cta-button']"),
            @FindBy(xpath = "//div[@class='cart__submit-container']/descendant::a[contains(text(),'Proceed To Checkout')]"),
            @FindBy(xpath = "/html/body/div[1]/div/div[1]/aside/div[2]/a"),
            @FindBy(xpath = "/html/body/main/div[3]/div/div/div[2]/div/div/div/form/div[9]/a/div"),
    })public WebElement proceedToCheckout;

    // Credit Card option X-path
    @FindAll({
            @FindBy(xpath = "//li/descendant::*[contains(text(),'Credit or Debit Card')]"),
            @FindBy(css = "#select2-checkout-form__method-result-oqsm-Credit\\ or\\ Debit\\ Card"),
    })public WebElement creditCardOption;
    
    @FindAll({
            @FindBy(xpath = "//li/descendant::*[contains(text(),'Checking Account')]"),
            @FindBy(xpath = "//span[@class='selection']"),
    })public WebElement checkingAccountOption;

    // Credit Card option X-path
    @FindAll({
            @FindBy(xpath = "/html/body/main/div/div/div/div[3]/form/div/div/div[2]/div[3]/section/div/div[2]/div/button"),
            @FindBy(xpath = "/html/body/main/div/div/div/div[3]/form/div/div/div[2]/div[3]/div[2]/div[2]/div[2]/button"),
            @FindBy(xpath = "(//div[@class='checkout-form__container']//button[text()='Complete Secure Checkout'])[1]"),
            @FindBy(xpath = "(/html/body/main/div/div/div/div[3]/form/div/div/div[2]/div[3]/div[2]/div[2]/div[2]/button"),
            @FindBy(xpath = "//*[@id=\"checking-form\"]/div[3]/button"),
    })public WebElement completeSecureCheckout;

    // Credit card number X-path
    @FindAll({
            @FindBy(xpath = "(//iframe)[1]"),
            @FindBy(xpath = "(//iframe)[2]"),
            @FindBy(xpath = "//*[@id=\"micro-number-container\"]/iframe"),
    })public WebElement creditCardNumberFrame;
    
    // Order number X-path
    @FindAll({
            @FindBy(xpath = "//span[@class='order-confirm__text']/descendant::span"),
            @FindBy(xpath = "*//p/strong"),
            @FindBy(xpath = "/html/body/main/div/div/div/div/div/div/div[1]/div[4]/p/strong"),
            @FindBy(xpath = "//*[@id=\"site-main\"]/div[2]/div/div/div/div/div[2]/div/span[1]"),
    })public WebElement orderNumber;
    
    // Close cookies X-path
    @FindAll({
            @FindBy(xpath = "//div[@id='onetrust-close-btn-container']/descendant::button"),
            @FindBy(xpath = "/html/body/main/div[3]/div/button"),
            @FindBy(xpath = "/html/body/main/div[6]/div/button"),
            @FindBy(xpath = "//button[contains(@class,'footer-banner__close')]"),
            @FindBy(xpath = "//span[contains(text(),'What do we use cookies for?')]/preceding-sibling::button"),
    })public WebElement cookiesClose;
    
    /*@FindAll({
            @FindBy(xpath = "(//button[@type='submit'])[2]"),
            @FindBy(xpath = "//button[@type='submit']/descendant::span[text()='View Plans']"),
            @FindBy(xpath = "//*[@class='button zip-button js-show-ps red-theme']"),
            @FindBy(xpath = "//*[contains(text(),'Get a quote')]"),
            @FindBy(xpath = "//div[@class='field zip-bar']/input[@name='zipcode']/following::button[@type='submit']"),

    })public WebElement view_Plan;
    
	@FindAll({
	        //Clicking the EnterZip of the Header and then enter the zip and checking the plans 
	        @FindBy(xpath = "(//a[text()=' View available plans'])[1]"),
	        @FindBy(xpath = "(//a[text()=' View available plans'])[2]"),
	        @FindBy(xpath = "(//a[text()=' View available plans'])[3]"),
	        //Enter the zip code and then click on the Go to button then we need to select the plans
	        @FindBy(xpath = "(//a[@class='button icon js-partner-link'])[1]"),
	        @FindBy(xpath = "(//a[@class='button icon js-partner-link'])[2]"),
	        @FindBy(xpath = "//li[@class='provider-selection__provider']/descendant::a")
	})public WebElement viewAvailablePlans;

    //View available palns X-path
    @FindAll({
            @FindBy(xpath = ("//a[text()=' View available plans'])[1]"),
                    @FindBy(xpath = "//a[text()=' View available plans'])[2]"),
                    @FindBy(xpath = "//a[text()=' View available plans'])[3]"),
                    @FindBy(xpath = "//li[@class='provider-selection__provider']/descendant::a"),
    })public WebElement viewAvailablePlans;

    //View palns X-path
    @FindAll({
            @FindBy(xpath = "//button[@class='button zip-button js-show-ps']/descendant::span[text()='View Plans']"),
            @FindBy(xpath = "//button[@type='submit']/descendant::span[text()='View Plans']"),
            @FindBy(xpath = "//*[@class='button zip-button js-show-ps red-theme']"),
          	@FindBy(xpath = "(//button[@type='submit'])[2]"),
          	@FindBy(xpath = "//button[@type='submit']/descendant::span[text()='View Plans']"),
          	@FindBy(xpath = "//*[@class='button zip-button js-show-ps red-theme']"),
          	@FindBy(xpath = "//*[contains(text(),'Get a quote')]"),
    		@FindBy(xpath = "//span[contains(text(),'GO')]/preceding-sibling::button[@class='button zip-button js-show-ps']"),
    })public WebElement viewPlan;

	//First name checkout X-path
	@FindBy(xpath = "//input[@placeholder='First Name']")
	public WebElement firstName; */
  
}
