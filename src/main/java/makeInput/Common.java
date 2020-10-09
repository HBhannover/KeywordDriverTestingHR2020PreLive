package makeInput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {	
	
	public static String ID = null;
	
	public static WebElement element;
	public static List<WebElement> listElements;
	
	//public static WebDriver driver = new FirefoxDriver();
	public static WebDriver driver = new ChromeDriver();
	public static Logger logger=Logger.getLogger("Common");
//	public Common() throws Exception {
//	FileHandler fh = new FileHandler("C:/Users/case/Desktop/HR2020/Logs_Screenshots/TestLogsID.txt");
//	   logger.addHandler(fh);}
	
 	public static void openUrl(String inputUrl){	
 		driver.get(inputUrl);
 		driver.manage().window().maximize();
 		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			System.out.println("no url was found");
			e.printStackTrace();
		}
 	}

 	
 	public static String takeCurrentUrl() {
 		String currentUrl = driver.getCurrentUrl();
 		return currentUrl;
 	}
 	
 	public static void takeScreenShort(String pfadToSave) throws IOException {
 		TakesScreenshot scrShot =((TakesScreenshot) driver);
 		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
 		File DestFile=new File(pfadToSave);
 		FileUtils.copyFile(SrcFile, DestFile);	
 	}
 	
 	public static void duppleClicker(String elementAddressTyp, String elementAddress) throws Exception {
 		Actions actions = new Actions(driver);
		WebElement logo = Common.Locator(elementAddressTyp, elementAddress);
 		TimeUnit.SECONDS.sleep(3);
 		actions. moveToElement(logo)
 		.doubleClick()
 		.perform();	
 	}
 	
	public static void rightClicker(String elementAddressTyp, String elementAddress) {
		Actions actions = new Actions(driver);
		WebElement element = Locator(elementAddressTyp, elementAddress);
		actions.contextClick(element).perform();

	}

	public static void highLighterMethod(String elementAddressTyp, String elementAddress) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: lightblue;');", Locator(elementAddressTyp,elementAddress));
	}
	
	public static void valueMarker(String elementAddressTyp, String elementAddress) {
		Actions actions = new Actions(driver);
		WebElement element = Locator(elementAddressTyp, elementAddress);
		actions.moveToElement(element).click().sendKeys(Keys.CONTROL,"a").build().perform();
	}
	
	public static void mouseOverElement(String elementAddressTyp, String elementAddress) {
		Actions actions = new Actions(driver);
		actions.moveToElement(Locator(elementAddressTyp, elementAddress)).perform();
	}

 	//Find out a String (include space between „“ or () or [])
	public static String getStringBetweenTwoChars(String input, String startChar, String endChar) {
		String restString="";
		try {
			for (int i = 0; i < input.length(); i++) {
				int start = input.indexOf(startChar);
				if (start != -1) {
					int end = input.indexOf(endChar, start + startChar.length());
					if (end != -1) {
						String textBetweenChars = input.substring(start + startChar.length(), end);
						input = input.substring(end + 1);
						
						String snext = getStringBetweenTwoChars(input, startChar, endChar);
						if (snext != "")
							textBetweenChars = textBetweenChars + "%Space&" + snext;
						restString = restString + textBetweenChars;
						return textBetweenChars;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	

	// convert a string to a Array with certain criteria
	public static String[] convertStringToArray(String stringText, String splitCriteria) {
		String[] stringArray = stringText.split(splitCriteria);
		System.out.println("convertArray: "+Arrays.toString(stringArray));
		return stringArray;
	}
	
	
	// Find out a keyword from a list of words
	public static String searchKeywordFromWords(String[] words, String keyWord) {
		String searchKeyword= "";
		for (int i = 0; i < words.length; i++) {
			if(words[i].contentEquals(keyWord))
				searchKeyword = keyWord;
		}
		return searchKeyword;
	}
	
	//Find out Character between Quotes using Pattern
	public static String getCharBetweenQuotes(String line) {
		String value = null;
		Pattern p = Pattern.compile(".*\\\"(.*)\\\".*");
		Matcher m = p.matcher(line);
		while (m.find()) {
			value = m.group(1);
			System.out.println(value);
			
		}
		return value;
	}

	
	//Find out a Webelement by different locatorTyp
	public static WebElement Locator(String locatorTyp, String locatorAddress){
		try {
		switch (locatorTyp) {
	
		case "id":
			element = driver.findElement(By.id(locatorAddress));
			locatorTyp = null;
			break;
			
		case "className":
			element = driver.findElement(By.className(locatorAddress));
			locatorTyp = null;
			break;
			
		case "linkText":
			element = driver.findElement(By.linkText(locatorAddress));
			locatorTyp = null;
			break;
			
		case "partialLinkText":
			element = driver.findElement(By.partialLinkText(locatorAddress));
			locatorTyp = null;
			break;
			
		case "tagName":
			element = driver.findElement(By.tagName(locatorAddress));
			locatorTyp = null;
			break;
			
		case "xpath":
			element = driver.findElement(By.xpath(locatorAddress));
			locatorTyp = null;
			break;
			
		case "textName": //Name des WebElements auf GUI	
			element = driver.findElement(By.xpath("//*[text() = '"+locatorAddress+"']"));
			break;
			
		case "name":	//Name des WebElements in HTML-Code
			element = driver.findElement(By.name(locatorAddress));
			locatorTyp = null;
			break;
			
		default:
			break; 
		}
		} catch (NoSuchElementException ex) {
			logger.warning("KEINE ELEMENTE gefunden");
		}
		return element;
		
	}
	
	//find out List of Webelements by different locatorTyp 
	public static List<WebElement> ListLocator(String locatorTyp, String locatorAddress){
		
		switch (locatorTyp) {
		case "id":	
			listElements = driver.findElements(By.id(locatorAddress));
			locatorTyp = null;
			break;
			
		case "className":
			listElements = driver.findElements(By.className(locatorAddress));
			locatorTyp = null;
			break;
			
		case "linkText":
			listElements = driver.findElements(By.linkText(locatorAddress));
			locatorTyp = null;
			break;
			
		case "partialLinkText":
			listElements = driver.findElements(By.partialLinkText(locatorAddress));
			locatorTyp = null;
			break;
			
		case "tagName":
			listElements = driver.findElements(By.tagName(locatorAddress));
			locatorTyp = null;
			break;
			
		case "xpath":
			listElements = driver.findElements(By.xpath(locatorAddress));
			locatorTyp = null;
			break;
			
		case "textName": //Name des WebElements auf GUI	
			listElements = driver.findElements(By.xpath("//*[text() = '"+locatorAddress+"']"));
			break;
			
		case "name":	//Name des WebElements in HTML-Code
			listElements = driver.findElements(By.name(locatorAddress));
			locatorTyp = null;
			break;
			
		default:
			break;
		}
		
		return listElements;
		
	}
	
	 	// Define List of sentences from a long text
	public static String[] SentencesDef(String path) {
		Scanner sentence = null;
		String[] SENTENCES = null;
		try {
			sentence = new Scanner(new File(path));
		} catch (FileNotFoundException ex) {
			System.out.println("Path not found!" + ex.getMessage());
			ex.printStackTrace();
		}
		ArrayList<String> sentenceList = new ArrayList<String>();

		while (sentence.hasNextLine()) {
			sentenceList.add(sentence.nextLine());
		}
		sentenceList.trimToSize();
		sentence.close();
		System.out.println("Freitext ist: "+sentenceList+ " Size: "+ sentenceList.size());
		
		String[] sentenceArray = sentenceList.toArray(new String[sentenceList.size()]);
//		System.out.println(Arrays.toString(sentenceArray));
//		System.out.println(sentenceArray.length);
		

		for (int r = 0; r < sentenceArray.length; r++) {
			
			// find out the sentence
			SENTENCES = sentenceArray[r].split("(?=WENN)|(?=ODER(?! NÄCHSTEN))|(?=DANN)|(?=UND)|(?=IMMER)|(?=NICHT)"); // WENN|UND|DANN|[.]

		}
		return SENTENCES;
	}
	
	public static String[] SentencesDefFromJira(String text) {
		String[] SENTENCES = null;	
		
		ArrayList<String> sentenceList = new ArrayList<String>();
		if(text != null) {
		sentenceList.add(text);		
		System.out.println("Freitext ist: "+sentenceList+ " Size: "+ sentenceList.size());
		
		String[] sentenceArray = sentenceList.toArray(new String[sentenceList.size()]);
//		System.out.println(Arrays.toString(sentenceArray));
//		System.out.println(sentenceArray.length);
		for (int r = 0; r < sentenceArray.length; r++) {
			// find out the sentence
			SENTENCES = sentenceArray[r].split("(?=WENN)|(?=ODER(?! NÄCHSTEN))|(?=DANN)|(?=UND)|(?=IMMER)|(?=NICHT)"); // WENN|UND|DANN|[.]
		}
		}
		return SENTENCES;
	}
	
	//split list of sentences by space, and become more words
	public static String[] WordsDefMoreSentences(String[] Sentences) {
		String[] words = null;
		for (int k = 0; k < Sentences.length; k++) {
			 System.out.println("Sentence " + (k+1) + ": " + Sentences[k]);
			 // find out the words of sentence
			 words = Sentences[k].split(" ");
			 System.out.println("[1] Wörter sind:" + Arrays.toString(words));
		}
		return words;
	}
	
	//split one sentence by space, and become more words
	public static String[] WordsDefOneSentenceSimple(String Sentence) {
		String[] words = null;
			 words = Sentence.split(" ");
			 System.out.println("[2] Wörter sind:" + Arrays.toString(words));
		return words;
	}
	
	// get string between quotes (include quotes) of a sentence and replace them
	public static String[] WordsDefOneSentenceWithoutQuotes(String Sentence, String startChar, String endChar) {
//		String startChar = "„";
//		String endChar = "“";	

		for (int i = 0; i < Sentence.length(); i++) {

			int start = Sentence.indexOf(startChar);
			if (start != -1) {
				int end = Sentence.indexOf(endChar, start + startChar.length());
				if (end != -1) {
					String stringWithQuotes = Sentence.substring(start - 1, end + 1);
					Sentence = Sentence.replace(stringWithQuotes, "");

				}
			}
		}

		String[] words = null;
		words = Sentence.split(" ");
		System.out.println("[3] Wörter sind:" + Arrays.toString(words));
		return words;
	}
	
	//get characters (not include space)
	public static String getCharacterFromQuotes(String Sentence) {
		String value = null;
		value = getStringBetweenTwoChars(Sentence, "„", "“");
		return value;
	}
	
	
//	public static void inputTableCell_Solution1(String tableAddressTyp, String tableAddress, int row, int col, String Value) throws Exception {
//		//WebDriver driver = new FirefoxDriver();
//		//driver.get("https://keisan.casio.com/exec/system/13800848854767");
//		//List<WebElement> inputTable = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Constans.Table1_Address)));
//		List<WebElement> inputTable = Common.ListLocator(tableAddressTyp, tableAddress);
//		TimeUnit.SECONDS.sleep(10);
//
//		 for (int i=0; i<inputTable.size(); i++) {
//			 if(i==row) {
//				 List<WebElement> columns = inputTable.get(i).findElements(By.tagName(Constans.TableColumnstagName));
//				 for(int j=0;j<columns.size();j++) {
//					 if(j==col) { //with Selenium Actions()
//						 Actions actions = new Actions(driver);
//						 WebElement target = columns.get(j);
//						 actions.moveToElement(target)
//						 		.click()
//						 		.sendKeys(Value)
//						 		.build()
//						 		.perform();		 
//					 }
//				 }
//			 }
//		 }
//	}
//	
	public static WebElement searchTableCell(String tableAddressTyp, String tableAddress, String row, String col, String ColumnsTagname, String InhaltTagname) throws Exception {
		// WebDriver driver = new FirefoxDriver();
		// driver.get("https://keisan.casio.com/exec/system/13800848854767");
		// List<WebElement> inputTable = new WebDriverWait(driver,
		// 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Constans.Table1_Address)));
		WebElement target = null;
		List<WebElement> inputTable = ListLocator(tableAddressTyp, tableAddress);
	
		TimeUnit.SECONDS.sleep(10);

		if (isNumeric(row) == true && isNumeric(col) == true) {
			System.out.println("Num+Num");
			int rowInt = Integer.parseInt(row);
			int colInt = Integer.parseInt(col);
			for (int i = 0; i < inputTable.size(); i++) {
				if (i == rowInt) {
					if (ColumnsTagname.equals(InhaltTagname)) {
						List<WebElement> columns = inputTable.get(i).findElements(By.tagName(ColumnsTagname));
						for (int j = 0; j < columns.size(); j++) {
							if (j == colInt) { // with Selenium Actions()
								target = columns.get(j);
							}
						}
					} else {
						List<WebElement> columns = inputTable.get(i).findElements(By.tagName(InhaltTagname));
						for (int j = 0; j < columns.size(); j++) {
							if (j == (colInt - 1)) { // with Selenium Actions()
								target = columns.get(j);
							}
						}
					}
				}
			}
		}
		if (isNumeric(row) == true && isNumeric(col) == false) {
			int colInt = -1;
			List<WebElement> titleRow = inputTable.get(0).findElements(By.tagName(ColumnsTagname));
		
			for (int k = 0; k < titleRow.size(); k++) {
				String Titles = titleRow.get(k).getText();                   
				String Titles_UTF8 = URLEncoder.encode(Titles, "UTF-8");		  //Titles in UTF-8
				String Titles_Cp1252 = URLDecoder.decode(Titles_UTF8, "cp1252");  //Titles in chcp 1252
				if (Titles.equals(col) || Titles_Cp1252.equals(col)){
					colInt = k;
				}
			}
			System.out.println("Num+String");
			int rowInt = Integer.parseInt(row);
			System.out.println(col);
			for (int i = 0; i < inputTable.size(); i++) {
				if (i == rowInt) {
					if (ColumnsTagname.equals(InhaltTagname)) {
						List<WebElement> columns = inputTable.get(i).findElements(By.tagName(ColumnsTagname));
						for (int j = 0; j < columns.size(); j++) {
							if (j == colInt) {
								target = columns.get(j);
							}
						}
					} else {
						List<WebElement> columns = inputTable.get(i).findElements(By.tagName(InhaltTagname));
						for (int j = 0; j < columns.size(); j++) {
							if (j == (colInt - 1)) {
								target = columns.get(j);							
							}
						}
					}
				}
			}
		}
		if (isNumeric(row) == false && isNumeric(col) == true) {
			int rowInt = -1;
			System.out.println("String+Num");
			int colInt = Integer.parseInt(col);
			for (int i = 0; i < inputTable.size(); i++) {
				List<WebElement> titleCol = inputTable.get(0).findElements(By.tagName(ColumnsTagname));
				for (int j = 0; j < titleCol.size(); j++) {
					if (titleCol.get(j).getText().equals(row)) {
						rowInt = j;
					}
				}
				for (int j = 0; j < inputTable.size(); j++) {
					if (j == rowInt) {
						if (ColumnsTagname.equals(InhaltTagname)) {
							List<WebElement> columns = inputTable.get(j).findElements(By.tagName(InhaltTagname));
							for (int k = 0; k < columns.size(); k++) {
								if (k == colInt) { 
									target = columns.get(k);
								}
							}
						} else {
							List<WebElement> columns = inputTable.get(j).findElements(By.tagName(InhaltTagname));
							for (int k = 0; k < columns.size(); k++) {
								if (k == (colInt - 1)) {
									target = columns.get(k);
								}
							}
						}
					}
				}
			}
		}

		if (isNumeric(row) == false && isNumeric(col) == false) {
			System.out.println("String+String");
			int rowInt = -1;
			int colInt = -1;
			List<WebElement> titleRow = inputTable.get(0).findElements(By.tagName(ColumnsTagname));
			for (int k = 0; k < titleRow.size(); k++) {
				if (titleRow.get(k).getText().trim().equals(col)) {
					colInt = k;
				}
			}
			for (int i = 1; i < inputTable.size(); i++) {
				{
					List<WebElement> titleCol = inputTable.get(i).findElements(By.tagName(ColumnsTagname));
					for (int j = 0; j < titleCol.size(); j++) {
						if (titleCol.get(0).getText().trim().equals(row)) {
							rowInt = i;
						}
					}
				}
			}

			for (int i = 0; i < inputTable.size(); i++) {
				if (i == rowInt) {

					if (ColumnsTagname.equals(InhaltTagname)) {
						List<WebElement> columns = inputTable.get(i).findElements(By.tagName(InhaltTagname));
						for (int k = 0; k < columns.size(); k++) {
							if (k == colInt) {
								target = columns.get(k);
							}
						}
					} else {
						List<WebElement> columns = inputTable.get(i).findElements(By.tagName(InhaltTagname));
						for (int k = 0; k < columns.size(); k++) {
							if (k == (colInt - 1)) {
								target = columns.get(k);
							}
						}
					}
				}
			}
		}	
		return target; //eine Zelle herausgeben
	}	
	//Tabelle: Suche eine Zeile
	public static List<WebElement> searchTableRows(String tableAddressTyp, String tableAddress, String row, String InhaltTagname) throws Exception {

		List<WebElement> columns = null;
		List<WebElement> inputTable = ListLocator(tableAddressTyp, tableAddress);
	
		TimeUnit.SECONDS.sleep(3);

		if (isNumeric(row) == true) {
			System.out.println("RowIsNum");
			int rowInt = Integer.parseInt(row);
			for (int i = 0; i < inputTable.size(); i++) {
				if (i == (rowInt)) {
					columns = inputTable.get(i).findElements(By.tagName(InhaltTagname));
				}
			}
		}
			
		if (isNumeric(row) == false) {
			System.out.println("RowIsString");
			for (int i = 0; i < inputTable.size(); i++) {
				if (inputTable.get(i).getText().equals(row)) {
					columns = inputTable.get(i).findElements(By.tagName(InhaltTagname));
				}
			}
		}

		return columns;
	}	
	//Tabelle: Suche eine Spalte
	public static List<WebElement> searchTableColumns(String tableAddressTyp, String tableAddress, String col, String ColumnsTagname, String InhaltTagname) throws Exception {

		List<WebElement> rows = new ArrayList<WebElement>();
		WebElement row = null;
		List<WebElement> inputTable = ListLocator(tableAddressTyp, tableAddress);
	
		TimeUnit.SECONDS.sleep(5);

		if (isNumeric(col) == true) {
			System.out.println("ColIsNum");
			int colInt = Integer.parseInt(col);
			for (int i = 0; i < inputTable.size(); i++) {
					List<WebElement> columns = inputTable.get(i).findElements(By.tagName(InhaltTagname));
					for (int j = 0; j < columns.size(); j++) {
						if (j == (colInt-1)) { // with Selenium Actions()
							row = columns.get(colInt);
							rows.add(row);
					}
				}
			}
		}
		if (isNumeric(col) == false) {
			int colInt = -1;
			List<WebElement> titleRow = inputTable.get(0).findElements(By.tagName(ColumnsTagname));
			for(int k=0; k<titleRow.size(); k++) {
				String Titles = titleRow.get(k).getText();                   
				String Titles_UTF8 = URLEncoder.encode(Titles, "UTF-8");		  //Titles in UTF-8
				String Titles_Cp1252 = URLDecoder.decode(Titles_UTF8, "cp1252");  //Titles in chcp 1252
				if (Titles.equals(col) || Titles_Cp1252.equals(col)){
					colInt = k;
				}
			}
			System.out.println("ColIsString");
			for (int i = 0; i < inputTable.size(); i++) {
					List<WebElement> columns = inputTable.get(i).findElements(By.tagName(InhaltTagname));
					if(columns.size() !=0) {
					for (int j = 0; j < columns.size(); j++) {
						if (j==(colInt-1)) {
							row = columns.get(j);
							rows.add(row);
					}}
				}
			}
		}
		
		return rows;
	}
	
	public static boolean isNumeric(String textNum) {
		//return textNum.matches("-?\\d+(\\.\\d+)?");
		return textNum.matches("-?[0-9](\\.\\[0-9])?");
		
	}

//	public static void inputTableCell_Solution2( String tableAddressTyp, String tableAddress, int rowPa, int colPa, String Value){
//		
//		//WebDriver driver = new FirefoxDriver();
//		//driver.get("https://keisan.casio.com/exec/system/13800848854767");
//		
//		//List<WebElement> inputTable = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='var_a_EXL']//tbody//tr")));
//		
//		List<WebElement> inputTable = Common.ListLocator(tableAddressTyp, tableAddress);
//		for(int i=0; i<inputTable.size();i++) {
//			if(i==rowPa) {
//				List<WebElement> columns = inputTable.get(i).findElements(By.tagName(Constans.TableColumnstagName));
//				for(int j=0; j<columns.size();j++) {
//					if(j==colPa) { //with Selenium JavascriptExecutor:
//						JavascriptExecutor js = (JavascriptExecutor) driver;
//						js.executeScript("argument[0].innerText = '"+Value+"'", columns.get(j));
//						System.out.println("row1: "+rowPa);
//						System.out.println("col1: "+colPa);						
//					}
//				}
//			}
//		}
//	}
//	
//	public static String outputTableCell(String tableAddressTyp, String tableAddress, int rowOut, int colOut) throws Exception{
//		String cellValue = "";
//		List<WebElement> outputTable = Common.ListLocator(Constans.OutputTableAddressTyp, Constans.OutputTableAddress);
//		TimeUnit.SECONDS.sleep(15);
//		System.out.println("outputTable-Size: " + outputTable.size());
//		List<WebElement> columns;
//		
//		for (int r = 0; r < outputTable.size(); r++) {
//			if (r== rowOut) {
//				columns = outputTable.get(r).findElements(By.tagName(Constans.OutputTableColumnstagName));
//				for (int c = 0; c < columns.size(); c++) {
//					if (c == colOut) {
//						WebElement target=columns.get(c);
//						cellValue = target.getText();
//						//System.out.println("text deee: "+target.getText());
//						System.out.println("[row;col]=[" +outputTable.indexOf(outputTable.get(r)) +";"+columns.indexOf(columns.get(c))+ "] is: " +target.getText());
//					}
//				}
//			}
//		}
//		return cellValue;
//	}
	
	public static void inputTableCell(String tableAddressTyp, String tableAddress, String row, String col,String inputWert, String ColumnsTagname, String InhaltTagname) throws Exception{
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		actions.moveToElement(searchTableCell(tableAddressTyp, tableAddress, row, col, ColumnsTagname, InhaltTagname))
		.click()
		.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
        .sendKeys(inputWert)
        .build().perform();
	}
	
	public static void inputTabelleZeileListe(String tableAddressTyp, String tableAddress, String row, String InhaltTagname, String[] inputWert) throws Exception{
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		List<WebElement> columns = searchTableRows(tableAddressTyp, tableAddress, row, InhaltTagname );
		for(int i=0; i<columns.size();i++) {
			actions.moveToElement(columns.get(i)).click().sendKeys(inputWert[i])
			.build().perform();
		}	
	}
	
	public static void inputTabelleSpalteListe(String tableAddressTyp, String tableAddress, String col, String ColumnsTagname, String InhaltTagname, String[] inputWert) throws Exception{
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		List<WebElement> rows = searchTableColumns(tableAddressTyp, tableAddress, col, ColumnsTagname, InhaltTagname);
		for(int i=0; i<rows.size();i++) {
			actions.moveToElement(rows.get(i)).click().sendKeys(inputWert[i])
			.build().perform();
		}	
	}
	
	public static String[] outputTabelleZeileListe(String tableName, String tableAddressTyp, String tableAddress, String row, String InhaltTagname) throws Exception{
		String[] outputArray = null;
		String outputText = null;
		List<WebElement> columns = searchTableRows(tableAddressTyp, tableAddress, row, InhaltTagname);
		Label1:	for(int i=0; i<columns.size();i++) {			
			String outputText1 = columns.get(i).getText();
			
			if(outputText1.contains("Mil")) {
				outputText1 = "Miljöh";
			}
			if(outputText1.equals("")||outputText1.equals(null)) {
				switch (tableName) {
				case "tabelle1":
					String[] idsRow = IDTabelle1Row(row);
					for(int j=0; j<idsRow.length; j++) {
						outputText1 = htmlTextGetter(idsRow[j]);
						outputText = outputText + "," + outputText1;	
					} break Label1;
					
				case "Käsewahl":
					String[] idsRow1 = IDKaesewahlRow(row);
					for(int j=0; j<idsRow1.length; j++) {
						outputText1 = htmlTextGetter(idsRow1[j]);
						outputText = outputText + "," + outputText1;	
					} break Label1;
					
				default:
					break;
				}				
//				String[] idsRow = IDTabelle1Row(row);
//				for(int j=0; j<idsRow.length; j++) {
//					outputText1 = htmlTextGetter(idsRow[j]);
//					outputText = outputText + "," + outputText1;	
//				} break Label1;
			} else {
			outputText = outputText + "," + outputText1; //null + ...
			}		
		} 
		outputArray = outputText.split(","); //ein Array mit A[0] = null
		return outputArray;
	}
	
	public static String[] outputTabelleSpalteListe(String tableName, String tableAddressTyp, String tableAddress, String col, String ColumnsTagname, String InhaltTagname) throws Exception{
		String[] outputArray = null;
		String outputText = "";
		List<WebElement> rows = searchTableColumns(tableAddressTyp, tableAddress, col, ColumnsTagname, InhaltTagname);
		Label2: for(int i=0; i<rows.size();i++) {//rows[0] ist der Spalte-Titel
			String outputText1 = rows.get(i).getText();
			if(outputText1.contains("Mil")) {
				outputText1 = "Miljöh";
			}
			if(outputText1.equals("")||outputText1.equals(null)) {
				switch (tableName) {
				case "tabelle1":
					String[] idsCol = IDTabelle1Cell(col);
					for(int j=0; j<idsCol.length; j++) {
						outputText1 = htmlTextGetter(idsCol[j]);
						outputText = outputText + "," + outputText1;	
					} break Label2;

				case "Käsewahl":
					String[] idsCol1 = IDKaesewahlCell(col);
					for(int j=0; j<idsCol1.length; j++) {
						outputText1 = htmlTextGetter(idsCol1[j]);
						outputText = outputText + "," + outputText1;	
					} break Label2;
					
				default:
					break;
				}
//				String[] idsCol = IDTabelle1Cell(col);
//				for(int j=0; j<idsCol.length; j++) {
//					outputText1 = htmlTextGetter(idsCol[j]);
//					outputText = outputText + "," + outputText1;	
//				} break Label2;
			} else {
			outputText = outputText + "," + outputText1;
			}
		}
		outputArray = outputText.split(",");
		return outputArray; 
	}
	
	public static void leftClickTableCell(String tableAddressTyp, String tableAddress, String row, String col, String ColumnsTagname, String InhaltTagname) throws Exception {
		Actions actions = new Actions(driver);
		actions.moveToElement(searchTableCell(tableAddressTyp, tableAddress, row, col, ColumnsTagname, InhaltTagname)).click().build().perform();
	}
	
	public static void duppleClickTableCell(String tableAddressTyp, String tableAddress, String row, String col, String ColumnsTagname, String InhaltTagname) throws Exception {
		Actions actions = new Actions(driver);
		actions.moveToElement(searchTableCell(tableAddressTyp, tableAddress, row, col, ColumnsTagname, InhaltTagname)).doubleClick().build().perform();	
	}
					
	public static void rightClickTableCell(String tableAddressTyp, String tableAddress, String row, String col, String ColumnsTagname, String InhaltTagname) throws Exception {
		Actions actions = new Actions(driver);
		actions.contextClick(searchTableCell(tableAddressTyp, tableAddress, row, col, ColumnsTagname, InhaltTagname)).perform(); 		
	}
				
	public static void highLightTableCell(String tableAddressTyp, String tableAddress, String row, String col, String ColumnsTagname, String InhaltTagname) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", searchTableCell(tableAddressTyp, tableAddress, row, col, ColumnsTagname, InhaltTagname));					
	}
	
	public static void valueCellMarker(String tableAddressTyp, String tableAddress, String row, String col, String ColumnsTagname, String InhaltTagname) throws Exception {	
		Actions actions = new Actions(driver);
		//sendKeys(Keys.chord(Keys.CONTROL, "a")) geht's nicht!
		actions.moveToElement(searchTableCell(tableAddressTyp, tableAddress, row, col, ColumnsTagname, InhaltTagname))
		.click()
		.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
        .build().perform();	
	}
	
	public static void mouseOverTableCell(String tableAddressTyp, String tableAddress, String row, String col, String ColumnsTagname, String InhaltTagname) throws Exception {		
		Actions actions = new Actions(driver);						
		actions.moveToElement(searchTableCell(tableAddressTyp, tableAddress, row, col, ColumnsTagname,InhaltTagname)).perform();							 		 				
	}
	
	public static void buttonClicker(String buttonAddressTyp, String buttonAddress) throws Exception {
		TimeUnit.SECONDS.sleep(3);
		Common.Locator(buttonAddressTyp, buttonAddress).click();
		TimeUnit.SECONDS.sleep(5);
	}

	public static void InputValueInField(String FieldAddressTyp, String FieldAddress, String Value)  {
		final Charset fromCharset = Charset.forName("windows-1252");
		 final Charset toCharset = Charset.forName("UTF-8");
		 String fixed = new String(Value.getBytes(fromCharset), toCharset);
		try {
			try {
				TimeUnit.SECONDS.sleep(3);
				Common.Locator(FieldAddressTyp, FieldAddress).clear();
				Common.Locator(FieldAddressTyp, FieldAddress).sendKeys(fixed);
				logger.info("Eingabe 1 erfolgreich");
			} catch (InterruptedException e) {
				logger.warning("NOT FOUND INPUTFELD");
				System.err.println("FAILURE");
				e.printStackTrace();
			}
	
		}
		catch (NoSuchElementException  ex) {
			logger.warning("Input failed");
			System.err.println("FAILL");
		}
		
	}
	
	public static String Convert1252ToUTF8(String windows1252Text) {
		final Charset fromCharset = Charset.forName("windows-1252");
		final Charset toCharset = Charset.forName("UTF-8");
		 String UTF8Text = new String(windows1252Text.getBytes(fromCharset), toCharset);
		 return UTF8Text;
	}
	
	public static String ConvertUTF8To1252(String UTF8Text) {
		final Charset fromCharset = Charset.forName("UTF-8");
		final Charset toCharset = Charset.forName("windows-1252");
		 String windows1252Text = new String(UTF8Text.getBytes(fromCharset), toCharset);
		 return windows1252Text;
	}

	public static String getTextByElement(String ElementAddressTyp, String ElementAddress) {
		String elementText = Common.Locator(ElementAddressTyp, ElementAddress).getText();
		return elementText;
	}
	
	public static String htmlTextGetterHR(String id) {
		String elem = driver.findElement(By.id(id)).getAttribute("value");
		return elem;
		}

	// überprüfen, ob Radiobutton oder CheckBox schon angewählt wurde? (true/false)
	public static boolean checkRadioButtonAndCheckBox(String elementAddressTyp, String elementAddress) {
		boolean status = false;
		List<WebElement> webElements = Common.ListLocator(elementAddressTyp, elementAddress);
		// int count = webElements.size();
		for (WebElement check : webElements) {
			if (check.isEnabled()) {
				status = check.isSelected();
			}
		}
		return status;
	}

	public static void clickRadioButtonAndCheckBox(String elementAddressTyp, String elementAddress) throws Exception {
		List<WebElement> webElements = Common.ListLocator(elementAddressTyp, elementAddress);
		webElements.get(0).click();
		System.out.println("Radiobutton oder CheckBox geklickt");
		TimeUnit.SECONDS.sleep(2);
	}

	public static List<WebElement> botstrapDropDownMenu(String dropDownAddressTyp, String dropDownAddress, String dropDownMenuAddressTyp, String dropDownMenuAddress) throws Exception {
		Common.Locator(dropDownAddressTyp, dropDownAddress).click();
		Thread.sleep(3000);
		List<WebElement> listElements = Common.ListLocator(dropDownMenuAddressTyp, dropDownMenuAddress);
		return listElements;
	}
	
	public static void botstrapDropDown(String dropDownAddressTyp, String dropDownAddress, String dropDownMenuAddressTyp, String dropDownMenuAddress, String dropDownElementText) throws Exception{
		List<WebElement> dropDownList = botstrapDropDownMenu(dropDownAddressTyp, dropDownAddress, dropDownMenuAddressTyp, dropDownMenuAddress);
		for (WebElement dropDownListElement : dropDownList) {
			if (dropDownListElement.getText().trim().equals(dropDownElementText)) {
				dropDownListElement.click();
				break;
			}
		}
	}
	
	public static void MouseOverBotstrapDropDown(String dropDownAddressTyp, String dropDownAddress) {
		Actions actions = new Actions(driver);
		actions.moveToElement(Locator(dropDownAddressTyp, dropDownAddress)).perform();
	}
	
	public static void scrollToElement(String textWert) {
			WebElement element = driver.findElement(By.xpath("//*[text()='"+textWert+"']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	//Scroll a Element to middle of Viewport
	public static void scrollElementToMiddle(String textWert) throws Exception {
		WebElement element = driver.findElement(By.xpath("//*[text()='"+textWert+"']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript( 
				  "var elementTop = arguments[0];" 
				+ "box = elementTop.getBoundingClientRect();"
				+ "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
				+ "window.scrollBy(0, box.top-(viewPortHeight/2));", element);
		Thread.sleep(3000);
	}
	
	public static boolean elementTextIsVisible(String textElement) {
		boolean temp = false;
		try {
			WebElement element = driver.findElement(By.xpath("//*[text()='" + textElement + "']"));
			element.isDisplayed();
			temp = true;
		} catch (Exception e) {
			temp = false;
		}
		return temp;
	}
	
	public static boolean isVisibleInViewport_New(String textWert) {
		WebElement element = driver.findElement(By.xpath("//*[text()='"+textWert+"']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		  return (boolean)js.executeScript(
		      "	 var elem = arguments[0],               " +
		      "  box = elem.getBoundingClientRect(),    " +
		      "  cx = box.left + box.width / 2,         " +
		      "  cy = box.top + box.height / 2,         " +
		      "  e = document.elementFromPoint(cx, cy); " +
		      "	 for (; e; e = e.parentElement) {       " +
		      "  if (e === elem)                        " +
		      "    return true;                         " +
		      "	 }                                      " +
		      "	 return false;                          "
		      , element);
		}
	
	public static boolean isVisibleInViewport(String textWert) {
		WebElement element = driver.findElement(By.xpath("//*[text()='"+textWert+"']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (boolean)js.executeScript(
			   "box = arguments[0].getBoundingClientRect();" 
			 + "if ((box.top > 0) && (box.left > 0)"
			 + "&& (box.right < (window.innerWidth || document.documentElement.clientWidth))"
			 + "&& (box.bottom < (window.innerHeight || document.documentElement.clientHeight))){"
			 + " return true; "
			 + " } else {return false;}", element);	
	}

	//switch to new windows or new tabs:
	public static boolean switchToWindow(String windowTitle) {
		int count = 0;
		boolean status = false;
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for(String setWindow : allWindows) {
			driver.switchTo().window(setWindow);
			if (driver.getTitle().contains(windowTitle)) {
				count +=1;
				status = true;
				driver.switchTo().window(parentWindow);
			}
		}
		if(count == 0) {
			driver.switchTo().window(parentWindow);
			status = false;
		}
		return status;
	}
	
	// switch to new windows or new tabs:
	public static String searchElemNewWindow(String windowTitle, String elem) {
		String elemText = null;
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String setWindow : allWindows) {
			driver.switchTo().window(setWindow);
			if (driver.getTitle().contains(windowTitle)) {
				List<WebElement> wertText = Common.ListLocator("textName", elem);
				if (wertText.size() != 0) {
					for (int i = 0; i < wertText.size(); i++) {
						if (wertText.get(i).getText().equals(elem)) {
							elemText = wertText.get(i).getText();
							break;
						}
					}
				} else {
					driver.switchTo().window(parentWindow);
					System.out.println(elem + " nicht gefunden!");
				}
			}
		}
		return elemText.trim();
	}
	
	public static List<WebElement> ComboboxInput(String ComboboxAddressTyp, String ComboboxAddress, String inputText1) throws Exception{
		List<WebElement> listbox = null;
		String inputText = Convert1252ToUTF8(inputText1);
		WebElement inputBox = Locator(ComboboxAddressTyp, ComboboxAddress);
		Actions actions = new Actions(driver);
		actions.moveToElement(inputBox).click().sendKeys(inputText).build().perform();
		try {
			Thread.sleep(1000);
			listbox = ListLocator("textName", inputText);
			System.out.println(listbox.size());
		
		} catch (InterruptedException e) {
			System.out.println("Kein Suchergebnis gefunden");
		}
		return listbox;
	}
	//Text input than click on a element
	public static void ComboboxInputClicker(String ComboboxAddressTyp, String ComboboxAddress, String inputText1, String inputPos) {
		WebElement inputBox = Locator(ComboboxAddressTyp, ComboboxAddress);
		String inputText = Convert1252ToUTF8(inputText1);
		Actions actions = new Actions(driver);
		actions.moveToElement(inputBox).click().sendKeys(inputText).build().perform();
		try {
			int inputPosNum = Integer.parseInt(inputPos);
			Thread.sleep(3000);
			List<WebElement> listbox = ListLocator(Constans.ListboxAddressTyp, Constans.ListboxAddress);
			System.out.println(listbox.size());
			
			for(int i=0; i<listbox.size(); i++) {
				System.out.println(listbox.get(i).getText());
				if(i==(inputPosNum-1)) {
					System.out.println("Text ist: "+listbox.get(i).getText());
					listbox.get(i).click();
					break;
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Kein Suchergebnis gefunden");
		}
	}
	
	public static boolean listSearch(String ListboxAddressTyp, String ListboxAddress, String searchText) throws Exception{
		Boolean status = false;
		List<WebElement> listsearch = ListLocator(ListboxAddressTyp, ListboxAddress);
		System.out.println(listsearch.size());
		Thread.sleep(2000);
		for(WebElement listElem : listsearch) {		
			if(searchText.equals(listElem.getAttribute("value"))) {
				status = true;
				break;
			} else {
				status = false;
			}
		}
		return status;
	}
	
	public static void searchAndClick(String ComboboxAddressTyp, String ComboboxAddress, String searchText) throws Exception{
		WebElement inputBox = Locator(ComboboxAddressTyp, ComboboxAddress);
		Actions actions = new Actions(driver);
		actions.moveToElement(inputBox).click().build().perform();
		
		try {
		//	int inputPosNum = Integer.parseInt(inputPos);
			Thread.sleep(2000);
			List<WebElement> listbox = ListLocator(Constans.Listbox1_AddressTyp, Constans.Listbox1_Address);		
			for(int i=0; i<listbox.size(); i++) {
				System.out.println(listbox.get(i).getAttribute("value"));
				if(listbox.get(i).getAttribute("value").trim().equals(searchText)) {
					System.out.println("Text ist: "+listbox.get(i).getAttribute("value"));
					listbox.get(i).click();
					break;
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Kein Suchergebnis gefunden");
		}
	}
	
	public static void mouseOverCombobox(String ComboboxAddressTyp, String ComboboxAddress) {
		WebElement inputBox = Locator(ComboboxAddressTyp, ComboboxAddress);
		Actions actions = new Actions(driver);
		actions.moveToElement(inputBox).build().perform();
	}
	
public static String IDTabelle1(String row, String col) {
	row.trim();
	col.trim();
	String id = null;
	if(row.equals("1") && col.equals("Deutschland")) {
		id= "tabInput1D";
	}
	if(row.equals("1") && col.equals("Frankreich")) {
		id= "tabInput1F";
	}
	if(row.equals("1") && col.equals("Italien")) {
		id= "tabInput1I";
	}
	if(row.equals("2") && col.equals("Deutschland")) {
		id= "tabInput2D";
	}
	if(row.equals("2") && col.equals("Frankreich")) {
		id= "tabInput2F";
	}
	if(row.equals("2") && col.equals("Italien")) {
		id= "tabInput2I";
	}
	return id;
}

public static String[] IDTabelle1Cell (String col) {
	String ids = null;
	String[] idsCol=null;
	if(col.equals("Deutschland")) {
		ids = "tabInput1D,tabInput2D";
	}
	if(col.equals("Frankreich")) {
		ids = "tabInput1F,tabInput2F";
	}
	if(col.equals("Italien")) {
		ids= "tabInput1I,tabInput2I";
	}
	idsCol = ids.split(",");
	return idsCol;
}

public static String[] IDTabelle1Row (String row) {
	String ids = null;
	String[] idsRow=null;
	if(row.equals("1")) {
		ids = "tabInput1D,tabInput1F,tabInput1I";
	}
	if(row.equals("2")) {
		ids = "tabInput2D,tabInput2F,tabInput2I";
	}
	idsRow = ids.split(",");
	return idsRow;
}

public static String htmlTextGetter(String id) {
String elem = driver.findElement(By.id(id)).getAttribute("value");
	if(elem.contains("Mil")) {
	elem = "Miljöh";
	}
return elem;
}

public static String IDKaesewahl(String row, String col) {
	row.trim();
	col.trim();
	String id = null;
	if(row.equals("Cheddar") && col.equals("Wenig")) {
		id= "tabInput1D";
	}
	if(row.equals("Cheddar") && col.equals("Durchschnittlich")) {
		id= "tabInput1F";
	}
	if(row.equals("Cheddar") && col.equals("Viel")) {
		id= "tabInput1I";
	}
	if(row.equals("Mozzarella") && col.equals("Wenig")) {
		id= "tabInput2D";
	}
	if(row.equals("Mozzarella") && col.equals("Durchschnittlich")) {
		id= "tabInput2F";
	}
	if(row.equals("Mozzarella") && col.equals("Viel")) {
		id= "tabInput2I";
	}
	return id;
}

public static String[] IDKaesewahlCell (String col) {
	String ids = null;
	String[] idsCol=null;
	if(col.equals("Wenig")) {
		ids = "tabInput1D,tabInput2D";
	}
	if(col.equals("Durchschnittlich")) {
		ids = "tabInput1F,tabInput2F";
	}
	if(col.equals("Viel")) {
		ids= "tabInput1I,tabInput2I";
	}
	idsCol = ids.split(",");
	return idsCol;
}

public static String[] IDKaesewahlRow (String row) {
	String ids = null;
	String[] idsRow=null;
	if(row.equals("Cheddar")) {
		ids = "tabInput1D,tabInput1F,tabInput1I";
	}
	if(row.equals("Mozzarella")) {
		ids = "tabInput2D,tabInput2F,tabInput2I";
	}
	idsRow = ids.split(",");
	return idsRow;
}
	
	/*

Yes, this is possible. First, you need to save the reference to the current window.

String parentWindow= driver.getWindowHandle();

The after having clicked the link, you need to switch to the other window.

List<String> allWindows = driver.getWindowHandles();
for(String curWindow : allWindows){
    driver.switchTo().window(curWindow);
}

This is where you perform operations on the new window, finally closing it with

driver.close();

and switch back to the parent window

driver.switchTo().window(parentWindow);

*/

public static String testExecuter(String sentence) throws IOException {
	String statusID = null;
	KeywordsEditor keywordsEdit = new KeywordsEditor();
	for(int n=1; n<2; n++) {
		
		Common.openUrl(Constans.urlHenrik);
		
		if(n==1) {
			System.out.println("_______________ Testfall"+n+"_________________");
			//Common.openUrl(Constans.url);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall1);
		//	keywordsEdit.keywordsHandling(Constans.pathTabelleProbe); 
			try {
				statusID =	keywordsEdit.keywordsHandling(sentence);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
//			keywordsEdit.keywordsHandling(Constans.pathTextfeld1);
//			keywordsEdit.keywordsHandling(Constans.pathTabelle4);
//			keywordsEdit.keywordsHandling(Constans.pathTabelle3);
//			keywordsEdit.keywordsHandling(Constans.pathTabelle2);
//			keywordsEdit.keywordsHandling(Constans.pathTabelle1);
//			keywordsEdit.keywordsHandling(Constans.pathRadiobutton1);
//			keywordsEdit.keywordsHandling(Constans.pathCheckbox1);
//			keywordsEdit.keywordsHandling(Constans.pathPasswortfeld1);
//			keywordsEdit.keywordsHandling(Constans.pathDropdown1);
//			keywordsEdit.keywordsHandling(Constans.pathDropdown2);
//			keywordsEdit.keywordsHandling(Constans.pathKombobox1);
//			keywordsEdit.keywordsHandling(Constans.pathScrollbar1);
//			keywordsEdit.keywordsHandling(Constans.pathLink1);
//			keywordsEdit.keywordsHandling(Constans.pathLink2);
		
		}
		if(n==2) {
			System.out.println("_______________ Testfall"+n+"_________________");
			//Common.openUrl(Constans.urlAdditionTable);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall2);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall2_1);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall2_2);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall2_3);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall2_4);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall2_5);
			try {
				keywordsEdit.keywordsHandling(Constans.pathProbe);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(n==3) {
			System.out.println("_______________ Testfall"+n+"_________________");
			//Common.openUrl(Constans.urlRadioButtonCheckBox);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall3);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall3_1);
			
		}
		if(n==4) {
			System.out.println("Testfall 4");
			
		}
		if(n==5) {
			System.out.println("_______________ Testfall"+n+"_________________");
			//Common.openUrl(Constans.urlAdditionTable);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall5);
			
		}
		if(n==6) {
			System.out.println("_______________ Testfall"+n+"_________________");
			//Common.openUrl(Constans.urlBootstrapDropDown);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall6);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall6_2);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall6_3);
			//keywordsEdit.keywordsHandling(Constans.pathProbe);
		}
		if(n==7) {
			System.out.println("_______________ Testfall"+n+"_________________");
			//Common.openUrl(Constans.urlBootstrapDropDown);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall7);
			//keywordsEdit.keywordsHandling(Constans.pathProbe);
		}
		if(n==8) {
			System.out.println("_______________ Testfall"+n+"_________________");
			//Common.openUrl(Constans.urlPPIAG);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall8_1);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall8_2);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall8_3);
		}
		if(n==9) {
			System.out.println("_______________ Testfall"+n+"_________________");
			//Common.openUrl(Constans.urlBootstrapDropDown);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall9_1);
			//keywordsEdit.keywordsHandling(Constans.pathTestfall9_2);
			
		}
		
	}
	return statusID;
		
}

}
