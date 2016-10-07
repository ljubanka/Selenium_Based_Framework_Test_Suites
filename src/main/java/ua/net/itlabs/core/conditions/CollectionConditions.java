package ua.net.itlabs.core.conditions;

import ua.net.itlabs.core.conditions.collection.*;

public class CollectionConditions {
    public static CollectionCondition size(int expectedSize) {
        return new Size(expectedSize);
    }

    public static CollectionCondition minimumSize(int expectedSize) {
        return new MinimumSize(expectedSize);
    }

    public static CollectionCondition texts(String... expectedTexts) {
        return new Texts(expectedTexts);
    }

    public static CollectionCondition exactTexts(String... expectedTexts) {
        return new ExactTexts(expectedTexts);
    }

}
