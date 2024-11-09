package com.Epsondoms.PageRepository;

import java.nio.file.Path;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WelcomePage {
	// initialization
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	// declarization
	@FindBy(xpath="//input[@id='name']")
	private WebElement name;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='mobile']")
	private WebElement mobile;
	
	@FindBy(xpath="//input[@id='male']")
	private WebElement male;
	
	@FindBy(xpath="(//input[@name='places'])[1]")
	private WebElement places;
	
	@FindBy(partialLinkText="Contact Us")
	private WebElement contact;
	
	@FindBy(xpath="//textarea[@id='feedback']")
	private WebElement feedback;
	
	@FindBy(xpath="//input[@id='reg']")
	private WebElement register;
	
	@FindBy(name="country1")
	private WebElement country;
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement file;
	
	@FindBy(xpath="//input[@name='dob']")
	private WebElement dateofbirth;
	
	//utilization
	public WebElement getName() {
		return name;
	}
	public WebElement getEmail() {
		return email;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	
	public WebElement getMobile() {
		return mobile;
	}
	
	public WebElement getMale(){
		return male;
	}
	 public WebElement getPlaces() {
		 return places;
	 }
	 public WebElement getContact() {
		 return contact;
	 }
	 public WebElement getFeedback() {
		 return feedback;
	 }
	 public WebElement getRegister() {
		 return register;
	 }
	 public WebElement getCountry() {
		 return country;
			 
	 }
	 public WebElement getFile() {
		return file;
	 }
	 public WebElement getDateofbirth() {
		 return dateofbirth;
	 }
	 

}
