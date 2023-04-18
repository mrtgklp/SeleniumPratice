package day05_pratice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilesDownload extends TestBase {
    @Test
    public void filesDownload() {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//*[text()='some-file.txt']")).click();

        /*
        Dosyanın, bilgisayarımda downloads'a basrıyla indirilip indirilmedigini Java ile test edecegim.
        Cunku seleniumi web sayfasını test eder. Selenium, benim bilgisayarımdaki downloads'a mudahale edemez.
         */
        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz
        String farklıKısım = System.getProperty("user.home");
        String aynıKısım = "/Downloads/2f53fd6d-fc4e-4711-856d-78954d638b68.tmp/";
        String dosyaYolu = farklıKısım + aynıKısım;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
