package base;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;


public class commonApi {

    public WebDriver driver;
    String currentDir = System.getProperty("user.dir");
    String browserstackUsername="walidferhat_yxeTJ1";
    String browserstackPassword="euohJpjYBWiG4JpwZLbN";
    String saucelabsUsername="oauth-walidferhat89-2a20d";
    String saucelabspassword="d2b1ff08-0d4b-49e4-ac03-afa7d1959180";
    public void cloudDriver(String envirnmnt,String username,String password,
                            String os,String osVersion,String browser,String browserVersion) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os",os);
        capabilities.setCapability("osVersion",osVersion);
        capabilities.setCapability("browser",browser);
        capabilities.setCapability("browserVersion",browserVersion);

        if (envirnmnt.equalsIgnoreCase("browserstack")) {
            capabilities.setCapability("resolution","1024x768");
            driver = new RemoteWebDriver(new URL("http://"+username+":"+password+"@hub-cloud.browserstack.com:80/wd/hub"),capabilities );
        }
        else if (envirnmnt.equalsIgnoreCase("saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://"+username+":"+password+"@ondemand.saucelabs.com:80/wd/hub"),capabilities );
        }
    }
    public void localDriver(String os,String browser){
        if(os.equalsIgnoreCase("win")){
            if(browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", currentDir+"\\driver\\win\\chromedriver.exe");
                driver = new ChromeDriver();

            }
            else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", currentDir+"\\driver\\win\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }
        else if (os.equalsIgnoreCase("mac")) {
            if(browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", currentDir+"/driver/mac/chromedriver");
                driver = new ChromeDriver();

            }
            else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", currentDir+"/driver/mac/geckodriver-v0.31.0-macos.tar.gz");
                driver = new FirefoxDriver();

            }

        }
    }
    @Parameters({"useCloudDrive","os","browser","url","envrnmnr","osVersion","browserVersion"})
    @BeforeMethod
    public void setUp(boolean useCloudDriv,String os, String browser, String url,String envrnmnt,
                      String osVersion,String browserVersion) throws MalformedURLException {

        if(useCloudDriv){
            if(envrnmnt.equalsIgnoreCase("browserstack")){
            cloudDriver(envrnmnt,browserstackUsername,browserstackPassword,os,osVersion,browser,browserVersion);
            }
            else if (envrnmnt.equalsIgnoreCase("saucelabs")) {
                cloudDriver(envrnmnt,saucelabsUsername,saucelabspassword,os,osVersion,browser,browserVersion);
            }

        }
        else {
            localDriver(os,browser);
        }

        driver.get(url);
        driver.manage().window().maximize();
    }



        @AfterMethod
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

