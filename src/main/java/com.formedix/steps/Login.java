package com.formedix.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    private WebDriver driver;
    @Given("^I am on the Home page \"(.*?)\"$")
    public void i_am_on_the_Home_page(String url){
        WebDriverManager.chromedriver().setup();
         driver =new ChromeDriver();
        driver.get(url);

    }

    @When("^I enter user name in the user name field as \"(.*?)\"$")
    public void i_enter_user_name_in_the_user_name_field_as(String username)  {
        driver.findElement(By.id("username")).sendKeys(username);

    }

    @When("^I enter password in the password field as \"(.*?)\"$")
    public void i_enter_password_in_the_password_field_as(String password)  {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("^I click on sign in button$")
    public void i_click_on_sign_in_button(){
        driver.findElement(By.id("btnSubmit")).click();
    }

    @When("^I click on respository menu item$")
    public void i_click_on_respository_menu_item(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"historyHeader\"]/span[2]")));
        String actual=driver.findElement(By.xpath("//*[@id=\"historyHeader\"]/span[2]")).getText();
        Assert.assertEquals("RECENT",actual);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("menuMdb")));
        driver.findElement(By.id("menuMdb")).click();
    }

    @When("^I click on studies sub menu item$")
    public void i_click_on_studies_sub_menu_item(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menuMdbStudies\"]/span/span")));
        driver.findElement(By.xpath("//*[@id=\"menuMdbStudies\"]/span/span")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"crumb-containerList\"]/span[2]/span[1]")));
        String actual=driver.findElement(By.xpath("//*[@id=\"crumb-containerList\"]/span[2]/span[1]")).getText();
        Assert.assertEquals("Studies",actual);
    }

    @When("^I click on tech study link$")
    public void i_click_on_tech_study_link(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("fdxMdbContainerListItem0Name")));
        driver.findElement(By.id("fdxMdbContainerListItem0Name")).click();
    }

    @When("^I click on data acquisition option$")
    public void i_click_on_data_acquisition_option(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("dataAcquisitionName")));
        driver.findElement(By.id("dataAcquisitionName")).click();
    }

    @When("^I click on forms option$")
    public void i_click_on_forms_option(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("FORMTypeName")));
        driver.findElement(By.id("FORMTypeName")).click();
    }

    @When("^I click on medical history form$")
    public void i_click_on_medical_history_form(){
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"uuid-be7ff048-01f1-4bbe-998c-7f1072f24a21\"]/div/div/span[2]/div[1]")));
        driver.findElement(By.xpath("//*[@id=\"uuid-be7ff048-01f1-4bbe-998c-7f1072f24a21\"]/div/div/span[2]/div[1]")).click();
    }

    @When("^I click on edit button$")
    public void i_click_on_edit_button(){
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(By.id("switchEditMode")));
        driver.findElement(By.id("switchEditMode")).click();
    }

    @When("^I enter description in the description field as \"(.*?)\"$")
    public void i_enter_description_in_the_description_field_as(String description)  {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"assetLocaleEditTextTextareadescriptiontest_locale\"]")));
        driver.findElement(By.xpath("//*[@id=\"assetLocaleEditTextTextareadescriptiontest_locale\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"assetLocaleEditTextTextareadescriptiontest_locale\"]")).sendKeys(description);
    }


    @When("^I click on validate and update button$")
    public void i_click_on_validate_and_update_button(){
        driver.findElement(By.id("saveAsset")).click();
        new WebDriverWait(driver, 20).
                until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("formDescription")));
        String actual = driver.findElement(By.id("formDescription")).getText();
        Assert.assertEquals("description updated", actual);
    }

    @When("^I click on menu user$")
    public void i_click_on_menu_user(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("menuUser")));
        driver.findElement(By.id("menuUser")).click();
    }

    @When("^I click on sign out option$")
    public void i_click_on_sign_out_option(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("menuUserLogout")));
        driver.findElement(By.id("menuUserLogout")).click();
    }

    @Then("^I should be able to sign out successfully$")
    public void i_should_be_able_to_sign_out_successfully() throws InterruptedException {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[1]")));
        String actual=driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]")).getText();
        Assert.assertEquals("You have signed out.",actual);
        Thread.sleep(5000);
        driver.close();
    }
}
