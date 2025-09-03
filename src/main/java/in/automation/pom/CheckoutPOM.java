package in.automation.pom;

import in.automation.pom.util.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPOM extends BasePOM {
    //Standard Delivery
    private By fullNameTB = By.xpath("//input[@name='address[full_name]']");
    private By telephoneTB = By.xpath("//input[@name='address[telephone]']");
    private By address1TB = By.xpath("//input[@name='address[address_1]']");
    private By cityTB = By.xpath("//input[@name='address[city]']");
    private By postCodeTB = By.xpath("//input[@name='address[postcode]']");
    private By countryDD = By.xpath("//select[@id='address[country]']");
    private By provinceDD = By.xpath("//select[@id='address[province]']");
    private String shippingMethod = "//span[contains(text(),'$$$')]";
    private By continueToPaymentBtn = By.xpath("//button[@type='submit']/span[text()='Continue to payment']");
    private String paymentMethod = "//img[@alt='$$$']//ancestor::div[contains(@class,'payment-method-list')]//a";
    private By placeOrderBtn = By.xpath("//button/span[text()='Place Order']");

    public CheckoutPOM(WebDriver wd){
        super(wd);
    }

    public CheckoutPOM get(){

        String resourcePath = "/checkout";
        String baseUrl = "https://demo.evershop.io";
        String newURL = baseUrl.concat(resourcePath);
        get(newURL);
        return this;

    }

    public CheckoutPOM fillFullName(String fullName){
        wd.findElement(fullNameTB).sendKeys(fullName);
        return this;
    }

    public CheckoutPOM fillTelePhone(String telePhone){
        wd.findElement(telephoneTB).sendKeys(telePhone);
        return this;
    }
    public CheckoutPOM fillAddress1(String address1){
        wd.findElement(address1TB).sendKeys(address1);
        return this;
    }
    public CheckoutPOM fillCity(String city){
        wd.findElement(cityTB).sendKeys(city);
        return this;
    }
    public CheckoutPOM fillPostCode(String postCode){
        wd.findElement(postCodeTB).sendKeys(postCode);
        return this;
    }
    public CheckoutPOM selectCountry(String countryName){
        Select s1 = new Select(wd.findElement(countryDD));
        s1.selectByVisibleText(countryName);
        return this;
    }
    public CheckoutPOM selectProvince(String provinceName){
        Select s1 = new Select(wd.findElement(provinceDD));
        s1.selectByVisibleText(provinceName);
        return this;
    }

    public CheckoutPOM selectShippingMethod(String shippingMethodName){
        String newPath = shippingMethod.replace("$$$",shippingMethodName);
        WaitManager.waitForElementVisibility(wd, wd.findElement(By.xpath(newPath)));
        WebElement we2 = wd.findElement(By.xpath(newPath)).findElement(By.xpath("parent::label/input"));

        //WebElement we = wd.findElement(By.xpath(newPath));
        we2.click();
        return this;

    }

    public CheckoutPOM clickContinueToPayment(){
        wd.findElement(continueToPaymentBtn).click();
        return this;
    }

    public CheckoutPOM selectPaymentMethod(String paymentMethodName){
        String newPath = paymentMethod.replace("$$$",paymentMethodName);
        WebElement we = wd.findElement(By.xpath(newPath));
        we.click();
        return this;
    }

    public SuccessPOM clickPlaceOrder(){
        wd.findElement(placeOrderBtn).click();
        return new SuccessPOM(wd);
    }




}
