package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginInvalidoTest {

    @Test
    public void validarLoginInvalido() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Crear objeto de la página LoginPage
        LoginPage loginPage = new LoginPage(driver);

        // Abrir página
        loginPage.abrirPagina();

        // Iniciar sesión con usuario bloqueado
        loginPage.iniciarSesion("locked_out_user", "secret_sauce");

        // Obtener mensaje de error
        String mensajeError = loginPage.obtenerMensajeError();

        // Verificar mensaje esperado
        Assert.assertEquals(
                mensajeError,
                "Epic sadface: Sorry, this user has been locked out." );

        driver.quit();
    }
}

