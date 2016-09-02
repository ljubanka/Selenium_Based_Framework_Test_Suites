package ua.net.itlabs.core.conditions;

import ua.net.itlabs.core.wrappers.LazyEntity;

public interface Condition<V> {
    V apply(LazyEntity entity);
}
