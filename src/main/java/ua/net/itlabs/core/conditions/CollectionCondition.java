package ua.net.itlabs.core.conditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;

public abstract class CollectionCondition extends AbstractCondition<List<WebElement>> {

    //protected List<WebElement> elements;

    @Override
    public String elementOrElements() {
        return "elements";
    }

    @Override
    public List<WebElement> getWrappedEntity() {
        return getWebDriver().findElements(locator);
    }



}
