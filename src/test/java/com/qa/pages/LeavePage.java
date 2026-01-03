package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;

import cucumber.api.Scenario;

public class LeavePage {
	
	WebDriver driver;
	Scenario scenario;
	
	// Page object repo
		@FindBy(xpath = "//span[text()='Leave']")
		WebElement leavePageLink;
		
		@FindBy(xpath = "//h6[text()='Leave']")
		WebElement leavePagetitle;

		@FindBy(xpath = "//span[text()='Configure ']")
		WebElement configureMenu;
		
		@FindBy(xpath = "//a[text()='Leave Types']")
		WebElement leaveTypesOption;
		
		@FindBy(xpath = "//button[text()=' Add ']")
		WebElement addLeaveButton;
		
		@FindBy(xpath = "//h6[text()='Add Leave Type']/following::input[1]")
		WebElement leaveTypeField;
		
		@FindBy(xpath = "// button[text()=' Save ']")
		WebElement saveButton;
		
		@FindBy(xpath = "//div[@class='oxd-table-card']/child::div/child::div[2]")
		WebElement newlyAddedLEaveTypeText;
		
		@FindBy(xpath = "//button/i[@class='oxd-icon bi-pencil-fill']")
		WebElement editLeaveTypeButton;
		
		@FindBy(xpath = "//h6[text()='Edit Leave Type']/following::input[1]")
		WebElement editLeaveTypeField;
		
		@FindBy(xpath = "//button/i[@class='oxd-icon bi-trash']")
		WebElement deleteLeaveTypeButton;
		
		@FindBy(xpath = "//button[text()=' Yes, Delete ']")
		WebElement deleteLeaveTypeconfirmButton;
		
		// Page class Constructor
		
		public LeavePage (WebDriver driver, Scenario scenario){
			
			this.driver = driver;
			this.scenario = scenario;
			PageFactory.initElements(driver, this);
			
		}
		
		// Page operation methods
		
		
		/**
		 * @return-----
		 * This method will navigate to LeavePage
		 */
		public String navigateToLeavePage(){
			
			ElementActions.clickElement(driver, leavePageLink, scenario);
			return ElementActions.getText(driver, leavePagetitle, scenario);
			
			
		}
		
		/**
		 * ----This Method will launch config menu
		 */
		public void launchConfigMenu(){
			ElementActions.clickElement(driver, configureMenu, scenario);
		}
		
		
		/**
		 * -----This method will launch leave page type
		 */
		public void launchLeaveTypePage(){
			ElementActions.clickElement(driver, leaveTypesOption, scenario);
		}
		
		
		/**
		 * @param leaveTypeName
		 * This Method will add new leave type
		 */
		public void addNewLeaveType(String leaveTypeName){
			ElementActions.clickElement(driver, addLeaveButton, scenario);
			ElementActions.sendKeys(driver, leaveTypeField, scenario, leaveTypeName);
			ElementActions.clickElement(driver, saveButton, scenario);
			
		}
		
		/**
		 * @return
		 * This method will return newly added leave type
		 */
		public String getNewlyaddedLeaveType(){
			 return ElementActions.getText(driver, newlyAddedLEaveTypeText, scenario);
		}
		
		
		/**
		 * @param texttoAppend --
		 * this method will edit newly added leave type
		 */
		public void editLeaveType(String texttoAppend){
			ElementActions.clickElement(driver, editLeaveTypeButton, scenario);
			ElementActions.sendKeys(driver, editLeaveTypeField, scenario, texttoAppend);
			ElementActions.clickElement(driver, saveButton, scenario);
			
		}
		
		/**
		 * This Method will delete leave type
		 */
		public void deleteLeaveType(){
			
			ElementActions.clickElement(driver, deleteLeaveTypeButton, scenario);
			ElementActions.clickElement(driver, deleteLeaveTypeconfirmButton, scenario);
			
		}
	

}
