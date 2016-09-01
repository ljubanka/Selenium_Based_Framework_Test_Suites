package ua.net.itlabs.core.conditions.element;

import org.openqa.selenium.WebElement;

public class Present extends ElementCondition {

    private boolean isPresent;

    @Override
    public WebElement check(WebElement wrappedEntity) {
        isPresent = (wrappedEntity !=null);
        return isPresent? wrappedEntity :null;
    }

    @Override
    public String expected() {
        return "true";
    }

    @Override
    public String actual() {
        return String.valueOf(isPresent);
    }
}
