package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Alert al;
	public static Select s;
	public static int browser;
	
	public static void launchBrowser() {
	
		switch(browser) {
		case 1:WebDriverManager.edgedriver().setup();
		driver =new EdgeDriver();
	break;
	case 2:WebDriverManager.firefoxdriver().setup();
	driver =new FirefoxDriver();
	break;
	case 3:WebDriverManager.iedriver().setup();
	driver =new InternetExplorerDriver();
	break;
	default:
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();	
	}
	}
	public static void passUrl(String url) {
		driver.get(url);
	}                                                            
	public static void toMaximize() {
		driver.manage().window().maximize();
	}
	public static void toGetTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	public static void toGetCurrentUrl() {
		String Url = driver.getCurrentUrl();
		System.out.println(Url);

	}
	public static void toClose() {
	driver.close();
	}
	public static void toQuit() {
		driver.quit();

	}
	public static void getParentId() {
		String ParentId = driver.getWindowHandle();
		System.out.println(ParentId);
	}
	public static void getParchildId() {
		Set<String> allWindowId = driver.getWindowHandles();
		System.out.println(allWindowId);
	}
	public static void toInput(WebElement element,String input) {
	element.sendKeys(input);
	}
	public static void toClick(WebElement element) {
		element.click();
		}
	public static void toGetText(WebElement element) {
String text = element.getText();
System.out.println(text);
	}
	
	//public static void toGetAttribute(WebElement element) {
	//	String attribute = element.getAttribute("value");
		//System.out.println(attribute);
		//}
	public static String toGetAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
		return attribute;
		}
	
	public static void mouseHoverAction(WebElement element) {
		a=new Actions(driver);
		a.moveToElement(element).perform();

	}
	public static void toDragAndDrop(WebElement element,WebElement element1) {
		a.dragAndDrop(element,element1).perform();
	}
	public static void rightClick(WebElement element) {
		a.contextClick(element).perform();

	}
	public static void toDoubleClick() {
		a.doubleClick().perform();

	}
	public static void toKeyUp(WebElement element) {
		a.keyUp(element,Keys.SHIFT).perform();

	}
	public static void toKeyDown(WebElement element) {
		a.keyDown(element,Keys.SHIFT).perform();

	}

	public static  void enterKey() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static  void paste() throws AWTException {
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	public static  void tabKey() throws AWTException {
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	public static  void downKey() throws AWTException {
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	public static  void upKey() throws AWTException {
		
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}
	public static void toAcceptAlert() {
		 al=driver.switchTo().alert();
		al.accept();
	
	}
	public static void toDismissAlert() {
		 al=driver.switchTo().alert();
		al.dismiss();
	
	}
	public static void screenshot(String filename) throws IOException {
		TakesScreenshot t=(TakesScreenshot)driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\User\\eclipse-workspace\\Selenium1\\"+filename+".png");
		FileUtils.copyFile(src, dest);

	}
	public static void frameId(String id) {
		driver.switchTo().frame(id);
		
	}
	public static void frameName(String name) {
		driver.switchTo().frame(name);
		
	}
	public static void frameIndex(int index) {
		driver.switchTo().frame(index);
		
	}
	public static void frameElement(WebElement element) {
		driver.switchTo().frame(element);
		
	}
	public static void parentFrame() {
		driver.switchTo().parentFrame();
		
	}
	public static void defaultFrame() {
		driver.switchTo().defaultContent();
		
	}
	public static void selectValue(WebElement element,String value) {
		 s =new Select(element);
		 s.selectByValue(value);
	}
	public static void selectText(WebElement element,String text) {
		
		 s.selectByVisibleText(text);
	}
	public static void selectIndex(WebElement element,int index) {
				 s.selectByIndex(index);
	}
	public static void deselectValue(WebElement element,String value) {
		 s =new Select(element);
		 s.deselectByValue(value);
		 
	}
	public static void deselectText(WebElement element,String text) {
		
		 s.deselectByVisibleText(text);
	}
	public static void deselectIndex(WebElement element,int index) {
				 s.deselectByIndex(index);
	}
	public static void toDeselectAll() {
		 s.deselectAll();
}
	public static void toCheckMultiple() {
		 boolean multiple = s.isMultiple();
		 System.out.println(multiple);
}
	public static void toGetOptions(WebElement element) {
		List<WebElement> Options= s.getOptions();
		for(int i=0;i<Options.size();i++) {
		 element =Options.get(i);
			System.out.println(element.getText());
		}
		
	}
	public static void toGetFirstOption(WebElement element) {
		 element = s.getFirstSelectedOption();
		System.out.println(element.getText());

	}
	public static void toGetAllOptions(WebElement element) {
		
			 List<WebElement> Options= s.getAllSelectedOptions();
			for(int i=0;i<Options.size();i++) {
			 element =Options.get(i);
				System.out.println(element.getText());
			}
			
	}
	
	public static  void toInsertJavascript(WebElement element,String input) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].setAttribute('value','"+input+"')",element);
		
	}
	public static  void toClickJavascript(WebElement element) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].click()",element);
		
	}
	public static  void scrollDown(WebElement element) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView('true')",element);
		
	}
	public static  void scrollUp(WebElement element) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].scrollIntoView('false')",element);
		
	}
	public static void windowUrl(String url) {
		driver.switchTo().window(url);
		
	}
	public static void windowTitle(String title) {
		driver.switchTo().window(title);
		
	}
	public static void windowId() {
		 String windowHandle = driver.getWindowHandle();
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> li=new ArrayList();
		 li.addAll( windowHandles );
		 driver.switchTo().window(li.get(1));
	}
	public static void nxtwindowId() {
		 String windowHandle = driver.getWindowHandle();
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> li=new ArrayList();
		 li.addAll( windowHandles );
		 driver.switchTo().window(li.get(2));
	}
public static String excelRead(int row,int cell) throws IOException {
		
		File f=new File("C:\\Users\\User\\eclipse-workspace\\TESTNG\\Datas\\Testdata.xlsx");
		
		FileInputStream file=new FileInputStream(f);
		
		Workbook w=new XSSFWorkbook(file);
		
		Sheet s=w.getSheet("Sheet1");                                        
		
			Row r=s.getRow(row);
		Cell c=r.getCell(cell);

				int cellType = c.getCellType();
				String value; //instance variable
				if(cellType==1) {
					//currentcell value is string value
					value=c.getStringCellValue();
				}
				else if(DateUtil.isCellDateFormatted(c)) {
					Date d=c.getDateCellValue();
					SimpleDateFormat sim=new SimpleDateFormat("dd/mm/yyyy");
					value=sim.format(d);
				}
				else {
					double dd=c.getNumericCellValue();
					//typecasting
					long l=(long)dd;
					value= String.valueOf(l);
				}
return value;
				}

}

	
