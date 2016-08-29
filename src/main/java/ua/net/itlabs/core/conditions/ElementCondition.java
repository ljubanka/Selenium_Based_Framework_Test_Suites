package ua.net.itlabs.core.conditions;

import org.openqa.selenium.WebElement;

import java.util.List;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;

public abstract class ElementCondition extends AbstractCondition<WebElement> {
    //protected WebElement element;

    @Override
    public String elementOrElements() {
        return "element";
    }

    @Override
    public WebElement getWrappedEntity() {
        return getWebDriver().findElement(locator);
    }

}
