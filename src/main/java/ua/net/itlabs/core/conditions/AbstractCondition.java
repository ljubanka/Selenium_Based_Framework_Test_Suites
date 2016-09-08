package ua.net.itlabs.core.conditions;

import ua.net.itlabs.core.wrappers.LazyEntity;

public abstract class AbstractCondition<T> implements Condition<T>, DescribesResult{

    protected LazyEntity entity;
    public abstract T check(T wrappedEntity);


    public T apply(LazyEntity entity) {
        this.entity = entity;
        T result = check((T) entity.getWrappedEntity());
        if (result != null) {
            return result;
        }
        return null;
    }

    public String toString() {
        return String.format(getClass().getSimpleName() +
                "\nfor " + identity() + " from " + entity +
                (expected() == "" ? "" : "\nexpected: " + expected()) +
                (actual() == "" ? "" : "\nactual: " + actual()));
    }

}
