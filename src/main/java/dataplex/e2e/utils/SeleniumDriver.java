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

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Represents SeleniumDriver
 */
public class SeleniumDriver {

    private static final Logger logger = LoggerFactory.getLogger(SeleniumDriver.class);
    public static final int TIMEOUT = 50;
    public static final int PAGE_LOAD_TIMEOUT = 50;
    public static WebDriverWait waitDriver;
    public static URL url;
    private static SeleniumDriver seleniumDriver;
    private static ChromeDriver chromeDriver;

    SeleniumDriver() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-setuid-sandbox");
//        chromeOptions.addArguments("--disable-web-security", "--user-data-dir", "--allow-running-insecure-content");
       chromeOptions.addArguments("--headless");
       chromeOptions.addArguments("--window-size=" + SeleniumHelper.readParameters("windowSize"));
        chromeOptions.setAcceptInsecureCerts(true);
//        chromeOptions.setHeadless(true);
        chromeOptions.addArguments("--disable-gpu");
//        chromeOptions.addArguments("--proxy-server='direct://'");
//        chromeOptions.addArguments("--proxy-bypass-list=*");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-extensions");
//        chromeOptions.setExperimentalOption("excludeSwitches", enable-automation);
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.addArguments("--disable-features=VizDisplayCompositor");
        chromeOptions.addArguments
                ("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36");
        chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.manage().window().maximize();
        HttpCommandExecutor executor = (HttpCommandExecutor) chromeDriver.getCommandExecutor();
        url = executor.getAddressOfRemoteServer();
        waitDriver = new WebDriverWait(chromeDriver, TIMEOUT);
        chromeDriver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        String window = chromeDriver.getWindowHandle();
        SessionId session = chromeDriver.getSessionId();
        logger.info("Session iD:" + session);
        logger.info("Window ->" + window);
    }

    public static SessionId session() {
        SessionId session = chromeDriver.getSessionId();
        return session;
    }

    public static void getWaitDriver() {
        new WebDriverWait(chromeDriver, 40000).
                until(ExpectedConditions.invisibilityOf(chromeDriver.findElement(By.className("loading-bar"))));
    }

    public static void openPage(String url) {
        logger.info(url);
        logger.info(String.valueOf(chromeDriver));
        chromeDriver.get(url);
    }

    public static WebDriver getDriver() {
        return chromeDriver;
    }

    public static void setUpDriver() throws IOException {
        if (seleniumDriver == null) {
            seleniumDriver = new SeleniumDriver();
        }
    }

    public static void tearDown() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
        seleniumDriver = null;
    }

    public static void waitForPageToLoad() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            logger.error("page load interrupted" + e);
        }
    }
}
