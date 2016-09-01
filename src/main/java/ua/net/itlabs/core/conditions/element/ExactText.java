package ua.net.itlabs.core.conditions.element;

import org.openqa.selenium.WebElement;

public class ExactText extends Text {

    public ExactText(String expectedText) {
        super(expectedText);
    }

    @Override
    public WebElement check(WebElement wrappedEntity) {
        actualText = wrappedEntity.getText();
        if (actualText.equals(expectedText)) {
            return wrappedEntity;
        }
        return null;
    }

}
