package ua.net.itlabs.core.conditions;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.collection.*;

import java.util.List;

public class CollectionConditions {

    public static CollectionCondition sizeOf(int expectedSize) {
        return new SizeOf(expectedSize);
    }

    public static CollectionCondition minimumSizeOf(int expectedSize) {
        return new MinimumSizeOf(expectedSize);
    }

    public static CollectionCondition texts(String... expectedTexts) {
        return new Texts(expectedTexts);
    }

    public static CollectionCondition exactTexts(String... expectedTexts) {
        return new ExactTexts(expectedTexts);
    }

    public static CollectionCondition nthElementText(int index, String expectedText) {
        return new NthElementText(index, expectedText);
    }

}
