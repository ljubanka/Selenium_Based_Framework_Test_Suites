package ua.net.itlabs.core.wrappers.element;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.wrappers.LazyCollection;

public class LazyCollectionNthElement extends AbstractLazyElement {
    private int index;
    private LazyCollection parentCollection;

    public LazyCollectionNthElement(LazyCollection parentCollection, int index) {
        this.parentCollection = parentCollection;
        this.index = index;
    }

    @Override
    public WebElement getWrappedEntity() {
        return parentCollection.getWrappedEntity().get(index);
    }

    @Override
    public String toString() {
        return "parentCollection[" + index + "] = " + getWrappedEntity();
    }
}
