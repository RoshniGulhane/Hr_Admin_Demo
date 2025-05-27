package com.admin.in.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	
	    WebDriver driver;

	   
	    @FindBy(xpath = "//input[contains(@placeholder,'Enter Your Task')]")
	    WebElement taskInput;

	    @FindBy(xpath = "//button[normalize-space()='ADD']")
	    WebElement addTaskButton;

	    public DashboardPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void addTaskToDailyList(String taskName) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(taskInput)).sendKeys(taskName);
	        wait.until(ExpectedConditions.elementToBeClickable(addTaskButton)).click();
	    }
	    	public void updateTask(String taskName, String updatedName) {
	    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

	    	    // Find the task by its text and click its corresponding edit icon
	    	    WebElement taskRow = wait.until(ExpectedConditions.visibilityOfElementLocated(
	    	        By.xpath("//li[.='" + taskName + "']/following-sibling::div//svg[@data-testid='EditIcon']")));
	    	    taskRow.click();

	    	    // Clear and update input
	    	    WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(
	    	        By.xpath("//input[@placeholder='Enter Your Task']")));
	    	    input.clear();
	    	    input.sendKeys(updatedName);

	    	    // Click the update button
	    	    WebElement updateBtn = wait.until(ExpectedConditions.elementToBeClickable(
	    	        By.xpath("//button[normalize-space()='UPDATE']")));
	    	    updateBtn.click();
	    	}

	    	public void deleteTask(String taskName) {
	    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

	    	    // Find the delete icon for the given task name
	    	    WebElement deleteIcon = wait.until(ExpectedConditions.elementToBeClickable(
	    	        By.xpath("//li[.='" + taskName + "']/following-sibling::div//svg[@data-testid='DeleteIcon']")));
	    	    deleteIcon.click();
	    	}
	    public void goToAddEmployee() {
	    	try {
				Thread.sleep(2000);
				 driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(2)")).click();	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    } 
	    public void goToHolidays() {
	    	try {
				Thread.sleep(2000);
				 driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(8) > p:nth-child(2)")).click();
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } 
	    public void goToPayroll() {
	    	try {
				Thread.sleep(5000);
				 driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(7)")).click();
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }  
	    
	    public void goToDepartment() {
	    	try {
				Thread.sleep(7000);
				 driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(4)")).click();
				 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }  
	    public void goToMessanger() {
	    	try {
				Thread.sleep(5000);
				 driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(6) > p:nth-child(2)")).click();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }  
	
	    public void goToAttendance() {
	    	try {
				Thread.sleep(5000);
				 driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(4) > p:nth-child(2)")).click();	 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }  
	    public void goToTask() {
	    	try {
				Thread.sleep(7000);
				 driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(9)")).click();	 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }  
	    public void goToSetting() {
	    	try {
				Thread.sleep(6000);
				 driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(10)")).click();	 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }  
	    public void goToSupport() {
	    	try {
				Thread.sleep(6000);
				 driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(12)")).click();	 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }  
	    public void goToLeave() {
	    	try {
				Thread.sleep(7000);
				 driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(11)")).click();	 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }  

	    
	    
}
