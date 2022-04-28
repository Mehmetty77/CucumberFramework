package stepdefinitions.homework;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import pages.SchubertPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Iterator;
import java.util.Set;

public class Schubert {


    SchubertPage schubi = new SchubertPage();


    @Given("go to schubert page")
    public void goToSchubertPage() throws InterruptedException {
        Driver.getDriver().get("https://www.schubert-verlag.de/aufgaben/uebungen_b2/b2_konjunktiv-eins3.htm");
        Driver.getDriver().manage().window().maximize();
        Thread.sleep(2000);
        ReusableMethods.clickWithJS(schubi.trafficLights);


    }

    @And("localise texts")
    public void localiseTexts() throws InterruptedException, AWTException {
        Robot robot = new Robot();
        robot.mouseMove(400,5); // Navigating through mouse hover. Note that the coordinates might differ, kindly check the coordinates of x and y axis and update it accordingly.
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);

        System.out.println(Driver.getDriver().getTitle());
        System.out.println(Driver.getDriver().getWindowHandle());

        String parent = Driver.getDriver().getWindowHandle();
        Set<String> s = Driver.getDriver().getWindowHandles();

        Iterator<String> I1 = s.iterator();

        while (I1.hasNext()) {

            String child_window = I1.next();

            if (!parent.equals(child_window)) {
                Driver.getDriver().switchTo().window(child_window);

            }
        }
        System.out.println(Driver.getDriver().getTitle());
        System.out.println(Driver.getDriver().getWindowHandle());
        Driver.getDriver().manage().window().maximize();
//    }
    }
}
