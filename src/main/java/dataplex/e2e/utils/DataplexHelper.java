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

package dataplex.e2e.utils;

import dataplex.e2e.pages.actions.GoogleSignInActions;
import org.openqa.selenium.NoAlertPresentException;

import java.io.IOException;

/**
 * Dataplex Helper
 */
public interface DataplexHelper {

    //CdfSchemaLocators SCHEMA_LOCATORS = SeleniumHelper.getPropertiesLocators(CdfSchemaLocators.class);

    default void openDataplex() throws IOException, InterruptedException {
        SeleniumDriver.openPage(SeleniumHelper.readParameters(ConstantUtil.DATAPLEXURL));
        GoogleSignInActions.corpLogin();
        try {
            SeleniumDriver.getDriver().switchTo().alert().accept();
            SeleniumDriver.waitForPageToLoad();
        } catch (NoAlertPresentException Ex) {
            SeleniumDriver.waitForPageToLoad();
        }
    }

    default void openPantheonURL() throws IOException, InterruptedException {
        SeleniumDriver.openPage(SeleniumHelper.readParameters(ConstantUtil.DATAPLEXURL));
        try {
            SeleniumDriver.getDriver().switchTo().alert().accept();
            SeleniumDriver.waitForPageToLoad();
        } catch (NoAlertPresentException Ex) {
            SeleniumDriver.waitForPageToLoad();
        }
    }

    default void openBQNotebookURL() throws IOException, InterruptedException {
        SeleniumDriver.openPage(SeleniumHelper.readParameters(ConstantUtil.BQNOTEBOOKURL));
        GoogleSignInActions.googleLogin();
        try {
            dataplex.e2e.utils.SeleniumDriver.getDriver().switchTo().alert().accept();
            dataplex.e2e.utils.SeleniumDriver.waitForPageToLoad();
        } catch (NoAlertPresentException Ex) {
            dataplex.e2e.utils.SeleniumDriver.waitForPageToLoad();
        }
    }

    default void openGCSNotebookURL() throws IOException, InterruptedException {
        dataplex.e2e.utils.SeleniumDriver.openPage(SeleniumHelper.readParameters(ConstantUtil.GCSNOTEBOOKURL));
        GoogleSignInActions.googleLogin();
        try {
            dataplex.e2e.utils.SeleniumDriver.getDriver().switchTo().alert().accept();
            dataplex.e2e.utils.SeleniumDriver.waitForPageToLoad();
        } catch (NoAlertPresentException Ex) {
            SeleniumDriver.waitForPageToLoad();
        }
    }

}
