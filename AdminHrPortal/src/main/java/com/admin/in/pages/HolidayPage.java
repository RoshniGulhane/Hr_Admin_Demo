package com.admin.in.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HolidayPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@placeholder='Holiday Name']")
    WebElement hname;

    @FindBy(id = "datePicker")
    WebElement holidayDate;

    @FindBy(xpath = "//button[normalize-space()='Add Holiday']")
    WebElement addHolidayButton;

    public HolidayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterHolidayName(String name) {
        hname.clear();
        hname.sendKeys(name);
    }

    public void enterDate(String hdate) {
        holidayDate.clear();
        holidayDate.sendKeys(hdate);
    }

    public void clickAddHoliday() {
        addHolidayButton.click();
    }

    public void addHoliday(String name, String date) {
        driver.findElement(By.xpath("//button[normalize-space()='Add New Holiday']")).click();
        enterHolidayName(name);
        enterDate(date);
        wait.until(ExpectedConditions.elementToBeClickable(addHolidayButton)).click();
    }

    public void searchEditHoliday(String holidayName, String newName, String newDate) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[contains(@placeholder,'Search')]")));
        searchBox.clear();
        searchBox.sendKeys(holidayName);

        // Wait for the row to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//tr[td[normalize-space()='" + holidayName + "']]")));

        // Then wait for the Edit button to be clickable
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//tr[td[normalize-space()='" + holidayName + "']]//button[contains(text(),'Edit')]")));
        editButton.click();

        wait.until(ExpectedConditions.visibilityOf(hname)).clear();
        hname.sendKeys(newName);

        holidayDate.clear();
        holidayDate.sendKeys(newDate);

        driver.findElement(By.xpath("//button[normalize-space()='Update Holiday']")).click();
    }



    public void deleteHoliday(String holidayName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String deleteXPath = "//tr[td[normalize-space()='" + holidayName + "']]//button[contains(@class,'delete')]";

            WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(deleteXPath)));
            deleteBtn.click();

            // Accept alert if present
            try {
                wait.until(ExpectedConditions.alertIsPresent());
                driver.switchTo().alert().accept();
            } catch (NoAlertPresentException e) {
                System.out.println("No alert appeared.");
            }

            System.out.println("Deleted holiday: " + holidayName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}
