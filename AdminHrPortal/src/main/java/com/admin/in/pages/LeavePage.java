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
		 WebElement viewPendingLeavePage = driver.findElement(By.cssSelector(".px-4.py-2.rounded.btn-primary"));
		 viewPendingLeavePage.click();
		 
		 Thread.sleep(2000);
		 WebElement viewFilterPage = driver.findElement(By.xpath("//button[normalize-space()='Filter']"));
		 viewFilterPage.click();
		 
		 WebElement viewFilterSelectEmp = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > select:nth-child(1)"));
		 Select dropdown = new Select(viewFilterSelectEmp);
	        dropdown.selectByIndex(1);
	        
	        WebElement viewSelectYr = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > select:nth-child(2)"));
			 Select dropdown1 = new Select(viewSelectYr);
		        dropdown1.selectByIndex(1);
		        
		        
	     Thread.sleep(2000);
			 WebElement applyPage = driver.findElement(By.xpath("//button[normalize-space()='Apply']"));
			 applyPage.click();     
		}
	
	public void searchLeave() throws InterruptedException {
		 WebElement searchLeavePage = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		 searchLeavePage.sendKeys("fedf");
		 
//		 WebElement addNotePage = driver.findElement(By.xpath("//input[@placeholder='Add note...']"));
//		 addNotePage.sendKeys("aaaa");
//		 
//		 WebElement selectPayStsPage = driver.findElement(By.xpath("(//select[@class='input mt-2'])[1]"));
//		 Select dropdown1 = new Select(selectPayStsPage);
//	        dropdown1.selectByIndex(1);
//		 
//		 WebElement approveBtnPage = driver.findElement(By.xpath("//button[@class='btn_approved']"));
//		 approveBtnPage.click();
		 
		 
	}
	
		
		
	
}
