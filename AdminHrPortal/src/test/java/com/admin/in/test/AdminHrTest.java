package com.admin.in.test;

import org.testng.annotations.Test;

import com.admin.in.core.BaseTest;
import com.admin.in.pages.AllEmployeePage;
import com.admin.in.pages.DashboardPage;
import com.admin.in.pages.DepartmentPage;
import com.admin.in.pages.LeavePage;
import com.admin.in.pages.LoginPage;
import com.admin.in.pages.MessangerPage;
import com.admin.in.pages.PayrollPage;
import com.admin.in.pages.SettingPage;
import com.admin.in.pages.TaskPage;





public class AdminHrTest extends BaseTest {
	
	 @Test(priority = 1)
	    public void loginTest() throws InterruptedException {
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login("adminuser@yopmail.com", "Bluehr@1234");
	    }
	 @Test(priority = 2)
	    public void dashboardTest() throws InterruptedException {
	        DashboardPage dashboardPage = new DashboardPage(driver);
	        dashboardPage.dashboard("hrModule");
	       
	    }
	 
//	 @Test(priority = 3)
//	    public void updateDashboardTest() throws InterruptedException {
//	        DashboardPage dashboardPage = new DashboardPage(driver);
//	        dashboardPage.updateTask();
//	       
//	    }
	 @Test(priority = 4)
	    public void deleteDashboardTest() throws InterruptedException {
	        DashboardPage dashboardPage = new DashboardPage(driver);
	        dashboardPage.deleteTask();
	       
	    }
	 @Test(priority = 5)
	    public void addEmployeeTest() {
	        DashboardPage dashboardPage = new DashboardPage(driver);
	        dashboardPage.goToAddEmployee();
	        String filePath ="C:\\Users\\HP\\Downloads\\ABC.pdf";

	        AllEmployeePage addEmployeePage = new AllEmployeePage(driver);
	        addEmployeePage.addEmployee( "tresd@gmail.com","Rani", "Radhe",filePath,"RaniRadheA@64");
	 }
//	 @Test(priority = 4)
//	    public void editEmployeeTest() throws InterruptedException {
//	        DashboardPage dashboardPage = new DashboardPage(driver);
//	        dashboardPage.goToAddEmployee();
//	        AllEmployeePage addEmployeePage = new AllEmployeePage(driver);
//	        addEmployeePage.editEmployee("roshani bijwe");
//	 }
	 @Test(priority = 6)
	    public void searchEmployeeTest() throws InterruptedException {
	        DashboardPage dashboardPage = new DashboardPage(driver);
	        dashboardPage.goToAddEmployee();
	        AllEmployeePage addEmployeePage = new AllEmployeePage(driver);
	        addEmployeePage.searchAndViewEmployee();
	 }
//	 @Test(priority = 7)
//	    public void viewEmployeeTest() throws InterruptedException {
//	        DashboardPage dashboardPage = new DashboardPage(driver);
//	        dashboardPage.goToAddEmployee();
//	        AllEmployeePage addEmployeePage = new AllEmployeePage(driver);
//	        addEmployeePage.clickViewForEmployee("Rani Radhe");
//	 }
//	 @Test(priority = 7)
//	    public void departmentTest() throws InterruptedException {
//	        DashboardPage dashboardPage = new DashboardPage(driver);
//	        dashboardPage.goToDepartment();
//	        DepartmentPage departmentPage = new DepartmentPage(driver);
//	        departmentPage.searchDept("testing");
//	 }
//	 @Test(priority = 8)
//	    public void deptAddTest() throws InterruptedException {
//	        DashboardPage dashboardPage = new DashboardPage(driver);
//	        dashboardPage.goToDepartment();
//	        DepartmentPage departmentPage = new DepartmentPage(driver);
//	        departmentPage.addDept();
//	 }
//	 @Test(priority = 9)
//	    public void deptMemberTest() throws InterruptedException {
//	        DashboardPage dashboardPage = new DashboardPage(driver);
//	        dashboardPage.goToDepartment();
//	        DepartmentPage departmentPage = new DepartmentPage(driver);
//	        departmentPage.addDeptMember();
//	 }
	 @Test(priority = 10)
	    public void payrollTest() throws InterruptedException {
	        DashboardPage dashboardPage = new DashboardPage(driver);
	        dashboardPage.goToPayroll();
	        PayrollPage payPage = new PayrollPage(driver);
	       
	 }
	 @Test(priority = 11)
	    public void massengerTest() throws InterruptedException {
	        DashboardPage dashboardPage = new DashboardPage(driver);
	        dashboardPage.goToMessanger();
	        MessangerPage message = new MessangerPage(driver);
	        //message.searchMsg("Deepanshu Sharma");
	 }
	 @Test(priority = 12)
	    public void taskTest() throws InterruptedException {
	        DashboardPage dashboardPage = new DashboardPage(driver);
	        dashboardPage.goToTask();
	        TaskPage taskpage = new TaskPage(driver);
	        //message.searchMsg("Deepanshu Sharma");
	 }
	 @Test(priority = 13)
	    public void settingTest() throws InterruptedException {
	        DashboardPage dashboardPage = new DashboardPage(driver);
	        dashboardPage.goToSetting();
	        SettingPage mesg = new SettingPage(driver);
	        //message.searchMsg("Deepanshu Sharma");
	 }
	 @Test(priority = 14)
	    public void leaveTest() throws InterruptedException {
	        DashboardPage dashboardPage = new DashboardPage(driver);
	        dashboardPage.goToLeave();
	        LeavePage leavePage = new LeavePage(driver);
	        //message.searchMsg("Deepanshu Sharma");
	 }
}
