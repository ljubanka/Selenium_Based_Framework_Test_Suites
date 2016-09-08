package ua.net.itlabs.core.conditions.element;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.AbstractCondition;
import ua.net.itlabs.core.conditions.DescribesResult;
import ua.net.itlabs.core.conditions.ElementCondition;
import ua.net.itlabs.core.wrappers.LazyEntity;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;

public abstract class AbstractElementCondition extends AbstractCondition<WebElement> implements ElementCondition {

    protected LazyEntity entity;
    public abstract WebElement check(WebElement wrappedEntity);

//    public WebElement apply(LazyEntity entity) {
//        this.entity = entity;
//        WebElement result = check((WebElement) entity.getWrappedEntity());
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
        return "WebElement";
    }

}
