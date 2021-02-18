package org.hck.tests;


import org.hck.pages.HomePage;
import org.hck.reports.ExtentLogger;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public final class LoginPageTest extends BaseTest{

    /**
     * singleton classes-prevent class instances being created in any place other than this very class.
     */
    private LoginPageTest() {

    }


   @Test(description = "Search Product with Invalid data.")
    public void searchProduct(){
       HomePage hp = new HomePage();
       String actualTitle = hp.getTitleText();
       Assert.assertEquals(actualTitle, "My Store");
       assertThat(actualTitle)
               .isNotNull()
               .hasSizeGreaterThan(4)
               .isEqualTo("My Store");
       hp.enterSearch("Automation 1");
       hp.clickSearchButton();
      String warningMessageText =  hp.getWarningText();
       ExtentLogger.pass("",true);
       assertThat(warningMessageText)
               .isNotNull()
               .isEqualTo("No results were found for your search \"Automation 1\"")
               .hasSizeGreaterThan(5);


   }

    @Test(description = "Search Product with Invalid data2.")
    public void searchProductx(){
        HomePage hp = new HomePage();
        String actualTitle = hp.getTitleText();
        Assert.assertEquals(actualTitle, "My Store");
        assertThat(actualTitle)
                .isNotNull()
                .hasSizeGreaterThan(4)
                .isEqualTo("My Store");
        hp.enterSearch("Automation 1");
        hp.clickSearchButton();
        String warningMessageText =  hp.getWarningText();
        ExtentLogger.pass("",true);
        assertThat(warningMessageText)
                .isNotNull()
                .isEqualTo("No results were found for your search \"Automation 1\"")
                .hasSizeGreaterThan(5);


    }
}
