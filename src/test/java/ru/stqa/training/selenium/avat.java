package ru.stqa.training.selenium;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class avat extends TestBase {

    @Test
    public void FirstAvat() {
        driver.navigate().to("https://market.evotor.ru/");
        wait.until(titleIs("Эвотор | Главная страница"));
        java.lang.String nameExpected = "Популярные приложения";
        String nameActual = driver.findElement(By.xpath("//section/div/h2")).getText();
        Assert.assertEquals(nameExpected,nameActual);
        //переходим на приложение ОБмен через Exel
        driver.findElement(By.xpath("//section//div/div[@class=\"well well-shadowed app-card backside\"]/div/img[@alt=\"Обмен через Excel\"]")).click();
        //wait.until(titleIs("Эвотор | Страница приложения Обмен через Excel"));
        //снимаем скриншот
        File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screen = new File("screen" + System.currentTimeMillis()+ ".png");
        try {
            FileUtils.copyFile(tempFile, screen);
            System.out.println("Screen was saved there: " +screen.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ищем число тарифов
        int count = driver.findElements(By.xpath("//div/span[@class=\"card-price\"]/strong")).size();
        Assert.assertEquals(5, count);
        System.out.print(count);
        //вывести цену со второй карточки
        java.lang.String price = driver.findElement(By.xpath("//div[@class=\"well well-shadowed card front-card card-style-1 small\"]/span[2]/strong")).getText();
        System.out.print(price);
    }   
}
