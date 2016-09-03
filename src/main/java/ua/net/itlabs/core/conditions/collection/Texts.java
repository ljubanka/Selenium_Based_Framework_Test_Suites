package ua.net.itlabs.core.conditions.collection;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import ua.net.itlabs.core.Helpers;

import java.util.List;

public class Texts extends AbstractCollectionCondition {
    protected List<String> actualTexts;
    protected String[] expectedTexts;

    public Texts(String... expectedTexts) {
        this.expectedTexts = expectedTexts;
    }

    @Override
    public List<WebElement> check(List<WebElement> elements) {
        actualTexts = Helpers.getTexts(elements);
        if (actualTexts.size() != expectedTexts.length) {
            return null;
        }
        for (int i = 0; i < actualTexts.size(); i++) {
            if (!checkElement(i)) {
                return null;
            }
        }
        return elements;
    }

    public boolean checkElement(int index) {
        return actualTexts.get(index).contains(expectedTexts[index]);
    }

    @Override
    public String expected() {
        return StringUtils.join(expectedTexts, ", ");
    }

    @Override
    public String actual() {
        return actualTexts.toString();
    }

}
