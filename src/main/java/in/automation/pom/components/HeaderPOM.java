package in.automation.pom.components;

import in.automation.pom.AboutUsPOM;
import in.automation.pom.AccountPOM;
import in.automation.pom.CartPOM;
import in.automation.pom.HomePOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPOM {
    private WebDriver wd;

    public HeaderPOM(WebDriver wd){
        this.wd = wd;
    }
    private By shopDropDown = By.xpath("//li[@class='relative group']/a[contains(text(),'Shop')]");
    private By aboutUs = By.xpath("//li[@class='relative group']/a[contains(text(),'About us')]");
    private By appIcon = By.xpath("//a[@class='logo-icon']");
    private By searchIcon = By.xpath("//a[@class='search-icon']");
    private By cartIcon = By.xpath("//a[@class='mini-cart-icon']");
    private By accountIcon = By.xpath("//a[contains(@href,'/account')]");

    public AboutUsPOM clickAboutUsLink(){
        wd.findElement(aboutUs).click();
        return new AboutUsPOM(wd);
    }

    public HomePOM clickAppIcon(){
        wd.findElement(appIcon).click();
        return new HomePOM(wd);
    }

    public CartPOM clickCartIcon(){
        wd.findElement(cartIcon).click();
        return new CartPOM(wd);
    }

    public AccountPOM clickAccountIcon(){
        wd.findElement(accountIcon);
        return new AccountPOM(wd);
    }





}






