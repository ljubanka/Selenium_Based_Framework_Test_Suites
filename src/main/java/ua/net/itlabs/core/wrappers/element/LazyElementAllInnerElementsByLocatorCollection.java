package ua.net.itlabs.core.wrappers.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.wrappers.LazyElement;
import ua.net.itlabs.core.wrappers.collection.AbstractLazyCollection;

import java.util.List;

public class LazyElementAllInnerElementsByLocatorCollection extends AbstractLazyCollection {
    private LazyElement parentElement;
    private By innerLocator;

    public LazyElementAllInnerElementsByLocatorCollection(LazyElement parentElement, By innerLocator) {
        this.parentElement = parentElement;
        this.innerLocator = innerLocator;
    }

    @Override
    public List<WebElement> getWrappedEntity() {
        return parentElement.getWrappedEntity().findElements(innerLocator);
    }

    @Override
    public String toString() {
        return parentElement.toString() + "find(" + innerLocator +")";
    }
}
