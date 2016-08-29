package ua.net.itlabs.core.conditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;
import static ua.net.itlabs.core.Helpers.getTexts;

public class MinimumSizeOf extends CollectionCondition {
    private int listSize;
    private int expectedSize;
    //private List<WebElement> elements;
    //private By locator;

    public MinimumSizeOf(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    @Override
    public List<WebElement> check(List<WebElement> elements) {
//        this.locator = locator;
//        elements = getWrappedEntity();
        listSize = elements.size();
        return (listSize >= expectedSize)?elements:null;
    }

//    public String toString() {
//        return String.format("minimum size of list \n %s \nto be: %s, while actual size is: %s\n", getTexts(elements), expectedSize, listSize);
//    }

    @Override
    public List<String> elementsString() {
        return getTexts(getWrappedEntity());
    }

    @Override
    public String resultDescription() {
        return "minimum size";
    }

    @Override
    public String expectedResultString() {
        return String.valueOf(expectedSize);
    }

    @Override
    public String actualResultString() {
        return String.valueOf(listSize);
    }


}
