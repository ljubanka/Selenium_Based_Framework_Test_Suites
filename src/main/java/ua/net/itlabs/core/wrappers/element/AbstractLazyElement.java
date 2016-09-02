package ua.net.itlabs.core.wrappers.element;

import org.openqa.selenium.*;
import ua.net.itlabs.core.conditions.Condition;
import ua.net.itlabs.core.wrappers.LazyElement;

import java.util.List;

import static ua.net.itlabs.core.WaitFor.waitFor;
import static ua.net.itlabs.core.conditions.ElementConditions.present;
import static ua.net.itlabs.core.conditions.ElementConditions.visible;

public abstract class AbstractLazyElement implements LazyElement{

    @Override
    public LazyElement shouldBe(Condition<WebElement> condition) {
        waitFor(this).until(condition);
        return this;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        WebElement element = waitFor(this).until(visible());
        return element.getScreenshotAs(outputType);
    }

    @Override
    public void click() {
        WebElement element = waitFor(this).until(visible());
        element.click();
    }

    @Override
    public void submit() {
        WebElement element = waitFor(this).until(present());
        element.submit();
    }

    @Override
    public LazyElement doubleClick() {
        return null;
    }

    @Override
    public LazyElement hover() {
        return null;
    }

    @Override
    public LazyElement setValue(String text) {
        WebElement element = waitFor(this).until(visible());
        element.clear();
        element.sendKeys(text + Keys.ENTER);
        return this;
    }

    @Override
    public void clear() {
        waitFor(this).until(visible()).clear();
    }

    @Override
    public String getTagName() {
        WebElement element = waitFor(this).until(present());
        return element.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        WebElement element = waitFor(this).until(present());
        return element.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        WebElement element = waitFor(this).until(visible());
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        WebElement element = waitFor(this).until(visible());
        return element.isEnabled();
    }

    @Override
    public String getText() {
        WebElement element = waitFor(this).until(visible());
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        WebElement element = waitFor(this).until(present());
        return element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        WebElement element = waitFor(this).until(present());
        return element.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        WebElement element = waitFor(this).until(present());
        return element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        WebElement element = waitFor(this).until(present());
        return element.getLocation();
    }

    @Override
    public Dimension getSize() {
        WebElement element = waitFor(this).until(present());
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        WebElement element = waitFor(this).until(present());
        return element.getRect();
    }

    @Override
    public String getCssValue(String s) {
        WebElement element = waitFor(this).until(present());
        return element.getCssValue(s);
    }

    @Override
    public void sendKeys(CharSequence... var1) {
        WebElement element = waitFor(this).until(visible());
        element.clear();
        element.sendKeys(var1);
    }

    @Override
    public LazyElement pressEnter() {
        WebElement element = waitFor(this).until(visible());
        element.sendKeys(Keys.ENTER);
        return this;
    }
}
