package ua.net.itlabs.searchtest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ua.net.itlabs.gmailtest.testconfigs.BaseTest;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static ua.net.itlabs.core.ConciseAPI.byCSS;
import static ua.net.itlabs.core.ConciseAPI.open;
import static ua.net.itlabs.core.Conditions.text;
import static ua.net.itlabs.core.WaitFor.waitFor;
import static ua.net.itlabs.core.ConciseAPI.*;
import static ua.net.itlabs.core.Conditions.sizeOf;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void testSearchAndFollowLink() {
        open("http://google.com/ncr");

        search("Selenium automates browsers");

        waitFor(byCSS(searchResults)).until(sizeOf(10));
        //wait.until(textToBePresentInElementLocated(By.cssSelector(searchResults + ":first-child"), "Selenium automates browsers"));
        waitFor(byCSS(searchResults + ":first-child")).until(text("Selenium automates browsers"));

        //followNthLink(0);
//        wait.until(urlContains("http://www.seleniumhq.org/"));
    }

//    @Test
//    public void testFollowResultLink() {
//        driver.get("http://google.com/ncr");
//
//        search("Selenium automates browsers");
//
//        followNthLink(0);
//        wait.until(urlContains("http://www.seleniumhq.org/"));
//    }

    public String searchResults = ".srg>.g";

//    public void followNthLink(int index) {
//        wait.until(minimumSizeOf(By.cssSelector(searchResults), index+1));
//        driver.findElements(By.cssSelector(searchResults)).get(index).findElement(By.cssSelector(".r>a")).click();
//    }

    public void search(String queryText) {
        //driver.findElement(By.name("q")).clear();
        getWebDriver().findElement(By.name("q")).clear();
        //driver.findElement(By.name("q")).sendKeys(queryText + Keys.ENTER);
        getWebDriver().findElement(By.name("q")).sendKeys(queryText + Keys.ENTER);
    }

}
