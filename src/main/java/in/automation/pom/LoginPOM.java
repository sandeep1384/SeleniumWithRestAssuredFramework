package in.automation.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM {

    final WebDriver wd;

    private By emailTB = By.xpath("//input[@name='email']") ;
    private By passwordTB = By.xpath("//input[@name='password']");
    private By submitBtn = By.xpath("//button[@type='submit']");

    public LoginPOM get(){

        String resourcePath = "/account/login";
        String baseUrl = "https://demo.evershop.io";
        String newURL = baseUrl.concat(resourcePath);
        wd.get(newURL);
        return this;
    }

    public LoginPOM(WebDriver wd){
        this.wd = wd;
    }


    public LoginPOM fillUserName(String emailId){

        wd.findElement(emailTB).sendKeys(emailId);
        return this;
    }

    public LoginPOM fillPassword(String password){

        wd.findElement(passwordTB).sendKeys(password);
        return this;
    }

    public HomePOM clickSubmitButton(){

        wd.findElement(submitBtn).click();
        HomePOM homePOM = new HomePOM(wd);
        return homePOM;
    }

}
