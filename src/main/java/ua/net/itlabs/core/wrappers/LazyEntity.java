package ua.net.itlabs.core.wrappers;

public interface LazyEntity<T> extends DescribesEntity {
    T getWrappedEntity();

}
