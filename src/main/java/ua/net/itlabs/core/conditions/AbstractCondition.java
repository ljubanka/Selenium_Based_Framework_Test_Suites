package ua.net.itlabs.core.conditions;

import ua.net.itlabs.core.elements.LazyElement;
import ua.net.itlabs.core.elements.LazyEntity;

public abstract class AbstractCondition<V> implements Condition<V>{

    protected LazyEntity entity;
    //public abstract V getWrappedEntity();
    public abstract V check(V wrappedEntity);
    public abstract String identity();
    public abstract String expected();
    public abstract String actual();

    public V apply(LazyEntity entity) {
        this.entity = entity;
        V result = check((V) entity.getWrappedEntity());
        if (result != null) {
            return result;
        }
        return null;
    }

//    public String toString() {
//        return String.format(getClass().getSimpleName() +
//                "\nfor " + identity() + " found by " + locator +
//                (expected() == "" ? "" : "\nexpected: " + expected()) +
//                (actual() == "" ? "" : "\nactual: " + actual()));
//    }

}
