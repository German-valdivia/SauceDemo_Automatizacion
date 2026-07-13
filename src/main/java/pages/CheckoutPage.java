package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    // Localizadores del formulario de checkout
    private By campoNombre = By.id("first-name");
    private By campoApellido = By.id("last-name");
    private By campoCodigoPostal = By.id("postal-code");
    private By botonContinuar = By.id("continue");

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Escribir nombre
    public void escribirNombre(String nombre) {
        driver.findElement(campoNombre).sendKeys(nombre);
    }

    // Escribir apellido
    public void escribirApellido(String apellido) {
        driver.findElement(campoApellido).sendKeys(apellido);
    }

    // Escribir codigo postal
    public void escribirCodigoPostal(String codigoPostal) {
        driver.findElement(campoCodigoPostal).sendKeys(codigoPostal);
    }

    // Hacer clic en continuar
    public void hacerClickContinuar() {
        driver.findElement(botonContinuar).click();
    }

    // Completar formulario completo
    public void completarInformacion(String nombre, String apellido, String codigoPostal) {
        escribirNombre(nombre);
        escribirApellido(apellido);
        escribirCodigoPostal(codigoPostal);
        hacerClickContinuar();
    }
}
