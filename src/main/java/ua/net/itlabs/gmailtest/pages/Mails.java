package ua.net.itlabs.gmailtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static ua.net.itlabs.core.ConciseAPI.*;

public class Mails {

    public static void send(String to, String subject) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).sendKeys(to);
        $(By.name("subjectbox")).sendKeys(subject);
        $(byText("Send")).click();
    }

//    public  static void assertMail(int index, String text) {
//        assertThat(listNthElementHasText(emails, index, text));
//    }
//
//    public static void assertMails(String... emailTexts) {
//        assertThat(texts(emails, emailTexts));
//    }

    public static void searchBySubject(String text) {
        $(By.name("q")).sendKeys("subject: " + text + Keys.ENTER);
    }

    public static By emails = byCSS("[role='main'] .zA");
}
