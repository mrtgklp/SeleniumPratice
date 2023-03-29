package youtube;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class listenMusic {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
    }

    @Test
    public void test01() {
        //https://youtube.com
        driver.navigate().to("https://www.youtube.com");
        //arama butonun da "zeynep bastik" aramasını yap
       driver.findElement(By.xpath("//input[@id='search']")).sendKeys("zeynep bastik");
       driver.findElement(By.xpath(" //button[@id='search-icon-legacy']")).click();
       driver.findElement(By.xpath("//*[@class='ytp-inline-preview-scrim']")).click();


    }
}
