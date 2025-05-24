package EducacionIT_76632.EduIT;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticaM3 {
	WebDriver driver;
	//Variables que necesitaremos para nuestra prueba
	String url = "http://www.automationpractice.pl/";
	String urlAuthentication="http://www.automationpractice.pl/index.php?controller=my-account";
	
	@BeforeSuite
	public void setUP() {
		// Paso 1: Definir qué navegador vamos a utilizar
		 driver = new EdgeDriver();
	}
	
	@BeforeTest
	public void irUrl() {
		// Paso 2: Abrir la página que se va a probar
		driver.get(url);
		
	}
	
	@BeforeClass
	public void maxVentana() {
		
		driver.manage().window().maximize(); // Maximiza la ventana	
		
	}
	
	@Test
	public void registrarUsuario() {
		// Paso 3: Hacer click en 'Sign in'
				WebElement lnkSign=driver.findElement(By.partialLinkText("Sign"));
				lnkSign.click();

				// Paso 4: Escribir el correo electronico

				WebElement txtEmail=driver.findElement(By.id("email_create"));
				txtEmail.sendKeys("correo19abr"+Math.random()+"@gmail.com");


				// Paso 5 : Hacer clic en 'Create an account'
				WebElement btnCreate=driver.findElement(By.name("SubmitCreate"));
				btnCreate.click();
		        
				
				//Necesitamos agregar una espera de X tiempo o hasta que el radio button se cargue
				WebDriverWait  espera=new WebDriverWait(driver,Duration.ofSeconds(30));
				espera.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
				
				//(6)Seleccionar Sr. o Sra
				WebElement radTitulo=driver.findElement(By.id("id_gender1"));
				radTitulo.click();


				// Paso 7: Escribir el nombre
				WebElement txtNombre=driver.findElement(By.id("customer_firstname"));
				txtNombre.sendKeys("Arturo");
				
				// Paso 8: Escribir el apellido
				WebElement txtApellido=driver.findElement(By.cssSelector("#customer_lastname"));
				txtApellido.sendKeys("Lopez");
				
				// Paso 9: Limpiar el valor del correo electronico
				WebElement txtEmailForm=driver.findElement(By.id("email"));
				txtEmailForm.clear();
				
				// Paso 10: Escribir un nuevo valor de correo electronico
				txtEmailForm.sendKeys("correoModificado19abr"+Math.random()+"@gmail.com");
				
				//Paso 11: Escribir la contrasena
				WebElement txtPasswordForm=driver.findElement(By.name("passwd"));
				txtPasswordForm.clear();
				txtPasswordForm.sendKeys("123456");
				
				//Paso 12 : Seleccionar la fecha de nacimiento(dia-mes-ano)
				Select drpDaysForm=new Select(driver.findElement(By.id("days")));
				drpDaysForm.selectByValue("11");
				
				Select drpMonthsForm=new Select(driver.findElement(By.id("months")));
				drpMonthsForm.selectByValue("4");
				
				Select drpYearsForm=new Select(driver.findElement(By.id("years")));
				drpYearsForm.selectByValue("1998");
				
				
				//Paso 13: Hacer click en checkbox
				WebElement chkNewsletter=driver.findElement(By.name("newsletter"));
				chkNewsletter.click();
				
				//Paso 14: Hacer click en boton 'Register'
				WebElement btnRegister=driver.findElement(By.id("submitAccount"));
				btnRegister.click();
				
				//Paso 19: Confirmacion de la Cuenta
				Assert.assertEquals(urlAuthentication, driver.getCurrentUrl());
				
		
	}
	
	//Paso 18: Captura Pantalla
	
	@AfterMethod	
	public void CapturaPantalla() throws IOException {
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EduIT\\Evidencias\\screenshot.png"));
		
	}
	
    //Paso 16: Fin de Prueba
	@AfterClass
	
	public void finPrueba() {
		System.out.println("fin de Prueba");
	}
	
	//Paso 15: Cerrar el Navegador
	
	@AfterTest
	public void cierreNavegador() {
		
		driver.quit();
		
	}
	
	
	//Paso 17: Cierre de Suite
	@AfterSuite
	public void finSuite() {
		System.out.println("fin de Suite");
		
	}
	
}
