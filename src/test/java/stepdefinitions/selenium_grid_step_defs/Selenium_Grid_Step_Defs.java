package stepdefinitions.selenium_grid_step_defs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class Selenium_Grid_Step_Defs {
    WebDriver driver;
    @Given("user is on the application_login page with chrome")
    public void user_is_on_the_application_login_page_with_chrome() throws MalformedURLException {
//       1. Create Desired Capabilities object
        DesiredCapabilities cap=new DesiredCapabilities();
//       2. Use cap ro assign browser name and operation system
        cap.setBrowserName("chrome");
//        cap.setPlatform(Platform.MAC); //For mac
//        cap.setPlatform(Platform.WINDOWS); //for windows
        cap.setPlatform(Platform.ANY); // for either mac or windows
//       3. Merge the Chrome with Desired Capabilities
        ChromeOptions options=new ChromeOptions();
        options.merge(cap);
//       4. Create driver object using RemoteWebDriver
//         Hub URL = porturl / wd / hub
        String hubURL="http://192.168.178.28:4446/wd/hub";
        driver= new RemoteWebDriver(new URL(hubURL),options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        5. CONFIGURATIONS ARE DONE. WE CAN WRITE OUR JAVA CODES
        driver.get(ConfigReader.getProperty("app_qa_environment"));
        try{
            ReusableMethods.waitFor(1);
            driver.findElement(By.id("details-button")).click();
            ReusableMethods.waitFor(1);
            driver.findElement(By.id("proceed-link")).click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
            System.out.println("Advanced Link and Proceed Link is not displayed");
        }
    }
    @Given("user is on the application_login page with firefox")
    public void user_is_on_the_application_login_page_with_firefox() throws MalformedURLException {
DesiredCapabilities cap= new DesiredCapabilities();

cap.setBrowserName("firefox");
cap.setPlatform(Platform.ANY);

        FirefoxOptions firefoxOptions=new FirefoxOptions();
        firefoxOptions.merge(cap);

        String hubURL="http://192.168.178.28:4445/wd/hub";

        driver= new RemoteWebDriver(new URL(hubURL),firefoxOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        5. CONFIGURATIONS ARE DONE. WE CAN WRITE OUR JAVA CODES
        driver.get(ConfigReader.getProperty("app_qa_environment"));
        try{
            ReusableMethods.waitFor(1);
            driver.findElement(By.id("details-button")).click();
            ReusableMethods.waitFor(1);
            driver.findElement(By.id("proceed-link")).click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
            System.out.println("Advanced Link and Proceed Link is not displayed");
        }



    }

    @Then("verify the title includes Resortsline")
    public void verify_the_title_includes_Resortsline() {
        String title=driver.getTitle();
        Assert.assertTrue(title.contains("Resortsline"));
    }
}
