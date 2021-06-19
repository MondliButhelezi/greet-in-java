package net.greet;

import java.util.HashMap;
import java.util.Map;

public class Greet implements GreetCommands {
    HashMap <String, Integer> greetedList = new HashMap<>();
       /*
   I used the the Map list because it can only be used with an implementing class. It allows
   to store the values in key-pair combination; it does not allow duplicate keys; however,
   we can store the duplicate values.
    */

    //  method that will take user name and language and put in the HashMap
    public String greetNameLang(String username, String language) {

        username = ignoreCaseForNames(username);

        if (!greetedList.containsKey(username)) {
            greetedList.put(username, 1);
        } else if (greetedList.containsKey(username)) {
            greetedList.put(username, greetedList.get(username) + 1);
        }
        return Languages.valueOf(language.toUpperCase()).getLanguageGreeting() + username;
    }

    // Displays a list of all users that has been greeted and how many time each user has been greeted.
    public String greetedUsersSum() {
        String username = "";
        int currentCounter = 0;

        if (greetedList.size() > 0) {
            for (Map.Entry<String, Integer> name : greetedList.entrySet()) {
                username = name.getKey();
                currentCounter = name.getValue();
                System.out.println("The name: " + username + " has been greeted: " + currentCounter + " time(s).");
            }
        } else {
            System.out.println("There are no users greeted yet!");
        }
        return username + " = " + currentCounter;
    }

    //  Returns how many times a specific username has been greeted.
    public String counterOneUser(String username) {
        username = ignoreCaseForNames(username);
        int currentUserCounter = 0;

        if (greetedList.size() > 0) {
            if (greetedList.containsKey(username)) {
                currentUserCounter  = greetedList.get(username);
            }
            System.out.println("The name: " + username + " has been greeted: " + currentUserCounter + " time(s).");
        } else {
            System.out.println("There are no users greeted yet!");
        }
        return username + " = " + currentUserCounter;
    }

    // Returns a count of how many unique users has been greeted.
    public int counterForAllUsers() {
        return greetedList.size();
    }

    //  method to clear delete all users and reset counter
    public void clearAllUsers() {

        if (greetedList.size() > 0) {
            greetedList.clear();
            System.out.println("All users have been cleared!");
        } else {
            System.out.println("There are no users greeted yet!");
        }
    }

    //  clear method that deletes a user by username and decrement counter for all by 1
    public void clearOneUser(String username) {
        username = ignoreCaseForNames(username);

        if (greetedList.size() > 0) {
            if (greetedList.get(username) > 0) {
                greetedList.remove(username);
                System.out.println("The user: " + username + " has been cleared from the list!");
            }
        } else {
            System.out.println("There are no users greeted yet!");
        }
    }

    //    help method to show users how to use the program
    public void help() {
        System.out.println("Welcome to the help options of the greet App, look at available commands below: \n" +
                "\n" +
                "There are 4 available languages [ ~~english, zulu, xhosa & sotho~~ ].\n" +
                "Available commands include - [ ~~greet, greeted, count, counter, clear, exit, delete~~ ].\n" +
                "> To greet someone [ ~~greet Username language ~~ ].\n" +
                "> To see greeted people [ ~~greeted~~ ].\n" +
                "> To see how many times a specific user has been greeted [ ~~count Username~~ ].\n" +
                "> To see how people have been greeted [ ~~counter~~ ].\n" +
                "> To increment the counter of a certain user [ ~~clear Username~~].\n" +
                "> To delete all the people that were greeted [ ~~abolish~~ ].\n" +
                "> To exit the program [ ~~exit~~ ].");
    }

    //  format username to start with uppercase at index 0 and lowercase from index 1
    private String ignoreCaseForNames(String username) {
        username = username.substring(0, 1).toUpperCase() + username.substring(1).toLowerCase();
        return username;
    }
}
