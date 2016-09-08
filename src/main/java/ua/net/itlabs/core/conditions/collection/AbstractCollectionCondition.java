package ua.net.itlabs.core.conditions.collection;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.AbstractCondition;
import ua.net.itlabs.core.conditions.CollectionCondition;
import ua.net.itlabs.core.conditions.DescribesResult;
import ua.net.itlabs.core.wrappers.LazyEntity;

import java.util.List;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;

public abstract class AbstractCollectionCondition extends AbstractCondition<List<WebElement>> implements CollectionCondition {

    protected LazyEntity entity;
    public abstract List<WebElement> check(List<WebElement> wrappedEntity);


//    public List<WebElement> apply(LazyEntity entity) {
//        this.entity = entity;
//        List<WebElement> result = check((List<WebElement>) entity.getWrappedEntity());
//        if (result != null) {
//            return result;
//        }
//        return null;
//    }
//
//    public String toString() {
//        return String.format(getClass().getSimpleName() +
//                "\nfor " + identity() + " from " + entity +
//                (expected() == "" ? "" : "\nexpected: " + expected()) +
//                (actual() == "" ? "" : "\nactual: " + actual()));
//    }

    @Override
    public String identity() {
        return "WebElements";
    }


}
