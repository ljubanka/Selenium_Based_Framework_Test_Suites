package ua.net.itlabs.core.conditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.ConciseAPI;
import ua.net.itlabs.core.conditions.Condition;

//public class Text extends ElementCondition {
//    private String actualText;
//    private String expectedText;
//
//    public Text(String expectedText) {
//        this.expectedText = expectedText;
//    }
//
//    @Override
//    public WebElement apply(By locator) {
//        WebElement element = ConciseAPI.getWebDriver().findElement(locator);
//        actualText = element.getText();
//        if (actualText.contains(expectedText)) {
//            return element;
//        }
//        return null;
//    }
//
//    public String toString() {
//        return String.format("text to be \'%s\' while actual text is \'%s\'", expectedText, actualText);
//    }
//
//}
