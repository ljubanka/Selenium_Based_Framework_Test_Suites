package ua.net.itlabs.core;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.net.itlabs.core.conditions.Condition;
import ua.net.itlabs.core.elements.LazyCollection;
import ua.net.itlabs.core.elements.LazyElement;

import java.util.List;

import static ua.net.itlabs.core.WaitFor.waitFor;
import static ua.net.itlabs.core.conditions.ElementConditions.visible;

public class ConciseAPI {
    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void setWebDriver(WebDriver driver) {
        ConciseAPI.driver = driver;
    }

    public static void open(String url) {
        getWebDriver().get(url);
    }

    public static LazyElement $(By locator){
        return new LazyElement(locator);//waitFor(locator).until(visible());
    }

    public static LazyElement $(String cssSelector){
        return $(byCSS(cssSelector));
    }

    public static LazyCollection $$(By elementsLocator) {//}, Condition<List<WebElement>> waitForCondition) {
        return new LazyCollection(elementsLocator); //waitFor(elementsLocator).until(waitForCondition);
    }

    public static By byText(String elementText) {
        return By.xpath("//*[text()='" + elementText + "']");
    }

    public static By byTitle(String title) {
        return By.xpath("//*[starts-with(@title,'" + title + "')]");
    }

    public static By byCSS(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

//        super(".//*/text()[normalize-space(.) = " + Quotes.escape(elementText) + "]/parent::*");

    public static <V> V assertThat(Function<? super WebDriver, V> condition) {
        return assertThat(condition, Configuration.timeout);
    }

    public static <V> V assertThat(Function<? super WebDriver, V> condition, int timeout) {
        return (new WebDriverWait(getWebDriver(), timeout)).until(condition);
    }



}
