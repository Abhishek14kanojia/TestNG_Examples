package com.seleniumTests;

import com.seleniumExample.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class ActionFacebookTest extends BaseClass {

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browserName) throws InterruptedException {
        initializationTest(browserName);
        driver.get("https://www.facebook.com/");
        Thread.sleep(1500);
    }

    @Test
    @Parameters({"email", "pass"})
    public void actionClass_FacebookLoginScreen(String myEmail, String myPass) throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.name("pass"));
        Action seriesActions = actions.moveToElement(email)
                .click()
                .keyDown(email, Keys.SHIFT)
                .sendKeys(email, myEmail)
                .keyUp(email, Keys.SHIFT)
                .doubleClick(email)
                .build();
        seriesActions.perform();

        actions.keyDown(Keys.TAB).perform();
        actions.keyUp(Keys.TAB).perform();

        password.sendKeys(myPass);

        Thread.sleep(1000);
        WebElement loginBtn = driver.findElement(By.name("login"));
        actions.moveToElement(loginBtn).click().perform();
        Thread.sleep(3000);

    }
    @AfterTest
    public void setDown(){
        tearDown();
    }
}
