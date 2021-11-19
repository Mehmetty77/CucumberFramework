@selenium_grid
Feature: verify_application_title
  @grid_chrome
  Scenario: verify_title_on_chrome
    Given user is on the application_login page with chrome
    Then verify the title includes Resortsline
  @grid_firefox
  Scenario: verify_title_on_firefox
    Given user is on the application_login page with firefox
    Then verify the title includes Resortsline

    #    NOTES:
#  1. Register HUB
#  -Change Directory and RUn code: java -jar selenium-server-standalone-3.141.59.jar -role hub
#  2. Register node for chrome:
#  -Change Directory and run code:
#  java -Dwebdriver.chrome.driver="/Users/techproed/Documents/selenium libraries/drivers/chromedriver" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.0.14:4444/grid/register -port 4445
#  3. Register node for firefox:
#  -Change Directory and run code:
#  java -Dwebdriver.gecko.driver="/Users/techproed/Documents/selenium libraries/drivers/geckodriver" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.0.14:4444/grid/register -port 4446
#  4. Write your feature file and step defs
#    @grid_firefox
#  Scenario: verify_title_on_firefox
#    Given user is on the application_login page with firefox
#    Then verify the title includes Resortsline
#     @Given("user is on the application_login page with firefox")
#    public void user_is_on_the_application_login_page_with_firefox() {
#    }