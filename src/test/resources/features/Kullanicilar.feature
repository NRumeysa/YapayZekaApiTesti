# encoding: UTF-8
Feature: User Operations Test

  Scenario: Check User List
    Given user list is retrieved from first page
    Then list should be retrieved successfully

  Scenario: Create New User
    Given a new user is created
    Then user should be created successfully

  Scenario: Update User
    Given a user is updated
    Then user should be updated successfully

  Scenario: Delete User
    Given a user is deleted
    Then user should be deleted successfully