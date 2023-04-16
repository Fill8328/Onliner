import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


class WebDriverTest {

//    @BeforeAll
//    public void initDriver(){
//        WebDriver driver = new ChromeDriver();
//        driver.navigate().to("https://www.onliner.by/");
//        driver.manage().window().maximize();
//    }


    @Test
    public void checkContainer() {
        //System.setProperties("webdriver.chrome.driver", "/Users/user/Documents/chromedriver_mac_arm64");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.onliner.by/");
        driver.manage().window().maximize();
        driver.findElement(By.className("b-main-navigation__text")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[3]")).getText().equals("Электроника"));

        assertEquals("Электроника", driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[3]")).getText());
        assertEquals("Компьютеры и сети", driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[4]")).getText());
        assertEquals("Бытовая техника", driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[5]")).getText());
        assertEquals("На каждый день", driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[6]")).getText());
        assertEquals("Стройка и ремонт", driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[7]")).getText());
        assertEquals("Дом и сад", driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[8]")).getText());
        assertEquals("Авто и мото", driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[9]")).getText());
        assertEquals("Красота и спорт", driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[10]")).getText());
        assertEquals("Детям и мамам", driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[11]")).getText());

        driver.close();
    }
    @Test
    public void sectorСheckComputerAndNetworks(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://catalog.onliner.by/");
        driver.manage().window().maximize();
        WebElement computerAndNetworksButton =
                driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[4]"));
        computerAndNetworksButton.click();
        System.out.println(computerAndNetworksButton.getText());

        List<WebElement> elements =  driver.findElements(By.xpath("//*[@id=\"container\"]/div/div/div/div/div[1]/div[4]/div/div[3]/div[1]/div/div"));

       // assertTrue(elements.contains("Ноутбуки, компьютеры, мониторы"), "Отсутствует элемент");
       assertTrue(        elements.stream()
               .map(WebElement::getText)
               .collect(Collectors.toList())
               .contains("Ноутбуки, компьютеры, мониторы"), "Отсутствует элемент");

        assertTrue(        elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList())
                .contains("Комплектующие"), "Отсутствует элемент");
        driver.close();
    }
}
