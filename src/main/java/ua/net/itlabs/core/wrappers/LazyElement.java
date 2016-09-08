package ua.net.itlabs.core.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.Condition;
import ua.net.itlabs.core.conditions.ElementCondition;

public interface LazyElement extends LazyEntity<WebElement>, WebElement {

    LazyElement should(ElementCondition... conditions);
    LazyElement shouldBe(ElementCondition... conditions);
    LazyElement shouldHave(ElementCondition... conditions);
    LazyElement doubleClick();
    LazyElement hover();
    LazyElement setValue(String text);
    LazyElement pressEnter();
    LazyElement pressEscape();
    LazyElement find(By locator);
    LazyElement $(By locator);
    LazyElement $(String cssSelector);

}
