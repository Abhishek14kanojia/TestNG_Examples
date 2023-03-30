package com.seleniumTests;

import com.seleniumExample.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class DragAndDrop extends BaseClass {

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browserName) throws InterruptedException {
        initializationTest(browserName);
        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(2000);
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")));
        WebElement dragElement = driver.findElement(By.id("draggable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(dragElement).perform();

        WebElement dropElement = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(dragElement, dropElement).perform();
        Thread.sleep(2000);

        driver.switchTo().parentFrame();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END);
        actions.keyUp(Keys.CONTROL).sendKeys(Keys.END);
        Thread.sleep(2000);

    }

    @AfterTest
    public void setDown() {
        tearDown();
    }

}
