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

import dataplex.e2e.utils.Constants;
import dataplex.e2e.utils.SeleniumDriver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.AfterStep;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * After Actions
 */

public class AfterActions {

    @AfterStep
//    public static void takeScreenshot(Scenario scenario) {
//        try {
//            WebDriver driver = SeleniumDriver.getDriver();
//            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenshotBytes, "image/png");
//        } catch (Exception e) {
//            scenario.write("Exception in capturing screenshot : " + e.getMessage() + " : " + e);
//        }
//    }

    public static void takeScreenshot(Scenario scenario) {
        Date d = new Date();
        String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
        File srcFile = ((TakesScreenshot) SeleniumDriver.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(Constants.REPORTS_PATH + screenshotFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//public class AfterActions {
//
//    @AfterStep
//    public static void tearDown(Scenario scenario) {
//        WebDriver driver = SeleniumDriver.getDriver();
//        //String timestamp = new String("yyyy_MM_dd__hh_mm_ss");
//        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        scenario.embed(screenshotBytes, "image/png");
//
//    }
//
//
////    @After
////    public void cleanup() {
////        System.out.println("After");
//////        WebDriver driver=new ChromeDriver();
//////        driver.close();
////        SeleniumDriver.tearDown();
////    }
//}

