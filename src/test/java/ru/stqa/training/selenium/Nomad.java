package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Nomad extends TestBase {

    @Test
    public void Login() {
        driver.navigate().to("http://test.nomadcar.com/ru/");
        wait.until(titleIs("Nomadcar – Аренда автомобилей Мерседес в Швейцарии. Прокат авто в Женеве, Цюрихе и других городах Швейцарии с Номадкар"));
        driver.manage().window().maximize();
        //объявляем email логина в переменную и проводим кейс логина с переходом на страницу профиля
        String emailOriginal = "nomadcar.auto@gmail.com";
        driver.findElement(By.xpath("//div/span[@class=\"auth-link\"][1]")).click();
        driver.findElement(By.xpath("//div[@class=\"popup-content\"]/form/input[@type=\"email\"]")).sendKeys(emailOriginal);
        driver.findElement(By.xpath("//div[@class=\"popup-content\"]/form/input[@type=\"password\"]")).sendKeys("456456");
        driver.findElement(By.xpath("//div[@class=\"popup-content\"]/form/button")).click();
        wait.until(titleIs("Nomadcar – Аренда автомобилей Мерседес в Швейцарии. Прокат авто в Женеве, Цюрихе и других городах Швейцарии с Номадкар"));
        driver.navigate().to("https://test.nomadcar.com/ru/cabinet/profile");
        wait.until(titleIs("Профиль"));
        //получаем email который заполнен в профиле
        String email = driver.findElement(By.xpath("//div[@class=\"profileDivLikeInput\" and @name=\"email\"]/span")).getText();
        System.out.println(email);
        //проверка что email в профиле тот же что и использовался при логине
        Assert.assertEquals(emailOriginal, email);

    }
    @Test
    public void PaymentNewCard() {
        driver.findElement(By.linkText("Автомобили"));
    }

}
