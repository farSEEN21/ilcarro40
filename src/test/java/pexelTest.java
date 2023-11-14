import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.css.Rect;

import javax.swing.*;

public class pexelTest implements locators {

    MainForPexel mp = new MainForPexel();


    @BeforeTest
    public void start()
    {
        mp.init();
    }

@Test
    public void PositiveLogin() throws InterruptedException {
    mp.click(By.xpath(PIXIL_REG));
    if (mp.wd.findElement(By.xpath("//div[@class='main-content']")).isDisplayed()) {
        System.out.println("donee");
        wait(10000);
        WebElement box=mp.wd.findElement(By.xpath("//*[@id='content']"));
        Rectangle rect=box.getRect();
      int x_point= rect.getX()+26;
      int y_point= rect.getY()+26;
        Actions clickpoint=new Actions(mp.wd);
        clickpoint.moveToElement(box,x_point,y_point).click().build().perform();
        mp.wd.findElement(By.xpath("//div[@class='ctp-checkbox-container']/lable/input")).click();
       {
            mp.wd.findElement(By.xpath("//div[@class='ctp-checkbox-container']/lable/input")).click();
            System.out.println("done");
        }
        mp.click(By.xpath("//a[contains(@href,'/ru-ru/join-contributor/?onboarding=skipped')]"));
        mp.type(By.xpath("//input[@class='Input_input___ME0t']"), "Aleks");
    }
    else  mp.click(By.xpath(PIXIL_REG));
    {
        mp.wd.findElement(By.xpath("//div[@class='ctp-checkbox-container']/lable/input")).click();
        System.out.println("done");
    }
    mp.click(By.xpath("//a[contains(@href,'/ru-ru/join-contributor/?onboarding=skipped')]"));
    mp.type(By.xpath("//input[@class='Input_input___ME0t']"), "Aleks");
}






}
