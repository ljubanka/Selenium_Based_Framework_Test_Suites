package ua.net.itlabs.core.wrappers.collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.CollectionCondition;
import ua.net.itlabs.core.conditions.ElementCondition;
import ua.net.itlabs.core.wrappers.LazyCollection;
import ua.net.itlabs.core.wrappers.LazyElement;

import java.util.ArrayList;
import java.util.List;

public class LazyFilteredCollection extends AbstractLazyCollection {
    private ElementCondition condition;
    private LazyCollection parentCollection;

    public LazyFilteredCollection(LazyCollection parentCollection, ElementCondition condition) {
        this.condition = condition;
        this.parentCollection = parentCollection;
    }

    @Override
    public String toString() {
        return parentCollection.toString() + " filter(" + condition.getClass().getSimpleName() + ")";
    }

    @Override
    public List<WebElement> getWrappedEntity() {
        List<WebElement> filteredList = new ArrayList<WebElement>();

        for (LazyElement lazyElement: parentCollection) {
            if (lazyElement.is(condition)) {
                filteredList.add(lazyElement.getWrappedEntity());
            }
        }
        return filteredList;
    }
}
