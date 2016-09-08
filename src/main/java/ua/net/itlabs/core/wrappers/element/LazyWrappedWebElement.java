package ua.net.itlabs.core.wrappers.element;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.wrappers.LazyElement;
import ua.net.itlabs.core.wrappers.LazyEntity;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;

public class LazyWrappedWebElement extends AbstractLazyElement{

    private WebElement element;
    private LazyEntity parentEntity;

    public LazyWrappedWebElement(LazyEntity parentEntity, WebElement element) {
        this.element = element;
        this.parentEntity = parentEntity;
    }

    @Override
    public WebElement getWrappedEntity() {
        return element;
    }

    @Override
    public String toString() {
        return "WebElement " + element + " from " + parentEntity;
    }

}
