package ua.net.itlabs.core.conditions.collection;

import org.openqa.selenium.WebElement;
import java.util.List;

public class MinimumSizeOf extends CollectionCondition {
    private int listSize;
    private int expectedSize;

    public MinimumSizeOf(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    @Override
    public List<WebElement> check(List<WebElement> elements) {
        listSize = elements.size();
        return (listSize >= expectedSize)?elements:null;
    }

    @Override
    public String expected() {
        return String.valueOf(expectedSize);
    }

    @Override
    public String actual() {
        return String.valueOf(listSize);
    }

}