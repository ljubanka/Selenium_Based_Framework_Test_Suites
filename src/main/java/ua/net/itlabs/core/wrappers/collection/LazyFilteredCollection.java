package ua.net.itlabs.core.wrappers.collection;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.ElementCondition;
import ua.net.itlabs.core.wrappers.LazyCollection;
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
        List<WebElement> parentCollectionWebElements = parentCollection.getWrappedEntity();

        for (WebElement element: parentCollectionWebElements) {
            if (condition.check(element)) {
                filteredList.add(element);
            }
        }
        return filteredList;
    }

}
