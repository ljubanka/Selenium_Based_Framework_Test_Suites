package ua.net.itlabs.core.conditions.collection;

import org.openqa.selenium.WebElement;
import java.util.List;

public class SizeOf extends CollectionCondition {
    protected int listSize;
    protected int expectedSize;

    public SizeOf(int expectedSize) {
        this.expectedSize = expectedSize;
    }

    @Override
    public List<WebElement> check(List<WebElement> wrappedEntity) {
        listSize = wrappedEntity.size();
        return listSize == expectedSize? wrappedEntity :null;
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
