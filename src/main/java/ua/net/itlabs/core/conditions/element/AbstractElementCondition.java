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

    @Override
    public String identity() {
        return "element";
    }

}
