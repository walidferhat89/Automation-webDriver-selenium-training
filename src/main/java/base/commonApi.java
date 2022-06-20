package base;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class commonApi {

    public WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\walid\\IdeaProjects\\may-22-experteam-bootcamp-framework\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {

        driver.close();
    }
    public String getPageTitle(){
        return driver.getTitle();
    }

    public void click(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception e) {
            driver.findElement(By.xpath(locator)).click();
        }
    }

    public void type(String locator, String input) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(input);
        } catch (Exception e) {
            driver.findElement(By.xpath(locator)).sendKeys(input);
        }

    }

    public String getElementText(String locator) {
        try {
            return driver.findElement(By.cssSelector(locator)).getText();
        } catch (Exception e) {
            return driver.findElement(By.xpath(locator)).getText();
        }

    }

    public boolean isDisplayed(String locator) {
        try {
            return driver.findElement(By.cssSelector(locator)).isDisplayed();
        } catch (Exception e) {
            return driver.findElement(By.xpath(locator)).isDisplayed();
        }
    }
}
