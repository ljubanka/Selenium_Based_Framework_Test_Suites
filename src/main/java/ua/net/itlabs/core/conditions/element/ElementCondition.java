package ua.net.itlabs.core.conditions.element;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.AbstractCondition;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;

public abstract class ElementCondition extends AbstractCondition<WebElement> {

    @Override
    public String identity() {
        return "element";
    }

    @Override
    public WebElement getWrappedEntity() {
        return getWebDriver().findElement(locator);
    }

}
