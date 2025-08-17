package in.automation.pom;

import in.automation.pom.util.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePOM extends BasePOM{

    private By shopKidsButton = By.xpath("//*[@id='app']/div/main/div[2]/div/div/div[1]/div/div/a");

    //Nike react infinity run flyknit

    private String productLink = "//div[@class='listing-tem']/div[contains(@class,'product-name')]/a/span[text()='$$$']";

    public By getProductLinkLocator(String productName){
        String updatedProductName = productLink.replace("$$$","productName");
        return By.xpath(updatedProductName);

    }

    public HomePOM get(){

        String resourcePath = "/";
        String baseUrl = "https://demo.evershop.io";
        String newURL = baseUrl.concat(resourcePath);
        get(newURL);
        return this;

    }

    public HomePOM(WebDriver wd){
        super(wd);

    }
    public HomePOM waitFor(){

        WaitManager.waitForElementToBeLocated(wd, shopKidsButton);
        return this;
    }

    public ProductPOM clickProductName(String productName){
        wd.findElement(getProductLinkLocator(productName)).click();
        return new ProductPOM(wd);
    }

}
