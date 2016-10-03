package ua.net.itlabs.core.wrappers.element;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.wrappers.LazyEntity;

public class LazyWrappedWebElement extends AbstractLazyElement{

    private WebElement element;
    private LazyEntity parentEntity;

    public LazyWrappedWebElement(LazyEntity parentEntity, WebElement element) {
        this.element = element;
        this.parentEntity = parentEntity;
    }

    @Override
    public WebElement fetchWrappedEntity() {
        return element;
    }

    @Override
    public String toString() {
        return "WebElement " + element + " from " + parentEntity;
    }

}
