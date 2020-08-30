package org.thefutureisshining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) {
        WebDriver driver;
        String baseUrl = "http://live.demoguru99.com/index.php/tv.html";
        String actualResult = "";
        String expectedResult = "$615.00";
        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromePath); //para que busque el ejecutable del chromedriver
        driver = new ChromeDriver(); //para que abra el navegador
        driver.get(baseUrl); //para que abra la pagina indicada
        driver.manage().window().maximize(); //para que agrande a pantalla completa

        //click en el link TV
        driver.findElement(By.linkText("TV")).click();

        //click en el Xpath (boton) add to cart
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span")).click();

        // obtener el texto del resultado
        actualResult = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-price > span > span")).getText();

        if (actualResult.contentEquals(expectedResult)) {
            System.out.println("Status: Pass. El resultado es: " + actualResult + " al igual que: " + expectedResult);
        } else {
            System.out.println("Status: Fail. El resultado es: " + actualResult + " y no es igual que: " + expectedResult);
        }
        driver.close();
    }
}
