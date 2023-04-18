package day05_pratice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class C01_ActionMoveToElement extends TestBase {
    @Test
    public void actionTest01() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
       String sayfa1Handle = driver.getWindowHandle();
        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement dılSecenigi = driver.findElement(By.id("icp-nav-flyout"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dılSecenigi).perform();
        bekle(3);
        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//*[@id='icp-flyout-mkt-change'])[1]")).click();
        bekle(3);
        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Turkey (Türkiye)");
        bekle(3);

        // Go to website butonuna tiklayiniz
        /*
        Drop Down Listesi "Go to website" butonuna basmamıza engel oldugu için
        herhangi bir yere click yapıp drop down listesinin toparlamasını sagladık.
         */
        //driver.findElement(By.xpath("(//span[@class='a-text-bold'])[3]")).click();
        driver.findElement(By.xpath("//a[@id='icp-dropdown_18']")).click();
        bekle(2);
        driver.findElement(By.xpath("//span[@id='icp-save-button']")).click();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
       Set<String> windowHandlesSeti=driver.getWindowHandles();
        System.out.println("Tüm Sayfanın Degerleri: "+windowHandlesSeti);
        System.out.println("Sayfa 1 Handle:"+sayfa1Handle);
        String sayfa2Handle="";
        for (String each:windowHandlesSeti
             ) {
            if (!each.equals(sayfa1Handle)){
                sayfa2Handle=each;
            }
        }
        System.out.println("Sayfa 2 Handle Degeri: "+ sayfa2Handle);
        driver.switchTo().window(sayfa2Handle);//driver'i safya2'ye gecirdik

        String ikinciSayfaTitle = driver.getTitle();
        System.out.println("İkinci Sayfa Title: "+ikinciSayfaTitle);
        Assert.assertTrue(ikinciSayfaTitle.contains("Elektronik"));
    }
}
