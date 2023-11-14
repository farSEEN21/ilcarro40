import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainForPexel {


    WebDriver wd=new FirefoxDriver();



    public void init(){
        wd.get("http://pexels.com");
        wd.manage().window();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }



    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        WebElement input=wd.findElement(locator);
        input.clear();
        input.sendKeys(text);

    }



    public boolean isElementPresent(By locator){
        if (wd.findElement(locator).isDisplayed())return true;
        else return false;
    }



}
