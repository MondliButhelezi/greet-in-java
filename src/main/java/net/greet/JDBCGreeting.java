package net.greet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCGreeting {

    final String DATABASE_URL = "jdbc:h2:file:./target/greet_db";
    final String ADD_NAME = "insert into greet (username, counter) values (?, ?)";
    final String FIND_NAME = "select * from greet where username = ?";
    final String UPDATE_NAME = "update greet set counter = counter + 1 where username = ?";
    final String RETURN_TABLE = "select * from greet";
    final String DELETE_NAME = "delete from greet where username = ?";
    final String DELETE_EVERYTHING = "delete from greet";
    final String TABLE_SIZE = "select count(*) as counter from greet";

    Connection connection;
    PreparedStatement addName;
    PreparedStatement findName;
    PreparedStatement updateName;
    PreparedStatement returnTable;
    PreparedStatement deleteName;
    PreparedStatement deleteEverything;
    PreparedStatement tableSize;

    public JDBCGreeting() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, "sa","");

            addName = connection.prepareStatement(ADD_NAME);
            findName = connection.prepareStatement(FIND_NAME);
            updateName = connection.prepareStatement(UPDATE_NAME);
            returnTable = connection.prepareStatement(RETURN_TABLE);
            deleteName = connection.prepareStatement(DELETE_NAME);
            deleteEverything = connection.prepareStatement(DELETE_EVERYTHING);
            tableSize = connection.prepareStatement(TABLE_SIZE);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            }
    }
}
