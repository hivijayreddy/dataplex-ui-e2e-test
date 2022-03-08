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
import dataplex.e2e.utils.Constants;
import dataplex.e2e.utils.IWaitTimeConstants;
import dataplex.e2e.utils.JSONReaderUtil;
import dataplex.e2e.utils.SeleniumDriver;
import dataplex.e2e.utils.SeleniumHelper;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static dataplex.e2e.pages.actions.LakeActions.enteredText;

/**
 * Explore notebook Actions
 */

public class ExploreNotebookActions {

    private static String envID;
    private static String envDisplayName;
    public static dataplex.e2e.pages.locators.EnvironmentNotebookLocators environmentNotebookLocators = null;
    public static SoftAssert softAssert;

    static {
        environmentNotebookLocators = PageFactory.initElements(SeleniumDriver.getDriver(),
                dataplex.e2e.pages.locators.EnvironmentNotebookLocators.class);
    }


    public static void createEnvironment() {
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEnvironmentTab.click();

        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickCreateEnvironment.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEnvironmentDisplayName.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentDisplayName.
                sendKeys("dp-auto" + randomNumber() + "-environment");
        envDisplayName = dataplex.e2e.pages.locators.EnvironmentNotebookLocators.
                enterEnvironmentDisplayName.getAttribute("value");
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEnvironmentID.click();
        clearLabel(dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentID);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentID.
                sendKeys("dp-auto" + randomNumber() + "-environmentid");
        envID = dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentID.getAttribute("value");
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEnvironmentDescription.click();
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentDescription.
                sendKeys("dp-auto" + randomNumber() + "description");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickCreateButton.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
    }

    public static void createEnvironmentWithMinimumLength() {
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEnvironmentTab.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickCreateEnvironment.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEnvironmentDisplayName.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentDisplayName.
                sendKeys("dp-auto" + randomNumber() + "-environment");
        envDisplayName = dataplex.e2e.pages.locators.EnvironmentNotebookLocators.
                enterEnvironmentDisplayName.getAttribute("value");
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEnvironmentID.click();
        clearLabel(dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentID);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentID.
                sendKeys("" + randomChar());
        envID = dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentID.getAttribute("value");
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEnvironmentDescription.click();
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentDescription.
                sendKeys("dp-auto" + randomNumber() + "description");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickCreateButton.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
    }

    public static void createEnvironmentWithMaximumLength() {
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEnvironmentTab.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickCreateEnvironment.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEnvironmentDisplayName.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentDisplayName.
                sendKeys("dp-auto-creating-environment-with-max-length" + randomNumber() + "-environment");
        envDisplayName = dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentDisplayName.
                getAttribute("value");
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEnvironmentID.click();
        clearLabel(dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentID);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentID.
                sendKeys("dp-auto" + randomNumber() + "-environmentid");
        envID = dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentID.getAttribute("value");
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEnvironmentDescription.click();
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentDescription.
                sendKeys("dp-auto" + randomNumber() + "description");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickCreateButton.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
    }


    public static void envFilter() {
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEnvFilter.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentNameInFilter.sendKeys(envDisplayName);
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentNameInFilter.sendKeys(Keys.ENTER);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterEnvironmentNameInFilter.sendKeys(Keys.ESCAPE);
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
    }

    public static void envMakeDefault() {
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.selectEnvironment.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.makeEnvironmentDefault.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
    }

    public static void deleteEnvironment() {
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.selectEnvironment.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickDeleteEnvironment.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.confirmEnvironmentDelete.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.verifyNoEnvironmentsFound.click();
    }

    public static void createNotebook() throws InterruptedException {
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickExplore.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWENTY_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.expandProject.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickMoreResults.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickMoreResults.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEnvFilter.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterLakeNameInExploreFilter.sendKeys(enteredText);
        //dataplex.e2e.pages.locators.EnvironmentLocators.enterLakeNameInExploreFilter.sendKeys("dp-auto51192-lake");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterLakeNameInExploreFilter.sendKeys(Keys.ENTER);
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterLakeNameInExploreFilter.sendKeys(Keys.ESCAPE);
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_THREE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.expandLake.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickNoteBooks.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.createNoteBook.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickNoteBookPath.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterNoteBookPath.
                sendKeys("notebook" + randomNumber());
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickNoteBookDescription.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterNoteBookDescription.
                sendKeys("Notebook" + randomNumber() + "description");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickCreateNotebook.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TEN_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickToOpenNotebook.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        ArrayList<String> newTb = new ArrayList<String>(SeleniumDriver.getDriver().getWindowHandles());
        SeleniumDriver.getDriver().switchTo().window(newTb.get(1));
        waitTillJupyterNoteBookOpen();
    }

