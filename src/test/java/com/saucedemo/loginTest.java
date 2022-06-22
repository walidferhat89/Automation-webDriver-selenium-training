package com.saucedemo;

import base.commonApi;
import org.testng.Assert;
import org.testng.annotations.Test;


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

    @Test
    public void addItems(){
        test1();

        click("a[id='item_4_title_link']");
        System.out.println("login btn clicked");

        String getTex = getElementText("div[class='inventory_details_name large_size']");
        System.out.println("headerTitle:" + getTex);
        Assert.assertEquals("Sauce Labs Backpack", getTex);

        click("button[id='add-to-cart-sauce-labs-backpack']");
        System.out.println("item added to cart");

        String btnText = getElementText("button[id='remove-sauce-labs-backpack']");
        System.out.println("add btn change to remove btn:" + btnText);
        Assert.assertEquals("REMOVE", btnText);

    }
}