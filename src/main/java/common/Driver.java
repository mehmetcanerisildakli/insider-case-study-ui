package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Objects;

public class Driver {

    static WebDriver webDriver;
    Util util = new Util();

    public void driverSet() {
        String browser = util.getProperties("BROWSER");

        if (!Objects.equals(browser, null)) {
            switch (browser) {
                case "CHROME":
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    break;
                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
            }
        }
        webDriver.manage().window().maximize();
    }

    public void driverTearDown() {

        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
