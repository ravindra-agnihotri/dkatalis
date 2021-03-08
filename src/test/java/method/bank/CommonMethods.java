package method.bank;


import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PropertiesUtility;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class CommonMethods extends BaseClass {
    public static void getSite(String siteURL){
        driver.get(siteURL);
        driver.manage().window().maximize();

    }

    public static WebElement element(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesUtility.getProperty(xpath))));

    }
    public static void switchFrames(String frameXpath){
        driver.switchTo().frame(driver.findElement(By.xpath(PropertiesUtility.getProperty(frameXpath))));
    }

    public static void selectPaymentOption(String  paymentMethod){
       List<WebElement> paymentOptions= driver.findElements(By.xpath(PropertiesUtility.getProperty("selectPaymentOption")));
       for(int i=0;i<= paymentOptions.size()-1;i++){

     if (paymentOptions.get(i).getAttribute("href").contains(paymentMethod)){
         paymentOptions.get(i).click();
       }

    }}


    public static void longWait(String  xpath){
        WebDriverWait webDriverWait= new WebDriverWait(driver,60);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(PropertiesUtility.getProperty(xpath))));
    }


}
