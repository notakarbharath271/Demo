package com.freecrm.stepDefinations;

import com.freecrm.commonUtilities.CommonUtilis;
import com.freecrm.pageObjects.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewCompany_Step_Def {
	
	@Given("the user is logged in sucussfully and is on home page")
	public void the_user_is_logged_in_sucussfully_and_is_on_home_page() {
		CommonUtilis.getInstance().loginToFreeCRM();
		try {
			HomePage.getInstance().switchToFrame();
			HomePage.getInstance().validateUSerID();
		} catch (Exception e) {
			
		}
		
		
	}

	@When("the user mouse over on the company option from the menu bar and clicks on new company from the list")
	public void the_user_mouse_over_on_the_company_option_from_the_menu_bar_and_clicks_on_new_company_from_the_list() {
	   
	}

	@When("fill the from with appropreate details")
	public void fill_the_from_with_appropreate_details() {
	    
	}

	@When("clicks on the save button")
	public void clicks_on_the_save_button() {
	   
	}

	@Then("the user should able to see the new company created {string}")
	public void the_user_should_able_to_see_the_new_company_created(String string) {
	    
	}


}
