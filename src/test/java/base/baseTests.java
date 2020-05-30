package base;


import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class baseTests {
    public EventFiringWebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOption()));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor)driver;
       goHome();
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");

    }

    @BeforeMethod
    public void goHome() throws InterruptedException {
      driver.get("https://zgeografija-cefd4.web.app/");
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/test.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected ChromeOptions getChromeOption() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //bez otvaranja pretrazivaca
        //options.setHeadless(true);
        return options;
    }

}
