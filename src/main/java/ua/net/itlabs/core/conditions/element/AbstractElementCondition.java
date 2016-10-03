package ua.net.itlabs.core.conditions.element;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.AbstractCondition;

public abstract class AbstractElementCondition extends AbstractCondition<WebElement> implements ElementCondition {

    public abstract boolean check(WebElement wrappedEntity);

    @Override
    public String identity() {
        return "element";
    }

}
