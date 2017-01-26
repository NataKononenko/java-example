package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Wiley extends TestBase {

    @Test
    public void FirstTest() {
        /* check links by opening them - done */
        driver.navigate().to("http://www.wiley.com/WileyCDA");
        wait.until(titleIs("Wiley: Journals, books, and online products and services"));
        driver.findElement(By.linkText("Home")).click();
        driver.navigate().to("http://www.wiley.com/WileyCDA");
        wait.until(titleIs("Wiley: Journals, books, and online products and services"));
        driver.findElement(By.linkText("Subjects")).click();
        driver.navigate().to("http://www.wiley.com/WileyCDA");
        wait.until(titleIs("Wiley: Journals, books, and online products and services"));
        driver.findElement(By.linkText("About Wiley")).click();
        driver.navigate().to("http://www.wiley.com/WileyCDA");
        wait.until(titleIs("Wiley: Journals, books, and online products and services"));
        driver.findElement(By.linkText("Contact Us")).click();
        driver.navigate().to("http://www.wiley.com/WileyCDA");
        wait.until(titleIs("Wiley: Journals, books, and online products and services"));
        driver.findElement(By.linkText("Help")).click();

    }

    @Test
    public void SecondTest() {
        //ad verification for text
        driver.navigate().to("http://www.wiley.com/WileyCDA");
        wait.until(titleIs("Wiley: Journals, books, and online products and services"));
        driver.findElement(By.linkText("Students"));
    }

    @Test
    public void ThirdTest() {
        //ad check of h1
        driver.navigate().to("http://www.wiley.com/WileyCDA");
        wait.until(titleIs("Wiley: Journals, books, and online products and services"));
        driver.findElement(By.linkText("Students"));
//        boolean isElementPresent(WebDriver driver, By.linkText("Students")){
//            try {
//                driver.findElement(By.linkText("Students"));
//                return true;
//            } catch (NoSuchElementException ex) {
//                return false;
//            }
//        }

        wait.until(titleIs("Wiley: Students"));
    }

    @Test
    public void Test7() {
        //check alert - done
        driver.navigate().to("http://www.wiley.com/WileyCDA");
        driver.findElement(By.id("EmailAddress"));
        driver.findElement(By.name("submitButton")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertTrue(alertText.contains("Please enter email address"));
        alert.accept();
    }

    @Test
    public void Test8() {
        //check alert for invalid email - done
        driver.navigate().to("http://www.wiley.com/WileyCDA");
        driver.findElement(By.id("EmailAddress")).sendKeys("234gmail.com");
        driver.findElement(By.name("submitButton")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertTrue(alertText.contains("Invalid email address"));
        alert.accept();
    }

    @Test
    public void Test9() {
        //check that list of item appeared
        driver.navigate().to("http://www.wiley.com/WileyCDA");
        wait.until(titleIs("Wiley: Journals, books, and online products and services"));
        driver.findElement(By.name("query")).sendKeys("for dummies");
        driver.findElement(By.xpath("//div/form/fieldset//input[@class=\"icon icon__search search-form-submit\"]")).click();
        WebElement list = driver.findElement(By.id("search-results"));

    }

    @Test
    public void Test12() {
        //check window in new tab
        driver.navigate().to("http://www.wiley.com/WileyCDA");
        wait.until(titleIs("Wiley: Journals, books, and online products and services"));
        driver.findElement(By.linkText("Institutions")).click();

        Iterator<String> i = driver.getWindowHandles().iterator();
        String lastWindow = null;
        while (i.hasNext()) {
            lastWindow = i.next();
        }

        String url = driver.switchTo().window(lastWindow).getCurrentUrl();
        Assert.assertEquals("http://wileyedsolutions.com/", url);
    }
}