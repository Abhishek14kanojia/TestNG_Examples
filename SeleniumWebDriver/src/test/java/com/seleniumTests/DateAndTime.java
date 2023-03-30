package com.seleniumTests;

import com.seleniumExample.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class DateAndTime extends BaseClass {

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browserName) throws InterruptedException {
        initializationTest(browserName);
        driver.get("https://demo.guru99.com/test/");
        Thread.sleep(1000);
    }

    @Test
    public void enterDateAndTime() throws InterruptedException {
        WebElement dataCalendar = driver.findElement(By.name("bdaytime"));
        dataCalendar.sendKeys("14092000");
        Thread.sleep(1000);
        dataCalendar.sendKeys(Keys.TAB);
        dataCalendar.sendKeys("1219AM");
        Thread.sleep(2000);
    }

    @AfterTest
    public void setDown(){
        tearDown();
    }
}
