package ua.net.itlabs.core.wrappers.collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.Condition;

import java.util.List;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;
import static ua.net.itlabs.core.WaitFor.waitFor;

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
