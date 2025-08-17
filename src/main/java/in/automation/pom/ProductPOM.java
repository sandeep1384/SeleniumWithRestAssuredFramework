package in.automation.pom;

import in.automation.pom.util.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPOM extends BasePOM {

    private By addToCartButton = By.xpath("//button/span[text()='ADD TO CART']");

    private String itemSizeCB = "//ul[contains(@class,''variant-option-list')]/li/a[text()='$$$']";

    private String itemColorCB = "//ul[contains(@class,''variant-option-list')]/li/a[text()='$$$']";

    private By qtyTB = By.xpath("//input[@name='qty']");

    private By viewCartButton = By.xpath("//a[@class='add-cart-popup-button' and contains(@text(),'VIEW CART')]");

    public By getitemSizeCBLocator(String sizeName){
        String updateditemSizeCB =  itemSizeCB.replace("$$$",sizeName );
        return By.xpath(updateditemSizeCB);
    }

    public By getitemColorCBLocator(String colorName){
        String updateditemColorCB =  itemColorCB.replace("$$$",colorName );
        return By.xpath(updateditemColorCB);
    }

    public ProductPOM(WebDriver wd){
        super(wd);
    }

    public ProductPOM waitFor(){
        WaitManager.waitForElementToBeLocated(wd, addToCartButton);
        return this;
    }

    public ProductPOM selectItemSize(String itemSize){
        By ele = getitemSizeCBLocator(itemSize);
        wd.findElement(ele).click();
        WaitManager.waitForElementToHaveAttributeWithSpecificValue(wd, wd.findElement(ele).findElement(By.xpath("//parent::li")),"class", "selected");
        return this;
    }

    public ProductPOM selectItemColor(String itemColor){
        By ele = getitemColorCBLocator(itemColor);
        wd.findElement(ele).click();
        WaitManager.waitForElementToHaveAttributeWithSpecificValue(wd, wd.findElement(ele).findElement(By.xpath("//parent::li")),"class", "selected");
        return this;
    }

    public ProductPOM fillItemQty(String qty){
        wd.findElement(qtyTB).clear();
        wd.findElement(qtyTB).sendKeys(qty);
        return this;
    }

    public ProductPOM clickAddToCartBtn(){
        wd.findElement(addToCartButton).click();
        WaitManager.waitForElementToBeLocated(wd, viewCartButton);
        return this;
    }

    public CartPOM clickViewCartButton(){
        wd.findElement(viewCartButton).click();
        return new CartPOM(wd);
    }
}
