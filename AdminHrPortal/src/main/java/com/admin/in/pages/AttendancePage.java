package com.admin.in.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AttendancePage {
	WebDriver driver;
	
	public AttendancePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void requestAtten() throws InterruptedException {
	driver.get("http://13.201.253.18:3000/attendance");
	WebElement requestField = driver.findElement(By.xpath("(//button[normalize-space()='Request'])[1]"));
	requestField.click();
//Report  button[class='text-white text-lg py-1 px-3 ']
	
	WebElement reportField = driver.findElement(By.cssSelector("button[class='text-white text-lg py-1 px-3 ']"));
	reportField.click();

	}
}
