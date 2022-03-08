Feature: Environment Creation
#  @TC01-Create_an_environment_successfully
#    Scenario: User is able to Create the Environment
#      Given Open Dataplex Project
#      Then Click on Create button to Create Lake
#      Then Enter Display name
#      Then Enter Lake ID
#      Then Enter Description
#      Then Click on Create button to Save the Lake
#      Then Search For Created Lake
#      Then Wait till Lake is in Active State and Open Created Lake
#      Then Create Environment
#      Then Wait till Environment is in Active state
#
#  @TC02-Delete_an_environment_successfully
#    Scenario: User is able to Delete the Environment
#      Then Delete Environment

#  @TC02-Create_an_environment_with_minimum_environment_id_length_of_1
#    Scenario: User is able to Create the Environment with id length of 1
#      Then Click on Manage Tab
#      Then Search For Created Lake
#      Then Wait till Lake is in Active State and Open Created Lake
#      Then Create Environment with Minimum Length
#      Then Wait till Environment is in Active state
#
#  @TC03-Create_an_environment_with_maximum_environment_id_length_of_63
#    Scenario: User is able to Create the Environment with id length of 63
#      Then Click on Manage Tab
#      Then Search For Created Lake
#      Then Wait till Lake is in Active State and Open Created Lake
#      Then Create Environment with Maximum Length
#      Then Wait till Environment is in Active state

#  @TC04-Create_an_environment_with_duplicate_Environment_id
#    Scenario: Fail to create an environment with duplicate environment id
#      Then Click on Manage Tab
#      Then Search For Created Lake
#      Then Wait till Lake is in Active State and Open Created Lake
#      Then Create Environment with Maximum Length
#      Then Wait till Environment is in Active state


#  @TC01-Notebook_Creation
#  Scenario: User is able to Create the Notebook
#    Given Open Dataplex Project
#    Then Click on Create button to Create Lake
#    Then Enter Display name
#    Then Enter Lake ID
#    Then Enter Description
#    Then Click on Create button to Save the Lake
#    Then Search For Created Lake
#    Then Open Created Lake
#    Then Create Environment
#    Then Wait till Environment is in Active state
#    Then Create and Open Notebook
#
#  @TC04-Run_NoteBook_with_BigQuery
#     Scenario: User is able to Run NoteBook by using BigQuery Commands
#       Given Open BigQuery NoteBook
#       Then Run BigQuery Notebook
#
  @TC05-Run_NoteBook_with_GCS
  Scenario: User is able to Run NoteBook by using GCS Commands
    Given Open GCS NoteBook
    Then Run GCS Notebook