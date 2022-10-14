package com.freecrm.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.freecrm.commonUtilities.CommonUtilis;
import com.freecrm.driverManager.DriverManager;

public class HomePage {

	private static Logger LOGGER = LogManager.getLogger(HomePage.getInstance());
	private static HomePage homePageInstance = null;

	private HomePage() {

	}

	public static HomePage getInstance() {

		if (homePageInstance == null) {
			homePageInstance = new HomePage();
		}

		return homePageInstance;

	}

	@FindBy(name = "mainpanel")
	private WebElement frameattributeValue;

	public void switchToFrame() {
		CommonUtilis.getInstance().heighlightElement(frameattributeValue);
		DriverManager.getDriver().switchTo().frame(frameattributeValue);
	}

	@FindBy(xpath = "//td[contains(text(),'User:')]")
	private WebElement userid;

	public void validateUSerID() {
		try {
			CommonUtilis.getInstance().heighlightElement(userid);
			String UserID = userid.getText();

			
			  if (UserID.contains("User")) {
			  LOGGER.info("User is logging to application sucessfully."); } else {
			  
			  LOGGER.info("User is logging to application unsucessfully."); }
			 

		} catch (Exception e) {
			LOGGER.error(e);
			//CommonUtilis.getInstance().takeScreenShot();
			Assert.fail(e.getMessage());
		}
	}

}
