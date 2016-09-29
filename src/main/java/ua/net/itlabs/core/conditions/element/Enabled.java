package ua.net.itlabs.core.conditions.element;

import org.openqa.selenium.WebElement;

public class Enabled extends AbstractElementCondition{
    private boolean isEnabled;

    @Override
    public WebElement check(WebElement element) {
        isEnabled = element.isEnabled();
        return isEnabled ?element:null;
    }

    @Override
    public String expected() {
        return "true";
    }

    @Override
    public String actual() {
        return String.valueOf(isEnabled);
    }
}
