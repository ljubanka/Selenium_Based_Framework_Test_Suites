package ua.net.itlabs.core.conditions;

import ua.net.itlabs.core.wrappers.LazyEntity;

public abstract class AbstractCondition<V> implements Condition<V>, DescribesResult{

    protected LazyEntity entity;
    public abstract V check(V wrappedEntity);


    public V apply(LazyEntity entity) {
        this.entity = entity;
        V result = check((V) entity.getWrappedEntity());
        if (result != null) {
            return result;
        }
        return null;
    }

    public String toString() {
        return String.format(getClass().getSimpleName() +
                "\nfor " + identity() + " found by " + entity +
                (expected() == "" ? "" : "\nexpected: " + expected()) +
                (actual() == "" ? "" : "\nactual: " + actual()));
    }

}
