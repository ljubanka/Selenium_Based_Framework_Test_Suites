package ua.net.itlabs.core.wrappers.element;

import org.openqa.selenium.*;
import ua.net.itlabs.core.wrappers.DescribesEntity;
import ua.net.itlabs.core.Command;
import ua.net.itlabs.core.conditions.ElementCondition;
import ua.net.itlabs.core.exceptions.ElementNotFoundException;
import ua.net.itlabs.core.wrappers.LazyCollection;
import ua.net.itlabs.core.wrappers.LazyElement;
import ua.net.itlabs.core.wrappers.collection.LazyElementInnerCollection;
import java.util.List;

import static ua.net.itlabs.core.ConciseAPI.actions;
import static ua.net.itlabs.core.ConciseAPI.byCSS;
import static ua.net.itlabs.core.WaitFor.waitFor;
import static ua.net.itlabs.core.conditions.ElementConditions.present;
import static ua.net.itlabs.core.conditions.ElementConditions.visible;
import static ua.net.itlabs.core.WithWaitFor.withWaitFor;

public abstract class AbstractLazyElement implements LazyElement, DescribesEntity {
    public abstract WebElement fetchWrappedEntity();

    @Override
    public WebElement getWrappedEntity() {
        WebElement element = fetchWrappedEntity();
        if (element == null) {
            throw new ElementNotFoundException(this.toString());
        }
        return element;
    }

    @Override
    public boolean is(ElementCondition condition) {
        try {
            return condition.check(this.getWrappedEntity());
        }
        catch (WebDriverException e) {}
        return false;
    }

    @Override
    public LazyElement find(By locator) {
        return new LazyElementInnerElement(this, locator);
    }

    @Override
    public LazyElement find(String cssSelector) {
        return find(byCSS(cssSelector));
    }

    @Override
    public LazyElement $(By locator) {
        return find(locator);
    }

    @Override
    public LazyElement $(String cssSelector) {
        return find(cssSelector);
    }

    @Override
    public LazyCollection findAll(By innerLocator) {
        return new LazyElementInnerCollection(this, innerLocator);
    }

    @Override
    public LazyCollection findAll(String innerCssSelector) {
        return findAll(byCSS(innerCssSelector));
    }

    @Override
    public LazyElement should(ElementCondition... conditions) {
        waitFor(this).until(conditions);
        return this;
    }

    @Override
    public LazyElement shouldBe(ElementCondition... conditions) {
        should(conditions);
        return this;
    }

    @Override
    public LazyElement shouldHave(ElementCondition... conditions) {
        should(conditions);
        return this;
    }

    @Override
    public <X> X getScreenshotAs(final OutputType<X> outputType) throws WebDriverException {
        return withWaitFor(this, visible()).run(new Command<X>() {
            @Override
            public X action(WebElement element) {
                return element.getScreenshotAs(outputType);
            }
        });
    }

    @Override
    public void click() {
        withWaitFor(this, visible()).run(new Command<Void>() {
            @Override
            public Void action(WebElement element) {
                element.click();
                return null;
            }
        });
    }

    @Override
    public void submit() {
        withWaitFor(this, visible()).run(new Command<Void>() {
            @Override
            public Void action(WebElement element) {
                element.submit();
                return null;
            }
        });
    }

    @Override
    public LazyElement doubleClick() {
        withWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement action(WebElement element) {
                actions().doubleClick(element).perform();
                return element;
            }
        });
        return this;
    }

    @Override
    public LazyElement hover() {
        withWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement action(WebElement element) {
                actions().moveToElement(element).perform();
                return element;
            }
        });
        return this;
    }

    @Override
    public LazyElement setValue(final String text) {
        withWaitFor(this, visible()).run(new Command<WebElement>() {
            @Override
            public WebElement action(WebElement element) {
                element.clear();
                element.sendKeys(text);
                return element;
            }
        });
        return this;
    }

    @Override
    public void clear() {
        withWaitFor(this, visible()).run(new Command<Void>() {
            @Override
            public Void action(WebElement element) {
                element.clear();
                return null;
            }
        });
    }

    @Override
    public String getTagName() {
        return withWaitFor(this, present()).run(new Command<String>() {
            @Override
            public String action(WebElement element) {
                return element.getTagName();
            }
        });
    }

    @Override
    public String getAttribute(final String name) {
        return withWaitFor(this, present()).run(new Command<String>() {
            @Override
            public String action(WebElement element) {
                return element.getAttribute(name);
            }
        });
    }

    @Override
    public boolean isSelected() {
        return withWaitFor(this, visible()).run(new Command<Boolean>() {
            @Override
            public Boolean action(WebElement element) {
                return element.isSelected();
            }
        });
    }

    @Override
    public boolean isEnabled() {
        return withWaitFor(this, visible()).run(new Command<Boolean>() {
            @Override
            public Boolean action(WebElement element) {
                return element.isEnabled();
            }
        });
    }

    @Override
    public String getText() {
        return withWaitFor(this, visible()).run(new Command<String>() {
            @Override
            public String action(WebElement element) {
                return element.getText();
            }
        });
    }

    @Override
    public List<WebElement> findElements(final By by) {
        return withWaitFor(this, present()).run(new Command<List<WebElement>>() {
            @Override
            public List<WebElement> action(WebElement element) {
                return element.findElements(by);
            }
        });
    }

    @Override
    public WebElement findElement(final By by) {
        return withWaitFor(this, present()).run(new Command<WebElement>() {
            @Override
            public WebElement action(WebElement element) {
                return element.findElement(by);
            }
        });
    }

    @Override
    public boolean isDisplayed() {
        return withWaitFor(this, present()).run(new Command<Boolean>() {
            @Override
            public Boolean action(WebElement element) {
                return element.isDisplayed();
            }
        });
    }

    @Override
    public Point getLocation() {
        return withWaitFor(this, visible()).run(new Command<Point>() {
            @Override
            public Point action(WebElement element) {
                return element.getLocation();
            }
        });
    }

    @Override
    public Dimension getSize() {
        return withWaitFor(this, visible()).run(new Command<Dimension>() {
            @Override
            public Dimension action(WebElement element) {
                return element.getSize();
            }
        });
    }

    @Override
    public Rectangle getRect() {
        return withWaitFor(this, visible()).run(new Command<Rectangle>() {
            @Override
            public Rectangle action(WebElement element) {
                return element.getRect();
            }
        });
    }

    @Override
    public String getCssValue(final String cssProperty) {
        return withWaitFor(this, present()).run(new Command<String>() {
            @Override
            public String action(WebElement element) {
                return element.getCssValue(cssProperty);
            }
        });
    }

    @Override
    public void sendKeys(final CharSequence... chars) {
        withWaitFor(this, visible()).run(new Command<Void>() {
            @Override
            public Void action(WebElement element) {
                element.sendKeys(chars);
                return null;
            }
        });
    }

    @Override
    public LazyElement pressEnter() {
        sendKeys(Keys.ENTER);
        return this;
    }

    @Override
    public LazyElement pressEscape() {
        sendKeys(Keys.ESCAPE);
        return this;
    }

    @Override
    public LazyElement pressTab() {
        sendKeys(Keys.TAB);
        return this;
    }

    @Override
    public String identity() {
        return "element";
    }

}
