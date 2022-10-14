package com.freecrm.commonUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.constants.Constants;
import com.freecrm.driverManager.DriverManager;
import com.freecrm.pageObjects.HomePage;
import com.freecrm.pageObjects.LoginPage;
import com.freecrm.stepDefinations.Common_StepDef;

public class CommonUtilis {
	
	
	
	private static final Logger LOGGER = LogManager.getLogger(CommonUtilis.getInstance());

	/**
	 * the below statements create the object for this class at once and we can call
	 * the getInstance() method any where by using this class this type of creating
	 * object is called Singleton design pattern.
	 */
	private static CommonUtilis commonUtilisInstance = null;

	private CommonUtilis() {

	}

	public static CommonUtilis getInstance() {
		if (commonUtilisInstance == null) {
			commonUtilisInstance = new CommonUtilis();
		}
		return commonUtilisInstance;
	}

	/**
	 * Create the method for load the properties file by using the getCalss() method
	 * no need to use the file input stream by using getResourceAsStream() it
	 * automatically load the file.
	 * 
	 */
	public void loadPropertiesFile() {

		Properties properties = new Properties();

		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("Loaded the porperties from the properties file.");
		Constants.BROWSER = properties.getProperty("BrowserName");
		Constants.URL = properties.getProperty("Url");
		Constants.USERNAME = properties.getProperty("UserName");
		Constants.PASSWORD = properties.getProperty("Password");

	}
	
	

	public void loginToFreeCRM() {
		//DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.time));
		LOGGER.info("Open the url : "+Constants.URL);
		DriverManager.getDriver().get(Constants.URL);
		LOGGER.info("Enter the username into username filed : "+Constants.USERNAME);
		LoginPage.getInstance().enterUsername(Constants.USERNAME);
		LOGGER.info("Enter the password into password filed : "+Constants.URL);
		LoginPage.getInstance().enterPassword(Constants.PASSWORD);
		LOGGER.info("Clicks on login button ");
		LoginPage.getInstance().clickLogonBtn();
		
	}

	public void switchToFrame(String frameValue, String howTo) {

		switch (howTo) {
		case "index":
			DriverManager.getDriver().switchTo().frame(Integer.parseInt(frameValue));
			break;

		case "idORname":
			DriverManager.getDriver().switchTo().frame(frameValue);
			break;
		case "frameElement":
			DriverManager.getDriver().switchTo().frame(frameValue);
			break;

		default:
			LOGGER.info("Please provid the options for switch to iframe. the options are index or idORname or frameElement");
			break;
		}
		
		
	}
	public void inItWebElement() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance());
	}
	
	public void heighlightElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].setAttribute('style','border:3px solid green');", element);

	}
	
	public void takeScreenShot() {
		TakesScreenshot screenshot =  (TakesScreenshot) DriverManager.getDriver();
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(Common_StepDef.getScenarioName()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
