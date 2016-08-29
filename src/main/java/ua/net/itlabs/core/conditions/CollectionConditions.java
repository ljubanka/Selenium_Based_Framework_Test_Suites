package ua.net.itlabs.core.conditions;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.collection.ListNthElementHasText;
import ua.net.itlabs.core.conditions.collection.MinimumSizeOf;
import ua.net.itlabs.core.conditions.collection.SizeOf;
import ua.net.itlabs.core.conditions.collection.Texts;

import java.util.List;

public class CollectionConditions {

    public static Condition<List<WebElement>> sizeOf(int expectedSize) {
        return new SizeOf(expectedSize);
    }

    public static Condition<List<WebElement>> minimumSizeOf(int expectedSize) {
        return new MinimumSizeOf(expectedSize);
    }

    public static Condition<List<WebElement>> texts(String... expectedTexts) {
        return new Texts(expectedTexts);
    }

    public static Condition<List<WebElement>> listNthElementHasText(int index, String expectedText) {
        return new ListNthElementHasText(index, expectedText);
    }

}
