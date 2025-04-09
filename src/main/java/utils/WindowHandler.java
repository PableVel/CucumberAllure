package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHandler {

	private WebDriver driver;

	public WindowHandler(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToWindowByTitle(String windowTitle) {
		String currentWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		String windowName = allWindows.stream().filter(window -> driver.switchTo().window(window).getTitle().equals(windowTitle))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No windows found with title " + windowTitle));

		driver.switchTo().window(windowName);

	}

	public void switchToNewWindow() {
		String currentWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();

		String newWindow = allWindows.stream()
				.filter(window -> !window.equals(currentWindow))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No new windows found"));

		driver.switchTo().window(newWindow);
		
	}


	public void closeCurrentWindowAndSwitchToMain() {
		// Obtener el handle de la ventana principal
		String mainWindow = driver.getWindowHandles().iterator().next();

		// Cerrar la ventana actual
		driver.close();

		// Cambiar el control a la ventana principal
		driver.switchTo().window(mainWindow);
	}
}
