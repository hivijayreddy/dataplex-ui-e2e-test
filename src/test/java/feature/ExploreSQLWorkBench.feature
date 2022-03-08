Feature: SQL WorkBench Creation

  @TC01-Create_and_Run_SQL_WorkBench_Queries_successfully
  Scenario: User is able to Create the SQL WorkBench
    Given Open Dataplex Project for SQLWorkBench
    Then Click Explore Tab
    Then Save Query with Name
    Then Enter Query To Run
    Then Run the Query
    Then Wait till Query is Completed
    Then Verify the Query status is Succeeded or not