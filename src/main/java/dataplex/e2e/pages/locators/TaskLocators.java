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
 * Locators for Task
 */
public class TaskLocators {
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Process') and contains(@class,'cfc-page-displayName')]")
    public static WebElement clickProcessTab;

    @FindBy(how = How.XPATH, using = "//ace-icon[@icon = 'create']")
    public static WebElement clickCreateTask;

    @FindBy(how = How.XPATH, using = "(//*[contains(text(),'CREATE TASK') and contains(@class,'cfc-color-active')])[2]")
    public static WebElement clickCreateCustomSparkTask;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Dataplex lake') and contains(@class,'ng-tns-c')]")
    public static WebElement selectLake;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Type to filter']")
    public static WebElement searchForLake;

    @FindBy(how = How.XPATH, using = "//*[@class='ace-option-text-highlighted']")
    public static WebElement selectLakeFromList;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'ID') and contains(@class,'ng-star-inserted')]")
    public static WebElement clickTaskID;

    @FindBy(how = How.XPATH, using = "(//*[contains(@id,'_0rif_mat-input')])[2]")
    public static WebElement enterTaskID;

    @FindBy(how = How.XPATH, using = "(//*[@data-mat-icon-name='arrow-drop-down'])[3]")
    public static WebElement clickTypeDropdpwn;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),' PySpark ') and contains(@class,'mat-option-text')]")
    public static WebElement selectPySparkType;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),' Main python file ') " +
            "and contains(@class,'ng-star-inserted')]")
    public static WebElement clickMainPythonFile;

    @FindBy(how = How.XPATH, using = "(//*[contains(@id,'_0rif_mat-input')])[4]")
    public static WebElement enterMainPythonFilePth;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),' Main class or jar file ') and contains(@class,'ng-tns-c')]")
    public static WebElement clickMainClassOrJarFile;

    @FindBy(how = How.XPATH, using = "(//*[contains(@id,'_0rif_mat-input')])[4]")
    public static WebElement enterMainClassOrJarFilePath;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),' User service account ') and contains(@class,'ng-tns-c')]")
    public static WebElement clickUserServiceAccount;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Filter']")
    public static WebElement enterServiceAccount;

    @FindBy(how = How.XPATH, using = "(//span[@class='ace-select-option-subtext cfc-select-option-subtext'])[4]")
    public static WebElement selectServiceAccount;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),' Continue ')]")
    public static WebElement clickContinue;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'JAR files') and contains(@class,'ng-tns-c')]")
    public static WebElement clickJARFiles;

    @FindBy(how = How.XPATH, using = "(//input[@aria-label='Type a value and tab to add'])[1]")
    public static WebElement enterJARFiles;

    @FindBy(how = How.XPATH, using = "(//span[contains(text(),' Create ')])[2]")
    public static WebElement clickToCreateTask;

    @FindBy(how = How.XPATH, using = "//*[@class='cfc-filter-label cfc-flex-no-shrink']")
    public static WebElement clickTaskFilter;

    @FindBy(how = How.XPATH, using = "//*[@data-ph='Filter tasks']")
    public static WebElement enterTaskNameInFilter;

    @FindBy(how = How.XPATH, using = "//*[@class='ng-star-inserted' and contains(@href,'/dataplex/process/tasks')]")
    public static WebElement clickTask;

    @FindBy(how = How.XPATH, using = "//*[@class='ng-star-inserted' and contains(@href,'/dataproc/batches')]")
    public static WebElement clickOnJobID;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),' Succeeded ')]")
    public static WebElement jobSuccess;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),' Failed ')]")
    public static WebElement jobFailed;


    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Environments') " +
            "and contains(@class,'mat-tab-link mat-focus-indicator ng-star-inserted')]")
    public static WebElement clickEnvironmentTab;

    @FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'Create environment') " +
            "and contains(@class,'mat-focus-indicator mat-button mat-button-base mat-primary')]")
    public static WebElement clickCreateEnvironment;

    @FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'Delete environment') " +
            "and contains(@class,'mat-focus-indicator mat-button mat-button-base mat-primary')]")
    public static WebElement clickDeleteEnvironment;

    @FindBy(how = How.XPATH, using = "(//*[contains(text(),'Delete') and contains(@class,'mat-button-wrapper')])[3]")
    public static WebElement confirmEnvironmentDelete;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'No environments found') " +
            "and contains(@class,'cfc-table-no-rows-message')]")
    public static WebElement verifyNoEnvironmentsFound;

    @FindBy(how = How.XPATH, using = "//*[contains(@id,'_0rif_label-name')]")
    public static WebElement clickEnvironmentDisplayName;

    @FindBy(how = How.XPATH, using = "//*[contains(@aria-labelledby,'_0rif_label-name')]")
    public static WebElement enterEnvironmentDisplayName;

    @FindBy(how = How.XPATH, using = "//*[contains(@id,'_0rif_label-id')]")
    public static WebElement clickEnvironmentID;

    @FindBy(how = How.XPATH, using = "//*[contains(@aria-labelledby,'_0rif_label-id')]")
    public static WebElement enterEnvironmentID;

    @FindBy(how = How.XPATH, using = "//*[contains(@id,'_0rif_label-description')]")
    public static WebElement clickEnvironmentDescription;

    @FindBy(how = How.XPATH, using = "//*[contains(@aria-labelledby,'_0rif_label-description')]")
    public static WebElement enterEnvironmentDescription;

    @FindBy(how = How.XPATH, using = "//*[contains(@id,'_0rif_submitButton')]")
    public static WebElement clickCreateButton;

    @FindBy(how = How.XPATH, using = "//table//tbody//tr//td[4]")
    public static WebElement verifyEnvironmentStatus;

    @FindBy(how = How.XPATH, using = "//*[@class='cfc-filter-label cfc-flex-no-shrink']")
    public static WebElement clickEnvFilter;

    @FindBy(how = How.XPATH, using = "//*[@data-ph='Filter environments']")
    public static WebElement enterEnvironmentNameInFilter;

    @FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'Select row')]")
    public static WebElement selectEnvironment;

    @FindBy(how = How.XPATH, using = "(//*[contains(text(),'Make Default')])[2]")
    public static WebElement makeEnvironmentDefault;

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

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Notebooks') and contains(@class,'ng-star-inserted')]")
    public static WebElement clickNoteBooks;

    @FindBy(how = How.XPATH, using = "//*[@aria-label='New Notebook']")
    public static WebElement createNoteBook;

    @FindBy(how = How.XPATH, using = "//*[@id='_0rif_notebook-path']")
    public static WebElement clickNoteBookPath;

    @FindBy(how = How.XPATH, using = "//*[@aria-labelledby='_0rif_notebook-path']")
    public static WebElement enterNoteBookPath;

    @FindBy(how = How.XPATH, using = "//*[@id='_0rif_label-description']")
    public static WebElement clickNoteBookDescription;

    @FindBy(how = How.XPATH, using = "//*[@aria-labelledby='_0rif_label-description']")
    public static WebElement enterNoteBookDescription;

    @FindBy(how = How.XPATH, using = "//*[@type='submit']")
    public static WebElement clickCreateNotebook;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'OPEN NOTEBOOK') and contains(@class,'mat-button-wrapper')]")
    public static WebElement clickToOpenNotebook;

    @FindBy(how = How.XPATH, using = "//*[@class='CodeMirror-line']")
    public static WebElement clickNoteBooktoWrite;

    @FindBy(how = How.XPATH, using = "//div[@class='CodeMirror-sizer']/div/div/div")
    public static WebElement enterNoteBooktoWrite;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Edit') " +
            "and contains(@class,'lm-MenuBar-itemLabel p-MenuBar-itemLabel')]")
    public static WebElement clickEdit;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Clear All Outputs') " +
            "and contains(@class,'lm-Menu-itemLabel p-Menu-itemLabel')]")
    public static WebElement clickClearOutputs;

    @FindBy(how = How.XPATH, using = "//*[@data-icon='ui-components:run']")
    public static WebElement clickRun;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Find…') " +
            "and contains(@class,'lm-Menu-itemLabel p-Menu-itemLabel')]")
    public static WebElement clickFind;

    @FindBy(how = How.XPATH, using = "//*[@class='jp-DocumentSearch-input']")
    public static WebElement enterSearchText;

    @FindBy(how = How.XPATH, using = "//*[@class='jp-DocumentSearch-index-counter']")
    public static WebElement validateSearchText;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Run') " +
            "and contains(@class,'lm-MenuBar-itemLabel p-MenuBar-itemLabel')]")
    public static WebElement selectRunFromMenu;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Run All Cells') " +
            "and contains(@class,'lm-Menu-itemLabel p-Menu-itemLabel')]")
    public static WebElement clickRunAllCells;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'File') " +
            "and contains(@class,'lm-MenuBar-itemLabel p-MenuBar-itemLabel')]")
    public static WebElement selectFileFromMenu;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Save Notebook') " +
            "and contains(@class,'lm-Menu-itemLabel p-Menu-itemLabel')]")
    public static WebElement clickSaveNoteBook;
}
