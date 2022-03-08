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
package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.Date;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/feature/Task.feature"},
        glue = {"main.java.stepsdesign", "stepsdesign"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-html-report",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class TestRunner {

    @AfterClass
    public static void modifyReportName() {

        String basePath = System.getProperty("user.dir") + "/target/cucumber-reports/advanced-reports/extentreports/";
        Date d = new Date();
        String toName = basePath + d.toString().
                replaceAll(":", "_").replaceAll(" ", "_") + ".html";
        new File(basePath + "extentRep.html").renameTo(new File(toName));

    }


}
