package ua.net.itlabs.core.wrappers.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;

public class LazyWebDriverElement extends AbstractLazyElement {
    private By locator;

    @Override
    public WebElement fetchWrappedEntity() {
        return getWebDriver().findElement(locator);
    }

    public LazyWebDriverElement(By locator) {
        this.locator = locator;
    }

    @Override
    public String toString() {
        return locator.toString();
    }

}
