package com.seleniumTests;

import com.seleniumExample.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class AutoItFileUpload extends BaseClass {

    @BeforeTest
    @Parameters("browser")
    public void setUp(String browserName) throws InterruptedException {

        initializationTest(browserName);
        driver.get("https://www.freepdfconvert.com/pdf-to-word");
//        driver.get("https://demo.guru99.com/test/upload/");
        Thread.sleep(1000);
    }

    @Test
    public void fileUpload() throws IOException, InterruptedException {
        WebElement chooseBtn = driver.findElement(By.xpath("//*[@id=\"top\"]/body/main/div[1]/div/div/div[2]/section/label/div/div[1]/a"));
        chooseBtn.click();
        Thread.sleep(500);
        Runtime.getRuntime().exec("C:\\Users\\Asus\\OneDrive\\Documents\\autoIT\\guru99file.exe");
        Thread.sleep(2000);
        System.out.println("File Successful!!");

    }

//    @Test
//    public void fileUploadSendKeys() throws InterruptedException {
//        WebElement chooseBtn1 = driver.findElement(By.id("uploadfile_0"));
//        chooseBtn1.sendKeys("C:\\Users\\Asus\\Downloads\\Abhishek's Resume (2).pdf");
//        Thread.sleep(2000);
//        System.out.println("File Successful!!!");
//
//    }

    @AfterTest
    public void setDown(){
        tearDown();
    }

}
