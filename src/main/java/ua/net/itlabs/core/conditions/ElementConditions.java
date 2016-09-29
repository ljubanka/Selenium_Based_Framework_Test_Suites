package ua.net.itlabs.core.conditions;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.element.*;

public class ElementConditions {
    public static final ElementCondition visible = new Visible();
    public static final ElementCondition present = new Present();
    public static final ElementCondition enabled = new Enabled();

    public static ElementCondition text(String expectedText) {
        return new Text(expectedText);
    }

    public static ElementCondition exactText(String expectedText) {
        return new ExactText(expectedText);
    }

//    public static ElementCondition present() {
//        return new Present();
//    }
//
//    public static ElementCondition visible() {
//        return new Visible();
//    }

}
