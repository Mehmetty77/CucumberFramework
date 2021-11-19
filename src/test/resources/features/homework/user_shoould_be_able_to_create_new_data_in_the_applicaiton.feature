@creating_member_test
  Feature: Create_Member_With_Credentials
    @create_new_member
    Scenario: TC01_user_should_create_a_new_member
      Given user is on the web page
      And user enters all required informations
        |FirstName  |LastName  |Position|Office     |Extension |StartDate     |Salary    |
        |Sam        |Walker    |teacher |NYC        |123       |2023-05-10    |90000      |
      When user clicks on create button
      And user types on search button
      Then user verifies the name field
      And take the screenshot
      And close the application

      @verify_member_test
      Scenario Outline: Verify_Member_With_Search_Button
        Given user is on the web page
        And user enters all  informations and creates new member
        When user types on search button
        Then user verifies the name field
        And take the screenshot
        And close the application
        Examples: member_data
        |firstname|	lastname	|position|	office	|extension|	startdate|	salary|
        |John	    |Walker	|teacher|	NYC|	123|	2023-05-10	|90000|
        |Adam	    |Brown	|QA|	TX	|234|	2023-05-10|	100000|
        |Sue	     |Jackson |	Manager|	LONDON	|345|	2023-05-10|	120000|
        |Sam	|Walker|	teacher|	NYC	|123|	2023-05-10|	90000|
        |Vince	|Brown	|QA|	TX	|234	|2023-05-10	|100000|
        |Ali	|Jackson	|Manager	|LONDON	|345|	2023-05-10	|120000|

        @verify_member_with_excel
        Scenario: Verify_Member_With_ExcelUtil
          Given user is on the web page
          When user enters info with excel
          Then user verifies name with excel
          And take the screenshot
          And close the application

