package ua.net.itlabs.core.wrappers.element;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.wrappers.LazyElement;

public class LazyElementInsideElement extends AbstractLazyElement {
    private By locator;
    private LazyElement parentElement;

    public LazyElementInsideElement(LazyElement parentElement, By locator) {
        this.parentElement = parentElement;
        this.locator = locator;
    }

    @Override
    public WebElement getWrappedEntity() {
        return parentElement.getWrappedEntity().findElement(locator);
    }

}
