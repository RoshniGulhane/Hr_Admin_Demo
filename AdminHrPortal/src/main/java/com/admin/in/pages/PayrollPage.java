package com.admin.in.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PayrollPage {

	WebDriver driver;

	    @FindBy(css="#employeeSelect")
	    WebElement selectEmp;
	    
	    @FindBy(css="body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > select:nth-child(2)")
	    WebElement selectSal;
	    
		/*
		 * @FindBy(css="select[name='department']") WebElement selectDept;
		 */
	   
	    
	    @FindBy(xpath="//input[@placeholder='Designation']")
	    WebElement designetion;
	    
	    
	    @FindBy(css="select[name='monthAndYear']")
	    WebElement monthYear;
	    
	    @FindBy(css="select[name='status']")
	    WebElement selectSts;
	    
	    @FindBy(xpath = "//button[normalize-space()='Add Payroll']")
	    WebElement addpayrollbtn;

	    // Actions
	    
	    public PayrollPage(WebDriver driver) {
	    	 this.driver = driver;
	         PageFactory.initElements(driver, this);
		}

		public void selectEmployee() {
	        Select dropdown = new Select(selectEmp);
	        dropdown.selectByIndex(2);
	    }
	    
	    public void selectSalery() {
	        Select dropdown = new Select(selectSal);
	        dropdown.selectByIndex(2);
	    }
	    
//	    public void selectDepartment() {
//	        Select dropdown = new Select(selectDept);
//	        dropdown.selectByIndex(1);
//	    }
	    public void enterDesignetion(String design) {
	    	designetion.sendKeys(design);
	    }
	    
	    public void selectMonthYear() {
	        Select dropdown = new Select(monthYear);
	        dropdown.selectByIndex(2);
	    }
	    
	    public void selectStatus() {
	        Select dropdown = new Select(selectSts);
	        dropdown.selectByIndex(2);
	    }
	   
	    public void clickLogin() {
	    	addpayrollbtn.click();
	    }
	    
	    public void addPayroll(String design ) {
			 driver.findElement(By.cssSelector(".btn_addedit.justify-center.items-center")).click();

	    	selectEmployee();
	    	selectSalery();
	    	
	    	enterDesignetion(design);
	    	selectMonthYear();
	    	selectStatus();
	    	try {
				Thread.sleep(10000);
				clickLogin();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	    
	    public void addSalStructure() {
	    	driver.get("http://13.201.253.18:3000/Payrollr/payroll");
	    	
	    	 WebElement salStructureButton = driver.findElement(By.xpath("//button[normalize-space()='Salary Structure']"));
	    	 salStructureButton.click();
	    	 
	    	 WebElement addsalButton = driver.findElement(By.xpath("//button[normalize-space()='Add Sal']"));
	    	 addsalButton.click();
	    	 
	    	 WebElement enterCtcField = driver.findElement(By.xpath("//input[@placeholder='Enter CTC...']"));
	    	 enterCtcField.sendKeys("2LPA");
	    	 
	    	 WebElement enterbasicSal = driver.findElement(By.xpath("//input[@placeholder='Enter basic Salary...']"));
	    	 enterbasicSal.sendKeys("43543");
	    	 
	    	 WebElement enterHouseRentAll = driver.findElement(By.xpath("//input[@placeholder='Enter house Rent Allowance...']"));
	    	 enterHouseRentAll.sendKeys("5689");
	    	 
	    	 WebElement specialAllowance = driver.findElement(By.xpath("//input[@placeholder='Enter special Allowance...']"));
	    	 specialAllowance.sendKeys("5000");
	    	 
	    	 WebElement enterLeaveAndTravel = driver.findElement(By.xpath("//input[@placeholder='Enter leave And Travel Allowance...']"));
	    	 enterLeaveAndTravel.sendKeys("2000");
	    	 
	    	 WebElement enterOtherAllow = driver.findElement(By.xpath("//input[@placeholder='Enter other Allowance...']"));
	    	 enterOtherAllow.sendKeys("1000");
	    	 
	    	 WebElement enterPF = driver.findElement(By.xpath("//input[@placeholder='Enter PF Employee Contribution...']"));
	    	 enterPF.sendKeys("675");
	    	 
	    	 WebElement enterProfTax = driver.findElement(By.xpath("//input[@placeholder='Enter professional Tax...']"));
	    	 enterProfTax.sendKeys("400");
	    	 
	    	 WebElement enterLeaveDed = driver.findElement(By.xpath("//input[@placeholder='Enter leave Deductions...']"));
	    	 enterLeaveDed.sendKeys("657");
	    	 
	    	 WebElement enterOtherDed = driver.findElement(By.xpath("//input[@placeholder='Enter other Deduction...']"));
	    	 enterOtherDed.sendKeys("876");
	    	 
	    	 WebElement saveButton = driver.findElement(By.xpath("(//button[normalize-space()='SUBMIT'])[1]"));
	    	 saveButton.click();
	    	 
	    	 
	    }
	
	    	
	   


}
