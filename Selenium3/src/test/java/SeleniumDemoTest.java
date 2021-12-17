import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;


class SeleniumDemoTest {
    private WebDriver driver;


    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1420,108");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");


    }

    @RepeatedTest(15)
    public void testAQuery() throws InterruptedException {
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("Selenium3");

        WebElement searchButton = driver.findElement(By.name("btnK"));
        Thread.sleep(500);
        searchButton.click();

        List<WebElement> results = driver.findElements(By.tagName("h3")) ;
        results.get(0).click();

    }

    @AfterEach
    public void destroy()  {
        driver.quit();
    }
}
