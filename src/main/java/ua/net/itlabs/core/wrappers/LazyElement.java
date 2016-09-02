package ua.net.itlabs.core.wrappers;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.Condition;

public interface LazyElement extends LazyEntity<WebElement>, WebElement {

    LazyElement shouldBe(Condition<WebElement> condition);
    //WebElement clear();
    //WebElement click();
    LazyElement doubleClick();
    LazyElement hover();
    LazyElement setValue(String text);
    //WebElement sendKeys(String text);
    LazyElement pressEnter();

}
