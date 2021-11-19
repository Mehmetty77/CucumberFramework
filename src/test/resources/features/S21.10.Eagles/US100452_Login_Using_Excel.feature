Feature: FE1010_login_feature

  @excel_admin
  Scenario: admin_login
    Given user log in the application using excel admin

  @excel_manager
  Scenario: manager_login
    Given user log in the application using excel manager
    Then take the screenshot