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

import dataplex.e2e.pages.actions.ExploreSQLWorkbenchActions;
import dataplex.e2e.utils.DataplexHelper;
import dataplex.e2e.utils.SeleniumHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.io.IOException;

/**
 * Explore SQL WorkBench Step Definitions
 */

public class ExploreSQLWorkbench implements DataplexHelper {

    @Given("Open Dataplex Project for SQLWorkBench")
    public void openDataplexProject() throws IOException, InterruptedException {
        openDataplex();
    }

    @Then("^Click Explore Tab$")
    public void clickExploreTAB() throws Throwable {
        ExploreSQLWorkbenchActions.clickExploreTAB();
    }

    @Then("^Save Query with Name$")
    public void saveQuerywithName() throws Throwable {
        ExploreSQLWorkbenchActions.saveQuerywithName();
    }

    @Then("^Enter Query To Run$")
    public void enterQueryToRun() throws Throwable {
        ExploreSQLWorkbenchActions.enterQueryToRun();
    }

    @Then("^Run the Query$")
    public void runQuery() throws Throwable {
        ExploreSQLWorkbenchActions.runQuery();
    }

    @Then("^Wait till Query is Completed$")
    public void runQuwaitforQueryExecutionery() throws Throwable {
        ExploreSQLWorkbenchActions.waitforQueryExecution();
    }

    @Then("Verify the Query status is Succeeded or not")
    public void verifyThePipelineStatusIs() {
        Assert.assertTrue("Query execution is Failed",
                SeleniumHelper.verifyElementPresent("//*[contains(text(),' SUCCEEDED ')]"));
    }
}
