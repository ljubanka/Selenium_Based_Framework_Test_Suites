package ua.net.itlabs.core.conditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class CollectionCondition extends AbstractCondition<List<WebElement>> {

    @Override
    public String elementOrElements() {
        return "elements";
    }


}
