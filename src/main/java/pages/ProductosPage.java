package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductosPage {

    private WebDriver driver;

    // Localizadores de la página de productos
    private By tituloPagina = By.className("title");
    private By botonAgregarMochila = By.id("add-to-cart-sauce-labs-backpack");
    private By iconoCarrito = By.className("shopping_cart_link");
    private By filtroOrdenamiento = By.className("product_sort_container");
    private By preciosProductos = By.className("inventory_item_price");
    private By botonesAgregarProducto = By.cssSelector(".btn_inventory");

    // Constructor
    public ProductosPage(WebDriver driver) {
        this.driver = driver;
    }

    // Obtener título de la página
    public String obtenerTituloPagina() {
        return driver.findElement(tituloPagina).getText();
    }

    // Validar si estamos en la página Products
    public boolean estaEnPaginaProductos() {
        return obtenerTituloPagina().equals("Products");
    }

    // Agregar Sauce Labs Backpack al carrito
    public void agregarMochilaAlCarrito() {
        driver.findElement(botonAgregarMochila).click();
    }

    // Ir al carrito
    public void irAlCarrito() {
        driver.findElement(iconoCarrito).click();
    }

    // Ordenar productos de mayor a menor precio
    public void ordenarPorPrecioMayorAMenor() {
        WebElement filtro = driver.findElement(filtroOrdenamiento);
        Select select = new Select(filtro);
        select.selectByVisibleText("Price (high to low)");
    }

    // Obtener precios de los productos como números
    public List<Double> obtenerPreciosProductos() {
        List<WebElement> elementosPrecios = driver.findElements(preciosProductos);
        List<Double> precios = new ArrayList<>();

        for (WebElement elemento : elementosPrecios) {
            String precioTexto = elemento.getText().replace("$", "");
            double precioNumero = Double.parseDouble(precioTexto);
            precios.add(precioNumero);
        }

        return precios;
    }

    // Agregar el primer producto disponible
    public void agregarPrimerProductoAlCarrito() {
        driver.findElements(botonesAgregarProducto).get(0).click();
    }
}
