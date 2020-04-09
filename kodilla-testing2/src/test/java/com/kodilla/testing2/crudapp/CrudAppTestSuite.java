package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class CrudAppTestSuite {

    private static final String BASE_URL = "https://tomasztomasiak.github.io/";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        //driver.get(BASE_URL);
        generator = new Random();
    }

//    @After
//    public void cleanUpAfterTest() {
//        driver.close();
//    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000, 0);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreatedCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreatedCard.click();
                });
        Thread.sleep(5000, 0);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "http://trello.com/login";
        //final String ALTASIAN_URL = "https://id.atlassian.com/login?application=trello&continue=https%3A%2F%2Ftrello.com%2Fauth%2Fatlassian%2Fcallback%3FreturnUrl%3D%252F%26csrf%3DgH7N3Zgdl5TK6u%252FuBAelpD0XJJhLnWw9qXsqiar82o8%253D%26display%3D&email=tomasz.tomasiak.pl%40gmail.com&errorCode&login_hint=tomasz.tomasiak.pl%40gmail.com&restrict=true";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);


        driverTrello.findElement(By.id("user")).sendKeys("tomasz.tomasiak.pl@gmail.com");

        //Thread.sleep(2000, 0);

        //WebDriver altasian = WebDriverConfig.getDriver((WebDriverConfig.CHROME));
        //altasian.get(ALTASIAN_URL);

        Thread.sleep(5000, 0);

        driverTrello.findElement(By.id("login")).submit();
        driverTrello.findElement(By.id("password")).sendKeys("KodillaTT");
        driverTrello.findElement(By.id("login-submit")).submit();
        // altasian.findElement(By.id("continue-as")).click();

        Thread.sleep(5000, 0);

        driverTrello.findElements(By.xpath("//a[@class=\"board-title\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() > 10)
                .forEach(aHref -> aHref.click());

        Thread.sleep(2000, 0);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size() > 10;

        driverTrello.close();

        return result;
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        //String taskName = createCrudAppTestTask();
        //sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello("abc"));
    }
}
