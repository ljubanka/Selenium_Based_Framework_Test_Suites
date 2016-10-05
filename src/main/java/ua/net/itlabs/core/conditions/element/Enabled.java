package ua.net.itlabs.core.conditions.element;

import org.openqa.selenium.WebElement;

public class Enabled extends AbstractElementCondition{
    public boolean isEnabled;

    @Override
    public boolean check(WebElement element) {
        isEnabled = element.isEnabled();
        return isEnabled;
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
