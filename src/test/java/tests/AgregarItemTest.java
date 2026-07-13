package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductosPage;
import pages.CarritoPage;

public class AgregarItemTest {

    @Test
    public void agregarItemAlCarrito() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Crear objetos de las páginas
        LoginPage loginPage = new LoginPage(driver);
        ProductosPage productosPage = new ProductosPage(driver);
        CarritoPage carritoPage = new CarritoPage(driver);

        // Abrir la página de SauceDemo
        loginPage.abrirPagina();

        // Iniciar sesión
        loginPage.iniciarSesion("standard_user", "secret_sauce");

        // Verificar que estamos en la página de productos
        Assert.assertTrue(
                productosPage.estaEnPaginaProductos(),
                "No se mostró la página Products después del login"
        );

        // Agregar Sauce Labs Backpack al carrito
        productosPage.agregarMochilaAlCarrito();

        // Ir al carrito
        productosPage.irAlCarrito();

        // Verificar que el producto está en el carrito
        Assert.assertTrue(
                carritoPage.productoEstaEnCarrito("Sauce Labs Backpack"),
                "El producto Sauce Labs Backpack no está en el carrito"
        );

        // Cerrar navegador
        driver.quit();
    }
}

