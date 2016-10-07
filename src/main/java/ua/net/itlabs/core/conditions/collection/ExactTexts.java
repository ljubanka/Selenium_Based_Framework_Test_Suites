package ua.net.itlabs.core.conditions.collection;

public class ExactTexts extends Texts {
    public ExactTexts(String... expectedTexts) {
        super(expectedTexts);
    }

    @Override
    public boolean checkElement(int index) {
        return actualTexts.get(index).equals(expectedTexts[index]);
    }
}
