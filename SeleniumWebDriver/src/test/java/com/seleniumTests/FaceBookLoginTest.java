package com.seleniumTests;

import com.seleniumExample.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceBookLoginTest extends BaseClass {

    @Test
    public void facebookLogin_Success() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.id("email")).sendKeys("abhishek14kanojia@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Abhi@2000");
        WebElement loginBtn = driver.findElement(By.name("login"));
        js.executeScript("arguments[0].click()", loginBtn);
        Thread.sleep(2000);
        String homeTitle = driver.getTitle();
        Assert.assertEquals("Facebook", homeTitle);
        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,-400)");
        Thread.sleep(1000);

        js.executeScript("alert('Logged in successfully')");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
    }


}
