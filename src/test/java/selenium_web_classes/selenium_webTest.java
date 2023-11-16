/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package selenium_web_classes;

import java.time.Duration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author Usuario
 */
public class selenium_webTest {
    
    private WebDriver driver;
    
    public selenium_webTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Habilita el modo headless
        driver = new ChromeDriver(options);
        driver.get("https://www.calculator.net/");        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));                    
        driver.manage().window().maximize();        
        driver.findElement(By.xpath("//*[@id=\"homelistwrap\"]/div[3]/div[2]/a")).click();        
        driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Test of main method, of class selenium_web.
     */
    @Test
    public void testPorcentaje_Positivo_A_and_B() {        
        driver.findElement(By.id("cpar1")).sendKeys("10");        
        driver.findElement(By.id("cpar2")).sendKeys("50");        
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();        
        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();        
        assertTrue(Double.parseDouble(result) > 0.0);
    }

    @Test
    public void testPorcentaje_Positivo_A_B() {        
        driver.findElement(By.id("cpar1")).sendKeys("10");        
        driver.findElement(By.id("cpar2")).sendKeys("50");        
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();        
        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();        
        String expected = "5";        
        assertEquals(expected, result);         
    }
    
    @Test
    public void testPorcentaje_Negativo_Or_A_or_B() {        
        driver.findElement(By.id("cpar1")).sendKeys("-10");        
        driver.findElement(By.id("cpar2")).sendKeys("50");        
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();        
        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();        
        assertTrue(Double.parseDouble(result) < 0.0);
    }

    @Test
    public void testPorcentaje_Negativo_A() {        
        driver.findElement(By.id("cpar1")).sendKeys("-10");        
        driver.findElement(By.id("cpar2")).sendKeys("200");        
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();        
        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();        
        String expected = "-20";        
        assertEquals(expected, result);        
    }
    
    @Test
    public void testPorcentaje_Negativo_B() {         
        driver.findElement(By.id("cpar1")).sendKeys("10");        
        driver.findElement(By.id("cpar2")).sendKeys("-350");        
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();        
        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();        
        String expected = "-35";        
        assertEquals(expected, result);        
    }

    @Test
    public void testPorcentaje_Cero_A() {        
        driver.findElement(By.id("cpar1")).sendKeys("0");        
        driver.findElement(By.id("cpar2")).sendKeys("200");        
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();        
        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();        
        String expected = "0";        
        assertEquals(expected, result);        
    }

    @Test
    public void testPorcentaje_Cero_B() {        
        driver.findElement(By.id("cpar1")).sendKeys("55");        
        driver.findElement(By.id("cpar2")).sendKeys("0");        
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();        
        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();        
        String expected = "0";        
        assertEquals(expected, result);        
    }

    @Test
    public void testPorcentaje_Decimal_A() {        
        driver.findElement(By.id("cpar1")).sendKeys("0.5");        
        driver.findElement(By.id("cpar2")).sendKeys("300");        
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();        
        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();        
        String expected = "1.5";        
        assertEquals(expected, result);        
    }
    
    @Test
    public void testPorcentaje_Decimal_B() {
        driver.findElement(By.id("cpar1")).sendKeys("5");        
        driver.findElement(By.id("cpar2")).sendKeys("200.5");        
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();        
        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();        
        String expected = "10.025";        
        assertEquals(expected, result);        
    }
}
