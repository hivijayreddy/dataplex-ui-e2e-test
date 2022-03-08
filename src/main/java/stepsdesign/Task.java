/*
 * Copyright © 2021 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package stepsdesign;

import dataplex.e2e.pages.actions.TaskActions;
import dataplex.e2e.utils.DataplexHelper;
import dataplex.e2e.utils.SeleniumDriver;
import dataplex.e2e.utils.SeleniumHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Task Step Definitions
 */

public class Task implements DataplexHelper {

    @Given("Open Dataplex Project For Task")
    public void openDataplexProject() throws IOException, InterruptedException {
        openDataplex();
    }

    @Given("Open Pantheon URL of Dataplex Project For Task")
    public void openPantheonDataplexURL() throws IOException, InterruptedException {
        openPantheonURL();
    }

    @Then("Click On Process Tab")
    public void clickProcessTAB() throws Throwable {
        TaskActions.clickProcessTAB();
    }

    @Then("Click On Create Task")
    public void clickCreateTask() throws Throwable {
        TaskActions.clickCreateTask();
    }

    @Then("^Click on Create Custom Spark Task to Create Spark Task$")
    public void clickCreateCustomSparkTask() throws Throwable {
        TaskActions.clickCreateCustomSparkTask();
    }

    @Then("^Select Lake from Dropdown$")
    public void selectlakeFromDropdown() throws Throwable {
        TaskActions.selectlakeFromDropdown();
    }

    @Then("^Enter Task ID$")
    public void enterTaskID() throws Throwable {
        TaskActions.enterTaskID();
    }

    @Then("^Select Type as PySpark$")
    public void selectTypePySpark() throws Throwable {
        TaskActions.selectTypePySpark();
    }

    @Then("^Enter GCS Path of Spark Jar$")
    public void enterSparkJarFilePath() throws Throwable {
        TaskActions.enterSparkJarFilePath();
    }

    @Then("^Enter GCS Path of PySpark File$")
    public void enterMainPythonFilePath() throws Throwable {
        TaskActions.enterMainPythonFilePath();
    }

    @Then("^Enter Main Class Name of Spark Jar$")
    public void enterSparkJarMainClassName() throws Throwable {
        TaskActions.enterSparkJarMainClassName();
    }

    @Then("^Select Service Account From The Dropdown$")
    public void taskActions() throws Throwable {
        TaskActions.selectServiceAccount();
    }

    @Then("^Click on Continue Button to go to Set Schedule screen$")
    public void clickContinueButtonForSetScheduleScreen() throws Throwable {
        TaskActions.clickContinueButtonForSetScheduleScreen();
    }

    @Then("^Click on Continue Button to go to Customize Resources screen$")
    public void clickContinueButtonForCustomizeResourcesScreen() throws Throwable {
        TaskActions.clickContinueButtonForCustomizeResourcesScreen();
    }

    @Then("^Enter GCS Main Class JAR File Path$")
    public void enterMainClassJARFilePath() throws Throwable {
        TaskActions.enterMainClassJARFilePath();
    }

    @Then("^Click on Create Button to Create a Spark Task$")
    public void clickCreateButton() throws Throwable {
        TaskActions.clickCreateButton();
    }

    @Then("^Search for Created task using Filter$")
    public void taskFilter() throws Throwable {
        TaskActions.taskFilter();
    }

    @Then("^From filter Result Click on Task$")
    public void openCreatedTask() throws Throwable {
        TaskActions.openCreatedTask();
    }

//    @Then("^Verify the Job Status$")
//    public void verifyJobStatus() throws Throwable {
//        TaskActions.verifyJobStatus();
//    }

    @Then("Wait till Job is Succeeded Or Failed")
    public void waitTillPipelineIsInRunningState() {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 300000);
        wait.until(ExpectedConditions.or
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),' Succeeded ')]")),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),' Failed ')]"))));
    }

    @Then("Verify the Job status is Succeeded or Not")
    public void verifyThePipelineStatusIs() {
        Assert.assertTrue("Job Status is Failed",
                SeleniumHelper.verifyElementPresent("//*[contains(text(),' Succeeded ')]"));
    }
}
