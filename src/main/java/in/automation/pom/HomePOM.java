package in.automation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePOM {

    private By shopKidsButton = By.xpath("//*[@id='app']/div/main/div[2]/div/div/div[1]/div/div/a");
    private WebDriver wd;

    public HomePOM get(){

        String resourcePath = "/";
        String baseUrl = "https://demo.evershop.io";
        String newURL = baseUrl.concat(resourcePath);
        wd.get(newURL);
        return this;

    }

    public HomePOM(WebDriver wd){

        this.wd = wd;

    }
    public HomePOM waitFor(){

        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(shopKidsButton));
        return this;
    }

    public void clickProductName(){
        //
    }

}
