package net.greet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTests {
    @Test
    public void shouldBeAbleToGreetWithAllLanguages() {
        Greet greet = new Greet();
        assertEquals(greet.greetNameLang("Vuyo", "english"), "Hello Vuyo");
        assertEquals(greet.greetNameLang("Vuyo", "zulu"), "Sawubona Vuyo");
        assertEquals(greet.greetNameLang("Vuyo", "xhosa"), "Molo Vuyo");
        assertEquals(greet.greetNameLang("Vuyo", "sotho"), "Dumela Vuyo");
    }

    @Test
    public void shouldShowUserGreeted() {
        Greet greet = new Greet();
        greet.greetNameLang("Sam", "xhosa");
        assertEquals(greet.greetedUsersSum(), "Sam = 1");
    }

        @Test
    public void shouldIgnoreNameCases() {
        Greet greet = new Greet();

        greet.greetNameLang("vuyo", "sotho");
        greet.greetNameLang("VUYO", "xhosa");
        greet.greetNameLang("VuYo", "zulu");

        assertEquals(greet.counterForAllUsers(), 1);
    }

    @Test
    public void shouldBeAbleToShowUsersGreeted() {
        Greet greet = new Greet();

        greet.greetNameLang("Vuyo", "zulu");
        greet.greetNameLang("Sim", "xhosa");
        greet.greetNameLang("Sali", "english");
        greet.greetNameLang("Sese", "zulu");

        assertEquals(greet.counterForAllUsers(), 4);
    }

    @Test
    public void shouldNotDuplicateUsers() {
        Greet greet = new Greet();

        greet.greetNameLang("Vuyo", "zulu");
        greet.greetNameLang("Vuyo", "sotho");
        greet.greetNameLang("Sali", "sotho");
        greet.greetNameLang("Sali", "xhosa");
        greet.greetNameLang("Sim", "xhosa");
        greet.greetNameLang("Sim", "english");

        assertEquals(greet.counterForAllUsers(), 3);
    }


    @Test
    public void shouldShowTimesEachUserWasGreeted() {
        Greet greet = new Greet();

        greet.greetNameLang("Vuyo", "english");
        greet.greetNameLang("Vuyo", "xhosa");
        greet.greetNameLang("Vuyo", "english");
        greet.greetNameLang("Sali", "sotho");
        greet.greetNameLang("Sali", "sotho");
        greet.greetNameLang("Sim", "zulu");

        assertEquals(greet.counterOneUser("Vuyo"), "Vuyo = 3");
        assertEquals(greet.counterOneUser("Sali"), "Sali = 2");
        assertEquals(greet.counterOneUser("Sim"), "Sim = 1");
    }

    @Test
    public void shouldClearOneUserCounter() {
        Greet greet = new Greet();

        greet.greetNameLang("Vuyo", "english");
        greet.greetNameLang("Vuyo", "english");

        greet.clearOneUser("Vuyo");

        assertEquals(greet.counterOneUser("Vuyo"), "Vuyo = 0");
    }

    @Test
    public void shouldBeAbleToClearOneUser() {
        Greet greet = new Greet();

        greet.greetNameLang("Sim", "xhosa");
        greet.greetNameLang("Sim", "xhosa");

        greet.clearOneUser("Sim");
        greet.clearOneUser("Sim");

        assertEquals(greet.counterOneUser("Sim"), "Sim = 0");
    }

    @Test
    public void shouldBeAbleToClearGreetedUsers() {
        Greet greet = new Greet();

        greet.greetNameLang("Vuyo", "english");
        greet.greetNameLang("Sim", "xhosa");
        greet.greetNameLang("Sali", "zulu");

        greet.clearAllUsers();

        assertEquals(greet.counterForAllUsers(), 0);
    }

}
