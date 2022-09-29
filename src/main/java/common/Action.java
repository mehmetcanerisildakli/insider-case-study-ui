package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Action extends Driver {


    Util util = new Util();

    public void goToHomePage() {
        webDriver.get(util.getProperties("URL"));
    }

    public void checkTitle(String title) {
        String currentTitle = webDriver.getTitle();
        System.out.printf("current title: %s title: %s%n", currentTitle, title);
        checkEquals(currentTitle, title);
    }

    public void checkElementIsVisible(By by) {

        List<WebElement> elements = webDriver.findElements(by);
        Assert.assertFalse(elements.isEmpty());
    }

    public void clickElement(By by) {

        WebElement element = webDriver.findElement(by);
        element.click();
    }

    public void checkContainsText(By by, String expectedText) {

        List<WebElement> elements = webDriver.findElements(by);
        for (WebElement element : elements) {
            if (!element.getText().contains(expectedText)) {
                Assert.fail(expectedText + "is not in the element");
            }
        }
    }

    public void scrollToElement(By by) {

        WebElement element = webDriver.findElement(by);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void selectFromList(By by, String text) {

        Select docList = new Select(webDriver.findElement(by));
        docList.selectByVisibleText(text);
    }

    public void hoverOver(WebElement webElement) {

        Actions action = new Actions(webDriver);
        action.moveToElement(webElement).perform();

    }

    public void checkEachBlockHasElement(By block, By element) {

        List<WebElement> blocks = webDriver.findElements(block);
        List<WebElement> elements = webDriver.findElements(element);
        for (int i = 0; i < elements.size(); i++) {
            hoverOver(blocks.get(i));
            wait(1);
            Assert.assertTrue(elements.get(i).isDisplayed());
        }
    }

    public WebElement getFirstElement(By by) {

        List<WebElement> elements = webDriver.findElements(by);
        return elements.get(0);
    }

    public void switchTab() {

        String mainTab = webDriver.getWindowHandle();
        for (String windowHandle : webDriver.getWindowHandles()) {
            if (!mainTab.contentEquals(windowHandle)) {
                webDriver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public String getTextOfElement(By by) {
        return webDriver.findElement(by).getText();
    }


    public void checkEquals(String expectedValue, String actualValue) {
        if (!expectedValue.equals(actualValue)) {
            Assert.fail(expectedValue + "and" + actualValue + "are not the same");
        }
    }

//    public void timeouts(int second) {
//        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(second));
//    }

    public void waitUntil(int second, By by) {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void wait(int second) {

        try {
            Thread.sleep(second * 1000L);
        } catch (Exception e) {
        }
    }

    public void takeScreenShot() {

        Date currentDate = new Date();
        String fileName = currentDate.toString().replace(" ", "-").replace(":", "-");
        File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshot/" + fileName + ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
