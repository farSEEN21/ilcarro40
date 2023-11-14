import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class main implements locators {

    WebDriver wd = new FirefoxDriver();

    public void init() {
        wd.get("https://ilcarro.web.app/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wd.close();
    }

    public void type(String string, By locator) {
        WebElement type = wd.findElement(locator);
        type.clear();
        type.sendKeys(string);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }


    public int today() {

        WebElement today = wd.findElement(By.xpath(TODAY));
        int todayis = Integer.parseInt(today.getText());
        return todayis;
    }

    public void selectday(int start, int end) {
        int i = 1;
        int today = today();
        if (start == end) {
            System.out.println("wrong dates");
        } else if (start > end) {
            System.out.println("wrong date format");
        } else if (start < today) {
            System.out.println("Wrong start date");
        } else {
            if (today >= 21) {
                wd.findElement(By.xpath("//*[@class='mat-focus-indicator mat-calendar-next-button mat-icon-button mat-button-base']")).click();
                wd.findElement(By.xpath("//tr[" + (i + 1) + "]/td[3]")).click();
                wd.findElement(By.xpath("//tr[" + (i + 2) + "]/td[6]")).click();
            } else {
                //wd.findElement(By.xpath("//div[normalize-space()='\\today+1\\']")).click();
//                wd.findElement(By.xpath(TODAY)).click();
//                wd.findElement(By.xpath("//tr[" + 4 + "]/td[6]")).click();
                //  wd.findElement(By.xpath("//div[normalize-space()='4']")).click();
                wd.findElement(By.xpath("//div[normalize-space()='"+start+"']")).click();
                wd.findElement(By.xpath("//div[normalize-space()='"+end+"']")).click();

            }
        }
    }


    public void submit() {
        if (wd.findElement(By.xpath(BTNYALLA)).isEnabled()) {
            wd.findElement(By.xpath(BTNYALLA)).click();
        } else {
            System.out.println("Not correct data");
        }
    }



}
