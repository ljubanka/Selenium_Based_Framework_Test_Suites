package ua.net.itlabs.core.conditions.collection;

import org.openqa.selenium.WebElement;
import java.util.List;

public class MinimumSizeOf extends SizeOf {

    public MinimumSizeOf(int expectedSize) {
        super(expectedSize);
    }

    @Override
    public boolean check(List<WebElement> elements) {
        listSize = elements.size();
        return listSize >= expectedSize;
    }

}
