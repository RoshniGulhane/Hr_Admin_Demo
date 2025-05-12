package com.admin.in.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HolidayPage {
	
	WebDriver driver;
	 @FindBy(xpath="//input[@placeholder='Holiday Name']")
	    WebElement hname;

	    @FindBy(xpath="//input[@placeholder='Select the date']")
	    WebElement holidayDate;
	    
	    @FindBy(xpath = "//button[normalize-space()='Add Holiday']")
	    WebElement addHolidayButton;

	   
	    public HolidayPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

		public void enterHolidayName(String name) {
	    	hname.sendKeys(name);
	    }

	    public void enterDate(String hdate) {
	    	holidayDate.sendKeys(hdate);
	    }
	    
	    public void clickLogin() {
	    	addHolidayButton.click();
	    }
	    
	    
	    
	    public void addHoliday(String name,String date ) {
			 driver.findElement(By.cssSelector("button[class='w-full md:w-52 min-h-12 bg-[#7151F3] rounded-xl text-white px-4 py-2']")).click();

	    	 enterHolidayName(name);
			 enterDate(date);
			 
			 try {
					Thread.sleep(7000);
					clickLogin();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
	    }
	    
	    public void searchEditHoliday() {
	    	 WebElement searchButton = driver.findElement(By.xpath("//input[@placeholder='Search holidays...']"));
	    	 searchButton.sendKeys("jay Shree Ram");
	    	 
	    	 WebElement editButton = driver.findElement(By.cssSelector("button[class='bg-transparent border border-blue-500 hover:bg-blue-500 text-yellow-600 hover:text-yellow-600 duration-300 px-3 py-1 rounded-lg']"));
	    	 editButton.click();
	    	 
	    	 WebElement editHday = driver.findElement(By.xpath("//input[@placeholder='Holiday Name']"));
	    	 editHday.clear();
	    	 editHday.sendKeys("jay Shree Ram");
	    	
	    	 WebElement editHdayDate = driver.findElement(By.xpath("//input[@placeholder='Select the date']"));
	    	 editHdayDate.clear();
	    	 editHdayDate.sendKeys("15-05-2025");
			
			 WebElement updateButton = driver.findElement(By.xpath("//button[normalize-space()='Update Holiday']"));
			 updateButton.click();
			 
			 
	    }
	    public void deleteHoliday() {
	    	try {
	    	 
	    	driver.get("https://bluehr.in/holidays"); // Replace with actual URL
            driver.manage().window().maximize();

            Thread.sleep(2000); // Optional static wait (use WebDriverWait in production)

            String holidayToDelete = "jay Shree Ram";

            // Dynamic XPath to locate the delete button for the specific holiday
            String deleteXPath = "//td[contains(text(),'" + holidayToDelete + "')]/following-sibling::td[last()]//button | " +
                                 "//td[contains(text(),'" + holidayToDelete + "')]/following-sibling::td[last()]//i[contains(@class,'fa-trash')]";

            WebElement deleteBtn = driver.findElement(By.xpath(deleteXPath));
            deleteBtn.click();

            // Optional: Handle JS alert if shown after delete click
            try {
                driver.switchTo().alert().accept();
            } catch (Exception e) {
                // No alert
            }
            System.out.println("Deleted holiday: " + holidayToDelete);

        } catch (Exception e) {
            e.printStackTrace();
        }
	    }
}

    

