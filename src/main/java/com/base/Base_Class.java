package com.base;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base_Class {

    public static WebDriver driver;

    protected static void launchBrowser(String browser) {
        try {
            if(browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if(browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURED DURING BROWSER LAUNCH");
        }
        driver.manage().window().maximize();
    }

    protected static void browserClose() {
        try {
            driver.close();
        } catch(Exception e) {
            Assert.fail("ERROR: OCCURED DURING BROWSER CLOSING");
        }
    }
    
    protected static void browserTerminated() {
        try {
            driver.quit();
        } catch(Exception e) {
            Assert.fail("ERROR: OCCURED DURING BROWSER QUITING");
        }
    }

    protected static void navigateTo(String newUrl) {
        try {
            driver.navigate().to(newUrl);
        } catch(Exception e) {
            Assert.fail("ERROR: OCCURED DURING NAVIGATE TO");
        }
    }

    protected static void navigation(String function) {
        try {
            if(function.equalsIgnoreCase("back")) {
                driver.navigate().back();
            } else if(function.equalsIgnoreCase("forward")){
                driver.navigate().forward();
            } else if(function.equalsIgnoreCase("refresh")){
                driver.navigate().refresh();
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURED DURING NAVIGATION");
        }
    }
    
    protected static void launchUrl(String url) {
        try {
            driver.get(url);
        } catch(Exception e) {
            Assert.fail("ERROR: OCCURED DURING BROWSER LAUNCH");
        }
    }

    protected static void handleAlert(String type, String value) {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println(alertText);
            if(type.equalsIgnoreCase("accept")) {
                alert.accept();
            } else if (type.equalsIgnoreCase("dismiss")) {
                alert.dismiss();
            } else if(type.equalsIgnoreCase("prompt")) {
                alert.sendKeys(value);
                alert.accept();
            }
        } catch(Exception e) {
            Assert.fail("ERROR: OCCURED DURING ALERT");
        }
    }
    
    protected static void mouseAction(WebElement element, String actionType) {
        try {
            Actions action = new Actions(driver);
            if(actionType.equalsIgnoreCase("click")) {
                action.click(element).perform();
            } else if(actionType.equalsIgnoreCase("double click")) {
                action.doubleClick(element).perform();
            } else if(actionType.equalsIgnoreCase("right click")) {
                action.contextClick(element).perform();
            } else if(actionType.equalsIgnoreCase("mouse hover")) {
                action.moveToElement(element).perform();
            } else if(actionType.equalsIgnoreCase("click and hold")) {
                action.clickAndHold(element).perform();
            } else if(actionType.equalsIgnoreCase("release")) {
                action.release(element).perform();
            }
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURED DURING MOUSE ACTION");
        }
    }

    protected static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        try {
            Actions action = new Actions(driver);
            action.dragAndDrop(sourceElement, targetElement).perform();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURED DURING DRAG AND DROP");
        }
    }
    
    protected static void indexFrame(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURED DURING FRAME BY INDEX");
        }
    }

    protected static void frameIdOrName(String idOrName) {
        try {
            driver.switchTo().frame(idOrName);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURED DURING FRAME BY ID OR NAME");
        }
    }
    
    protected static void frameWebElement(WebElement element) {
        try {
            driver.switchTo().frame(element);
        } catch(Exception e) {
            Assert.fail("ERROR: OCCURED DURING FRAME BY WEBELEMENT");
        }
    }

    protected static void switchToParentFrame() {
        try {
            driver.switchTo().parentFrame();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURED DURING SWITCHING TO PARENT FRAME");
        }
    }

    protected static void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURED DURING SWITCHING TO DEFAULT CONTENT");
        }
    }
    
    protected static void windowHandles(int num) {
        try {
            List<String> allWindows = new ArrayList(driver.getWindowHandles());
            driver.switchTo().window(allWindows.get(num));
        } catch(Exception e) {
            Assert.fail("ERROR: OCCURED DURING WINDOW HANDLES");
        }
    }

    protected static void selectOption(WebElement element, String type, String value) {
        try {
            Select select = new Select(element);
            if(type.equalsIgnoreCase("text")) {
                select.selectByVisibleText(value);
            } else if(type.equalsIgnoreCase("index")) {
                select.selectByIndex(Integer.parseInt(value));
            } else if(type.equalsIgnoreCase("value")) {
                select.selectByValue(value);
            }
        } catch(Exception e) {
            Assert.fail("ERROR: OCCURED DURING VALUE SELECTION");
        }
    }
    
    protected static void deselectOption(WebElement element, String type, String value) {
        try {
            Select select = new Select(element);
            if(type.equalsIgnoreCase("text")) {
                select.deselectByVisibleText(value);
            } else if(type.equalsIgnoreCase("index")) {
                select.deselectByIndex(Integer.parseInt(value));
            } else if(type.equalsIgnoreCase("value")) {
                select.deselectByValue(value);
            }
        } catch(Exception e) {
            Assert.fail("ERROR: OCCURED DURING VALUE DESELECTION");
        }
    }

    protected static void gettingOptions(WebElement element, String type) {
        try {
            Select select = new Select(element);
            if(type.equalsIgnoreCase("all selected options")) {
                select.getAllSelectedOptions();
            } else if(type.equalsIgnoreCase("first selected options")) {
                select.getFirstSelectedOption();
            } else if(type.equalsIgnoreCase("all options")) {
                select.getOptions();
            }
        } catch(Exception e) {
            Assert.fail("ERROR: OCCURED DURING GETTING OPTIONS");
        }
    }
    
    protected static boolean isMultiSelect(WebElement dropdown) {
        try {
            Select select = new Select(dropdown);
            return select.isMultiple();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURED DURING CHECKING DROP DOWN");
            return false;
        }
    }

    protected static void passInput(WebElement element, Object value) {
        try {
            element.sendKeys(String.valueOf(value));
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURED DURING VALUE PASSING");
        }
    }

    protected static void clickOnElememt(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURED DURING CLICKING ELEMENT");
        }
    }
    
    protected static void elementStatus(WebElement element, String type) {
        try {
            if (type.equalsIgnoreCase("selected")) {
                element.isSelected();
            } else if (type.equalsIgnoreCase("enabled")) {
                element.isEnabled();
            } else if (type.equalsIgnoreCase("displayed")) {
                element.isDisplayed();
            }
        } catch (Exception e) {
            Assert.fail("ERROR:OCCURED DURING CHECKING THE ELEMENT");
        }
    }

    protected static void getTitle() {
        try {
            driver.getTitle();
        } catch(Exception e) {
            Assert.fail("ERROR:OCCURED DURING GETTING THE TITLE OF THE PAGE");
        }
    }

    protected static void url() {
        try {
            driver.getCurrentUrl();
        } catch(Exception e) {
            Assert.fail("ERROR:OCCURED DURING GETTING THE URL OF THE PAGE");
        }
    }
    
    protected static void getText(WebElement element) {
        try {
            element.getText();
           System.out.println(element.getText());
        } catch(Exception e) {
            Assert.fail("ERROR: OCCURED DURING GETTING TEXT OF THE WEBELEMENT");
        }
    }

    protected static void setImplicitWait(int seconds) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURED DURING IMPLICIT WAIT");
        }
    }
    
    protected static void setExplicitWait(WebElement element, int seconds, String type) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            if (type.equalsIgnoreCase("visibility")) {
            	wait.until(ExpectedConditions.visibilityOf(element));
			}
            else if (type.equalsIgnoreCase("click")) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}
            else if (type.equalsIgnoreCase("select")) {
                wait.until(ExpectedConditions.elementToBeSelected(element));
            }
            else if (type.equalsIgnoreCase("alert")) {
            	wait.until(ExpectedConditions.alertIsPresent());				
			}

        }
        catch (Exception e) {
            Assert.fail("ERROR: OCCURED DURING EXPLICIT WAIT");
        }
    }

    protected static void takeScreenshot(String filePath)  {
        try {
        	TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            File destFile = new File( "C:\\Users\\Navaneethakrishnan\\eclipse-workspace\\Maven_Project\\screenshot.png");
            FileHandler.copy(srcFile, destFile);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURED DURING SCREENSHOT");
        }
    }

    protected static void scrollIntoView(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING SCROLL INTO VIEW JAVASCRIPT");
        }
    }
    
    protected static void clickByJS(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING JAVASCRIPT CLICK");
        }
    }

    protected static void scrollDown(int range) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0," + range + ");");
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING SCROLL DOWN");
        }
    }

    protected static void scrollUp(int range) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,-" + range + ");");
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING SCROLL UP");
        }
    }
    
    protected static void setValueByJS(WebElement element, String value) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='" + value + "';", element);
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING SET VALUE BY JAVASCRIPT");
        }
    }

    protected static void rangeJs(String range) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0," + range + ");");
        } catch (Exception e) {
            Assert.fail("ERROR: OCCURRED DURING SET VALUE BY JAVASCRIPT");
        }
    }
    
    


}