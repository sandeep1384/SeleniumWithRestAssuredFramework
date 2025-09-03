package in.automation.pom;

import org.openqa.selenium.WebDriver;

public class SuccessPOM extends BasePOM{
    public SuccessPOM(WebDriver wd){
        super(wd);
    }

    public SuccessPOM getPage(String orderid){

        String resourcePath = "/checkout/success/"+orderid;
        String baseUrl = "https://demo.evershop.io";
        String newURL = baseUrl.concat(resourcePath);
        get(newURL);
        return this;

    }
}
