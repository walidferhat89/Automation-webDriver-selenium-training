package com.saucedemo;


import org.junit.After;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {

    WebDriver driver;
    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\walid\\IdeaProjects\\may-22-experteam-bootcamp-framework\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        System.out.println("the title: " +driver.getTitle());
        Assert.assertEquals("Swag Labs", driver.getTitle());
    }
    @After
    public void tearDown(){
        driver.close();
    }



    @Test
    public void test2 (){


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

    }
    @Test
    public void test3(){

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



    }
}
