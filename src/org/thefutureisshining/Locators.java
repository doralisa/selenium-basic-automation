package org.thefutureisshining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) {
        WebDriver driver;
        String baseUrl = "http://live.demoguru99.com/index.php/";
        String actualResult = "";
        String expectedResult = "$615.00";
        String chromePath = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe"; //creo variable para que busque el driver cuando la llame

        System.setProperty("webdriver.chrome.driver", chromePath); //abro el chromedriver
        driver = new ChromeDriver(); //abro el navegador
        driver.get(baseUrl); //abro la pagina indicada
        driver.manage().window().maximize(); //maximizo la ventana del navegador

        driver.findElement(By.linkText("TV")).click(); //indicar que haga click en el boton TV
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span")).click(); //hacer click en "add to cart"
        actualResult = driver.findElement(By.cssSelector("#shopping-cart-table>tbody>tr>td.product-cart-price>span>span")).getText();

        //comparación del resultado obtenido y esperado
        if (actualResult.contentEquals(expectedResult)) {
            System.out.println("Status: Pass " + actualResult + " el resultado es igual a: " + expectedResult);
        } else {
            System.out.println("Status: Fail " + actualResult + " el resultado no es igual a: " + expectedResult);
        }
        driver.close();
    }
}
