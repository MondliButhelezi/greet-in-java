package net.greet;

public enum Languages {

    // The languages to be used as greetings
    ENGLISH ("Hello "),
    ZULU ("Sawubona "),
    XHOSA("Molo "),
    SOTHO("Dumela ");

    // add getter and setter for app to get language greeting from Greet class
    private String languageGreeting; // A field variable to create a getter

    // Setter method for language greeting
    Languages(String languageGreeting) {
        this.languageGreeting = languageGreeting;
    }

    // Getter method for language greeting
    public String getLanguageGreeting(){
        return languageGreeting;
    }
}
