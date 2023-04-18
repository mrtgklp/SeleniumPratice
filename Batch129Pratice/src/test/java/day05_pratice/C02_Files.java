package day05_pratice;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_Files  {
    @Test
    public void filesTest01(){
        // Desktop(masaustu)'da bir text dosyası olusturun
        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

        //"C:\Users\ASUS        \OneDrive\Desktop\Bug Raporu Oluşturma"
        String farklıkısım = System.getProperty("user.home");
        System.out.println(farklıkısım);
        String aynıKısım = "/OneDrive/Desktop/Bug Raporu Oluşturma";
        System.out.println(aynıKısım);

        String dosyaYolu = farklıkısım + aynıKısım;



        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
