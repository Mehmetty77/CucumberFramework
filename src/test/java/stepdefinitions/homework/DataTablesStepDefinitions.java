package stepdefinitions.homework;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

import pages.DataTablesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class DataTablesStepDefinitions {

    DataTablesPage dataPage=new DataTablesPage();
    String searchName;

    @Given("user is on the web page")
    public void user_is_on_the_web_page() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("data_tables_web"));
        //dataPage.newButton.click();

        Thread.sleep(1000);
    }
    @And("user enters all required informations")
    public void user_enters_all_required_fields(DataTable memberData) {

//        List<String> memberInfo=memberData.row(1);
//        searchName=memberInfo.get(0);
//        dataPage.firstName.sendKeys(memberInfo.get(0));
//        dataPage.lastName.sendKeys(memberInfo.get(1));
//        dataPage.position.sendKeys(memberInfo.get(2));
//        dataPage.office.sendKeys(memberInfo.get(3));
//        dataPage.extension.sendKeys(memberInfo.get(4));
//        dataPage.startDate.sendKeys(memberInfo.get(5));
//        dataPage.salary.sendKeys(memberInfo.get(6));




    }
    @When("user clicks on create button")
    public void user_clicks_on_create_button() {

    dataPage.createButton.click();
    }
    @When("user types on search button")
    public void user_types_on_search_button() {

     dataPage.searchBox.sendKeys(searchName);
    }
    @Then("user verifies the name field")
    public void user_verifies_the_name_field() {
     String foundName=dataPage.nameField.getText();
        Assert.assertTrue(foundName.contains(searchName));
    }

    ExcelUtil excelUtil;
    List<Map<String, String>> testData;


    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("data_tables_web"));
        dataPage = new DataTablesPage();
        Thread.sleep(1000);
        dataPage.newButton.click();

    }

    @Given("user enters all  informations and creates new member")
    public void user_enters_all_informations_and_creates_new_member(DataTable memberData) throws InterruptedException {

        List<List<String>> memberInfo=memberData.asLists();
    List<String> memberPersonalInfo=memberInfo.get(0);

        for (int i=1;i<memberPersonalInfo.size();i++){

        memberPersonalInfo=memberInfo.get(i);

        setUp();

                    searchName=memberPersonalInfo.get(0);
        dataPage.firstName.sendKeys(memberPersonalInfo.get(0));
        dataPage.lastName.sendKeys(memberPersonalInfo.get(1));
        dataPage.position.sendKeys(memberPersonalInfo.get(2));
        dataPage.office.sendKeys(memberPersonalInfo.get(3));
        dataPage.extension.sendKeys(memberPersonalInfo.get(4));
        dataPage.startDate.sendKeys(memberPersonalInfo.get(5));
        dataPage.salary.sendKeys(memberPersonalInfo.get(6));
            dataPage.createButton.click();
            Thread.sleep(1000);


    }

    }

    @Given("user enters info with excel")
    public void user_enters_info_with_excel() throws InterruptedException {
            String path="src/test/resources/testdata/data_tables_workbook.xlsx";
    String sheetName="data_tables_sheet";
    excelUtil=new ExcelUtil(path,sheetName);
        List<Map<String,String>> memberInfo=excelUtil.getDataList();
        Map<String,String > memberPersonalInfo=memberInfo.get(0);


//        System.out.println(memberInfo);
//        System.out.println(memberPersonalInfo);

        for (int i=0;i<memberInfo.size();i++){
            memberPersonalInfo=memberInfo.get(i);

            setUp();

            dataPage.firstName.sendKeys(memberPersonalInfo.get("firstname"));
            dataPage.lastName.sendKeys(memberPersonalInfo.get("lastname"));
            Thread.sleep(2000);
            dataPage.position.sendKeys(memberPersonalInfo.get("position"));
            dataPage.office.sendKeys(memberPersonalInfo.get("office"));
            dataPage.extension.sendKeys(memberPersonalInfo.get("extension"));
            dataPage.startDate.click();
            dataPage.day.click();
            dataPage.salary.sendKeys(memberPersonalInfo.get("salary"));
            dataPage.createButton.click();
            Thread.sleep(1000);
        }


        }




    @Then("user verifies name with excel")
    public void user_verifies_name_with_excel() throws InterruptedException {
        String path="src/test/resources/testdata/data_tables_workbook.xlsx";
        String sheetName="data_tables_sheet";
        excelUtil=new ExcelUtil(path,sheetName);
        List<Map<String,String>> memberInfo=excelUtil.getDataList();
        Map<String,String > memberPersonalInfo;

//        System.out.println(memberInfo);
//        System.out.println(memberPersonalInfo);

        for (int i=0;i<memberInfo.size();i++){
            memberPersonalInfo=memberInfo.get(i);
            System.out.println(memberPersonalInfo.get("firstname"));
            System.out.println(memberPersonalInfo.get("lastname"));
            dataPage.searchBox.sendKeys(memberPersonalInfo.get("firstname"));
           // ReusableMethods.waitForVisibility(dataPage.nameField,3);
            Thread.sleep(2000);
            Assert.assertEquals(memberPersonalInfo.get("firstname")+" "+memberPersonalInfo.get("lastname"),dataPage.nameField.getText());
            dataPage.searchBox.clear();
            Thread.sleep(2000);
        }

    }






}
