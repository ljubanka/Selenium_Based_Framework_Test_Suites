package ua.net.itlabs.core.conditions.collection;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.Helpers;

import java.util.List;

public class ListNthElementHasText extends CollectionCondition {
    private List<String> actualTexts;
    private String expectedText;
    private int index;

    public ListNthElementHasText(int index, String expectedText) {
        this.index = index;
        this.expectedText = expectedText;
    }

    @Override
    public List<WebElement> check(List<WebElement> elements) {
        actualTexts = Helpers.getTexts(elements);
        if (actualTexts.get(index).contains(expectedText)) {
            return elements;
        }
        return null;
    }

    @Override
    public String expected() {
        return ("element #" + index + " = " + expectedText);
    }

    @Override
    public String actual() {
        return actualTexts.toString();
    }
}
