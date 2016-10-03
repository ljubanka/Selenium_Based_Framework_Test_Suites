package ua.net.itlabs.core.conditions.collection;

import org.openqa.selenium.WebElement;
import java.util.List;

public class Size extends AbstractCollectionCondition {
    public int listSize;
    public int expectedSize;

    public Size(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    @Override
    public boolean check(List<WebElement> elements) {
        listSize = elements.size();
        return listSize == expectedSize;
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
