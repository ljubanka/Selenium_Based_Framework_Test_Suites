package ua.net.itlabs.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SizeOf extends Condition<Boolean>{
    private int listSize;
    private int expectedSize;

    public SizeOf(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    @Override
    public Boolean apply(By locator) {
        List<WebElement> elements;
        elements = ConciseAPI.getWebDriver().findElements(locator);
        listSize = elements.size();
        return listSize == expectedSize;
    }

    public String toString() {
        return String.format("\nsize of list \n to be: %s\n while actual size is: %s\n", expectedSize, listSize);
    }



}
