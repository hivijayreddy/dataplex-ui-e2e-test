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

package dataplex.e2e.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * SQL WorkBench Locators
 */

public class EnvironmentSQLWorkbenchLocators {

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Explore') and contains(@class,'cfc-page-displayName')]")
    public static WebElement clickExplore;

    @FindBy(how = How.XPATH, using = "(//*[@icon='arrow-drop-down'])[2]")
    public static WebElement expandProject;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),' More results ')]")
    public static WebElement clickMoreResults;

    @FindBy(how = How.XPATH, using = "//*[@data-ph='Filter by ID or name']")
    public static WebElement enterLakeNameInExploreFilter;

    @FindBy(how = How.XPATH, using = "(//*[@icon='arrow-drop-down'])[3]")
    public static WebElement expandLake;

    @FindBy(how = How.XPATH, using = "//*[@class='cfc-filter-label cfc-flex-no-shrink']")
    public static WebElement clickEnvFilter;

    @FindBy(how = How.XPATH, using = "//*[@data-ph='Filter environments']")
    public static WebElement enterEnvironmentNameInFilter;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'SQL Queries') and contains(@class,'ng-star-inserted')]")
    public static WebElement clickSQLQueries;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'NEW QUERY')]")
    public static WebElement clickNewQuery;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Save')]")
    public static WebElement clickSave;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Job Information') " +
            "and contains(@class,'mat-tab-label-content')]")
    public static WebElement clickJobInformation;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Status ')]")
    public static WebElement verifyJobStatus;


    @FindBy(how = How.XPATH, using = "//span[contains(text(),'More')]")
    public static WebElement clickMore;

    @FindBy(how = How.XPATH, using = "//*[@class='view-lines monaco-mouse-cursor-text']")
    public static WebElement clickFrame;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Format Query') and contains(@class,'cfc-menu-item-label')]")
    public static WebElement clickFormatQuery;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),' Save Query ') and contains(@class,'cfc-menu-item-label')]")
    public static WebElement clickSaveQuery;

    @FindBy(how = How.XPATH, using = "//input[@formcontrolname='queryPath']")
    public static WebElement enterQueryPathName;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),' Lake ') and contains(@class,'ng-tns-c')]")
    public static WebElement clickLakeDropdown;

    @FindBy(how = How.XPATH, using = "(//*[contains(text(),' Save ') and contains(@class,'mat-button-wrapper')])[2]")
    public static WebElement clickSaveToSaveSQL;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),' Run ') and contains(@class,'mat-button-wrapper')]")
    public static WebElement clickRun;

    @FindBy(how = How.XPATH, using = "//*[contains(@class, 'ace-select-body cfc-select-body ng-star-inserted')]")
    public static WebElement listOfLakes;

    @FindBy(how = How.XPATH, using = "//*[@aria-label='info environment selected icon']")
    public static WebElement clickOnUsingEnvironment;


}
