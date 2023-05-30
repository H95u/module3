package model;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection connection = UserDAO.getConnection();
        System.out.println(connection);
    }
}
