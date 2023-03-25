package com.qa.askomdch.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	private Properties prop;
	private ChromeOptions chromeOptions;
	private FirefoxOptions firefoxOptions;
	private EdgeOptions edgeOptions;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		chromeOptions = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim()))
			chromeOptions.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			chromeOptions.addArguments("--incognito");
		return chromeOptions;
	}

	public FirefoxOptions getFirefoxOptions() {
		firefoxOptions = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim()))
			firefoxOptions.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			firefoxOptions.addArguments("--incognito");
		return firefoxOptions;
	}

	public EdgeOptions getEdgeOptions() {
		edgeOptions = new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim()))
			edgeOptions.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			edgeOptions.addArguments("--incognito");
		return edgeOptions;
	}
}
