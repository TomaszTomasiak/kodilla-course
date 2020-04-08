package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_YEAR = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement day = driver.findElement(By.id("day"));
        Select selectDay = new Select(day);
        selectDay.selectByIndex(29);

        WebElement month = driver.findElement(By.name("birthday_month"));
        Select selectMonth = new Select(month);
        selectMonth.selectByIndex(2);

        while (!driver.findElement(By.id("birthday_wrapper")).isDisplayed());

        WebElement year = driver.findElement(By.xpath(XPATH_YEAR));
        year.sendKeys("1977");
    }
}
