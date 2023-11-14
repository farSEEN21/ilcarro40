import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testing implements locators {

    static main ma = new main();


    @BeforeTest
    public static void start() {
        ma.init();
    }


    @Test
    public void PositiveTest() {
        ma.type("jer", By.xpath(LOCATORCITY));
        ma.click(By.xpath("//div[@class='pac-item'][2]"));
        ma.click(By.xpath(LOCATORDATES));
        ma.selectday(17, 23);
        ma.submit();
        Assert.assertTrue(ma.wd.findElement(By.xpath("//*[@class='cars-container ng-star-inserted']")).getText().contains("408.7"));
    }

    @Test
    public void NegNoLocationTest() {
        ma.click(By.xpath(LOCATORDATES));
        ma.selectday(17, 23);
        Assert.assertFalse(ma.wd.findElement(By.xpath(BTNYALLA)).isEnabled());
    }

    @Test
    public void NegNoDateTest() {
        ma.type("jer", By.xpath(LOCATORCITY));
        ma.click(By.xpath("//div[@class='pac-item'][2]"));
        Assert.assertFalse(ma.wd.findElement(By.xpath(BTNYALLA)).isEnabled());
    }
    @Test
    public void NegWrongDateTest() {
        ma.type("jer", By.xpath(LOCATORCITY));
        ma.click(By.xpath("//div[@class='pac-item'][2]"));
        ma.click(By.xpath(LOCATORDATES));
        ma.type("11/10/2023 - 11/23/2023",By.xpath(LOCATORDATES));
          Assert.assertTrue(ma.wd.findElement(By.xpath("//*[@class='error ng-star-inserted']")).getText().contains("You can't pick date before today"));
    }




}
