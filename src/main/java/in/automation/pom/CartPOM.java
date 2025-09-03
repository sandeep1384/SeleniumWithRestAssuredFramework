package in.automation.pom;

import in.automation.pom.util.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPOM extends BasePOM{

    private By checkoutBtn = By.xpath("//a[contains(@href,'checkout')]");
    private By productTable = By.xpath("//div[@id='shopping-cart-items']/table");
    private By tableHead = By.xpath("thead");
    private By tableData = By.xpath("tbody");

    public void getCartTableColumns(){
        List<WebElement> columnNames = wd.findElement(productTable).findElement(tableHead).findElements( By.xpath("td"));
        for (WebElement we:columnNames){
            we.findElement(By.xpath("span")).getText();
        }

    }

    public void getCartTableRows(){
        List<WebElement> rows = wd.findElement(productTable).findElement(tableData).findElements( By.xpath("tr"));
        for (WebElement row:rows){
            WebElement cell1 = row.findElement(By.xpath("td[1]"));
            String productName = cell1.findElement(By.xpath("//div[@class='cart-tem-info]/a']")).getText();
            String productSize = cell1.findElement(By.xpath("//div[contains(@class,'cart-item-variant-options')]//li[1]//span[2]")).getText();
            String productColor = cell1.findElement(By.xpath("//div[contains(@class,'cart-item-variant-options')]//li[2]//span[2]")).getText();

            WebElement cell2 = row.findElement(By.xpath("td[2]"));
            String productPrice = cell2.findElement(By.xpath("//spam[@class='sale=price']")).getText();

            WebElement cell3 = row.findElement(By.xpath("td[3]"));
            String productQty = cell3.findElement(By.xpath("//input")).getAttribute("value");

            WebElement cell4= row.findElement(By.xpath("td[4]"));
            String productTotalPrice = cell4.findElement(By.xpath("//span")).getText();


        }

    }



    public CheckoutPOM clickCheckoutBtn(){
        wd.findElement(checkoutBtn).click();
        return new CheckoutPOM(wd);


    }

    public CartPOM get(){

        String resourcePath = "/cart";
        String baseUrl = "https://demo.evershop.io";
        String newURL = baseUrl.concat(resourcePath);
        get(newURL);
        return this;

    }

    public CartPOM(WebDriver wd){
        super(wd);
    }
}
