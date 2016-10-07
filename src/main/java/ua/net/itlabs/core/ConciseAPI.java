package ua.net.itlabs.core;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.net.itlabs.core.wrappers.LazyCollection;
import ua.net.itlabs.core.wrappers.LazyElement;
import ua.net.itlabs.core.wrappers.collection.LazyWebDriverCollection;
import ua.net.itlabs.core.wrappers.element.LazyWebDriverElement;

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

    public static void refresh() {
        getWebDriver().navigate().refresh();
    }

    public static Actions actions() {
        return new Actions(getWebDriver());
    }

    public static LazyElement $(By locator){
        return new LazyWebDriverElement(locator);
    }

    public static LazyElement $(String cssSelector){
        return $(byCSS(cssSelector));
    }

    public static LazyCollection $$(By elementsLocator) {
        return new LazyWebDriverCollection(elementsLocator);
    }

    public static LazyCollection $$(String cssSelector) {
        return $$(byCSS(cssSelector));
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

    public static void executeJavascript(String JSstring) {
        ((JavascriptExecutor)getWebDriver()).executeScript(JSstring);
    }

    public static <V> V assertThat(Function<? super WebDriver, V> condition) {
        return assertThat(condition, Configuration.timeoutMs);
    }

    public static <V> V assertThat(Function<? super WebDriver, V> condition, long timeoutMs) {
        return (new WebDriverWait(getWebDriver(), timeoutMs/1000)).until(condition);
    }

}
