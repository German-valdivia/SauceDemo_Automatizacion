package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResumenCompraPage {

    private WebDriver driver;

    // Localizador del boton Finish
    private By botonFinalizar = By.id("finish");

    // Constructor
    public ResumenCompraPage(WebDriver driver) {
        this.driver = driver;
    }

    // Hacer clic en Finish
    public void hacerClickFinalizar() {
        driver.findElement(botonFinalizar).click();
    }
}