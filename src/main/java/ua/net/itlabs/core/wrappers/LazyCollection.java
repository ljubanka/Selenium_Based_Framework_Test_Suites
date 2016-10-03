package ua.net.itlabs.core.wrappers;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.collection.CollectionCondition;
import ua.net.itlabs.core.conditions.element.ElementCondition;

import java.util.List;

public interface LazyCollection extends LazyEntity<List<WebElement>>, Iterable<LazyElement> {
    LazyCollection should(CollectionCondition... conditions);
    LazyCollection shouldHave(CollectionCondition... conditions);
    LazyCollection shouldBe(CollectionCondition... conditions);
    LazyCollection shouldHaveSize(int expectedSize);
    LazyElement get(int index);
    LazyCollection filter(ElementCondition condition);
    LazyElement find(ElementCondition condition);
    int size();
    boolean isEmpty();
    String[] getTexts();




}
