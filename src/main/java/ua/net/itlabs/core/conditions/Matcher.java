package ua.net.itlabs.core.conditions;

public interface Matcher<T> {
    boolean check(T wrappedEntity);

}
