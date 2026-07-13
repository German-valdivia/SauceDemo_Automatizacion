package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompraFinalizadaPage {

    private WebDriver driver;

    // Localizador del mensaje final
    private By mensajeConfirmacion = By.className("complete-header");

    // Constructor
    public CompraFinalizadaPage(WebDriver driver) {
        this.driver = driver;
    }

    // Obtener mensaje final de compra
    public String obtenerMensajeConfirmacion() {
        return driver.findElement(mensajeConfirmacion).getText();
    }
}
