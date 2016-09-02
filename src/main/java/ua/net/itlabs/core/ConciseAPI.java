package ua.net.itlabs.core;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    public static LazyWebDriverElement $(By locator){
        return new LazyWebDriverElement(locator);//waitFor(locator).until(visible());
    }

    public static LazyWebDriverElement $(String cssSelector){
        return $(byCSS(cssSelector));
    }

    public static LazyWebDriverCollection $$(By elementsLocator) {//}, Condition<List<WebElement>> waitForCondition) {
        return new LazyWebDriverCollection(elementsLocator); //waitFor(elementsLocator).until(waitForCondition);
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

    public static <V> V assertThat(Function<? super WebDriver, V> condition, long timeoutMs) {
        return (new WebDriverWait(getWebDriver(), timeoutMs/1000)).until(condition);
    }



}
