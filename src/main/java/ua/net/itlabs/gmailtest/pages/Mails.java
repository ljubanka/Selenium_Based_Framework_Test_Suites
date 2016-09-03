package ua.net.itlabs.gmailtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ua.net.itlabs.core.wrappers.LazyCollection;

import static ua.net.itlabs.core.ConciseAPI.*;
import static ua.net.itlabs.core.WaitFor.waitFor;
import static ua.net.itlabs.core.conditions.CollectionConditions.nthElementText;
import static ua.net.itlabs.core.conditions.CollectionConditions.texts;

public class Mails {

    public static void send(String to, String subject) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).sendKeys(to);
        $(By.name("subjectbox")).sendKeys(subject);
        $(byText("Send")).click();
    }

    public  static void assertMail(int index, String text) {
        emails.shouldHave(nthElementText(index, text));
    }

    public static void assertMails(String... emailTexts) {
        emails.shouldHave(texts(emailTexts));
    }

    public static void searchBySubject(String text) {
        $(By.name("q")).setValue("subject: " + text).pressEnter();
    }

    public static LazyCollection emails = $$(byCSS("[role='main'] .zA"));
}
