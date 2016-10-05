package ua.net.itlabs.core.conditions.element;

import org.openqa.selenium.WebElement;

public class Present extends AbstractElementCondition {

    public boolean isPresent;

    @Override
    public boolean check(WebElement element) {
        isPresent = (element !=null);
        return isPresent;
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
