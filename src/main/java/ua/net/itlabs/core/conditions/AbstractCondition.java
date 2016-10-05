package ua.net.itlabs.core.conditions;

import ua.net.itlabs.core.exceptions.WebDriverAssertionException;
import ua.net.itlabs.core.wrappers.LazyEntity;

public abstract class AbstractCondition<T> implements Condition<T>, DescribesResult{

    public LazyEntity<T> entity;

    public T apply(LazyEntity<T> entity) {
        T wrappedEntity = entity.getWrappedEntity();
        if (check(wrappedEntity)) {
            return wrappedEntity;
        }
            throw new WebDriverAssertionException(this.toString());
    }

    public String toString() {
        return String.format(getClass().getSimpleName() +
                "\nfor " + entity.identity() + " found by " + entity +
                (expected() == "" ? "" : "\nexpected: " + expected()) +
                (actual() == "" ? "" : "\nactual: " + actual()));
    }

}
