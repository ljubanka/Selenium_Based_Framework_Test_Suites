package ua.net.itlabs.core.conditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ua.net.itlabs.core.ConciseAPI.getWebDriver;

public class Visible extends Condition<WebElement> {
    private WebElement element;

    @Override
    public WebElement apply(By locator) {
        element = getWebDriver().findElement(locator);
        return element.isDisplayed()?element:null;
    }


}
