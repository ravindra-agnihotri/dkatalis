package stepdefinations;

import base.BaseClass;
import data.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import method.bank.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import utilities.PropertiesUtility;

public class CartCheckout extends CommonMethods{
    /**
     * this method invokes driver and opens site url in maximised window
     */
    @Given("user opens midtrans website")
    public void user_opens_opentrans_website() {
        initDriver(BrowserType.CHROME);
        getSite(Constants.SITE_URL);

    }
    @When("user fills details and payment options")
    public void userFillsDetailsAndPaymentOptions() {
        element("buyNow").click();
        element("checkout").click();
        switchFrames("checkoutFrame");
        element("continue").click();
        selectPaymentOption("credit");


    }


    @Then("enters {string}, {string}, {string} and {string}")
    public void entersAnd(String CARD_NUMBER, String CVV, String Expiry,String OTP) throws InterruptedException {
        element("cardNumber").sendKeys(CARD_NUMBER);
        element("cardCVV").sendKeys(CVV);
        element("cardExpiryDate").sendKeys(Expiry);
        element("payNow").click();
        Thread.sleep(5000);
        switchFrames("paymentParentFrame");
        element("otp").click();
        element("otp").sendKeys(OTP);
        element("paymentPageOkButton").click();


        Assert.assertTrue(element("paymentSuccessMessage").getText().equals("Transaction success"),"Test failed");


    }


}
