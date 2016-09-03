package ua.net.itlabs.core.wrappers.element;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.wrappers.LazyElement;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;

public class LazyWrappedWebElement extends AbstractLazyElement{

    private WebElement element;
    private LazyElement parentEntity;

    public LazyWrappedWebElement(WebElement element) {
        this.element = element;
        //this.parentEntity = parentEntity;
    }

    @Override
    public WebElement getWrappedEntity() {
        return element;
    }

}
