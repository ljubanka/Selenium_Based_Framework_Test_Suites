package ua.net.itlabs.core.wrappers.collection;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.CollectionCondition;
import ua.net.itlabs.core.wrappers.LazyCollection;
import ua.net.itlabs.core.wrappers.LazyElement;
import ua.net.itlabs.core.wrappers.element.LazyCollectionNthElement;
import ua.net.itlabs.core.wrappers.element.LazyWrappedWebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static ua.net.itlabs.core.WaitFor.waitFor;

public abstract class AbstractLazyCollection implements LazyCollection{

    @Override
    public Iterator<LazyElement> iterator() {
        List<LazyElement> list = new ArrayList<>();
        for (WebElement element: getWrappedEntity()) {
            list.add(new LazyWrappedWebElement(this, element));
        }
        return list.iterator();
    }

    @Override
    public LazyCollection should(CollectionCondition... conditions) {
        waitFor(this).until(conditions);
        return this;
    }

    @Override
    public LazyCollection shouldBe(CollectionCondition... conditions) {
        should(conditions);
        return this;
    }

    @Override
    public LazyCollection shouldHave(CollectionCondition... conditions) {
        should(conditions);
        return this;
    }

    @Override
    public int size() {
        return this.getWrappedEntity().size();
    }

    @Override
    public boolean isEmpty() {
        return this.getWrappedEntity().isEmpty();
    }

    @Override
    public String[] getTexts() {
        List<WebElement> elements = this.getWrappedEntity();
        String[] result = new String[elements.size()];
        for (int i=0; i<elements.size(); i++) {
            result[i] = elements.get(i).getText();
        }
        return result;
    }

    @Override
    public LazyElement get(int index) {
        return new LazyCollectionNthElement(this, index);
    }
}
