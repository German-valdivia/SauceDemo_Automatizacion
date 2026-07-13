package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Localizadores de la página de login
    private By campoUsuario = By.id("user-name");
    private By campoContrasena = By.id("password");
    private By botonLogin = By.id("login-button");
    private By mensajeError = By.cssSelector("h3[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Abrir la página
    public void abrirPagina() {
        driver.get("https://www.saucedemo.com/");
    }

    // Escribir usuario
    public void escribirUsuario(String usuario) {
        driver.findElement(campoUsuario).sendKeys(usuario);
    }

    // Escribir contraseña
    public void escribirContrasena(String contrasena) {
        driver.findElement(campoContrasena).sendKeys(contrasena);
    }

    // Hacer clic en login
    public void hacerClickLogin() {
        driver.findElement(botonLogin).click();
    }

    // Método completo para iniciar sesión
    public void iniciarSesion(String usuario, String contrasena) {
        escribirUsuario(usuario);
        escribirContrasena(contrasena);
        hacerClickLogin();
    }

    // Obtener mensaje de error
    public String obtenerMensajeError() {
        return driver.findElement(mensajeError).getText();
    }
}
