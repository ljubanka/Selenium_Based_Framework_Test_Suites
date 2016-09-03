package ua.net.itlabs.core.wrappers.collection;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.Helpers;
import ua.net.itlabs.core.conditions.CollectionCondition;
import ua.net.itlabs.core.conditions.CollectionConditions;
import ua.net.itlabs.core.conditions.Condition;
import ua.net.itlabs.core.wrappers.LazyCollection;
import ua.net.itlabs.core.wrappers.LazyElement;
import ua.net.itlabs.core.wrappers.element.LazyNthElement;
import ua.net.itlabs.core.wrappers.element.LazyWrappedWebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static ua.net.itlabs.core.WaitFor.waitFor;
import static ua.net.itlabs.core.conditions.CollectionConditions.minimumSizeOf;
import static ua.net.itlabs.core.conditions.ElementConditions.visible;

public abstract class AbstractLazyCollection implements LazyCollection{

    @Override
    public Iterator<LazyElement> iterator() {
        List<LazyElement> list = new ArrayList<>();
        for (WebElement element: getWrappedEntity()) {
            list.add(new LazyWrappedWebElement(element));
        }
        return list.iterator();
    }

//    @Override
//    public List<WebElement> shouldHave(CollectionCondition condition) {
//        return waitFor(this).until(condition);
//    }

    @Override
    public LazyCollection should(CollectionCondition... conditions) {
        waitFor(this).until(conditions);
        return this;
    }

    @Override
    public LazyCollection shouldBe(CollectionCondition... conditions) {
        waitFor(this).until(conditions);
        return this;
    }

    @Override
    public LazyCollection shouldHave(CollectionCondition... conditions) {

//        List<WebElement> result = null;
//        for (CollectionCondition condition: conditions) {
//            result = shouldHave(condition);
//            if (result == null) {
//                return null;
//            }
//        }
        //return result;
        waitFor(this).until(conditions);
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
        String[] result = new String[this.size()];
        for (int i=0; i<this.size(); i++) {
            result[i] = this.get(i).getText();
        }
        return result;
    }

    @Override
    public LazyElement get(int index) {
        return new LazyNthElement(this, index);
//        List<WebElement> elements = waitFor(this).until(minimumSizeOf(index+1));
//        WebElement element = elements.get(index);
//        //waitFor(this).until(minimumSizeOf(index+1)).get(index);
//        return new LazyWrappedWebElement(element);

    }
}
