package EducacionIT_76632.EduIT;
//Librerias que se necesitaran para ejecutar este archivo
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticaM1 {
	// Variables que necesitaremos para nuestra prueba
	String url = "http://www.automationpractice.pl/";

	@Test @Disabled
	public void lab1_test() {

		System.out.println("Hola mundo de Automatización!!");		
	}

	@Test
	public void buscarProductoEdge() {
		// Paso 1: Definir qué navegador vamos a utilizar
		WebDriver driver = new EdgeDriver();
		driver.manage().deleteAllCookies(); // Borra las cookies
		driver.manage().window().maximize(); // Maximiza la ventana

		// Paso 2: Abrir la página que se va a probar
		driver.get(url);


		//Paso 3:Escribir la palabra que queremos buscar

		WebElement txtBusqueda=driver.findElement(By.id("search_query_top"));
		txtBusqueda.sendKeys("dress");

		//Paso 4: Simular un ENTER

		//txtBusqueda.sendKeys(Keys.ENTER);

		//Paso 4 a: Hacer clic en botón de búsqueda

		WebElement btnBusqueda=driver.findElement(By.name("submit_search"));
		btnBusqueda.click();




		//Paso 5: Cerrar el Navegador

		//driver.close(); //Cierra la última pestaña que se trabajó
		driver.quit(); //Cierra todas las pestañas que se trabajaron


	}


	@Test
	public void buscarProductoFirefox() {
		// Paso 1: Definir qué navegador vamos a utilizar
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies(); // Borra las cookies
		driver.manage().window().maximize(); // Maximiza la ventana

		// Paso 2: Abrir la página que se va a probar
		driver.get(url);


		//Paso 3:Escribir la palabra que queremos buscar

		WebElement txtBusqueda=driver.findElement(By.id("search_query_top"));
		txtBusqueda.sendKeys("dress");

		//Paso 4: Simular un ENTER

		txtBusqueda.sendKeys(Keys.ENTER);

		//Paso 4 a: Hacer clic en botón de búsqueda

		//WebElement btnBusqueda=driver.findElement(By.name("submit_search"));
		//btnBusqueda.click();



		//Paso 5: Cerrar el Navegador

		//driver.close(); //Cierra la última pestaña que se trabajó
		driver.quit(); //Cierra todas las pestañas que se trabajaron


	}



}
