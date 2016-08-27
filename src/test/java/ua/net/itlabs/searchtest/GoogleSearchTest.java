package ua.net.itlabs.searchtest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ua.net.itlabs.testconfigs.BaseTest;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static ua.net.itlabs.core.ConciseAPI.byCSS;
import static ua.net.itlabs.core.ConciseAPI.open;
import static ua.net.itlabs.core.conditions.Conditions.minimumSizeOf;
import static ua.net.itlabs.core.conditions.Conditions.text;
import static ua.net.itlabs.core.WaitFor.waitFor;
import static ua.net.itlabs.core.ConciseAPI.*;
import static ua.net.itlabs.core.conditions.Conditions.sizeOf;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void testSearchAndFollowLink() {
        open("http://google.com/ncr");

        search("Selenium automates browsers");

        waitFor(byCSS(searchResults)).until(sizeOf(10));
        waitFor(byCSS(searchResults + ":first-child")).until(text("Selenium automates browsers"));

        followNthLink(0);
        assertThat(urlContains("http://www.seleniumhq.org/"));
    }

    @Test
    public void testFollowResultLink() {
        open("http://google.com/ncr");

        search("Selenium automates browsers");

        followNthLink(1);
        assertThat(urlContains("http://www.seleniumhq.org/"));
    }

    public String searchResults = ".srg>.g";

    public void followNthLink(int index) {
        waitFor(byCSS(searchResults)).until(minimumSizeOf(index+1)); // isn't this line extra now?
        $$(byCSS(searchResults), minimumSizeOf(index+1)).get(index).findElement(byCSS(".r>a")).click();
    }

    public void search(String queryText) {
        $(By.name("q")).clear();
        $(By.name("q")).sendKeys(queryText + Keys.ENTER);
    }

}
