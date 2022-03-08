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

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Selenium Helper
 */

public class SeleniumHelper {
    static String path;
    private static final long DEFAULT_TIMEOUT = 4;

    static {
        try {
            path = dataplex.e2e.utils.SeleniumHelper.readParameters("DownloadPath");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void folderName(String name) {

        File f1 = new File("src/e2e-test/resources/" + name);
        //Creating a folder using mkdir() method
        boolean bool = f1.mkdir();
        if (bool) {
            System.out.println("Folder is created successfully");
        } else {
            System.out.println("Error Found!");
        }
    }

    public static void filemove(String name, String input) throws IOException, InterruptedException {
        String aa = path + "/" + name + "/" + input;
        Thread.sleep(2000);
        File file = new File(path + "schema.json");
        if (file.renameTo
                (new File(path + "/" + name + "/" + input))) {
            // if file copied successfully then delete the original file
            file.delete();
            System.out.println("File moved successfully");
        } else {
            System.out.println("Failed to move the file");
        }

    }

    public static boolean isElementPresent(WebElement webElement) {
        try {
            boolean isPresent = webElement.isDisplayed();
            return isPresent;
        } catch (NoSuchElementException e) {
            return false;
        }

    }


    public static void dragAndDrop(WebElement from, WebElement to) {
        Actions act = new Actions(SeleniumDriver.getDriver());

        //Dragged and dropped.
        act.dragAndDrop(from, to).build().perform();
    }


    public static void alignStudioConnectors(WebElement element) {
        Actions actions = new Actions(SeleniumDriver.getDriver());
        actions.contextClick(element).perform();
        dataplex.e2e.utils.SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
    }

    public static void clickObject(WebElement element) {
        element.click();
    }

    public static void sendKeys(WebElement element, String keys) {
        element.sendKeys(keys);
    }

    public static boolean waitElementInvisible(String element) throws InterruptedException {
        Thread.sleep(7000);
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
        return true;
    }

    public static String readParameters(String property) throws IOException {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = ClassLoader.getSystemClassLoader().getResourceAsStream("ConnectionParameters.properties");
            prop.load(input);
            return prop.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }

    public static String readParametersForNoteBook(String property) throws IOException {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = ClassLoader.getSystemClassLoader().getResourceAsStream("NoteBookValidation.properties");
            prop.load(input);
            return prop.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }

    public static void waitForSpecificTime(final long timeToWait) {
        Uninterruptibles.sleepUninterruptibly(timeToWait, TimeUnit.MILLISECONDS);
    }

    public static void waitElementIsVisible(WebElement element, long timeoutInSec) {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), timeoutInSec);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitElementIsVisible(WebElement element) {
        waitElementIsVisible(element, DEFAULT_TIMEOUT);
    }

    public static void waitAndClick(WebElement element, long timeOutInSec) {
        waitElementIsVisible(element, timeOutInSec);
        element.click();
    }

    public static void waitAndClick(WebElement element) {
        waitAndClick(element, DEFAULT_TIMEOUT);
    }

    public static boolean isElementPresents(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait
                    (SeleniumDriver.getDriver(), IWaitTimeConstants.GLOBAL_WAIT_TIME_MAX_MS);
            //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public static boolean isElementExists(final WebElement element) {
        try {
            element.getText();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean verifyElementPresent(String locator) {
        try {
            SeleniumDriver.getDriver().findElement(By.xpath(locator));
            return true;
        } catch (Exception var2) {
            return false;
        }
    }
}
