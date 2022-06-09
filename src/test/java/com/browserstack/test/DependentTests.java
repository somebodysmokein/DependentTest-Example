package com.browserstack.test;

import org.testng.annotations.Test;

public class DependentTests extends TestBase{

    @Test
    public void test1() throws InterruptedException {
        getDriver().navigate().to("https://www.google.com/");
        getDriver().getPageSource();
        System.out.println("Test1 is running...");
        getDriver().getPageSource();
        Thread.sleep(10000);
        getDriver().getPageSource();
        System.out.println("Test1 completed...");
        getDriver().getPageSource();
    }

    @Test(dependsOnMethods = "test1")
    public void test2() throws InterruptedException {
        getDriver().navigate().to("https://www.google.com/");
        getDriver().getPageSource();
        System.out.println("Test2 is running...");
        getDriver().getPageSource();
        Thread.sleep(10000);
        getDriver().getPageSource();
        System.out.println("Test2 completed...");
        getDriver().getPageSource();
    }


}
