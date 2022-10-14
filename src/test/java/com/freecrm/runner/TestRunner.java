package com.freecrm.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features = "src/test/resources/features",
					glue = "com.freecrm.stepDefinations",
					dryRun = false,
					monochrome = true,
					publish = true,
					plugin = {"rerun:target/failed_Scenario.txt","pretty"

							//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							//"html:traget/cucumber-reports/report.html"
							//"json:traget/cucumber-reports/report.json"
							//"junit:traget/cucumber-reports/report.xml"	
					
								}
				
		
					)





public class TestRunner {  

}
