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
    //String expectedUserName = "Akhil Jain";
    String productName = "Nike court vision low";


    @BeforeTest
    public void preStep(){

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-save-password-bubble");
//        options.addArguments("--disable-infobars");
//
//        options.setExperimentalOption("prefs", new HashMap<String, Object>(){{
//            put("credentials_enable_service", false);
//            put("profile.password_manager_enabled", false);
       // }});
        //wd = new ChromeDriver(options);
        wd = new ChromeDriver();
        wd.manage().window().maximize();
    }

    @Test
    public void testLoginFlow(){
        LoginPOM login = new LoginPOM(wd);

        login.get()
                .fillUserName(emailId).fillPassword(password).clickSubmitButton()
                .waitFor().clickProductName(productName)
                .waitFor().selectItemSize("X").selectItemColor("Black").fillItemQty("1")
                .clickAddToCartBtn().clickViewCartButton();




    }

    @AfterTest
    public void postStep(){
        //wd.close();
    }
}
