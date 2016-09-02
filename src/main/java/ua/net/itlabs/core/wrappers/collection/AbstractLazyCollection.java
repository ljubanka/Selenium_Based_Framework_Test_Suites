package ua.net.itlabs.core.wrappers.collection;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.Condition;
import ua.net.itlabs.core.wrappers.LazyCollection;
import ua.net.itlabs.core.wrappers.LazyElement;
import ua.net.itlabs.core.wrappers.element.LazyWrappedWebElement;

import java.util.Iterator;
import java.util.List;

import static ua.net.itlabs.core.WaitFor.waitFor;

public abstract class AbstractLazyCollection implements LazyCollection{

    @Override
    public Iterator<LazyElement> iterator() {
        List<LazyElement> list = null;
        for (WebElement element: getWrappedEntity()) {
            list.add(new LazyWrappedWebElement(element));
        }
        return list.iterator();
    }

    @Override
    public List<WebElement> shouldHave(Condition<List<WebElement>> condition) {
        return waitFor(this).until(condition);
    }

    @Override
    public List<WebElement> shouldHave(Condition<List<WebElement>>... conditions) {
        List<WebElement> result = null;
        for (Condition<List<WebElement>> condition: conditions) {
            result = shouldHave(condition);
            if (result == null) {
                return null;
            }
        }
        return result;
    }
}
