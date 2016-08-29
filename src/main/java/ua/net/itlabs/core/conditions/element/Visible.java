package ua.net.itlabs.core.conditions.element;

import org.openqa.selenium.WebElement;

public class Visible extends ElementCondition {
    private boolean isVisible;

    @Override
    public WebElement check(WebElement element) {
        isVisible = element.isDisplayed();
        return isVisible?element:null;
    }

    @Override
    public String expected() {
        return "visible (true)";
    }

    @Override
    public String actual() {
        return String.valueOf(isVisible);
    }

}
