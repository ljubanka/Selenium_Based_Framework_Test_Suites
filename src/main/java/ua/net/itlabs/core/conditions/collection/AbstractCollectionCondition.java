package ua.net.itlabs.core.conditions.collection;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.AbstractCondition;
import ua.net.itlabs.core.wrappers.LazyEntity;

import java.util.List;

public abstract class AbstractCollectionCondition extends AbstractCondition<List<WebElement>> implements CollectionCondition {

    public LazyEntity entity;
    public abstract boolean check(List<WebElement> wrappedEntity);

    @Override
    public String identity() {
        return "collection";
    }


}
