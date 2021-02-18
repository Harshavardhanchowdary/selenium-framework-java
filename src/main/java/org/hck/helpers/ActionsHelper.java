package org.hck.helpers;

import org.hck.driver.DriverManager;
import org.hck.enums.WaitStrategy;
import org.hck.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;

public final class ActionsHelper {

    private ActionsHelper() {
    }


    public static void click(By by, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by, waitStrategy).click();
    }

    public static void getTitle(){
        DriverManager.getDriver().getTitle();
    }

}
