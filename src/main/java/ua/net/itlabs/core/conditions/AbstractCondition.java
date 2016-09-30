package ua.net.itlabs.core.conditions;

import ua.net.itlabs.core.exceptions.WebDriverAssertionException;
import ua.net.itlabs.core.wrappers.LazyEntity;

public abstract class AbstractCondition<T> implements Condition<T>, DescribesResult{

    protected LazyEntity<T> entity;
    //public abstract boolean check(T wrappedEntity);

    public T apply(LazyEntity<T> entity) {
        T wrappedEntity = entity.getWrappedEntity();
        if (check(wrappedEntity)) {
            return wrappedEntity;
        }
            throw new WebDriverAssertionException(this.toString());


//        this.entity = entity;
//        T result = check(entity.getWrappedEntity());
//        if (result != null) {
//            return result;
//        }
//        throw new WebDriverAssertionException();
        //return null;
    }

    public String toString() {
        return String.format(getClass().getSimpleName() +
                "\nfor " + identity() + " found by " + entity +
                (expected() == "" ? "" : "\nexpected: " + expected()) +
                (actual() == "" ? "" : "\nactual: " + actual()));
    }

}
