package ua.net.itlabs.core.wrappers.element;

import org.openqa.selenium.WebElement;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;

public class LazyWrappedWebElement extends AbstractLazyElement{

    private WebElement element;
    public LazyWrappedWebElement(WebElement element) {
        this.element = element;
    }

    @Override
    public WebElement getWrappedEntity() {
        return element;
    }

}
