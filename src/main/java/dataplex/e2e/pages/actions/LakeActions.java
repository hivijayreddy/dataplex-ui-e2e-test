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

import dataplex.e2e.utils.IWaitTimeConstants;
import dataplex.e2e.utils.SeleniumDriver;
import dataplex.e2e.utils.SeleniumHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.Random;

/**
 * Actions for Lake
 */
public class LakeActions {

    public static String enteredText;
    public static dataplex.e2e.pages.locators.LakeLocators lakeLocators = null;
    static SoftAssert softAssert;

    static {
        lakeLocators = PageFactory.initElements(SeleniumDriver.getDriver(),
                dataplex.e2e.pages.locators.LakeLocators.class);
    }

    public static void createLake() {
        dataplex.e2e.pages.locators.LakeLocators.createLakeButton.click();
    }

    public static void enterLakeDisplayname() throws InterruptedException {

        dataplex.e2e.pages.locators.LakeLocators.clickLakeDisplayName.click();
        dataplex.e2e.pages.locators.LakeLocators.enterLakeDisplayName.
                sendKeys("dp-auto" + randomNumber() + "-lake");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.LakeLocators.enterLakeDisplayName.click();
        enteredText = dataplex.e2e.pages.locators.LakeLocators.enterLakeDisplayName.getAttribute("value");
        System.out.println("Entered displayname is:" + enteredText);

    }

    public static void enterLakeID() throws InterruptedException {
        dataplex.e2e.pages.locators.LakeLocators.clickLakeID.click();
        clearLabel();
        dataplex.e2e.pages.locators.LakeLocators.enterLakeID.
                sendKeys("dp-auto" + randomNumber() + "-lakeid");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
    }

    public static void enterLakeDescription() throws InterruptedException {

        dataplex.e2e.pages.locators.LakeLocators.clickLakeDescription.click();
        dataplex.e2e.pages.locators.LakeLocators.enterLakeDescription.sendKeys("Lake Description");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);

    }

    public static void saveLake() {
        dataplex.e2e.pages.locators.LakeLocators.lakeCreation.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.LakeLocators.clickManage.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
    }

    public static void clickManageTab() {
        dataplex.e2e.pages.locators.LakeLocators.clickManage.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
    }

    public static void lakeFilter() {
        dataplex.e2e.pages.locators.LakeLocators.clickFilter.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.LakeLocators.enterLakeNameInFilter.sendKeys(enteredText);
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TEN_SEC_MS);
        dataplex.e2e.pages.locators.LakeLocators.enterLakeNameInFilter.sendKeys(Keys.ENTER);
        dataplex.e2e.pages.locators.LakeLocators.enterLakeNameInFilter.sendKeys(Keys.ESCAPE);
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TEN_SEC_MS);
    }

    public static void clickOnLake() {
        dataplex.e2e.pages.locators.LakeLocators.clickLake.click();
    }

    public static void clearLabel() {
        dataplex.e2e.pages.locators.LakeLocators.enterLakeID.sendKeys(Keys.COMMAND + "a");
        dataplex.e2e.pages.locators.LakeLocators.enterLakeID.sendKeys(Keys.BACK_SPACE);
    }

    public static int randomNumber() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000);
        return randomInt;
    }

}
