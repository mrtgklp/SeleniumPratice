package amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Amazon {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
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
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");
        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
         String acrualTagName=aramaKutusu.getTagName();
         String expectedTagName = "input";
         if (acrualTagName.equals(expectedTagName)){
             System.out.println("input tagname içeriyor");
         }else{
             System.out.println("input tagname içermiyor");
         }
        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
        String actualAttribute=aramaKutusu.getAttribute("name");
        String expectedAttribute = "field-keywords";
        if (actualAttribute.equals(expectedAttribute)){
            System.out.println("name field-keywords içeriyor");
        }else{
            System.out.println("name field-keywords içermiyor");
        }

    }
}
