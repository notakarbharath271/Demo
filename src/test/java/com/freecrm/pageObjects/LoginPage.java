package com.freecrm.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.freecrm.commonUtilities.CommonUtilis;

public class LoginPage {

	private static LoginPage loginPageInstance;
	private static final Logger LOGGER = LogManager.getLogger(LoginPage.getInstance());

	private LoginPage() {

	}

	public static LoginPage getInstance() {

		if (loginPageInstance == null) {
			loginPageInstance = new LoginPage();
		}
		return loginPageInstance;

	}
	
	@FindBy(how = How.XPATH ,using = "//*[@name='username']")
	private WebElement userName;
	
	@FindBy(how = How.XPATH ,using ="//*[@name='password']")
	private WebElement password;
	
	@FindBy(how = How.XPATH ,using ="//*[@value='Login']")
	private WebElement login_button;
	
	
	public void enterUsername(String user_name) {
		try {
		CommonUtilis.getInstance().heighlightElement(userName);
	 userName.sendKeys(user_name);
		}catch (Exception e) {
			LOGGER.error(e);
			//CommonUtilis.getInstance().takeScreenShot();
		}
	}
	public void enterPassword(String psw) {
		CommonUtilis.getInstance().heighlightElement(password);

		password.sendKeys(psw);
		}
	
	public void clickLogonBtn() {
		CommonUtilis.getInstance().heighlightElement(login_button);

		login_button.click();
		}

}
