package org.hck.pages;

import org.hck.enums.WaitStrategy;
import org.hck.reports.ExtentLogger;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public final By textBoxSearch = By.id("search_query_top");
    public final By buttonSearch = By.xpath("//form[@id='searchbox']/button");
    public final By textWarning = By.xpath("//div[@id ='center_column']//p[contains(@class,'alert-warning')]");
    private final By menuItemTShirts = By.xpath("//li[3]//a[text()='T-shirts']");

    public void clickTShirts() {
        click(menuItemTShirts, WaitStrategy.CLICKABLE);
        ExtentLogger.pass("Clicked on 'T-Shirts' tab.");
    }

    public HomePage enterSearch(String searchKey) {
        sendKeys(textBoxSearch, searchKey, WaitStrategy.PRESENCE);
        ExtentLogger.pass("Entered search text.");
        ExtentLogger.info("Search Text:"+searchKey);
        return this;
    }

    public void clickSearchButton() {
        click(buttonSearch, WaitStrategy.CLICKABLE);
        ExtentLogger.pass("Clicked on Search Button.");
    }

    public String getWarningText() {
        String waringText =  getText(textWarning, WaitStrategy.VISIBLE);
        ExtentLogger.pass("Got the warning message.");
        ExtentLogger.info("Message Obtained: "+waringText);
        return waringText;
    }

    public String getTitleText(){
       return getTite();
    }


}
