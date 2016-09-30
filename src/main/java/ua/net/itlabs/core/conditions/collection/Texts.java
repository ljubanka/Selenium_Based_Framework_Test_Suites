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
    public boolean check(List<WebElement> elements) {
        actualTexts = Helpers.getTexts(elements);
        if (actualTexts.size() != expectedTexts.length) {
            return false;
        }
        for (int i = 0; i < actualTexts.size(); i++) {
            if (!checkElement(i)) {
                return false;
            }
        }
        return true;
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
