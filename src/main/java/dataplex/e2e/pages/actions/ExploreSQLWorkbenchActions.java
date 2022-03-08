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

import dataplex.e2e.pages.locators.EnvironmentSQLWorkbenchLocators;
import dataplex.e2e.utils.ConstantUtil;
import dataplex.e2e.utils.IWaitTimeConstants;
import dataplex.e2e.utils.SeleniumDriver;
import dataplex.e2e.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.Random;

/**
 * Actions for SQL WorkBench
 */

public class ExploreSQLWorkbenchActions {

    public static EnvironmentSQLWorkbenchLocators environmentSQLWorkbenchLocators = null;
    public static SoftAssert softAssert;

    static {
        environmentSQLWorkbenchLocators = PageFactory.initElements(SeleniumDriver.getDriver(),
                EnvironmentSQLWorkbenchLocators.class);
    }

    public static void clickExploreTAB() throws Throwable {
        EnvironmentSQLWorkbenchLocators.clickExplore.click();
        wait_till_Explore_Page_loaded();
    }

    public static void saveQuerywithName() throws Throwable {
        EnvironmentSQLWorkbenchLocators.clickSave.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        EnvironmentSQLWorkbenchLocators.clickSaveQuery.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        EnvironmentSQLWorkbenchLocators.enterQueryPathName.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        EnvironmentSQLWorkbenchLocators.
                enterQueryPathName.sendKeys("sql" + randomNumber() + ".sql");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        EnvironmentSQLWorkbenchLocators.clickLakeDropdown.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        EnvironmentSQLWorkbenchLocators.
                listOfLakes.sendKeys("dp-metastore3-lake");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        EnvironmentSQLWorkbenchLocators.listOfLakes.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        EnvironmentSQLWorkbenchLocators.clickSaveToSaveSQL.click();
        wait_till_Query_is_saved();
    }

    public static void enterQueryToRun() throws Throwable {
        Actions act = new Actions(SeleniumDriver.getDriver());
        act.sendKeys(Keys.TAB).perform();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        act.sendKeys(SeleniumHelper.readParameters(ConstantUtil.QUERY_ONE)).build().perform();
        act.sendKeys(Keys.ENTER).perform();
        act.sendKeys(SeleniumHelper.readParameters(ConstantUtil.QUERY_TWO)).build().perform();
    }

    public static void runQuery() throws Throwable {
        EnvironmentSQLWorkbenchLocators.clickRun.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        waitTillRunEnabled();
    }

    public static void waitforQueryExecution() throws Throwable {
        waitTillRunEnabled();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        EnvironmentSQLWorkbenchLocators.clickJobInformation.click();
        wait_till_Query_Execution_is_Completed();
    }

    public static int randomNumber() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000);
        return randomInt;
    }

    public static void waitTillRunEnabled() {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 300000);
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),' Run ') and contains(@class,'mat-button-wrapper')]"))));

    }

    public static void wait_till_Explore_Page_loaded() throws Throwable {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 120000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@class='cfc-table-column-header-text' and contains(text(),' Display name ')]")));
    }

    public static void wait_till_Query_is_saved() throws Throwable {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 120000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@class='cfc-text-body' and contains(text(),' Using ')]")));
    }

    public static void wait_till_Query_Execution_is_Completed() throws Throwable {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 120000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),' SUCCEEDED ') or (contains(text(),' FAILED '))]")));
    }

}
