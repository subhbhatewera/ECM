package com.cm.qa.utills;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.ActionClass;

public class Calendar extends ActionClass{

	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	WebElement monthAndYearButton ;

	@FindBy(xpath = "//button[contains(@aria-label,'month and year')]//span[contains(@class,'button')]")
	WebElement yearLabel ;


	@FindBy(xpath = "//button[@aria-label='Previous 20 years']")
	WebElement previousButton ;

	@FindBy(xpath = "//button[@aria-label='Next 20 years']")
	WebElement nextButton ;

	String beforeXpath = "//tr[" ;

	String afterXpath = "]//td[" ;

	//tr[1]//td[1]

	public Calendar() {
		PageFactory.initElements(driver, this);
	}

	public void selectYear(String inputYear) {
		boolean flag = false ;		
		for(int yearRowNum = 1 ; yearRowNum <=6 ; yearRowNum ++) {
			for(int yearColNum = 1 ; yearColNum <= 4 ; yearColNum ++) {
				String yearValue = driver.findElement(By.xpath(beforeXpath+yearRowNum+afterXpath+yearColNum+"]")).getText() ;
				if(yearValue.equals(inputYear)) {
					driver.findElement(By.xpath(beforeXpath+yearRowNum+afterXpath+yearColNum+"]")).click();
					flag = true ; //If values is found, control will come out of inner loop
					break ;
				}
			}
			if(flag) {
				break ; //Control will come out of inner loop
			}
		}
	}

	public void verifyYearIsDisplayed(String inputYear) {
		List<WebElement> yearList = driver.findElements(By.xpath("//tr//td"));			
		int firstValue = Integer.parseInt(yearList.get(0).getText());
		int lastValue = Integer.parseInt(yearList.get(23).getText());
		int inputValue = Integer.parseInt(inputYear);
		System.out.println("First Value : "+firstValue);
		System.out.println("Last Value : "+lastValue);
		System.out.println("Input Value : "+inputValue);

		if (inputValue < firstValue) {
			sleep(500);
			previousButton.click();
			selectYear(inputYear);
		}
		else if(inputValue > lastValue) {
			sleep(500);
			nextButton.click();
			selectYear(inputYear);
		}				
		else if(inputValue > firstValue || inputValue < lastValue) {
			sleep(500);
			selectYear(inputYear);
		}	
	}

	public void selectMonth(String inputMonth) {
		List<WebElement> monthList = driver.findElements(By.xpath("//tr//td"));
		int inputValue = Integer.parseInt(inputMonth);	
		for(int i = 1 ; i <= 12 ; i++) {
			if(i == inputValue) {
				sleep(500);
				monthList.get(i).click();
				break ;
			}
		}

	}

	public int checkFirstRow() {
		int initialRow ;
		String rowOne = driver.findElement(By.xpath("(//tr[1])[2]")).getText();		
		if(rowOne.contains("1")) {
			initialRow = 1 ;
		}
		else {
			initialRow = 2 ;
		}
		return initialRow ;
	}	

	public void selectDay(String inputDay) {
		boolean flag = false ;
		WebElement element = null ;
		int initialRow = checkFirstRow() ;
		List<WebElement> rowList = driver.findElements(By.xpath("//tr"));
		int rowListSize = rowList.size();

		for(int dayRowNum = initialRow ; dayRowNum < (rowListSize-1) ; dayRowNum ++) {
			List<WebElement> colList = driver.findElements(By.xpath(beforeXpath+dayRowNum+"]//td"));
			int colListSize = colList.size();
			for(int dayColNum = 1 ; dayColNum <=colListSize ; dayColNum++) {
				try {
					element = driver.findElement(By.xpath(beforeXpath+dayRowNum+afterXpath+dayColNum+"]")) ;
				}
				catch(NoSuchElementException e) {
					System.out.println("Please enter a correct Date");
					e.printStackTrace();
					flag = false ;
				}
				String dayValue = element.getText();
				if(dayValue.equals(inputDay)) {
					element.click();
					flag = true ;
					break ;
				}
			}
			if(flag) {
				break ;
			}
		}
	}		

	public void selectDate(WebElement element, String date) {

		String [] dateArray = date.split("/") ;
		String month = dateArray[0] ;
		String day = dateArray[1] ;
		String year = dateArray[2] ;

		element.click();
		sleep(1000);
		monthAndYearButton.click();
		sleep(1000);

		verifyYearIsDisplayed(year);		
		selectMonth(month);
		selectDay(day);
	}
}