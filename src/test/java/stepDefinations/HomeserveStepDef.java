package stepDefinations;

import Config.update_Config_Properties;
import DataMapping.testDataMapping;
import Email_Validator.Verify_Gmail;
import automationFramework.CommonFunctions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
//import org.sample.Verify_Gmail;
import pageActions.CommonPageActions;
import pageActions.HSLandingPageActions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static DataMapping.testDataMapping.configProperties;
import static automationFramework.Constant.*;

public class HomeserveStepDef {
	CommonPageActions commonPageActions = new CommonPageActions();
	HSLandingPageActions hslandingPage = new HSLandingPageActions();
	CommonFunctions commonFunctions = new CommonFunctions();

	@Given("User is on {string} Home page")
	public void userIsOnHomePage(String Site) throws Exception {
		update_Config_Properties.Update_Config_Prop(Site);
        testDataMapping.setValue(outputData, "Date", CommonFunctions.returnDate("dd/MM/yyyy"));
		testDataMapping.readConfigProp();
		testDataMapping.setValue(outputData, "Site", Site);
		commonPageActions.navigateToApplication();
	}

	@Then("add product to the cart and the user clicks on Proceed to Checkout")
	public void add_product_to_the_cart_and_the_user_clicks_on_proceed_to_checkout() throws Exception {
		commonPageActions.addProductToCartAndProceedToCheckout();
	}

	@Then("the user fills in the Contact details")
	public void the_user_fills_in_the_contact_details()throws InterruptedException, IOException, ParseException {
		commonPageActions.enterUserDetails();

	}

	@When("Clicks on Continue to Payment Information")
	public void clicks_on_continue_to_payment_information()	throws Exception {
		hslandingPage.continueToPayment();
	}

	@Then("the user should see an order confirmation message")
	public void the_user_should_see_an_order_confirmation_message() throws Exception {
		hslandingPage.verifyOrderConformedSuccessfully();

	}

	@Then("the user Selects the State")
	public void the_user_Should_Select_the_Required_State() throws Exception {
		hslandingPage.select_State();
	}

	@Then("open Gmail and Validate order number in confirmation email is received")
	public void open_Gmail_and_Verify_Order_number_in_confirmation_email_is_received() throws Exception {
		Verify_Gmail.check(configProperties.getProperty("host"), configProperties.getProperty("mailStoreType"), configProperties.getProperty("gmusername"), configProperties.getProperty("gmpassword"));
	}
	
	//Updated Maheswari
	
	@When("user enters a valid zipcode and clicks on View Plans")
	public void user_enters_a_valid_zipcode_and_clicks_on_view_plans() throws InterruptedException, IOException {	
		commonPageActions.enterZipCodeAndSubmit();
	}
	
	@Then("the user selects the Billing Frequency")
	public void the_user_selects_the_Billing_Frequency() throws Exception{
		commonPageActions.selectBillingFrequency();
	}
	
	@Then("the user selects the PaymentType to make the payment and clicks on Complete Secure Checkout")
	public void the_user_selects_the_payment_type_to_make_the_payment_and_clicks_on_complete_secure_checkout() throws Exception {
		commonPageActions.chooseAndMakePayementType();
	}
	
	@Then("User fills up the Contact details with Zipcode and City")
	public void User_fills_up_the_contact_details_with_Zipcode_and_City() throws Exception{
		commonPageActions.enterUserDetails();
	}
	
	@When("User select product and proceed to checkout")
	public void user_select_product_and_proceed_to_checkout() throws Exception {
		commonPageActions.handlePopups();
		commonPageActions.addProductToCartAndProceedToCheckout();
	}
	
	@When("the user selects the plan and add to cart add and Proceed To Checkout")
	public void the_user_selects_the_plan_add_to_cart_and_Proceed_To_Checkout()	throws Exception {
		commonPageActions.selectThePlanAndAddToCartAndProceedToCheckout();
	}
}
