package com.example.case_study.DAO;

import com.example.case_study.DAO.connection.MyConnection;
import com.example.case_study.model.Account;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private Connection connection = MyConnection.getConnection();
    private static AccountDAO accountDAO;

    public static AccountDAO getInstance() {
        if (accountDAO == null) {
            accountDAO = new AccountDAO();
        }
        return accountDAO;
    }

    public void addAccount(InputStream fileContent) {
        String querry = "INSERT INTO account (image) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(querry)) {
            preparedStatement.setBinaryStream(1, fileContent);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Account getAccount() {
        Account account = null;
        String querry = "select * from account";
        try (PreparedStatement preparedStatement = connection.prepareStatement(querry)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                InputStream image = resultSet.getBlob("image").getBinaryStream();
                byte[] imageBytes = image.readAllBytes();
                account = new Account(id, imageBytes);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return account;
    }

    public List<Account> findAll() {
        List<Account> accountList = new ArrayList<>();
        String querry = "select * from account";
        try (PreparedStatement preparedStatement = connection.prepareStatement(querry)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                InputStream image = resultSet.getBlob("image").getBinaryStream();
                byte[] imageBytes = image.readAllBytes();
                accountList.add(new Account(id, imageBytes));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return accountList;
    }
}
