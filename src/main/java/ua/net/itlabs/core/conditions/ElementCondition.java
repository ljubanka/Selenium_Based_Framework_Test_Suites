package ua.net.itlabs.core.conditions;

import org.openqa.selenium.WebElement;

public abstract class ElementCondition extends AbstractCondition<WebElement> {
    @Override
    public String elementOrElements() {
        return "element";
    }
}
