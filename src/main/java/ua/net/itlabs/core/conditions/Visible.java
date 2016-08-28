package ua.net.itlabs.core.conditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;

public class Visible extends ElementCondition {
    private WebElement element;
    private By locator;

    @Override
    public WebElement apply(By locator) {
        element = getWebDriver().findElement(locator);
        return element.isDisplayed()?element:null;
    }

    @Override
    public List<String> elementsString() {
        return new ArrayList<String>(Arrays.asList(String.valueOf(element)));
    }

    @Override
    public String locatorString() {
        return locator.toString().split(" ")[1];
    }

    @Override
    public String resultDescription() {
        return "visibility state";
    }

    @Override
    public String expectedResultString() {
        return "visible (true)";
    }

    @Override
    public String actualResultString() {
        return String.valueOf(element.isDisplayed());
    }

}
