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

public class DepartmentPage {

	WebDriver driver;
    WebDriverWait wait;

    // Use @FindBy for better readability and maintainability
    @FindBy(xpath = "//input[@placeholder='Search Department...']")
    WebElement searchDeptInput;
    
    @FindBy(xpath = "//input[@placeholder='Search Department...']")
    WebElement addDeptInput;

    public DepartmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchDept(String deptName) {
        wait.until(ExpectedConditions.visibilityOf(searchDeptInput));
        searchDeptInput.clear();
        searchDeptInput.sendKeys(deptName);
    }
    
    public void addDept() {
    	driver.get("http://13.201.253.18:3000/department");
    	driver.findElement(By.xpath("//button[normalize-space()='Add Department']")).click();
    	WebElement addDeptName = driver.findElement(By.xpath("//input[contains(@placeholder,'Enter department name')]"));
    	addDeptName.sendKeys("java");
    	WebElement deptLocation = driver.findElement(By.xpath("//input[@placeholder='Enter department location']"));
    	deptLocation.sendKeys("Hyderabad");
    	
    	WebElement deptActive =driver.findElement(By.cssSelector(".w-12.h-6.rounded-full.bg-purple-600.relative"));
    	deptActive.click();
    	WebElement saveDept =driver.findElement(By.xpath("//button[normalize-space()='Save Department']"));
    	saveDept.click();
    }
    public void addDeptMember() {
    	driver.get("http://13.201.253.18:3000/department");
    	driver.findElement(By.xpath("//button[normalize-space()='Add Member']")).click();
    	
    	WebElement selectEmp = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > section:nth-child(4) > div:nth-child(1) > div:nth-child(1) > form:nth-child(2) > select:nth-child(1)"));
		Select selectEmpDrop = new Select(selectEmp);
		selectEmpDrop.selectByIndex(1);
		
		WebElement selectType = driver.findElement(By.xpath("//body/div[@id='root']/div[contains(@class,'layout-container flex flex-col md:flex-row bg-black scrollbar-hide overflow-hidden')]/div[2]"));
		Select selectTypeDrop = new Select(selectType);
		selectTypeDrop.selectByIndex(1);
		
		WebElement saveDeptMember =driver.findElement(By.xpath("//button[normalize-space()='Add']"));
		saveDeptMember.click();
    }
}
