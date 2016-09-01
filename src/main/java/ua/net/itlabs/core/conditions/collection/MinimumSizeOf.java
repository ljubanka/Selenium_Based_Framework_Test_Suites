package ua.net.itlabs.core.conditions.collection;

import org.openqa.selenium.WebElement;
import java.util.List;

public class MinimumSizeOf extends SizeOf {

    public MinimumSizeOf(int expectedSize) {
        super(expectedSize);
    }

    @Override
    public List<WebElement> check(List<WebElement> wrappedEntity) {
        listSize = wrappedEntity.size();
        return (listSize >= expectedSize)? wrappedEntity :null;
    }

}
