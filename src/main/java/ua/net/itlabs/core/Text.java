package ua.net.itlabs.core;

import org.openqa.selenium.By;

public class Text extends Condition<Boolean>{
    private String actualText;
    private String expectedText;

    public Text(String expectedText) {
        this.expectedText = expectedText;
    }

    @Override
    public Boolean apply(By locator) {

        actualText = ConciseAPI.getWebDriver().findElement(locator).getText();
        return Boolean.valueOf(actualText.contains(expectedText));
    }

    public String toString() {
        return String.format("text to be (\'%s\') while actual text is %s", expectedText, actualText);
    }

}
