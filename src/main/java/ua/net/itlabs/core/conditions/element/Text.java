package ua.net.itlabs.core.conditions.element;

import org.openqa.selenium.WebElement;

public class Text extends ElementCondition {
    protected String actualText;
    protected String expectedText;

    public Text(String expectedText) {
        this.expectedText = expectedText;
    }

    @Override
    public WebElement check(WebElement wrappedEntity) {
        actualText = wrappedEntity.getText();
        if (actualText.contains(expectedText)) {
            return wrappedEntity;
        }
        return null;
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
