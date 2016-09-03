package ua.net.itlabs.core.conditions;

import ua.net.itlabs.core.wrappers.LazyEntity;

public interface Condition<T> {

    T apply(LazyEntity entity);
}
