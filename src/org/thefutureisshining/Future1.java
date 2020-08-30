package org.thefutureisshining;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Future1 {
    public static void main(String[] args) {
        //Instanciar un objeto Webdriver
        WebDriver driver;

        //Declarar variables
        String baseURL = "http://demo.guru99.com/test/newtours/index.php";
        String actualResult = "";
        String expectedResult = "Welcome: Mercury Tours";

        //Indicar la localización del archivo chromedriver.exe en la propiedad webdriver.chrome.driver
        //System.getproperty("user.dir") = C:\...\...\SeleniumBasic
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        //Abrir el navegador Chrome
        driver = new ChromeDriver();

        //navegar a la página
        driver.get(baseURL);

        //extraer el titulo de la pagina web
        actualResult = driver.getTitle();

        //imprimir el resultado usando el operador ternario
        System.out.println(actualResult.contentEquals(expectedResult)?"Status: Pass, Result: " + actualResult : "Status: Fail Result: ");

        driver.close();
    }
}
