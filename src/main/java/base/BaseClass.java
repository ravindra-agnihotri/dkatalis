package base;

import data.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;

    public static WebDriver initDriver(String browserName){

        if (browserName.contains(BrowserType.CHROME)){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        }else {
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }
}
