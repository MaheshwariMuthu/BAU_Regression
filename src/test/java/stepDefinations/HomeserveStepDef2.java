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

public class HomeserveStepDef2 {
	/*CommonPageActions commonPageActions = new CommonPageActions();
	HSLandingPageActions hslandingPage = new HSLandingPageActions();
	SanjosePageActions sanjosePageActions = new SanjosePageActions();
	SLWALandingPageActions slwaLandingPageActions = new SLWALandingPageActions();
	CommonFunctions commonFunctions = new CommonFunctions();
//
//	//
//	@Given("user is on {string} Home page")
//	public void user_is_on_home_page(String Application) throws InterruptedException, IOException, ParseException {
//		commonPageActions.navigateToApplication(Application);
//
//	}


	@When("the user enters a valid zipcode and clicks on View Plans")
	public void the_user_enters_a_valid_zipcode_and_clicks_on_view_plans(DataTable dataTable)
			throws InterruptedException, IOException {
		List<Map<String, String>> userDetailsList = dataTable.asMaps(String.class, String.class);
		try {
			for (Map<String, String> userDetails : userDetailsList) {
				commonPageActions.enterZipCodeAndSubmit();
			}
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Then("the user fills in the Zipcode {string} and City {string} details")
	public void the_user_fills_in_the_Zipcode_and_City_details(String Zipcode,String City)
			throws InterruptedException, IOException, ParseException {
		hslandingPage.enter_Zipcode_and_City_Details(Zipcode,City);

	}

	@When("the user selects the payment method as {string} enters the payment details, and clicks on Complete Secure Checkout")
	public void the_user_selects_the_payment_method_as_enters_the_payment_details_and_clicks_on_complete_secure_checkout(String PaymentType)
			throws InterruptedException, IOException {
		sanjosePageActions.choosePaymentType(PaymentType);
	}


	@Then("the user Enters the AccountNumber as {string} and Complete Secure Checkout")
	public void the_user_enters_the_account_number_as_and_complete_secure_checkout(String value) throws Exception {
		hslandingPage.enterAccountDetailsAndCompleteCheckout(value);
	}*/

}
