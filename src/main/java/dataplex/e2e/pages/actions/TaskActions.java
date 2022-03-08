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

package dataplex.e2e.pages.actions;

import dataplex.e2e.utils.ConstantUtil;
import dataplex.e2e.utils.IWaitTimeConstants;
import dataplex.e2e.utils.SeleniumDriver;
import dataplex.e2e.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Random;

/**
 * Actions For Task
 */

public class TaskActions {

    private static String taskID;
    public static dataplex.e2e.pages.locators.TaskLocators taskLocators;

    static {
        taskLocators = PageFactory.initElements(SeleniumDriver.getDriver(),
                dataplex.e2e.pages.locators.TaskLocators.class);
    }

    public static void clickProcessTAB() {
        dataplex.e2e.pages.locators.TaskLocators.clickProcessTab.click();
        wait_till_task_page_loaded();
    }

    public static void clickCreateTask() {
        dataplex.e2e.pages.locators.TaskLocators.clickCreateTask.click();
        wait_till_Create_task_page_loaded();
    }

    public static void clickCreateCustomSparkTask() {
        dataplex.e2e.pages.locators.TaskLocators.clickCreateCustomSparkTask.click();
        wait_till_Task_Creation_page_loaded();
    }

    public static void selectlakeFromDropdown() {
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.TaskLocators.selectLake.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.TaskLocators.searchForLake.sendKeys("dp-metastore3-lake");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.TaskLocators.selectLakeFromList.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
    }

    public static void enterTaskID() {
        dataplex.e2e.pages.locators.TaskLocators.clickTaskID.click();
        dataplex.e2e.pages.locators.TaskLocators.enterTaskID.sendKeys("dp-" + randomNumber() + "-task");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        taskID = dataplex.e2e.pages.locators.TaskLocators.enterTaskID.getAttribute("value");
        System.out.println("Entered Task id is:" + taskID);
    }

    public static void selectTypePySpark() {
        dataplex.e2e.pages.locators.TaskLocators.clickTypeDropdpwn.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.TaskLocators.selectPySparkType.click();
    }

    public static void enterMainPythonFilePath() throws IOException {
        dataplex.e2e.pages.locators.TaskLocators.clickMainPythonFile.click();
        dataplex.e2e.pages.locators.TaskLocators.enterMainPythonFilePth.
                sendKeys(SeleniumHelper.readParameters(ConstantUtil.PY_SPARK_TASK_1));
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
    }

    public static void enterSparkJarFilePath() throws IOException {
        dataplex.e2e.pages.locators.TaskLocators.clickMainClassOrJarFile.click();
        dataplex.e2e.pages.locators.TaskLocators.enterMainClassOrJarFilePath.
                sendKeys(SeleniumHelper.readParameters(ConstantUtil.SPARK_TASK_1));
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
    }

    public static void enterSparkJarMainClassName() throws IOException {
        dataplex.e2e.pages.locators.TaskLocators.clickMainClassOrJarFile.click();
        dataplex.e2e.pages.locators.TaskLocators.enterMainClassOrJarFilePath.
                sendKeys(SeleniumHelper.readParameters(ConstantUtil.MAIN_CLASS_NAME_1));
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
    }

    public static void selectServiceAccount() throws IOException {
        dataplex.e2e.pages.locators.TaskLocators.clickUserServiceAccount.click();
        dataplex.e2e.pages.locators.TaskLocators.enterServiceAccount.
                sendKeys(SeleniumHelper.readParameters(ConstantUtil.SERVICE_ACCOUNT_NAME));
        dataplex.e2e.pages.locators.TaskLocators.selectServiceAccount.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
    }

    public static void clickContinueButtonForSetScheduleScreen() {
        dataplex.e2e.pages.locators.TaskLocators.clickContinue.click();
        wait_till_Set_Schedule_page_loaded();
    }

    public static void clickContinueButtonForCustomizeResourcesScreen() {
        dataplex.e2e.pages.locators.TaskLocators.clickContinue.click();
        wait_till_Customize_resources_page_loaded();
    }

    public static void enterMainClassJARFilePath() throws Throwable {
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        dataplex.e2e.pages.locators.TaskLocators.clickJARFiles.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.TaskLocators.enterJARFiles.
                sendKeys(SeleniumHelper.readParameters(ConstantUtil.SPARK_TASK_2));
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
    }

    public static void clickCreateButton() {
        dataplex.e2e.pages.locators.TaskLocators.clickToCreateTask.click();
        wait_till_task_page_loaded();
    }

    public static void taskFilter() {
        dataplex.e2e.pages.locators.TaskLocators.clickTaskFilter.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        dataplex.e2e.pages.locators.TaskLocators.enterTaskNameInFilter.sendKeys(taskID);
        dataplex.e2e.pages.locators.TaskLocators.enterTaskNameInFilter.sendKeys(Keys.ENTER);
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.TaskLocators.enterTaskNameInFilter.sendKeys(Keys.ESCAPE);
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWENTY_SEC_MS);
    }

    public static void openCreatedTask() {
        wait_till_task_clickable();
        dataplex.e2e.pages.locators.TaskLocators.clickTask.click();
        wait_till_Job_ID_Clickable();
        dataplex.e2e.pages.locators.TaskLocators.clickOnJobID.click();
        wait_till_Dataproc_Batches_page_loaded();
    }

    public static int randomNumber() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(100000);
    }

    public static void wait_till_task_clickable() {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 120000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@class='ng-star-inserted' and contains(@href,'/dataplex/process/tasks')]")));
    }

    public static void wait_till_task_page_loaded() {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 120000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@class='cfc-table-pagination-rows-per-page-text']")));
    }

    public static void wait_till_Create_task_page_loaded() {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 120000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(text(),'CREATE TASK')]")));
    }

    public static void wait_till_Task_Creation_page_loaded() {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 120000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Custom Spark task')]")));
    }

    public static void wait_till_Set_Schedule_page_loaded() {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 120000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Set schedule')]")));
    }

    public static void wait_till_Customize_resources_page_loaded() {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 120000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Additional properties')]")));
    }

    public static void wait_till_Job_ID_Clickable() {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 120000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@class='ng-star-inserted' and contains(@href,'/dataproc/batches')]")));
    }

    public static void wait_till_Dataproc_Batches_page_loaded() {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 120000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),' Batches ')]")));
    }

}
