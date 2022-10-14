package com.freecrm.stepDefinations;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.freecrm.commonUtilities.CommonUtilis;
import com.freecrm.driverManager.DriverManager;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Common_StepDef {
	
	
	private static final Logger LOGGER = LogManager.getLogger(Common_StepDef.class);
	private static String scenarioName =null;
	
	public static String getScenarioName() {
		return scenarioName;
	}

	/**
	 * Launching the browser before the scenario starts by using @Before annotation.
	 */
	
	@Before
	public void beforeScenario(Scenario scenario) {
		try {
			
			  scenarioName = scenario.getName();
			  LOGGER.info("Scenario name is : "+scenarioName);
			
			CommonUtilis.getInstance().loadPropertiesFile();
			
			
			/**the below condition tells us open the one browser instance no need to open the multiple instance.
			In the single instance cover all the scenarios
			*/
			if(DriverManager.getDriver()==null) {
				DriverManager.lanchBrowser();
				CommonUtilis.getInstance().inItWebElement();
				//CommonUtilis.getInstance().loginToFreeCRM();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	String fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	@AfterStep
	public void attachScreenshot(Scenario scenario) {
		
		if(scenario.isFailed()) {
			final byte[]  screenshotTaken = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			 scenario.attach(screenshotTaken, "image/png", fileSuffix+scenario.getName());
		}
		
	}

}
