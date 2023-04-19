package com.bellesboard.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bellesboard.qa.base.TestBase;

public class HomePage extends TestBase{

		//Page Factory
		@FindBy(xpath = "//a[contains(text(),'Home')]")
		WebElement homeMenu;
		
		@FindBy(xpath = "//a[contains(text(),'Meetings & Events')]")
		WebElement meetingsEventsMenu;
		
		@FindBy(xpath = "//a[contains(text(),'Calendar')]")
		WebElement calendarMenu;
		
		@FindBy(xpath = "//a[contains(text(),'Tasks')]")
		WebElement tasksMenu;
		
		@FindBy(xpath = "//a[contains(text(),'Documents')]")
		WebElement DocumentsMenu;
		
		@FindBy(xpath = "//a[contains(text(),'Dashboard')]")
		WebElement DashboardMenu;
		
		@FindBy(xpath = "//a[contains(text(),'Committees')]")
		WebElement CommitteesMenu;
		
		@FindBy(xpath = "//a[contains(text(),'Board Members')]")
		WebElement BoardMembersMenu;
		
		
		public  HomePage() {
			PageFactory.initElements(driver, this);
			
		}
		
		
	
	
}
