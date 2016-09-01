package ua.net.itlabs.core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.Condition;

import java.util.List;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;
import static ua.net.itlabs.core.WaitFor.waitFor;

public class LazyCollection implements LazyCollectionEntity {
    private By locator;

    public LazyCollection(By locator) {
        this.locator = locator;
    }

    public List<WebElement> getWrappedEntity() {
        return getWebDriver().findElements(locator);
    }

    @Override
    public List<WebElement> shouldHave(Condition<List<WebElement>> condition) {
        List<WebElement> elements;
        elements = waitFor(this).until(condition);
        return elements;
    }
}
