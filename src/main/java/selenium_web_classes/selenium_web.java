/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selenium_web_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class selenium_web {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.calculator.net/");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));    
                
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//*[@id=\"homelistwrap\"]/div[3]/div[2]/a")).click();
        
        driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();
        
        driver.findElement(By.id("cpar1")).sendKeys("10");
        
        driver.findElement(By.id("cpar2")).sendKeys("50");
        
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();
        
        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();
        
        System.out.println("The Result is " + result);
        
        driver.quit();
    }
}
