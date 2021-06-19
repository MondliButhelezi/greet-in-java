package net.greet;

public interface GreetCommands {

    String greetNameLang(String username, String language);
    String greetedUsersSum();
    String counterOneUser(String username);
    int counterForAllUsers();
    void clearOneUser(String username);
    void clearAllUsers();
    void help();
}
