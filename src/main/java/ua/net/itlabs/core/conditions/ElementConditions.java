package ua.net.itlabs.core.conditions;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.element.ExactText;
import ua.net.itlabs.core.conditions.element.Text;
import ua.net.itlabs.core.conditions.element.Visible;

public class ElementConditions {
    public static Condition<WebElement> text(String expectedText) {
        return new Text(expectedText);
    }

    public static Condition<WebElement> exactText(String expectedText) {
        return new ExactText(expectedText);
    }

    public static Condition<WebElement> visible() {
        return new Visible();
    }
}
