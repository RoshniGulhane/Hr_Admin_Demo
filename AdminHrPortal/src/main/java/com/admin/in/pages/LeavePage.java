package com.admin.in.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeavePage {
	 WebDriver driver;
	    WebDriverWait wait;

	    @FindBy(xpath = "//input[@placeholder='Search']")
	    WebElement searchLeaveInput;

	    public LeavePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	public void searchLeave(String deptName) {
        wait.until(ExpectedConditions.visibilityOf(searchLeaveInput));
        searchLeaveInput.clear();
        searchLeaveInput.sendKeys(deptName);
    }
	
	public void viewLeave() throws InterruptedException {
		Thread.sleep(2000);
		 WebElement viewAllLeavePage = driver.findElement(By.xpath("//button[normalize-space()='All Leaves']"));
		 viewAllLeavePage.click();
		 
		 Thread.sleep(2000);
		 WebElement viewPendingLeavePage = driver.findElement(By.xpath("(//button[@class='px-4 py-2 rounded btn-primary'])[1]"));
		 viewPendingLeavePage.click();
		 
		 Thread.sleep(2000);
		 WebElement viewFilterPage = driver.findElement(By.xpath("//button[normalize-space()='Filter']"));
		 viewFilterPage.click();
		 
		 WebElement viewFilter = driver.findElement(By.xpath("//select[@class='input']"));
		 Select dropdown = new Select(viewFilter);
	        dropdown.selectByIndex(1);
	        
	     Thread.sleep(2000);
			 WebElement applyPage = driver.findElement(By.xpath("//button[normalize-space()='Apply']"));
			 applyPage.click();     
		}
	public void requestLeave() throws InterruptedException {
		Thread.sleep(2000);
		WebElement openRequestLeavePage = driver.findElement(By.xpath("//button[normalize-space()='Request Leave']"));
		openRequestLeavePage.click();
		
		Thread.sleep(2000);
		WebElement subjectPage = driver.findElement(By.xpath("//input[@placeholder='Subject']"));
		subjectPage.sendKeys("cdcdcdcd");
		
		Thread.sleep(2000);
		WebElement dateFromPage = driver.findElement(By.xpath("//input[@name='from']"));
		dateFromPage.sendKeys("06-05-2025");
		
		Thread.sleep(2000);
		WebElement dateToPage = driver.findElement(By.xpath("//input[@name='to']"));
		dateToPage.sendKeys("08-05-2025");
		
		 WebElement leaveType = driver.findElement(By.xpath("//select[@name='leaveType']"));
		 Select dropdown = new Select(leaveType);
	        dropdown.selectByIndex(1);
	        
	     Thread.sleep(2000);
	     WebElement descriptionPage = driver.findElement(By.xpath("//textarea[@placeholder='Enter the Description...']"));
	     descriptionPage.sendKeys("aaaaaaadfsf hfguhgfdhgkfjgkldfjgodfhgkjdf"); 
	     
	     Thread.sleep(2000);
		WebElement clickIfUrgent = driver.findElement(By.xpath("//input[@name='urgent']"));
		clickIfUrgent.click();
			
			Thread.sleep(2000);
			WebElement clickApply = driver.findElement(By.xpath("//button[normalize-space()='Apply']"));
			clickApply.click();
	     
		
		
	}
}
