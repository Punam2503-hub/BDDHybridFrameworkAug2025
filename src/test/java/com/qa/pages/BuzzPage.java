package com.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;
import com.qa.util.WaitMethods;

import cucumber.api.Scenario;

/**
 * @author Acer
 * This buzz 
 */
public class BuzzPage {
	
	WebDriver driver ;
	Scenario scenario;
	
	
	
	// page object repository

	@FindBy(xpath = "//span[text()='Buzz']")

	WebElement buzzPagelink;

	@FindBy(xpath = "//textarea[@class='oxd-buzz-post-input']")

	WebElement buzzTextfield;

	@FindBy(xpath = "//button[text()=' Post ']")

	WebElement postButton;
	
	@FindBy(xpath = "//p[text()='Edit Post']/following::button[text()=' Post ']")

	WebElement editandpostButton;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text']")

	WebElement commentText;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-time']")

	WebElement commentTime;

	@FindBy(xpath = "//div[@class='orangehrm-buzz-post-actions']/child::div[1]")

	WebElement heartIcon;

	@FindBy(xpath = "//i[@class='oxd-icon bi-heart-fill orangehrm-buzz-stats-like-icon']/following-sibling::p[@class='oxd-text oxd-text--p orangehrm-buzz-stats-active']")

	WebElement likeCount;

	@FindBy(xpath = "//i[@class='oxd-icon bi-three-dots']")

	WebElement threedotsButton;

	@FindBy(xpath = "//p[text()='Edit Post']")

	WebElement editPostButton;
	
	@FindBy(xpath = "//p[text()='Edit Post']/following::textarea[1]")

	WebElement editpostfield;

	@FindBy(xpath = "//p[text()='Delete Post']")

	WebElement deletePostButton;

	@FindBy(xpath = "//button[text()=' Yes, Delete ']")
	WebElement yesDeleteButton;
	
	
	// Page class constructor
		
		
		/**
		 * @param driver
		 * @param scenario
		 * 
		 * This is the constructor of this class
		 */
		public BuzzPage(WebDriver driver, Scenario scenario){
			
			this.driver=driver;
			this.scenario=scenario;
			PageFactory.initElements(driver, this);
			
		}
	
		

		// page operation methods

		
		/**
		 * This method will navigate to buzzpage
		 */
		public void navigateToBuzzPage() {

			ElementActions.clickElement(driver, buzzPagelink, scenario);

		}

		/**
		 * @param commenttoPost
		 * This Method will Post the comment
		 */
		public void postComment(String commenttoPost) {

			WaitMethods.staticWait(2000);
			ElementActions.sendKeys(driver, buzzTextfield, scenario, commenttoPost);
			WaitMethods.staticWait(2000);
			ElementActions.clickElement(driver, postButton, scenario);
			WaitMethods.staticWait(5000);
		}

		
		/**
		 * @return
		 * This method will verify the text and time of the comment
		 */
		public HashMap getCommenttextandTime() {
			WaitMethods.staticWait(2000);
			HashMap<String, String> objmap = new HashMap<String, String>();

			objmap.put("commentText", ElementActions.getText(driver, commentText, scenario));
			objmap.put("commentTime", ElementActions.getText(driver, commentTime, scenario));

			return objmap;

		}
		
		/**
		 * This Method will like the comment
		 */
		public void LikeComment(){
			
			ElementActions.clickElement(driver, heartIcon, scenario);
			WaitMethods.staticWait(2000);
		}
		
		
		
		/**
		 * @return
		 * This method will return the count of likes 
		 */
		public String getLikeCount(){
			return ElementActions.getText(driver, likeCount, scenario);
		}
		
		

		/**
		 * @param textToappend
		 * This method will edit the post and post it again
		 */
		public void editPost(String textToappend){
			ElementActions.clickElement(driver, threedotsButton, scenario);
			WaitMethods.staticWait(2000);
			ElementActions.clickElement(driver, editPostButton, scenario);
			WaitMethods.staticWait(2000);
			ElementActions.sendKeys(driver, editpostfield, scenario, textToappend);
			WaitMethods.staticWait(2000);
			ElementActions.clickElement(driver, postButton, scenario);
			WaitMethods.staticWait(5000);
		}
		
		
		/**
		 * This method will delete the post
		 */
		public void deletePost(){
			ElementActions.clickElement(driver, threedotsButton, scenario);
			WaitMethods.staticWait(2000);
			ElementActions.clickElement(driver, deletePostButton, scenario);
			WaitMethods.staticWait(2000);
			ElementActions.clickElement(driver, yesDeleteButton, scenario);
		}

}
