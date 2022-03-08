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
 * Locators for Lake
 */

public class LakeLocators {
    @FindBy(how = How.XPATH, using = "//*[@data-mat-icon-name='create']")
    public static WebElement createLakeButton;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Display name') and contains(@class,'ng-star-inserted')]")
    public static WebElement clickLakeDisplayName;

    @FindBy(how = How.XPATH, using = "(//*[contains(@id,'_0rif_mat-input')])[1]")
    public static WebElement enterLakeDisplayName;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'ID') and contains(@class,'ng-star-inserted')]")
    public static WebElement clickLakeID;

    @FindBy(how = How.XPATH, using = "(//*[contains(@id,'_0rif_mat-input')])[2]")
    public static WebElement enterLakeID;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Description') and contains(@class,'ng-star-inserted')]")
    public static WebElement clickLakeDescription;

    @FindBy(how = How.XPATH, using = "(//*[contains(@id,'_0rif_mat-input')])[3]")
    public static WebElement enterLakeDescription;

    @FindBy(how = How.XPATH, using = "//*[@type='submit']")
    public static WebElement lakeCreation;

    @FindBy(how = How.XPATH, using = "(//*[@class='cfc-page-displayName'])[1]")
    public static WebElement clickManage;

    @FindBy(how = How.XPATH, using = "//*[@class='cfc-filter-label cfc-flex-no-shrink']")
    public static WebElement clickFilter;

    @FindBy(how = How.XPATH, using = "//*[@data-ph='Filter instances']")
    public static WebElement enterLakeNameInFilter;

    @FindBy(how = How.XPATH, using = "//table//tbody//tr//td[3]")
    public static WebElement verifyLakeStatus;

    @FindBy(how = How.XPATH, using = "//*[@class='ng-star-inserted' and contains(@href,'/dataplex/lakes')]")
    public static WebElement clickLake;

}
