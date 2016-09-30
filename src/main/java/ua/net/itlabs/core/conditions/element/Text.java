package ua.net.itlabs.core.conditions.element;

import org.openqa.selenium.WebElement;

public class Text extends AbstractElementCondition {
    protected String actualText;
    protected String expectedText;

    public Text(String expectedText) {
        this.expectedText = expectedText;
    }

    @Override
    public boolean check(WebElement element) {
        actualText = element.getText();
        return actualText.contains(expectedText);
    }

    @Override
    public String expected() {
        return expectedText;
    }

    @Override
    public String actual() {
        return actualText;
    }

}
