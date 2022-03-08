Feature: Spark & PySpark Job Creation

  @TC01-Create_Spark_Job_successfully
  Scenario: User is able to Create the Spark SQL Task
    Given Open Dataplex Project For Task
    #      Given Open Pantheon URL of Dataplex Project For Task
    Then Click On Process Tab
    Then Click On Create Task
    Then Click on Create Custom Spark Task to Create Spark Task
    Then Select Lake from Dropdown
    Then Enter Task ID
    Then Enter GCS Path of Spark Jar
    Then Select Service Account From The Dropdown
    Then Click on Continue Button to go to Set Schedule screen
    Then Click on Create Button to Create a Spark Task
    Then Search for Created task using Filter
    Then From filter Result Click on Task
    Then Wait till Job is Succeeded Or Failed
    Then Verify the Job status is Succeeded or Not

#  @TC02-Create_PySpark_Job_successfully
#    Scenario: User is able to Create the PySpark Task
#      Given Open Pantheon URL of Dataplex Project For Task
#      Then Click On Process Tab
#      Then Click On Create Task
#      Then Click on Create Custom Spark Task to Create Spark Task
#      Then Select Lake from Dropdown
#      Then Enter Task ID
#      Then Select Type as PySpark
#      Then Enter GCS Path of PySpark File
#      Then Select Service Account From The Dropdown
#      Then Click on Continue Button to go to Set Schedule screen
#      Then Click on Create Button to Create a Spark Task
#      Then Search for Created task using Filter
#      Then From filter Result Click on Task
#      Then Wait till Job is Succeeded Or Failed
#      Then Verify the Job status is Succeeded or Not
#
#  @TC03-Create_Spark_Job_With_MainClass_successfully
#    Scenario: User is able to Create the Spark Task with MainClass
#      Given Open Pantheon URL of Dataplex Project For Task
#      Then Click On Process Tab
#      Then Click On Create Task
#      Then Click on Create Custom Spark Task to Create Spark Task
#      Then Select Lake from Dropdown
#      Then Enter Task ID
#      Then Enter Main Class Name of Spark Jar
#      Then Select Service Account From The Dropdown
#      Then Click on Continue Button to go to Set Schedule screen
#      Then Click on Continue Button to go to Customize Resources screen
#      Then Enter GCS Main Class JAR File Path
#      Then Click on Create Button to Create a Spark Task
#      Then Search for Created task using Filter
#      Then From filter Result Click on Task
#      Then Wait till Job is Succeeded Or Failed
#      Then Verify the Job status is Succeeded or Not