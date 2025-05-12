package com.admin.in.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	    WebDriver driver;

	    By username = By.xpath("(//input[@placeholder='abc@gmail.com'])[1]");
	    By password = By.xpath("//input[@placeholder='Password']");
	    By adminpr=By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > section:nth-child(1) > div:nth-child(2) > div:nth-child(5) > label:nth-child(1) > span:nth-child(2)");
	    By remember=By.xpath("//input[@class='cursor-pointer']");
	    By loginBtn = By.xpath("//button[@type='submit']");
	    
	    By otpButton=By.cssSelector("button[type='submit']");

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void login(String user, String pass) throws InterruptedException {
	        driver.findElement(username).sendKeys(user);
	        driver.findElement(password).sendKeys(pass);
	        driver.findElement(adminpr).click();
	        driver.findElement(remember).click();
	        driver.findElement(loginBtn).click();
	        Thread.sleep(20000);
	        driver.findElement(otpButton).click();
	    }
	


}
