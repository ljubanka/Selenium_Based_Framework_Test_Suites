package ua.net.itlabs.core.wrappers.element;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.wrappers.collection.AbstractLazyCollection;

public class LazyNthElement extends AbstractLazyElement {
     private int index;
    private AbstractLazyCollection parentCollection;

    public LazyNthElement(AbstractLazyCollection parentCollection, int index) {
        this.parentCollection = parentCollection;
        this.index = index;
    }

    @Override
    public WebElement getWrappedEntity() {
        return parentCollection.getWrappedEntity().get(index);
    }
}
