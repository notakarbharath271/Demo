package com.freecrm.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features = "@target/failed_Scenario.txt",
					glue = "com.freecrm.stepDefinations",
					dryRun = false,
					monochrome = true
						
		
					)


public class FailedScenarioReRunner {

}
