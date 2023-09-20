package pe.edu.upc.testingweb;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Map<String, Object> vars = new HashMap<>();

        WebDriver driver;
        String pathDriver = System.getProperty("user.dir") + "\\driver\\chromedriver_117.exe";
        System.setProperty("webdriver.chrome.driver", pathDriver);
        driver = new ChromeDriver();

        driver.get("https://www.upc.edu.pe/");
        driver.manage().window().setSize(new Dimension(1382, 784));
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".active .fuente-ghoty-mvb")).click();

        driver.switchTo().window(vars.get("win631").toString());
        vars.put("window_handles", driver.getWindowHandles());
        driver.findElement(By.cssSelector(".pr-lg-1 .btn-conoce")).click();
        driver.switchTo().window(vars.get("win6433").toString());
        driver.findElement(By.cssSelector(".col-4 li:nth-child(11) .zizou")).click();
        driver.findElement(By.cssSelector("#paso-11 .mb-3:nth-child(8) > .item-d-show")).click();
        driver.findElement(By.cssSelector("#paso-11 .mb-3:nth-child(8) > .item-d-show")).click();
        driver.findElement(By.cssSelector("#paso-11 .mb-3:nth-child(8) > .item-d-show")).click();
        driver.findElement(By.name("first_name")).click();
        driver.findElement(By.name("first_name")).sendKeys("Carlos");
        driver.findElement(By.name("paternal_last_name")).sendKeys("Chira");
        driver.findElement(By.name("maternal_last_name")).click();
        driver.findElement(By.name("maternal_last_name")).sendKeys("Marcico");
        driver.findElement(By.cssSelector(".col-lg-6:nth-child(5) .fa")).click();
        driver.findElement(By.cssSelector(".col-lg-6:nth-child(5) .fa")).click();
        driver.findElement(By.name("gender")).click();
        {
            WebElement dropdown = driver.findElement(By.name("gender"));
            dropdown.findElement(By.xpath("//option[. = 'Masculino']")).click();
        }
        driver.findElement(By.name("dni")).click();
        driver.findElement(By.name("dni")).sendKeys("47859632");
        driver.findElement(By.id("shifts")).click();
        {
            WebElement dropdown = driver.findElement(By.id("shifts"));
            dropdown.findElement(By.xpath("//option[. = 'CAMPUS SAN ISIDRO']")).click();
        }
        driver.findElement(By.id("cities")).click();
        {
            WebElement dropdown = driver.findElement(By.id("cities"));
            dropdown.findElement(By.xpath("//option[. = 'Atalaya']")).click();
        }
        driver.findElement(By.id("careers")).click();
        {
            WebElement dropdown = driver.findElement(By.id("careers"));
            dropdown.findElement(By.xpath("//option[. = 'COMUNICACIÓN E IMAGEN EMPRESARIAL']")).click();
        }
        driver.findElement(By.cssSelector(".col-lg-6:nth-child(14) .fa")).click();
        driver.findElement(By.cssSelector(".col-lg-6:nth-child(14) .fa")).click();
        driver.findElement(By.cssSelector(".col-lg-6:nth-child(14) .fa")).click();
        driver.findElement(By.cssSelector(".col-lg-6:nth-child(14) .fa")).click();
    }
}