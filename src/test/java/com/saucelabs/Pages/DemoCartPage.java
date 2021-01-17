package com.saucelabs.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DemoCartPage extends PageBase {

    /***************************************************************/
    
	private WebDriver driver;
	
    /***************************************************************/
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")
    private WebElement addButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement cartButton;

	/***************************************************************/

	public DemoCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
	}
	
    /***************************************************************/
    
    public DemoCartPage login(String userName, String password) {
    	
    	this.addButton.click();
    	
    	this.cartButton.click();
    	
    	return new DemoCartPage(driver);
    	
    }
    
}
