package ua.net.itlabs.core.wrappers.element;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.wrappers.LazyElement;

public class LazyElementInnerElement extends AbstractLazyElement {
    private By innerLocator;
    private LazyElement parentElement;

    public LazyElementInnerElement(LazyElement parentElement, By innerLocator) {
        this.parentElement = parentElement;
        this.innerLocator = innerLocator;
    }

    @Override
    public WebElement getWrappedEntity() {
        return parentElement.getWrappedEntity().findElement(innerLocator);
    }

    @Override
    public String toString() {
        return parentElement.toString() + " find(" + innerLocator + ")";
    }
}
