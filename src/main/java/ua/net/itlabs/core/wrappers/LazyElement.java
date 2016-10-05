package ua.net.itlabs.core.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.element.ElementCondition;

public interface LazyElement extends LazyEntity<WebElement>, WebElement {

    //Void clear();
    LazyElement should(ElementCondition... conditions);
    LazyElement shouldBe(ElementCondition... conditions);
    LazyElement shouldHave(ElementCondition... conditions);
    LazyElement doubleClick();
    LazyElement hover();
    LazyElement setValue(String text);
    LazyElement pressEnter();
    LazyElement pressEscape();
    LazyElement pressTab();
    LazyElement find(By locator);
    LazyElement find(String cssSelector);
    LazyElement $(By locator);
    LazyElement $(String cssSelector);
    LazyCollection findAll(By innerLocator);
    LazyCollection findAll(String innerCssSelector);
    boolean is(ElementCondition condition);

}
