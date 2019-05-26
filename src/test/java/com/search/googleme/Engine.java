package com.search.googleme;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Engine {

	private WebDriver driver;
	private By textSearch = By.name("q");
	private By resultsFound = By.id("resultStats");
	private By resultLinks = By.cssSelector("div.r > a:not(.fl)");
	
	public Engine(String url) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(url);
	}
	
	public void enterKeyword(String keyword) {
		driver.findElement(textSearch).sendKeys(keyword +  Keys.ENTER);
	}
	
	public String getResultsFoundCountLabel() {
		return driver.findElement(resultsFound).getText().replaceAll("\\([^)]*\\)", "").trim();
	}
	
	public void selectResults(int topelements) {
		List<WebElement> results = driver.findElements(resultLinks);
		List<WebElement> cutList = results.subList(0, topelements);
		
		System.out.println(". Die erste(n) " + topelements + " sind:");
		
		for (WebElement result:cutList) {
			System.out.println("- " + result.getAttribute("href") );
		}
		
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
}
