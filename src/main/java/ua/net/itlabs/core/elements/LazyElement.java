package ua.net.itlabs.core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;
import static ua.net.itlabs.core.WaitFor.waitFor;
import static ua.net.itlabs.core.conditions.ElementConditions.visible;

public class LazyElement implements LazyElementEntity {
    private By locator;

    @Override
    public WebElement getWrappedEntity() {
        return getWebDriver().findElement(locator);
    }

    public LazyElement(By locator) {
        this.locator = locator;
    }

    @Override
    public WebElement shouldBe() {
        return null;
    }

    @Override
    public WebElement click() {
        WebElement element;
        element = waitFor(this).until(visible());
        element.click();
        return element;
    }

    @Override
    public WebElement doubleClick() {
        return null;
    }

    @Override
    public WebElement hover() {
        return null;
    }

    @Override
    public WebElement setValue(String text) {
        WebElement element;
        element = waitFor(this).until(visible());
        element.clear();
        element.sendKeys(text + Keys.ENTER);
        return element;
    }

    @Override
    public WebElement clear() {
        WebElement element;
        element = waitFor(this).until(visible());
        element.clear();
        return element;
    }

    @Override
    public WebElement sendKeys(String text) {
        WebElement element;
        element = waitFor(this).until(visible());
        element.clear();
        element.sendKeys(text);
        return element;
    }

    @Override
    public WebElement pressEnter() {
        WebElement element;
        element = waitFor(this).until(visible());
        element.sendKeys(Keys.ENTER);
        return element;
    }
}
