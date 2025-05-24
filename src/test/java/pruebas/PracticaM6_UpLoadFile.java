package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class PracticaM6_UpLoadFile {
	
	
	String url="https://demo.guru99.com/test/upload";
	WebDriver driver;
	
	
	@BeforeMethod
	public void SetUP() {
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@Test
	public void CargaArchivo() {
		
		WebElement rutaArchivo=driver.findElement(By.id("uploadfile_0"));
		rutaArchivo.sendKeys("C:\\Users\\user\\eclipse-workspace\\EduIT\\prueba.txt");
				
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}


}
