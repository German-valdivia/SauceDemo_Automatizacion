package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductosPage;

public class OrdenarProductosTest {

    @Test
    public void ordenarProductosPorPrecioMayorAMenor() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Crear objetos de las páginas
        LoginPage loginPage = new LoginPage(driver);
        ProductosPage productosPage = new ProductosPage(driver);

        // Abrir página SauceDemo
        loginPage.abrirPagina();

        // Iniciar sesión
        loginPage.iniciarSesion("standard_user", "secret_sauce");

        // Verificar que estamos en Products
        Assert.assertTrue(
                productosPage.estaEnPaginaProductos(),
                "No se mostró la página Products después del login" );

        // Ordenar productos de mayor a menor precio
        productosPage.ordenarPorPrecioMayorAMenor();

        // Obtener precios
        List<Double> precios = productosPage.obtenerPreciosProductos();

        // Verificar que estén ordenados de mayor a menor
        for (int i = 0; i < precios.size() - 1; i++) {
            Assert.assertTrue(
                    precios.get(i) >= precios.get(i + 1),
                    "Los productos no están ordenados de mayor a menor" );
        }

        // Cerrar navegador
        driver.quit();
    }
}

