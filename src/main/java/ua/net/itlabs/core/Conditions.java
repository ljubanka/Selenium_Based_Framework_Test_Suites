package ua.net.itlabs.core;


public class Conditions  {

    public static Condition<Boolean> sizeOf(int expectedSize) {
        return new SizeOf(expectedSize);

    }

    public static Condition<Boolean> text(String expectedText) {
        return new Text(expectedText);
    }
}
