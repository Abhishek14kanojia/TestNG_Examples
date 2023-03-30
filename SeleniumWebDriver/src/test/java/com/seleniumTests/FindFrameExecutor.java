package com.seleniumTests;

import com.seleniumExample.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindFrameExecutor extends BaseClass {

    @Test
    public void findingFrame_UsingJSExecutor() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer integer = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("Number of Frames : " + integer);
    }


}
