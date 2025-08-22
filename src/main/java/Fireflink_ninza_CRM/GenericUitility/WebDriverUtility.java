package Fireflink_ninza_CRM.GenericUitility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to WebDriver
 * @author Tushar Jadhav
 */
public class WebDriverUtility {

	/**
	 * This method will maximize the browser window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * this method will minimize the browser window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will full screen the browser window
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	
	/**
	 * this method will do implicit wait 
	 * @param driver
	 */
	public void implicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will perform explicit wait till the element is visible
	 * @param wait
	 * @param element
	 */
	public void waitTillVisibiltyOfElement(WebDriverWait wait,WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitTillVisibiltyOfElement(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will perform explicit wait till the element is 
	 * @param wait
	 * @param element
	 */
	public void waitTillElementIsClickable(WebDriverWait wait,WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will select the dropdown using index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) {
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}
	
	
	/**
	 * This method will select the dropdown using value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}
	
	/**
	 * This method will select the dropdown using visible text
	 * @param visibleText
	 * @param element
	 */
	public void handleDropDown(String visibleText,WebElement element) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(visibleText);
	}
	
	public void mouseHoveringAction(WebDriver driver,WebElement element) {
		
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();;
	}
	
	public void mouseHoverAction(WebDriver driver,int x,int y) {
		Actions act = new Actions(driver);
		act.moveByOffset(x,y).perform();;
	}
	
	public void dragAndDropAction(WebDriver driver,WebElement source,WebElement destination) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, destination).perform();;
		
	}
	
	public void doubleClickAction(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	public void doubleClickAction(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void rightClickAction(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element);
	}
	
	
	
	public void scroll(WebDriver driver,int x,int y) {
		Actions act = new Actions(driver);
		act.scrollByAmount(x,y).perform();;
	}
	
	public void scroll(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();;
	}
	
	public void switchFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchFrameBack(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	public void switchFrameToDefault(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	
	public void handleAlertPopUp(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void handleConfirmationPopUp(WebDriver driver,String value) {
		
		if(("OK").equalsIgnoreCase(value)) {
			driver.switchTo().alert().accept();
		}
		else {
			driver.switchTo().alert().dismiss();
		}
	}
	
	public void handlePromptPopUp(WebDriver driver,String info) {
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(info);
		alert.accept();
	}
	
	
	public void switchToOtherWindow(WebDriver driver) {
		String mainId = driver.getWindowHandle();
		Set<String> winId = driver.getWindowHandles();
		
		for(String id:winId) {
			if(!id.equals(mainId))
			{
				driver.switchTo().window(id);
				break;
			}
		}
	}
	
	/**
     * This method will be used to switch from one window to differ window
     * 
     * @param driver
     * @param expectedTitle
     */
    public void switchWindow(WebDriver driver, String expectedTitle) {
        Set<String> winIds = driver.getWindowHandles();
        for (String winId : winIds) {
            driver.switchTo().window(winId);
            String actualTitle = driver.getTitle();
            if (actualTitle.toLowerCase().contains(expectedTitle.toLowerCase())) {
                break;
            }
        }

    }
    
    public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException {
    	
    	TakesScreenshot ts = (TakesScreenshot) driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File dst = new File(".\\Screenshots\\"+screenShotName+".png");
    	
    	FileHandler.copy(src, dst);
    	
    	return dst.getAbsolutePath(); // for extent report
    }
	
	
	
	
	
	
	
}
