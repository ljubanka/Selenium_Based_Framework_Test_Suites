package ua.net.itlabs.core.elements;

import org.openqa.selenium.WebElement;

public interface LazyElementEntity extends LazyEntity<WebElement> {

    WebElement shouldBe();
    WebElement clear();
    WebElement click();
    WebElement doubleClick();
    WebElement hover();
    WebElement setValue(String text);
    WebElement sendKeys(String text);
    WebElement pressEnter();

}
