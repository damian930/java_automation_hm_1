package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium_Test {
    WebDriver driver;

    @Test
    void test_1() {
        System.setProperty("webdriver.chrome.driver", "D:\\Admin\\Desktop\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        driver.get("https://www.google.com");
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("google.com"));

        driver.quit();
    }

    @Test
    void test_2() {
        System.setProperty("webdriver.chrome.driver", "D:\\Admin\\Desktop\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        driver.get("https://www.google.com");
        WebElement styleElement = driver.findElement(By.tagName("style"));
        Assertions.assertNotNull(styleElement, "<style> element is not present on the page");

        driver.quit();
    }

    @Test
    void test_3() {
        System.setProperty("webdriver.chrome.driver", "D:\\Admin\\Desktop\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        driver.get("https://hsreplay.net/account/login/?next=%2F");
        WebElement loginWithBlizzardButton =
                driver.findElement(By.xpath("//button[contains(text(),'Log in with Blizzard')]"));
        loginWithBlizzardButton.click();

        driver.quit();
    }

    @Test
    void test_4() {
        System.setProperty("webdriver.chrome.driver", "D:\\Admin\\Desktop\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        driver.get("https://www.google.com");
        WebElement searchInput = driver.findElement(By.name("form"));
        String autocompleteValue = searchInput.getAttribute("autocomplete");
        Assertions.assertEquals("off", autocompleteValue, "Autocomplete is not set on off");

        driver.quit();
    }
}
