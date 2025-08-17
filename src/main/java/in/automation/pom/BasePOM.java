package in.automation.pom;

import in.automation.pom.components.HeaderPOM;
import org.openqa.selenium.WebDriver;

public class BasePOM {

    protected WebDriver wd;

    protected HeaderPOM headerPOM;

    public BasePOM(WebDriver wd){

        this.wd = wd;
        headerPOM = new HeaderPOM(wd);

    }

    public void get(String url){
        wd.get(url);

    }

    public HeaderPOM getHeader(){
        return headerPOM;
    }
}
