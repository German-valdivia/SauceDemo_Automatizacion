package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarritoPage {

    private WebDriver driver;

    // Localizadores del carrito
    private By nombreProductoCarrito = By.className("inventory_item_name");
    private By botonCheckout = By.id("checkout");

    // Constructor
    public CarritoPage(WebDriver driver) {
        this.driver = driver;
    }

    // Obtener nombre del producto en el carrito
    public String obtenerNombreProducto() {
        return driver.findElement(nombreProductoCarrito).getText();
    }

    // Validar si el producto está en el carrito
    public boolean productoEstaEnCarrito(String nombreProducto) {
        return obtenerNombreProducto().equals(nombreProducto);
    }

    // Hacer clic en Checkout
    public void hacerClickCheckout() {
        driver.findElement(botonCheckout).click();
    }
}
