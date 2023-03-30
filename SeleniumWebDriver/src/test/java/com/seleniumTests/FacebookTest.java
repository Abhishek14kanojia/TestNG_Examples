package com.seleniumTests;

import com.seleniumExample.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookTest extends BaseClass {

    @Test
    public void facebookWebsite_RedirectOnToValidScreen(){
        String fbLoginTitle = driver.getTitle();
        Assert.assertEquals("Facebook – log in or sign up",fbLoginTitle);
    }

    @Test
    public void facebookWebsite_CreateNewAccountTest() throws InterruptedException {
        Thread.sleep(3000);
        WebElement createPopUp = driver.findElement(By.linkText("Create new account"));
        boolean flag = createPopUp.isDisplayed();
        Assert.assertEquals(true, flag);
        createPopUp.click();
        Thread.sleep(3000);
        driver.findElement(By.name("firstname")).sendKeys("Abhishek");
        driver.findElement(By.name("lastname")).sendKeys("Kanojia");
        driver.findElement(By.name("reg_email__")).sendKeys("abhishek@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("Abcd@123");

        WebElement day = driver.findElement(By.id("day"));
        Select select = new Select(day);
        select.selectByValue("14");
        Thread.sleep(300);
        WebElement month = driver.findElement(By.id("month"));
        Select select1 = new Select(month);
        select1.selectByIndex(8);
        Thread.sleep(300);
        WebElement year = driver.findElement(By.id("year"));
        Select select2 = new Select(year);
        select2.selectByVisibleText("2000");
        Thread.sleep(300);
        driver.findElements(By.name("sex")).get(1).click();
        Thread.sleep(2000);

        boolean flag1 = select.isMultiple();
        if (flag1){
            System.out.println("Multiple selection not allowed");
        }
    }

}
