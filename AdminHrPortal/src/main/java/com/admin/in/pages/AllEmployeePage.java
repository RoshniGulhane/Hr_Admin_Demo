package com.admin.in.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllEmployeePage {

	WebDriver driver;

	// Web Elements using PageFactory
	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement emailId;

	@FindBy(xpath = "//button[normalize-space()='Generate ID']")
	WebElement userId;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastName;

	@FindBy(css = "select[name='type']")
	WebElement typeDropdown;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement userPwd;

	@FindBy(xpath = "//input[@type='file']")
	WebElement uploadDocumentInput;

	@FindBy(xpath = "//button[normalize-space()='Register']")
	WebElement registerButton;

	// Actions
	public void enterEmailId(String email) {
		emailId.sendKeys(email);
	}

	public void userId() {
		userId.click();
	}

	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void selectEmployeeType() {
		Select dropdown = new Select(typeDropdown);
		dropdown.selectByIndex(2);
	}

	public void enterPassword(String password) {
		userPwd.sendKeys(password);
	}

	public void uploadDocument(String filePath) {
		uploadDocumentInput.sendKeys(filePath); // must be an absolute path
	}

	public void clickLogin() {
		registerButton.click();
	}

	public AllEmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * @FindBy(xpath = "//tbody/tr[2]") List<WebElement> employeeRows;
	 */

	public void addEmployee(String email, String fname, String lname, String filePath, String password) {

		driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();
		enterEmailId(email);
		userId();
		enterFirstName(fname);
		enterLastName(lname);
		selectEmployeeType();
		enterPassword(password);
		uploadDocument(filePath);
		try {
			Thread.sleep(10000);
			clickLogin();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void editEmployee(String targetName) throws InterruptedException {
		 
		driver.get("http://13.201.253.18:3000/allemployees"); // Update URL
        driver.manage().window().maximize();

        
        boolean isFound = false;

        while (true) {
            // Wait briefly for rows to load
            Thread.sleep(1000); // Use WebDriverWait in real-world usage

            // Locate all rows in the table body
            List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

            for (WebElement row : rows) {
                String name = row.findElement(By.xpath("//p[contains(@class,'truncate')][normalize-space()='roshani bijwe']")).getText(); // Assuming name is in column 2
                if (name.equalsIgnoreCase(targetName)) {
                    // Found the target name
                    WebElement editButton = row.findElement(By.xpath(".//button[contains(text(), 'Add/Edit')]"));
                    editButton.click();
                    isFound = true;
                    break;
                }
            }

           if (isFound) break;

//            // Check if 'Next' button is enabled and clickable
//            WebElement nextButton = driver.findElement(By.xpath("//button[text()='>']"));
//            String classAttr = nextButton.getAttribute("class");
//            if (classAttr != null && classAttr.contains("disabled")) {
//                System.out.println("Name not found in any page.");
//                break;
//            } else {
//                nextButton.click();
//            }
        }

        // Example of editing form after clicking Edit (optional)
        if (isFound) {
		Thread.sleep(2000);
		WebElement persanlInfo = driver.findElement(
				By.cssSelector(".flex.items-center.gap-2.px-4.py-2.rounded-md.border-b-2.border-blue-500"));
		persanlInfo.click();
		// Now edit the form
		WebElement imageField = driver.findElement(By.cssSelector("input[name='image']"));
		imageField.clear();
		imageField.sendKeys("C:\\Users\\HP\\Downloads\\ABC.pdf");

		WebElement mobileField = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
		mobileField.clear();
		mobileField.sendKeys("9832987062");

		WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
		emailField.clear();
		emailField.sendKeys("ramNam@gmail.com");

		WebElement dobField = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
		dobField.clear();
		dobField.sendKeys("01-08-2001");

		WebElement statusField = driver.findElement(By.xpath("//select[@name='maritalStatus']"));
		Select dropdown = new Select(statusField);
		dropdown.selectByIndex(1);

		WebElement genderField = driver.findElement(By.xpath("//select[@name='gender']"));
		Select dropdown1 = new Select(genderField);
		dropdown1.selectByIndex(1);

		WebElement nationalField = driver.findElement(By.xpath("//select[@name='nationality']"));
		Select dropdown2 = new Select(nationalField);
		dropdown2.selectByIndex(1);

		WebElement cityField = driver.findElement(By.xpath("//input[@placeholder='City']"));
		cityField.sendKeys("Wardha");

		WebElement stateField = driver.findElement(By.xpath("//input[@placeholder='State']"));
		stateField.sendKeys("Maharashtra");

		WebElement zipCodeField = driver.findElement(By.xpath("//input[@placeholder='ZIP Code']"));
		zipCodeField.sendKeys("442302");

		WebElement savePDButton = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		savePDButton.click();
		// ****************************************************************************************************
		// Professional Information
		Thread.sleep(2000);
		WebElement profInfo = driver.findElement(By.cssSelector(
				"body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(2) > button:nth-child(1) > p:nth-child(2)"));
		profInfo.click();

		WebElement whoField = driver.findElement(By.cssSelector("select[name='employeeType']"));
		Select whoDropdown1 = new Select(whoField);
		whoDropdown1.selectByIndex(1);

		WebElement profEmailField = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
		profEmailField.sendKeys("asewd@gmail.com");

		WebElement deptField = driver.findElement(By.xpath("//select[@name='department']"));
		Select deptDropdown1 = new Select(deptField);
		deptDropdown1.selectByIndex(1);

		WebElement desiField = driver.findElement(By.xpath("//input[@placeholder='Enter Designation']"));
		desiField.sendKeys("fgdtrd");

		WebElement profDateField = driver.findElement(By.xpath("//input[contains(@name,'joiningDate')]"));
		profDateField.sendKeys("01-03-2025");

		WebElement offLocField = driver.findElement(By.xpath("//select[@name='officeLocation']"));
		Select offLocFieldDrop = new Select(offLocField);
		offLocFieldDrop.selectByIndex(1);

		WebElement saveProfInfoButton = driver.findElement(By.cssSelector("button[type='submit']"));
		saveProfInfoButton.click();

		// ******************************************************************************************************************************
		Thread.sleep(2000);
		WebElement DocumentInfo = driver.findElement(By.cssSelector(".flex.items-center.gap-2.px-4.py-2.rounded-md.border-b-2.border-blue-500"));
		DocumentInfo.click();

		// Document
		WebElement appoinmentField = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > div:nth-child(1) > div:nth-child(1) > label:nth-child(2)"));
		appoinmentField.clear();
		appoinmentField.sendKeys("C:\\Users\\HP\\Downloads\\ABC.pdf");

		WebElement uploadSalaryField = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > div:nth-child(1) > div:nth-child(2) > label:nth-child(2)"));
		uploadSalaryField.clear();
		uploadSalaryField.sendKeys("C:\\Users\\HP\\Downloads\\ABC.pdf");

		WebElement relievingField = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > div:nth-child(1) > div:nth-child(3) > label:nth-child(2)"));
		relievingField.clear();
		relievingField.sendKeys("C:\\Users\\HP\\Downloads\\ABC.pdf");

		WebElement experienceField = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > div:nth-child(1) > div:nth-child(4) > label:nth-child(2)"));
		experienceField.clear();
		experienceField.sendKeys("C:\\Users\\HP\\Downloads\\ABC.pdf");

		WebElement saveDocButton = driver.findElement(By.cssSelector("button[type='submit']"));
		saveDocButton.click();

		// ***************************************************************************************************************************************
		// Banking Details
		Thread.sleep(2000);
		WebElement bankingDetails = driver.findElement(By.cssSelector(
				"body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(4) > button:nth-child(1)"));
		bankingDetails.click();

		WebElement bankNameField = driver.findElement(By.xpath("//input[@placeholder='Bank Name']"));
		bankNameField.sendKeys("Axis");

		WebElement accHNameField = driver.findElement(By.xpath("//input[@placeholder='Account Holder Name']"));
		accHNameField.sendKeys("Roshni G");

		WebElement accNumField = driver.findElement(By.xpath("//input[@placeholder='Account Number']"));
		accNumField.sendKeys("123345566778");

		WebElement ifscField = driver.findElement(By.xpath("//input[@placeholder='IFSC Code']"));
		ifscField.sendKeys("1234");

		WebElement saveBankDetailsButton = driver.findElement(By.cssSelector("button[type='submit']"));
		saveBankDetailsButton.click();

		// **********************************************************************************************************************************
		// Account Access
		Thread.sleep(2000);
		WebElement accountAccess = driver.findElement(By.cssSelector(
				"body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(5) > button:nth-child(1) > p:nth-child(2)"));
		accountAccess.click();

		WebElement emailIdField = driver.findElement(By.xpath("//input[@placeholder='Enter Email ID']"));
		emailIdField.sendKeys("eeeeesa12@gmail.com");

		WebElement slackIdField = driver.findElement(By.xpath("//input[@placeholder='Enter Slack ID']"));
		slackIdField.sendKeys("ssssa12@gmail.com");

		WebElement skypeIdField = driver.findElement(By.xpath("//input[@placeholder='Enter Skype ID']"));
		skypeIdField.sendKeys("ewwwsa12@gmail.com");

		WebElement gitIdField = driver.findElement(By.xpath("//input[@placeholder='Enter GitHub ID']"));
		gitIdField.sendKeys("eeetytya12@gmail.com");

		WebElement saveAccButton = driver.findElement(By.cssSelector("button[type='submit']"));
		saveAccButton.click();

		System.out.println("Employee details updated successfully!");

	
 }


}
	// *****************************************************************************************************************************************
	// Search and View Employee

	public void searchAndViewEmployee() throws InterruptedException {
		WebElement searchButton = driver.findElement(By.cssSelector("input[placeholder='Search employees...']"));
		searchButton.sendKeys("Rani Radhe");

	}
	//################################################################################################################################
	
	
	public void clickViewForEmployee(String employeeName) throws InterruptedException {
		driver.get("http://13.201.253.18:3000/allemployees");
	    boolean employeeFound = false;

	    while (!employeeFound) {
	    	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	        // Find all rows in the employee table
	        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody/tr"));
	        
	        for (WebElement row : rows) {
	            String name = row.findElement(By.xpath(".//td[1]")).getText().trim();

	         // Updated inside the for loop in your method
	            if (name.equalsIgnoreCase(employeeName)) {
	                WebElement viewIcon = row.findElement(By.xpath("//tbody/tr[4]/td[5]/div[1]/button[1]"));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewIcon);
	                wait.until(ExpectedConditions.elementToBeClickable(viewIcon)).click();
	                System.out.println("Clicked view for: " + employeeName);
	                employeeFound = true;
	                break;
	            }

	        }

	        if (!employeeFound) {
	            try {
	                WebElement nextButton = driver.findElement(By.xpath("//button[contains(text(), 'Next')]"));
	                if (nextButton.isEnabled()) {
	                    nextButton.click();
	                    Thread.sleep(1000); // wait for table to load
	                } else {
	                    break;
	                }
	            } catch (NoSuchElementException e) {
	                break;
	            }
	        }
	    }

	    if (!employeeFound) {
	        throw new RuntimeException("Employee '" + employeeName + "' not found in the list.");
	    }
	}


	// ********************************************************************************************************************************************
	// Delete Employee
	public void deleteEmployee() throws InterruptedException {

		driver.get("http://13.201.253.18:3000/allemployees");

		/*Thread.sleep(2000);

		// Dynamic XPath to find the delete button for "Roshni Bijawe"
		String employeeName = "Roshni Bijawe";
		String deleteIconXPath = "//td[contains(text(),'" + employeeName
				+ "')]/following-sibling::td[last()]//button[contains(@class,'delete')] | " + "//td[contains(text(),'"
				+ employeeName + "')]/following-sibling::td[last()]//i[contains(@class,'fa-trash')]";

		// Click the delete button/icon
		WebElement deleteButton = driver.findElement(By.xpath(deleteIconXPath));
		deleteButton.click();

		// Handle confirmation alert if any
		driver.switchTo().alert().accept(); // Optional: Only if a JS alert appears

		System.out.println("Employee '" + employeeName + "' deleted successfully.");
		*/
		// Navigate to your app
       // driver.get("http://your-app-url.com"); // Replace with actual HRMS URL
		Thread.sleep(2000);
		        try {
		            // Dynamic XPath to find row with "Roshni Bijawe" and click the corresponding delete icon
		            String employeeName = "Roshni Bijawe";
		            String dynamicXpath = "//tr[td[contains(text(), '" + employeeName + "')]]//button[contains(@class, 'delete')]";

		            WebElement deleteButton = driver.findElement(By.xpath(dynamicXpath));
		            deleteButton.click();

		            // Switch to alert and accept
		            Alert alert = driver.switchTo().alert();
		            System.out.println("Alert message: " + alert.getText());
		            alert.accept();

		            System.out.println(employeeName + " deleted successfully.");
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            // Optionally close the browser
		            driver.quit();
		        }
		    }
		

       
    

	

}
