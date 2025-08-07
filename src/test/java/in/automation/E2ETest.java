package in.automation;

import in.automation.pom.LoginPOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class E2ETest {

    WebDriver wd;

    String emailId = "akhil.jain@podtest.in";
    String password = "Password";
    //String expectedUserName = "Akhil Jain";


    @BeforeTest
    public void preStep(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
    }

    @Test
    public void testLoginFlow(){
        LoginPOM login = new LoginPOM(wd);

        login.get()
                .fillUserName(emailId).fillPassword(password).clickSubmitButton()
                .waitFor().clickProductName();


        String actualURL = wd.getCurrentUrl();
        System.out.println("Actual URL is: " +actualURL);
        String expectedURL = "https://demo.evershop.io/";

        Assert.assertEquals(actualURL, expectedURL);


    }

    @AfterTest
    public void postStep(){
        wd.close();
    }
}
