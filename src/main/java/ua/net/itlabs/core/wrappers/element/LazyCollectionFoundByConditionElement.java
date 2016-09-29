package ua.net.itlabs.core.wrappers.element;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.ElementCondition;
import ua.net.itlabs.core.wrappers.LazyCollection;
import ua.net.itlabs.core.wrappers.LazyElement;

public class LazyCollectionFoundByConditionElement extends AbstractLazyElement{
    private LazyCollection parentCollection;
    private ElementCondition condition;

    public LazyCollectionFoundByConditionElement(LazyCollection parentCollection, ElementCondition condition) {
        this.condition = condition;
        this.parentCollection = parentCollection;
    }

    @Override
    public WebElement fetchWrappedEntity() {
        for (LazyElement lazyElement: parentCollection) {
            if (lazyElement.is(condition)) {
                return lazyElement.getWrappedEntity();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return parentCollection.toString() + " find(" + condition.getClass().getSimpleName() + ")";
    }

}
