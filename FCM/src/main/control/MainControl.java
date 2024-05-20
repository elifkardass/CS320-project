package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Main;
import gui.CustomerPage;
import gui.FactoryPage;
import gui.MainPage;
import java.sql.*;

public class MainControl {
    private String connectionUrl;
    private String connectionUsername;
    private String connectionPassword;
    private Connection connection;
    private Statement stat;
    private Statement stat2;

    public MainControl(MainPage mainPage) throws SQLException {
        connectionUrl = "jdbc:mysql://localhost:3306/";
        connectionUsername = "root";
        connectionPassword = "_*7A!%HzBg";
        connection = DriverManager.getConnection(connectionUrl, connectionUsername, connectionPassword);
        stat =  connection.createStatement();
        stat2 = connection.createStatement();

        mainPage.getButtonCreate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Instantiate and open FactoryPage
                FactoryPage factoryPage = new FactoryPage();
                // Instantiate FactoryControl with the newly created FactoryPage
                new FactoryControl(factoryPage);
                mainPage.setNonVisible();
            }
        });

        mainPage.getButtonCustomer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Instantiate CustomerPage
                CustomerPage customerPage = new CustomerPage(Main.foodList, mainPage);
                // Instantiate CustomerControl with the newly created CustomerPage
                new CustomerControl(customerPage);
                mainPage.setNonVisible();
            }
        });
    }
}