package ua.net.itlabs.core.conditions;

import org.openqa.selenium.By;

import java.util.List;

import static ua.net.itlabs.core.Helpers.getTexts;

public abstract class AbstractCondition<V> implements Condition<V>{

    //public abstract V check(By locator);
    public abstract List<String> elementsString();
    //public abstract String elementString();

    public abstract String elementOrElements();
    public abstract String locatorString();
    public abstract String resultDescription();
    public abstract String expectedResultString();
    public abstract String actualResultString();

//    public V apply(By locator) {
//        try {
//            check(locator);
//        }
//        catch () {
//
//        }
//
//    }

    public String toString() {

        return String.format(this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1) +
                        "\nfor %s %s, found by: %s locator \nexpected %s to be %s,\n" +
                "actual %s is %s", elementOrElements(), elementsString(), locatorString(), resultDescription(),
                    expectedResultString(), resultDescription(), actualResultString());
    }

}
