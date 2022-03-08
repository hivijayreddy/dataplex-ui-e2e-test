$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/feature/Task.feature");
formatter.feature({
  "name": "Spark \u0026 PySpark Job Creation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User is able to Create the Spark SQL Task",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@TC01-Create_Spark_Job_successfully"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open Dataplex Project For Task",
  "keyword": "Given "
});
formatter.match({
  "location": "Task.openDataplexProject()"
});
