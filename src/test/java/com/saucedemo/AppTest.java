package com.saucedemo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
    /*public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\walid\\IdeaProjects\\may-22-experteam-bootcamp-framework\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Assert.assertEquals("Swag Labs", driver.getTitle());
    }*/

    @Test
    public void test1 () {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\walid\\IdeaProjects\\may-22-experteam-bootcamp-framework\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Swag Labs",title);
        driver.close();
    }

    @Test
    public void test2 (){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\walid\\IdeaProjects\\may-22-experteam-bootcamp-framework\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        String title=driver.getTitle();
        System.out.println("title appears : " + title);
        Assert.assertEquals("Swag Labs",title);

        WebElement userNameField = driver.findElement(By.id("user-name"));
        boolean userNameIsDisplayed = userNameField.isDisplayed();
        System.out.println("user name field is displayed: " +userNameIsDisplayed);
        Assert.assertTrue(userNameIsDisplayed);

        WebElement passwordField = driver.findElement(By.id("password"));
        boolean passwordFieldDisplayed = passwordField.isDisplayed();
        System.out.println("password field is displayed: " + passwordFieldDisplayed);
        Assert.assertTrue(passwordFieldDisplayed);

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        boolean loginbtnIsDisplayed = loginBtn.isDisplayed();
        System.out.println("login btn is displayed: " + loginbtnIsDisplayed);
        Assert.assertTrue(loginbtnIsDisplayed);
        driver.close();

    }
    @Test
    public void test3(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\walid\\IdeaProjects\\may-22-experteam-bootcamp-framework\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        String title=driver.getTitle();
        System.out.println("title appears : " + title);
        Assert.assertEquals("Swag Labs",title);

        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        System.out.println("User name entered,");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        System.out.println("password entered,");
        WebElement clickBtn = driver.findElement(By.id("login-button"));
        clickBtn.click();
        System.out.println("login btn clicked");
        WebElement Header = driver.findElement(By.className("title"));
        String getTex = Header.getText();
        System.out.println("headerTitle:" + getTex);
        Assert.assertEquals("PRODUCTS",getTex);
        driver.close();

    }
}
