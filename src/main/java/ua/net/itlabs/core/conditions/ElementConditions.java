package ua.net.itlabs.core.conditions;

import org.openqa.selenium.WebElement;

public class ElementConditions {
    public static Condition<WebElement> text(String expectedText) {
        return new Text(expectedText);
    }

    public static Condition<WebElement> visible() {
        return new Visible();
    }
}
