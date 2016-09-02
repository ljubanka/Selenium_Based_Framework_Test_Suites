package ua.net.itlabs.core.wrappers;

import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.Condition;

import java.util.List;

public interface LazyCollection extends LazyEntity<List<WebElement>>, Iterable<LazyElement> {
    List<WebElement> shouldHave(Condition<List<WebElement>> condition);

    List<WebElement> shouldHave(Condition<List<WebElement>>... conditions);



}
