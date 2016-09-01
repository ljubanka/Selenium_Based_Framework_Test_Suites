package ua.net.itlabs.core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.conditions.Condition;

import java.util.List;

public interface LazyCollectionEntity extends LazyEntity<List<WebElement>> {
    List<WebElement> shouldHave(Condition<List<WebElement>> condition);



}
