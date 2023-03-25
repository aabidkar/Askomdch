package com.qa.askomdch.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TempTest {
	@Test
	public void doReview() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://askomdch.com/product/basic-blue-jeans/");
		driver.manage().window().maximize();
		driver.findElement(By.id("tab-title-reviews")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='star-3']")).click();
	}

}
