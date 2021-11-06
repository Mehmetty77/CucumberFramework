package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.GooglePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Day17_GoogleSearchStepDefinitions {
    /*This step definition class will have JAVA CODE
     * */
    GooglePage googlePage = new GooglePage();
    @Given("user is on the google page")
    public void user_is_on_the_google_page() throws InterruptedException {
      Driver.getDriver().get(ConfigReader.getProperty("google_url"));
        TimeUnit.SECONDS.sleep(1);
      Driver.getDriver().findElement(By.xpath("(//div[@class='jyfHyd'])[2]")).click();
        TimeUnit.SECONDS.sleep(1);
    }
    @Given("user search for iPhone")
    public void user_search_for_i_phone() {
        googlePage.googleSearchBox.sendKeys("iPhone"+ Keys.ENTER);
    }
    @Then("verify the result has iPhone")
    public void verify_the_result_has_i_phone() {
        String title=Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("iPhone"));
    }
    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }

    @Given("user search for tea pot")
    public void user_search_for_tea_pot() {
        googlePage.googleSearchBox.sendKeys("tea pot"+Keys.ENTER);
    }
    @Then("verify the result has tea pot")
    public void verify_the_result_has_tea_pot() {
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("tea pot"));
    }

    @Given("user search for flower")
    public void user_search_for_flower() {
        googlePage.googleSearchBox.sendKeys("flowers"+Keys.ENTER);
    }
    @Then("verify the result has flower")
    public void verify_the_result_has_flower() {
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("flower"));
    }



    @Given("user search for tesla")
    public void user_search_for_tesla() {
        googlePage.googleSearchBox.sendKeys("tesla"+Keys.ENTER);
    }
    @Then("verify the result has tesla")
    public void verify_the_result_has_tesla() {
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("tesla"));
    }
    @Given("user search for {string}")
    public void user_search_for(String string) {
       googlePage.googleSearchBox.sendKeys(string+Keys.ENTER);
    }
    @Then("verify the result has {string}")
    public void verify_the_result_has(String string) {
      String title= Driver.getDriver().getTitle();
      Assert.assertTrue(title.contains(string));
    }





}