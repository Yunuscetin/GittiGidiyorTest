package com.testinium.sample.training;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void startTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        this.driver.get("https://www.gittigidiyor.com/uye-girisi");
        Thread.sleep(2000);

    }

    @After
    public void endTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public String getTitle(){
        return driver.getTitle();
    }
    public void sendById(String id, String value){
        driver.findElement(By.id(id)).sendKeys(value);
    }
    public void sendByDataCy(String dataCy, String value){
        driver.findElement(By.xpath("//*[@data-cy='"+dataCy+"']")).clear();
        driver.findElement(By.xpath("//*[@data-cy='"+dataCy+"']")).sendKeys(value);
    }

    public void clickByDataCy(String dataCy)  {
        driver.findElement(By.xpath("//*[@data-cy='"+dataCy+"']")).click();
    }

    public void clickById(String id){
        driver.findElement(By.id(id)).click();
    }

    public void clickByXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void callHomePage() {
        driver.get("https://www.gittigidiyor.com/");
    }
    public void clickByClassName(String className) {
        driver.findElement(By.className(className));
    }
    public void sendByxPath(String name, String value){
        driver.findElement(By.xpath("//input[@name='"+name+"']")).sendKeys(value);
    }

}
