package ua.net.itlabs.core.conditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.ConciseAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Text extends ElementCondition {
    private String actualText;
    private String expectedText;
    private By locator;
    private WebElement element;

    public Text(String expectedText) {
        this.expectedText = expectedText;
    }

    @Override
    public WebElement apply(By locator) {
        this.locator = locator;
        element = ConciseAPI.getWebDriver().findElement(locator);
        actualText = element.getText();
        if (actualText.contains(expectedText)) {
            return element;
        }
        return null;
    }

    @Override
    public List<String> elementsString() {
        return new ArrayList<String>(Arrays.asList(String.valueOf(element)));
        //it returns smth like [[[FirefoxDriver: firefox on WINDOWS (81663880-5d32-4d91-a3de-c0819dfb2037)] -> css selector: .srg>.g:first-child]],
        // seems not very nice
    }

    @Override
    public String locatorString() {
        return locator.toString().split(" ")[1];
    }

    @Override
    public String resultDescription() {
        return "text";
    }

    @Override
    public String expectedResultString() {
        return expectedText;
    }

    @Override
    public String actualResultString() {
        return actualText;
    }

//    public String toString() {
//        return String.format("text to be \'%s\' while actual text is \'%s\'", expectedText, actualText);
//    }

}
