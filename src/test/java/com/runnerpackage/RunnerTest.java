package com.runnerpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.ReadExcelData;

public class RunnerTest {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.youtube.com/");
		
		String search = ReadExcelData.getParticularCellData(1, 0);
		
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys(search);
		driver.findElement(By.xpath("//button[@title='Search']")).click();
		
		
	}

}
