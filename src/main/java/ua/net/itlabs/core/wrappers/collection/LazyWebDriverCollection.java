package ua.net.itlabs.core.wrappers.collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;

public class LazyWebDriverCollection extends AbstractLazyCollection {
    private By locator;

    public LazyWebDriverCollection(By locator) {
        this.locator = locator;
    }

    public List<WebElement> getWrappedEntity() {
        return getWebDriver().findElements(locator);
    }

    @Override
    public String toString() {
        return locator.toString();
    }

}
