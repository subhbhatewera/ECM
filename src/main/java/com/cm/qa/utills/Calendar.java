package com.cm.qa.utills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cm.cm.qa.base.TestBase;

public class Calendar extends TestBase{

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
					flag = true ;
					break ;
				}
			}
			if(flag) {
				break ;
			}
		}
	}

	public String getMonth(String inputMonth) {
		String month = null ;
		switch(inputMonth) {
		case("01"):
			month = "January" ;
		break ;
		case("02"):
			month = "February" ;
		break ;
		case("03"):
			month = "March" ;
		break ;
		case("04"):
			month = "April" ;
		break ;
		case("05"):
			month = "May" ;
		break ;
		case("06"):
			month = "June" ;
		break ;
		case("07"):
			month = "July" ;
		break ;
		case("08"):
			month = "August" ;
		break ;
		case("09"):
			month = "September" ;
		break ;
		case("10"):
			month = "October" ;
		break ;
		case("11"):
			month = "November" ;
		break ;
		case("12"):
			month = "December" ;
		break ;
		}
		return month ;
	}

	public void selectMonth(String inputMonth) {

		String month = null ;
		boolean flag = false ;		

		switch(inputMonth) {
		case("01"):
			month = "JAN" ;
		break ;
		case("02"):
			month = "FEB" ;
		break ;
		case("03"):
			month = "MAR" ;
		break ;
		case("04"):
			month = "APR" ;
		break ;
		case("05"):
			month = "MAY" ;
		break ;
		case("06"):
			month = "JUN" ;
		break ;
		case("07"):
			month = "JUL" ;
		break ;
		case("08"):
			month = "AUG" ;
		break ;
		case("09"):
			month = "SEP" ;
		break ;
		case("10"):
			month = "OCT" ;
		break ;
		case("11"):
			month = "NOV" ;
		break ;
		case("12"):
			month = "DEC" ;
		break ;
		}

		for(int monthRowNum = 2 ; monthRowNum <=6 ; monthRowNum++) {
			for(int monthColNum = 1 ; monthColNum <= 4 ; monthColNum++) {
				String monthValue = driver.findElement(By.xpath(beforeXpath+monthRowNum+afterXpath+monthColNum+"]")).getText() ;
				if(monthValue.equals(month)) {
					driver.findElement(By.xpath(beforeXpath+monthRowNum+afterXpath+monthColNum+"]")).click();
					flag = true ;
					break ;
				}
			}
			if(flag) {
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

		int initialRow = checkFirstRow() ;

		for(int dayRowNum = initialRow ; dayRowNum <= 6 ; dayRowNum ++) {
			for(int dayColNum = 1 ; dayColNum <=7 ; dayColNum++) {
				String dayValue = driver.findElement(By.xpath(beforeXpath+dayRowNum+afterXpath+dayColNum+"]")).getText() ;
				if(dayValue.equals(inputDay)) {
					driver.findElement(By.xpath(beforeXpath+dayRowNum+afterXpath+dayColNum+"]")).click();
					flag = true ;
					break ;
				}				
			}
			if(flag) {
				break ;
			}
		}
	}

	public void selectDayNew(String inputMonth, String inputDay) {
		String month = getMonth(inputMonth);
		WebElement element = driver.findElement(By.xpath("(//td[contains(@aria-label,'"+month+" "+inputDay+"')])[1]")) ;
		element.click();
	}

	public void selectDateNew(WebElement element, String date) {

		String [] dateArray = date.split("/") ;
		String month = dateArray[0] ;
		String day = dateArray[1] ;
		String year = dateArray[2] ;

		customVisibleWait(element);
		element.click();
		monthAndYearButton.click();

		selectYear(year);
		selectMonth(month);
		selectDayNew(month, day);

	}

	public void selectDate(WebElement element, String date) {

		String [] dateArray = date.split("/") ;
		String month = dateArray[0] ;
		String day = dateArray[1] ;
		String year = dateArray[2] ;

		customVisibleWait(element);
		element.click();
		monthAndYearButton.click();

		selectYear(year);
		selectMonth(month);
		selectDay(day);
	}
}