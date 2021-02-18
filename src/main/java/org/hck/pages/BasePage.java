package org.hck.pages;

import org.hck.driver.DriverManager;
import org.hck.enums.WaitStrategy;
import org.hck.factories.ExplicitWaitFactory;
import org.hck.helpers.ActionsHelper;
import org.openqa.selenium.By;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy){
        ActionsHelper.click(by, waitStrategy);
    }

    protected void sendKeys(By by, String text, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).sendKeys(text);
    }

    protected String getText(By by, WaitStrategy waitStrategy){
        return ExplicitWaitFactory.performExplicitWait(by, waitStrategy).getText();
    }

    protected String getTite(){
        return DriverManager.getDriver().getTitle();
    }

}
