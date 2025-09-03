package in.automation;

import in.automation.pom.LoginPOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.HashMap;
import java.util.Objects;

public class E2ETest {

    WebDriver wd;

    String emailId = "sandeep@yopmail.com";
    String password = "Sdet@123";
    String productName = "Nike court vision low";
    String fullName = "Sandeep Patil";
    String telePhone = "8888899999";
    String address1 = "Mumbai Area";
    String city = "Mumbai";
    String country = "United States";
    String province = "Alabama";
    String postcode = "110000";
    String shippingMethodName = "Standard Delivery";
    String paymentMethodName="Cash On Delivery";




    @BeforeTest
    public void preStep(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testLoginFlow(){
        LoginPOM login = new LoginPOM(wd);

        login.get()
                .fillUserName(emailId).fillPassword(password).clickSubmitButton()
                .waitFor().clickProductName(productName)
                .waitFor().selectItemSize("X").waitFor().selectItemColor("Black").waitFor().fillItemQty("1")
                .clickAddToCartBtn().waitFor().clickViewCartButton()
                .clickCheckoutBtn()
                .fillFullName(fullName).fillTelePhone(telePhone).fillAddress1(address1)
                .fillCity(city).selectCountry(country).selectProvince(province)
                .fillPostCode(postcode).selectShippingMethod(shippingMethodName).clickContinueToPayment()
                .selectShippingMethod(paymentMethodName).clickPlaceOrder();




    }

    @AfterTest
    public void postStep(){
        //wd.close();
    }
}
