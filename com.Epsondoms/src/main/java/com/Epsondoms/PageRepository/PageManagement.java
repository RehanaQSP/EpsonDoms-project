package com.Epsondoms.PageRepository;

import org.openqa.selenium.WebDriver;

public class PageManagement {

	public WebDriver driver;
	public LoginPage loginpageobj;
	public RegisterPage registerpageobj;
	public WelcomePage welcomepageobj;

	// initialization
	public PageManagement(WebDriver driver) {
		this.driver=driver;
	}

	public LoginPage initloginpage() {
		loginpageobj = new LoginPage(driver);
		return loginpageobj;
	}

	public WelcomePage initWelcomepage() {
		welcomepageobj = new WelcomePage(driver);
		return welcomepageobj;
	}

	public RegisterPage initRegisterpage() {
		registerpageobj = new RegisterPage(driver);
		return registerpageobj;
	}

}
