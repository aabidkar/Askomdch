package com.qa.askomdch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.askomdch.constants.AppConstants;
import com.qa.askomdch.utils.ElementUtil;

public class ProductDetailPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By productHeader = By.tagName("h1");
	private By relatedProductCount = By.xpath("//h2[@class='woocommerce-loop-product__title']");
	private By productDescription = By.xpath("//div[contains(@class,'short-description')]/p");
	private By additionalInfo = By.xpath("//li[contains(@id,'additional_information')]/a");
	private By prodInfoWeght = By.xpath("//tr[contains(@class,'item--weight')]/th");
	private By prodReview = By.cssSelector("#tab-title-reviews>a");
	private By prodReviewTitle = By.cssSelector("#comments > h2");
	private By comment = By.id("comment");
	private By submitComment = By.xpath("//input[@id='submit']");
	private By reviewSuccMsg = By.xpath("//em[contains(@class,'awaiting-approval')]");
	private By quantity = By.name("quantity");
	private By addToCartBtn = By.name("add-to-cart");
	private By cartSuccessMsg = By.xpath("//div/a[@tabindex='1']");

	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getProductHeader() {
		System.out.println("Product Header is => " + elementUtil.doElementGetText(productHeader));
		return elementUtil.doElementGetText(productHeader);
	}

	public int getRelatedProductsCount() {
		System.out.println("Related Product Count is => " + elementUtil.getTotalElementsCount(relatedProductCount));
		return elementUtil.getTotalElementsCount(relatedProductCount);
	}

	public Boolean verifyProductDesc() {
		return elementUtil.doElementIsDisplayed(productDescription);
	}

	public Boolean verifyAdditionalInfo() {
		elementUtil.doClick(additionalInfo);
		return elementUtil.doElementIsDisplayed(prodInfoWeght);
	}

	public Boolean verifyReview() {
		elementUtil.doClick(prodReview);
		return elementUtil.doElementIsDisplayed(prodReviewTitle);
	}

	public String submitReview(int startRatingCount, String commentText) {
		By starRating = By.xpath("//a[@class='star-" + startRatingCount + "']");
		if (startRatingCount > 0 || startRatingCount < 5)
			elementUtil.waitForElementPresence(starRating, AppConstants.DEFAULT_SHORT_TIME_OUT).click();
		else
			System.out.println("Please enter a valid Star Rating for the Product");
		elementUtil.doSendKeys(comment, commentText);
		elementUtil.doClick(submitComment);
		return elementUtil.waitForElementPresence(reviewSuccMsg, AppConstants.DEFAULT_LONG_TIME_OUT).getText();

	}

	public void enterQuantity(int qty) {
		elementUtil.doSendKeys(quantity, String.valueOf(qty));
	}

	public String addProductToCart() {
		elementUtil.doClick(addToCartBtn);
		String successMsg=elementUtil.waitForElementVisible(cartSuccessMsg, AppConstants.DEFAULT_SHORT_TIME_OUT).getText();
		System.out.println("Cart Success Message is => "+successMsg);
		return successMsg;
	}

}
