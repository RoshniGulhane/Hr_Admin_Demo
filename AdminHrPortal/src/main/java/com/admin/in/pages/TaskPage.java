package com.admin.in.pages;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.Select;

	public class TaskPage {
	    WebDriver driver;

	    public TaskPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void taskAssign() throws InterruptedException {
	        driver.get("http://13.201.253.18:3000/task/EmployeeAssign");

	        WebElement projTitle = driver.findElement(By.xpath("(//input[@placeholder='Enter project title'])[1]"));
	        projTitle.sendKeys("aaaa");

	        WebElement addTask = driver.findElement(By.xpath("//input[@placeholder='Task Title']"));
	        addTask.sendKeys("hrmodule");

	        WebElement pointsBox = driver.findElement(By.xpath("//input[@placeholder='Points']"));
	        pointsBox.sendKeys("1");
	        Thread.sleep(500);
	        pointsBox.sendKeys("4");
	        Thread.sleep(500);
	        pointsBox.sendKeys("2");
	        Thread.sleep(500);

	        WebElement addTaskButton = driver.findElement(By.xpath("//button[normalize-space()='Add Task']"));
	        addTaskButton.click();

	        WebElement selectEmp = driver.findElement(By.cssSelector("select[class='w-full px-4 py-3 bg-black text-white border border-gray700 rounded-lg focus:outline-none focus:ring-2 focus:ring-tablepurple']"));
	        Select dropdown = new Select(selectEmp);
	        dropdown.selectByIndex(2);

	        WebElement deadlineDate = driver.findElement(By.xpath("//input[@id='datePicker']"));
	        deadlineDate.sendKeys("21-11-2008");

	        WebElement assignProjectBtn = driver.findElement(By.xpath("//button[normalize-space()='Assign Project']"));
	        assignProjectBtn.click();

	        WebElement progressField = driver.findElement(By.cssSelector(".flex.items-center.text-white[href='/task/EmployeeProgress']"));
	        progressField.click();
	    }
	

	 
}
