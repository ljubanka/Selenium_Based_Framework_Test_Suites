package ua.net.itlabs.core.conditions;

import ua.net.itlabs.core.conditions.element.*;

public class ElementConditions {
    public static ElementCondition text(String expectedText) {
        return new Text(expectedText);
    }

    public static ElementCondition exactText(String expectedText) {
        return new ExactText(expectedText);
    }

    public static ElementCondition cssClass(String cssClass) {
        return new CssClass(cssClass);
    }

    public static ElementCondition present() {
        return new Present();
    }

    public static ElementCondition visible() {
        return new Visible();
    }

    public static ElementCondition enabled() {
        return new Enabled();
    }

}