    public static void runBQNotebook() throws InterruptedException, IOException {
        List<String> notebookResultValidation = new ArrayList<String>();
        Map<String, String> searchInputs = JSONReaderUtil.
                getJsonData(Constants.MASTER_TEST_DATA, "BQNoteBookValidateData", 0);
        for (String key : searchInputs.keySet()) {
            notebookResultValidation.add(searchInputs.get(key));
        }
        waitTillJupyterNoteBookOpen();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEdit.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickClearOutputs.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.selectRunFromMenu.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickRunAllCells.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIFTEEN_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEdit.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickFind.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterSearchText.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);

        for (String searchinginput : notebookResultValidation) {
            dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterSearchText.sendKeys(searchinginput);
            SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
            validateNotebookResult();
            SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
            clearLabel(dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterSearchText);
            SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        }
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEdit.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickClearOutputs.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.selectFileFromMenu.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickSaveNoteBook.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);

    }

    public static void runGCSNotebook() throws Throwable {
        List<String> notebookResultValidation = new ArrayList<String>();
        Map<String, String> searchInputs = JSONReaderUtil.
                getJsonData(Constants.MASTER_TEST_DATA, "GCSNoteBookValidateData", 0);
        for (String key : searchInputs.keySet()) {
            notebookResultValidation.add(searchInputs.get(key));
        }
        waitTillJupyterNoteBookOpen();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        enterPythonScript();
//        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEdit.click();
//        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
//        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEditmenuOptions.click();
//        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
//        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickClearOutputs.click();
//        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
//        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.selectRunFromMenu.click();
//        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
//        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickRunAllCells.click();
//        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWENTY_SEC_MS);
//        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEdit.click();
//        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
//        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickFind.click();
//        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
//        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterSearchText.click();
//        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
//        for (String searchinginput : notebookResultValidation) {
//            dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterSearchText.sendKeys(searchinginput);
//            SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
//            validateNotebookResult();
//            SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
//            clearLabel(dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterSearchText);
//            SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
//        }
//        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
//        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEdit.click();
//        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
//        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickClearOutputs.click();
//        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
//        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.selectFileFromMenu.click();
//        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
//        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickSaveNoteBook.click();
//        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
    }

    public static void validateNotebookResult() {
        String expectedSearchResult = "1/1";
        String actualSearchResult = dataplex.e2e.pages.locators.
                EnvironmentNotebookLocators.validateSearchText.getText();
        Assert.assertEquals(expectedSearchResult, actualSearchResult);
    }

    public static void clearLabel(WebElement element) {
        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.BACK_SPACE);
    }

    public static int randomNumber() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000);
        return randomInt;
    }

    public static char randomChar() {
        Random random = new Random();
        char randomizedCharacter = (char) (random.nextInt(26) + 'a');
        return randomizedCharacter;
    }

    public static void waitTillJupyterNoteBookOpen() {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 300000);
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@class='jp-ToolbarButtonComponent-label' and contains(text()," +
                        "'Python 3 (ipykernel)')]"))));
    }

    public static void enterPythonScript() throws Throwable {
        Actions act = new Actions(SeleniumDriver.getDriver());
//        act.sendKeys(Keys.TAB).perform();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        act.sendKeys(SeleniumHelper.readParameters(ConstantUtil.GCS_JUPYTER_COMMAND_1)).build().perform();
//        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        Thread.sleep(20000);
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickRun.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TEN_SEC_MS);
//        act.sendKeys(Keys.ESCAPE).perform();
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(
                (dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEdit)));
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickEdit.click();
//        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TEN_SEC_MS);
        wait.until(ExpectedConditions.elementToBeClickable(
                (dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickFind)));
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickFind.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
//        act.keyDown(Keys.COMMAND).sendKeys(Keys.chord("f")).keyUp(Keys.COMMAND).perform();
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterSearchText.
                sendKeys(SeleniumHelper.readParameters(ConstantUtil.GCS_JUPYTER_COMMAND_1_RESULT));
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        validateNotebookResult();
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clearCommand.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        act.sendKeys(Keys.TAB).perform();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        act.sendKeys(SeleniumHelper.readParameters(ConstantUtil.GCS_JUPYTER_COMMAND_2)).build().perform();
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clickRun.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        act.keyDown(Keys.CONTROL).sendKeys(Keys.chord("f")).keyUp(Keys.CONTROL).perform();
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.enterSearchText.
                sendKeys(SeleniumHelper.readParameters(ConstantUtil.GCS_JUPYTER_COMMAND_2_RESULT));
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
        validateNotebookResult();
        dataplex.e2e.pages.locators.EnvironmentNotebookLocators.clearCommand.click();
    }

}
