package ua.net.itlabs.core.conditions;


import org.openqa.selenium.WebElement;

import java.util.List;

public class Conditions  {

    public static Condition<List<WebElement>> sizeOf(int expectedSize) {
        return new SizeOf(expectedSize);
    }

    public static Condition<List<WebElement>> minimumSizeOf(int expectedSize) {
        return new MinimumSizeOf(expectedSize);
    }

    public static Condition<WebElement> text(String expectedText) {
        return new Text(expectedText);
    }

    public static Condition<WebElement> visible() {
        return new Visible();
    }
}
