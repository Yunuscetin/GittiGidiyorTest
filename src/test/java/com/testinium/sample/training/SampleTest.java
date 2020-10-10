package com.testinium.sample.training;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class SampleTest extends BaseTest {

    @Test
    public void anasayfaTest(){
        assertEquals("Üye Girişi - GittiGidiyor", getTitle());
    }

    @Test
    public void girisYap(){
        sendById("L-UserNameField", "yunus_5959@windowslive.com");
        sendById("L-PasswordField", "yunus123");
        clickById("gg-login-enter");

    }
    public void urunAra() throws InterruptedException {
        sendByDataCy("header-search-input", "Telefon");
        clickByDataCy("search-find-button");
        Thread.sleep(3000);

    }
    public void urunCek() throws InterruptedException {
        List<WebElement> urunler = driver.findElements(By.xpath("//div[@class='clearfix']//ul//li//a[@class='product-link']"));
        Random r = new Random();
        int rSayi= r.nextInt(5);
        Thread.sleep(3000);
        urunler.get(rSayi).click();
        Thread.sleep(3000);
        clickByXpath("//div[@id='sp-addbasket-button']//form//button//span[@class='action-text']");
        Thread.sleep(3000);
    }
    public void adresEkle() throws InterruptedException {
        callHomePage();
        assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi",getTitle());
        clickByDataCy("header-user-menu");
        Thread.sleep(2000);
        clickByXpath("//a[@title='Bilgilerim / Ayarlarım']");
        Thread.sleep(2000);
        clickByXpath("//a[@href='\"/bana-ozel/adreslerim\"'");
        Thread.sleep(2000);
        sendById("L-PasswordField", "yunus123");
        clickById("AddAddress");
        Thread.sleep(3000);
    }
    public void adresBilgi(){
        assertEquals("GittiGidiyor - Adres bilgilerim", getTitle());
        sendByxPath("title","Ev");
        sendByxPath("name","Yunus");
        sendByxPath("surname","Çetin");
        sendById("cities", "Tekirdağ");
        sendById("counties","Süleymanpaşa");
        sendById("neighborhoods.","100.Yıl Mah.");
        sendByxPath("zipCode","59100");
        driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("Öğretmenler Sitesi E blok");
        sendByxPath("phone","5382389965");
        clickByXpath("//input[@id='AddressSave']");

    }
}

