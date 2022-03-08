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
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Google SignIn Actions
 */

public class GoogleSignInActions {

    public static dataplex.e2e.pages.locators.GoogleSignInLocator googleSignInLocator = null;

    static {

        googleSignInLocator = PageFactory.initElements(SeleniumDriver.getDriver(),
                dataplex.e2e.pages.locators.GoogleSignInLocator.class);

    }

//    public static void login() throws InterruptedException, IOException {
//        GoogleSignInLocator.username.get(0).sendKeys(SeleniumHelper.readParameters("gLoginUsername"));
//        GoogleSignInLocator.nextButton.click();
//        Thread.sleep(2000);
//        GoogleSignInLocator.passwordField.sendKeys(SeleniumHelper.readParameters("gPassword"));
//        Thread.sleep(2000);
//        GoogleSignInLocator.nextButton.click();
//        Thread.sleep(6000);
//        GoogleSignInLocator.nextButton.click();
//    }

    public static void corpLogin() throws InterruptedException, IOException {

        //SeleniumDriver.openPage(SeleniumHelper.readParameters(ConstantUtil.GOOGLESIGNIN));


        //SeleniumDriver.openPage(SeleniumHelper.readParameters(ConstantUtil.DATAPLEXURL));
        //GoogleSignInLocator.googleNextButton.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        googleSignInLocator.corpUsername.sendKeys(SeleniumHelper.readParameters("gLoginUsername"));
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        googleSignInLocator.corpPassword.sendKeys(SeleniumHelper.readParameters("gPassword"));
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        googleSignInLocator.corpSignnButton.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);
        googleSignInLocator.continueButton.click();


        googleSignInLocator.googleUsername.sendKeys(SeleniumHelper.readParameters("googleLoginUsername"));
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        googleSignInLocator.googleNextButton.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        googleSignInLocator.googlePassword.sendKeys(SeleniumHelper.readParameters("gPassword"));
        System.out.println("google password done");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        googleSignInLocator.googleNextButton.click();
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);


    }

    public static void googleLogin() throws InterruptedException, IOException {
        googleSignInLocator.googleUsername.sendKeys(SeleniumHelper.readParameters("googleLoginUsername"));
        System.out.println("google username done");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        googleSignInLocator.googleNextButton.click();
        googleSignInLocator.googlePassword.sendKeys(SeleniumHelper.readParameters("gPassword"));
        System.out.println("google password done");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_ONE_SEC_MS);
        googleSignInLocator.googleNextButton.click();
        System.out.println("google Next done");
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_FIVE_SEC_MS);


    }
}
