package ua.net.itlabs.core.conditions;

import ua.net.itlabs.core.elements.LazyElement;
import ua.net.itlabs.core.elements.LazyEntity;

public interface Condition<V> {
    V apply(LazyEntity entity);
}
