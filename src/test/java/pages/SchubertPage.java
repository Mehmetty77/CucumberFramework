package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SchubertPage {
    public SchubertPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath ="/html/body/center/table/tbody/tr[2]/td[2]/table[2]/tbody/tr[6]/td[2]/a" )
    public WebElement trafficLights;

    @FindBy (xpath ="(//a[contains(@onmouseout,\"myPop\" )])[3]" )
    public WebElement answerPopUp;


}
