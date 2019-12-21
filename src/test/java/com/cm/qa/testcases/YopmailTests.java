package com.cm.qa.testcases;

import org.testng.annotations.Test;

import com.cm.qa.utills.Yopmail;

import cm.cm.qa.base.TestBase;

public class YopmailTests extends TestBase{
	
	public YopmailTests() {
		super();
	}
	
	@Test
	public void login() {
		initializeBrowser();
		Yopmail y = new Yopmail();
		y.login();
	}

}
