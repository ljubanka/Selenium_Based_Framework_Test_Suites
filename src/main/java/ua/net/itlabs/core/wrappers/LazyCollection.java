package ua.net.itlabs.core.wrappers;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.CollectionCondition;
import ua.net.itlabs.core.conditions.Condition;

import java.util.List;

public interface LazyCollection extends LazyEntity<List<WebElement>>, Iterable<LazyElement> {
    //List<WebElement> shouldHave(CollectionCondition condition);
    LazyCollection should(CollectionCondition... conditions);
    LazyCollection shouldHave(CollectionCondition... conditions);
    LazyCollection shouldBe(CollectionCondition... conditions);
    LazyElement get(int index);
    int size();
    boolean isEmpty();
    String[] getTexts();




}
