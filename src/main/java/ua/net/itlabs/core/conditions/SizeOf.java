package ua.net.itlabs.core.conditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.ConciseAPI;
import ua.net.itlabs.core.conditions.Condition;

import java.util.List;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;
import static ua.net.itlabs.core.Helpers.getTexts;

public class SizeOf extends Condition<List<WebElement>> {
    private int listSize;
    private int expectedSize;
    private List<WebElement> elements;

    public SizeOf(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    @Override
    public List<WebElement> apply(By locator) {
        elements = getWebDriver().findElements(locator);
        listSize = elements.size();
        return listSize == expectedSize?elements:null;
    }

    public String toString() {
        return String.format("size of list \n %s \nto be: %s, while actual size is: %s\n", getTexts(elements), expectedSize, listSize);
    }



}
