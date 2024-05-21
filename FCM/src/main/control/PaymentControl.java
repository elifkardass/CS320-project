package control;


import app.FoodItem;
import app.Main;
import gui.CustomerPage;
import gui.PaymentPage;
import gui.RatePage;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class PaymentControl {
    private String connectionUrl;
    private String connectionUsername;
    private String connectionPassword;
    private Connection connection;
    private Statement stat;
    private Statement stat2;

    public PaymentControl(PaymentPage paymentPage) throws SQLException {
        connectionUrl = "jdbc:mysql://localhost:3306/fcm";
        connectionUsername = "root";
        connectionPassword = "2415Qwe.";
        connection = DriverManager.getConnection(connectionUrl, connectionUsername, connectionPassword);
        stat =  connection.createStatement();

        paymentPage.getButtonMakePayment().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean checkPayment = false;
                try {
                    checkPayment = checkPaymentMethod(paymentPage);
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                if (checkPayment) {
                    RatePage ratePage = new RatePage(paymentPage.getFoodItem(), paymentPage.getMainPage()); // Opens the RatePage
                    new RateControl(ratePage);
                    paymentPage.setNonVisible();
                }
            }
        });
    }
    public boolean checkPaymentMethod(PaymentPage paymentPage) throws SQLException {



        String password = new String(paymentPage.getPasswordFieldCardPassword().getPassword());
        String cardNumber = paymentPage.getTextFieldCardNumber().getText();


        String sql = "SELECT * FROM CreditCards WHERE CreditCardNumber = ? AND Password = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cardNumber);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Password is correct for the given card number.");
                return true;
            } else {
                System.out.println("Password is incorrect for the given card number.");
                return false;
            }
        }

        // boolean checkPassword = (Objects.equals(password, dataPassword)) ;
        // boolean checkNumber = (Objects.equals(cardNumber, dataCardNumber)) ;

        // if(checkPassword & checkNumber){
        //     return true;
        // }else{
        //     System.out.println("wrong");
        //     return false;
        // }

    }

}



