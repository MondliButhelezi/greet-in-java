package net.greet;

import java.util.Scanner;

public class Greeter {
    public static void main(String[] args) {
        Greet greet = new Greet();
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------  Welcome to my Greet App ------------------ \n" +
                "---------- Enter 'help' to know all available commands -------\n" +
                "");
        String inputString;

        boolean run = true;

        while(run){

            System.out.print("Enter a valid command: ");
            inputString = scanner.nextLine();
            String[] command = inputString.split(" ");

            String inputCommand = "";
            String inputName = "";
            String inputLanguage = "";

            // If statements to set command, name & language
            if (command.length == 1){
                inputCommand = command[0].toLowerCase();
            } else if (command.length == 2) {
                inputCommand = command[0].toLowerCase();
                inputName = command[1];
            } else if (command.length == 3){
                inputCommand = command[0].toLowerCase();
                inputName = command[1];
                inputLanguage = command[2].toUpperCase();
            }

            // If statements to set the commands
            if (inputCommand.equals("greet")) {
                System.out.println(greet.greetNameLang(inputName, inputLanguage));
            } else if(inputCommand.equals("greeted")) {
                greet.greetedUsersSum();
            } else if (inputCommand.equals("counter")) {
                System.out.println("Number of users greeted: " + greet.counterForAllUsers());
            } else if(inputCommand.equals("count") && !inputName.equals(" ")) {
                greet.counterOneUser(inputName);
            } else if (inputCommand.equals("clear") && !inputName.equals(" ")) {
                greet.clearOneUser(inputName);
            } else if(inputCommand.equals("abolish")){
                greet.clearAllUsers();
            } else if (inputCommand.equals("help")){
                greet.help();
            } else if (inputCommand.equals("exit")) {
                run = false;
            } else {
                System.out.println("Please enter a valid command!");
            }
        }
    }
}
