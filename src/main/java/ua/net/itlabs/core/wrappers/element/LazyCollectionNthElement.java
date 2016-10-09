package ua.net.itlabs.core.wrappers.element;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.exceptions.LazyCollectionIndexOutOfBoundsException;
import ua.net.itlabs.core.wrappers.LazyCollection;

public class LazyCollectionNthElement extends AbstractLazyElement {
    private int index;
    private LazyCollection parentCollection;

    public LazyCollectionNthElement(LazyCollection parentCollection, int index) {
        this.parentCollection = parentCollection;
        this.index = index;
    }

    @Override
    public WebElement fetchWrappedEntity() {
        try {
            return parentCollection.getWrappedEntity().get(index);
        }
        catch (IndexOutOfBoundsException e) {
            throw new LazyCollectionIndexOutOfBoundsException(this.toString());
        }
    }

    @Override
    public String toString() {
        return parentCollection.toString() + "[" + index + "]";
    }

}
