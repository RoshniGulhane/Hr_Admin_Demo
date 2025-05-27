package com.admin.in.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DepartmentPage {

	WebDriver driver;
    WebDriverWait wait;

   
    
    public DepartmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchDept(String deptName) {
    	WebElement addDeptName = driver.findElement(By.xpath("//input[@placeholder='Search Department...']"));
    	addDeptName.sendKeys("hr");

    }
    
    public void addDept() throws InterruptedException {
    	driver.get("http://13.201.253.18:3000/department");
    	driver.findElement(By.xpath("//button[normalize-space()='Add Department']")).click();
    	WebElement addDeptName = driver.findElement(By.xpath("(//input[@placeholder='Enter department name'])[1]"));
    	addDeptName.sendKeys("java");
    	WebElement deptLocation = driver.findElement(By.xpath("//input[@placeholder='Enter department location']"));
    	deptLocation.sendKeys("Hyderabad");
    	
    	WebElement deptActive =driver.findElement(By.xpath("(//div[@class='w-12 h-6 rounded-full bg-gray-600 relative'])[1]"));
    	deptActive.click();
    	WebElement saveDept =driver.findElement(By.xpath("//button[normalize-space()='Save Department']"));
    	saveDept.click();
    	
    	// Switch to alert and handle it
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text is: " + alert.getText());
        alert.accept(); // Click OK

      Thread.sleep(2000);
        WebElement cancleBtn = driver.findElement(By.xpath("//button[normalize-space()='Cancel']"));
        cancleBtn.click(); 
    }
   
    public void addDeptMember() throws InterruptedException {
    	driver.get("http://13.201.253.18:3000/department");
    	driver.findElement(By.xpath("//button[normalize-space()='Add Member']")).click();
    	
    	WebElement selectEmp = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > section:nth-child(4) > div:nth-child(1) > div:nth-child(1) > form:nth-child(2) > select:nth-child(1)"));
		Select selectEmpDrop = new Select(selectEmp);
		selectEmpDrop.selectByIndex(1);
		
		WebElement selectType = driver.findElement(By.xpath("body/div[@id='root']/div[contains(@class,'layout-container flex flex-col md:flex-row bg-black scrollbar-hide overflow-hidden')]/div[2]"));
		Select selectTypeDrop = new Select(selectType);
		selectTypeDrop.selectByIndex(3);
		
		WebElement saveDeptMember =driver.findElement(By.xpath("//button[normalize-space()='Add']"));
		saveDeptMember.click();
		
		Thread.sleep(2000);
		WebElement cancleBtn =driver.findElement(By.xpath("//button[normalize-space()='Cancel']"));
		cancleBtn.click();
		
		
    }
}
