package com.search.googleme;

public class Search {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "assets/chromedriver.exe");		
		Engine engine = new Engine("https://www.google.de/");
		engine.enterKeyword(args[0]);
		System.out.println(engine.getResultsFoundCountLabel());
		
		int resultCount = 3;
		try {
			resultCount = Integer.parseInt(args[1]);			
		}
		catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
			System.out.println("Invalid option for result count to display, the default option 3 will be used");
		}
		finally {
			engine.selectResults(resultCount);
		}		
		engine.closeBrowser();
	}
}
