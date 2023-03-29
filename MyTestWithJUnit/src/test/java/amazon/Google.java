package amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Google {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() {
        // https://www.google.com/ adresine gidin
        driver.navigate().to("https://www.google.com");
        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Google")) {
            System.out.println("Google title içeriyor");
        } else {
            System.out.println("Google title içermiyor");
        }
        // arama cubuguna "Nutella" yazıp aratın
        WebElement armaCubugu = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        armaCubugu.sendKeys("Nutella", Keys.ENTER);
        // bulunan sonuc sayısını yazdırın
        WebElement bulunanSonuc = driver.findElement(By.xpath("//div[@id='result-stats']"));
        //System.out.println(bulunanSonuc.getText());
        String arr[] = bulunanSonuc.getText().split(" ");
        String sonuc = arr[1];
        System.out.println(sonuc);
        // sonuc sayısının 100000000  fazla oldugunu test edin
        String sonucSayısı=sonuc.replaceAll("\\D","");
        System.out.println(sonucSayısı);
        if (Integer.parseInt(sonucSayısı)>100000000){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }
    }
}
