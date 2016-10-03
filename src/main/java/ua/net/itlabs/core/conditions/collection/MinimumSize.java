package ua.net.itlabs.core.conditions.collection;

import org.openqa.selenium.WebElement;
import java.util.List;

public class MinimumSize extends Size {

    public MinimumSize(int expectedSize) {
        super(expectedSize);
    }

    @Override
    public boolean check(List<WebElement> elements) {
        listSize = elements.size();
        return listSize >= expectedSize;
    }

}
