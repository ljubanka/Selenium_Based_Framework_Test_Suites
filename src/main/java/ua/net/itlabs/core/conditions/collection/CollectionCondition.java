package ua.net.itlabs.core.conditions.collection;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.AbstractCondition;

import java.util.List;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;

public abstract class CollectionCondition extends AbstractCondition<List<WebElement>> {

    @Override
    public String identity() {
        return "elements";
    }

    @Override
    public List<WebElement> getWrappedEntity() {
        return getWebDriver().findElements(locator);
    }

}
