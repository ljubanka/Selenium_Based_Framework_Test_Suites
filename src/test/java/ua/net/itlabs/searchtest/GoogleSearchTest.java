package ua.net.itlabs.searchtest;

import org.junit.Test;
import org.openqa.selenium.By;
import ua.net.itlabs.testconfigs.BaseTest;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static ua.net.itlabs.core.ConciseAPI.open;
import static ua.net.itlabs.core.ConciseAPI.*;
import static ua.net.itlabs.core.conditions.CollectionConditions.*;
import static ua.net.itlabs.core.conditions.ElementConditions.text;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void testSearchAndFollowLink() {
        open("http://google.com/ncr");

        search("Selenium automates browsers");
        $$(searchResults).shouldHave(size(10));
        $$(searchResults).get(0).shouldHave(text("Selenium automates browsers"));

        followNthLink(0);
        assertThat(urlContains("http://www.seleniumhq.org/"));
    }

    @Test
    public void testFollowResultLink() {
        open("http://google.com/ncr");

        search("Selenium automates browsers");

        followNthLink(0);
        assertThat(urlContains("http://www.seleniumhq.org/"));
    }

    public String searchResults = ".srg>.g";

    public void followNthLink(int index) {
        $$(searchResults).get(index).find(".r>a").click();
    }

    public void search(String queryText) {
        $(By.name("q")).setValue(queryText).pressEnter();
    }

}
