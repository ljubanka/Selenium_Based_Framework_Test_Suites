package ua.net.itlabs.core.conditions.element;

import org.openqa.selenium.WebElement;

public class Visible extends AbstractElementCondition {
    public boolean isVisible;

    @Override
    public boolean check(WebElement element) {
        isVisible = element.isDisplayed();
        return isVisible;
    }

    @Override
    public String expected() {
        return "true";
    }

    @Override
    public String actual() {
        return String.valueOf(isVisible);
    }

}
