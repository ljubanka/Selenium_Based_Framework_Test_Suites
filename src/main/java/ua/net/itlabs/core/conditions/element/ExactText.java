package ua.net.itlabs.core.conditions.element;

import org.openqa.selenium.WebElement;

public class ExactText extends Text {
    //private String actualText;
    //private String expectedText;

    public ExactText(String expectedText) {
        //this.expectedText = expectedText;
        super(expectedText);
    }

    @Override
    public WebElement checkElement(WebElement element) {
        actualText = element.getText();
        if (actualText.equals(expectedText)) {
            return element;
        }
        return null;
    }
//    @Override
//    public WebElement check(WebElement element) {
//        actualText = element.getText();
//        if (actualText.equals(expectedText)) {
//            return element;
//        }
//        return null;
//    }
//
//    @Override
//    public String expected() {
//        return expectedText;
//    }
//
//    @Override
//    public String actual() {
//        return actualText;
//    }

}
