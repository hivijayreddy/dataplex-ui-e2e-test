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

import dataplex.e2e.pages.actions.ExploreNotebookActions;
import dataplex.e2e.pages.actions.LakeActions;
import dataplex.e2e.utils.DataplexHelper;
import dataplex.e2e.utils.IWaitTimeConstants;
import dataplex.e2e.utils.SeleniumDriver;
import dataplex.e2e.utils.SeleniumHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * Explore notebook Step Definitions
 */
public class ExploreNotebook implements DataplexHelper {

    @Given("Open Dataplex Project")
    public void openDataplexProject() throws IOException, InterruptedException {
        openDataplex();
    }

    @Given("Open BigQuery NoteBook")
    public void openBQNoteBook() throws IOException, InterruptedException {
        openBQNotebookURL();
    }

    @Given("Open GCS NoteBook")
    public void openGCSNoteBook() throws IOException, InterruptedException {
        openGCSNotebookURL();
    }

    @Then("^Click on Create button to Create Lake$")
    public void click_on_create_button_to_create_lake() throws Throwable {
        LakeActions.createLake();
    }

    @Then("^Enter Display name$")
    public void enter_display_name() throws Throwable {
        LakeActions.enterLakeDisplayname();
    }

    @Then("^Enter Lake ID$")
    public void enter_lake_id() throws Throwable {
        LakeActions.enterLakeID();
    }

    @Then("^Enter Description$")
    public void enter_description() throws Throwable {
        LakeActions.enterLakeDescription();
    }

    @Then("^Click on Create button to Save the Lake$")
    public void click_on_create_button_to_save_the_lake() throws Throwable {
        LakeActions.saveLake();
    }

    @Then("^Click on Manage Tab$")
    public void click_managetab() throws Throwable {
        LakeActions.clickManageTab();
    }

    @Then("^Search For Created Lake$")
    public void search_lake() throws Throwable {
        LakeActions.lakeFilter();
    }

    @Then("^Wait till Lake is in Active State and Open Created Lake$")
    public void open_lake() throws Throwable {
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 24000000);
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@class='ng-star-inserted' and contains(@href,'/dataplex/lakes')]")));
        LakeActions.clickOnLake();
    }


    @Then("Wait till Environment is in Active state")
    public void waitTillEnvActiveState() throws InterruptedException {
        ExploreNotebookActions.envFilter();
        Boolean bool = true;
        WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 24000000);
//        wait.until(ExpectedConditions.or(ExpectedConditions.
//                        visibilityOfElementLocated(By.xpath("//*[@aria-label='Active']")),
//                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Failed']"))));
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@class='ng-star-inserted' and contains(@href,'/dataplex/lakes')]")));
        SeleniumHelper.waitForSpecificTime(IWaitTimeConstants.GLOBAL_WAIT_TIME_TWO_SEC_MS);
    }

    @Then("^Create Environment$")
    public void create_Environment() throws Throwable {
        ExploreNotebookActions.createEnvironment();
    }

    @Then("^Delete Environment$")
    public void delete_Environment() throws Throwable {
        ExploreNotebookActions.deleteEnvironment();
    }

    @Then("^Create Environment with Minimum Length$")
    public void environment_minlength() throws Throwable {
        ExploreNotebookActions.createEnvironmentWithMinimumLength();
    }

    @Then("^Create Environment with Maximum Length$")
    public void environment_maxlength() throws Throwable {
        ExploreNotebookActions.createEnvironmentWithMaximumLength();
    }

    @Then("^Make Environment as Default$")
    public void env_Default() throws Throwable {
        ExploreNotebookActions.envFilter();
        ExploreNotebookActions.envMakeDefault();
    }

    @Then("^Create and Open Notebook$")
    public void create_Notebook() throws Throwable {
        ExploreNotebookActions.createNotebook();
    }

    @Then("^Run BigQuery Notebook$")
    public void run_BQNotebook() throws Throwable {
        ExploreNotebookActions.runBQNotebook();
    }

    @Then("^Run GCS Notebook$")
    public void run_GCSNotebook() throws Throwable {
        ExploreNotebookActions.runGCSNotebook();
    }
}
