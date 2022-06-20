package com.saucedemo;

import base.commonApi;
import org.junit.Assert;
import org.junit.Test;


public class loginTest extends commonApi {

    @Test
    public void test1() {
    type("#user-name","standard_user");
        System.out.println("User name entered,");

    type("#password","secret_sauce");
        System.out.println("password entered,");

    click("#login-button");
        System.out.println("login btn clicked");

        String getTex = getElementText(".title");
        System.out.println("headerTitle:" + getTex);
        Assert.assertEquals("PRODUCTS", getTex);


    }
    @Test
    public void test2() {
    type("#user-name","standard_user");
        System.out.println("username entered");

    type("input[id='password']"," ");
        System.out.println("password field empty");

    click("input[id='login-button']");
        System.out.println("login btn clicked");

        String msg = getElementText("//h3[@data-test='error']");
        System.out.println(msg);

        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", msg);

    }
    @Test
    public void test3() {
    type("input[id='user-name']"," ");
        System.out.println("username field empty");

    type("input[id='password']","secret_sauce");
        System.out.println("password entered");

    click("input[id='login-button']");
        System.out.println("btn clicked");

        String msg = getElementText("//h3[@data-test='error']");
        System.out.println(msg);

        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", msg);
    }


}