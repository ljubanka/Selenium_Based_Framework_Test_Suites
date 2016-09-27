package ua.net.itlabs.searchtest;

import org.junit.Test;
import org.openqa.selenium.By;
import ua.net.itlabs.testconfigs.BaseTest;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static ua.net.itlabs.core.ConciseAPI.byCSS;
import static ua.net.itlabs.core.ConciseAPI.open;
import static ua.net.itlabs.core.ConciseAPI.*;
import static ua.net.itlabs.core.conditions.CollectionConditions.*;
import static ua.net.itlabs.core.conditions.ElementConditions.text;
import static ua.net.itlabs.core.conditions.ElementConditions.visible;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void testSearchAndFollowLink() {
        open("http://google.com/ncr");

        search("Selenium automates browsers");
        $$(byCSS(searchResults)).shouldHave(sizeOf(9));

        $(byCSS(topSearchResult)).shouldBe(visible());
        $(byCSS(topSearchResult)).shouldHave(text("Selenium automates browsers"));
        //$$(byCSS(topSearchResult)).get(0).shouldHave(text("Selenium automates browsers"));

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
    public String topSearchResult = "#rso>.g:first-child";

    public void followNthLink(int index) {
        if (index==1) {
            followFirstLink();
        }
        else {
            $$(byCSS(searchResults)).shouldHave(minimumSizeOf(index + 1));
            $$(byCSS(searchResults)).get(index).findElement(byCSS(".r>a")).click();
        }
    }

    public void followFirstLink() {
        $(byCSS(topSearchResult)).shouldBe(visible());
        $(byCSS(topSearchResult)).findElement(byCSS(".r>a")).click();
    }

    public void search(String queryText) {
        $(By.name("q")).setValue(queryText).pressEnter();
    }

}
