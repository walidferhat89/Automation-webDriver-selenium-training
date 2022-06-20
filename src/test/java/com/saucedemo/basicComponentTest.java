package com.saucedemo;


import base.commonApi;
import org.junit.Assert;

import org.junit.Test;


public class basicComponentTest extends commonApi {


    @Test
    public void test1(){
        System.out.println("the title: " +getPageTitle());
        Assert.assertEquals("Swag Labs", getPageTitle());
    }
    @Test
    public void test2 (){

        boolean userNameIsDisplayed = isDisplayed("#user-name");
        System.out.println("user name field is displayed: " +userNameIsDisplayed);
        Assert.assertTrue(userNameIsDisplayed);

        boolean passwordFieldDisplayed = isDisplayed("#password");
        System.out.println("password field is displayed: " + passwordFieldDisplayed);
        Assert.assertTrue(passwordFieldDisplayed);

        boolean loginbtnIsDisplayed = isDisplayed("#login-button");
        System.out.println("login btn is displayed: " + loginbtnIsDisplayed);
        Assert.assertTrue(loginbtnIsDisplayed);

    }


}
