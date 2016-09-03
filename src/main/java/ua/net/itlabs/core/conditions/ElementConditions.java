package ua.net.itlabs.core.conditions;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.element.ExactText;
import ua.net.itlabs.core.conditions.element.Present;
import ua.net.itlabs.core.conditions.element.Text;
import ua.net.itlabs.core.conditions.element.Visible;

public class ElementConditions {
    public static ElementCondition text(String expectedText) {
        return new Text(expectedText);
    }

    public static ElementCondition exactText(String expectedText) {
        return new ExactText(expectedText);
    }

    public static ElementCondition present() {
        return new Present();
    }

    public static ElementCondition visible() {
        return new Visible();
    }

}
