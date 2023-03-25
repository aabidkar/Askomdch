package com.qa.askomdch.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.askomdch.exception.FrameworkException;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static String highlight;

	/**
	 * This method is initializing the driver on the basis of the given browser
	 * name.
	 * 
	 * @param browserName
	 * @return this returns the driver.
	 */
	public WebDriver initDriver(Properties prop) {
		optionsManager = new OptionsManager(prop);
		highlight = prop.getProperty("highlight").trim();
		String browserName = prop.getProperty("browsername").toLowerCase().trim();
		System.out.println("Passed Browser Name is => " + browserName);
		if (browserName.trim().equalsIgnoreCase("chrome"))
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		else if (browserName.trim().equalsIgnoreCase("firefox"))
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		else if (browserName.trim().equalsIgnoreCase("edge"))
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
		else
			throw new FrameworkException("Please enter a valid browser name...");
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	/*
	 * Get the local thread copy of the driver.
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * This method is reading the properties from the .properties file.
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public Properties initProperties() {
		System.out.println("Loaded Init Proper");
		prop = new Properties();
		FileInputStream ip = null;
		String envName = System.getProperty("env");
		System.out.println("Running test on Env " + envName);
		try {
			switch (envName.toLowerCase().trim()) {
			case "qa":
				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
				prop.load(ip);
				break;
			case "stage":
				ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
				prop.load(ip);
				break;
			case "uat":
				ip = new FileInputStream("./src/test/resources/config/config.properties");
				prop.load(ip);
				break;
			default:
				throw new FrameworkException("Invalid enviroment is passed =>  " + envName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	/**
	 * Take the screenshot.
	 */
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			org.openqa.selenium.io.FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}
}
