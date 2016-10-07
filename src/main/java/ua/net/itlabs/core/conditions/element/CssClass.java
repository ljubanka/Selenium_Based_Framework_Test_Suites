package ua.net.itlabs.core.conditions.element;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class CssClass extends AbstractElementCondition {
    public String expectedCssClass;
    public String actualCssClass;

    public CssClass(String expectedCssClass) {
        this.expectedCssClass = expectedCssClass;
    }

    @Override
    public boolean check(WebElement wrappedEntity) {
        actualCssClass = wrappedEntity.getAttribute("class");
        String[] classesList = StringUtils.split(actualCssClass, " ");
        if (Arrays.asList(classesList).contains(expectedCssClass)) {
            return true;
        }
        return false;
    }

    @Override
    public String expected() {
        return expectedCssClass;
    }

    @Override
    public String actual() {
        return actualCssClass;
    }

}
