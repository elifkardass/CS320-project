package gui;

import app.FoodItem;

import javax.swing.*;
import java.awt.*;

public class PaymentPage extends BaseView {

    private JFrame frame;
    private JTextField textFieldCardNumber;
    private JPasswordField passwordFieldCardPassword;
    private JLabel labelAmount;
    private JButton buttonMakePayment;
    private FoodItem foodItem;
    private MainPage mainPage; // reference to mainPage
    public PaymentPage(FoodItem foodItem, MainPage mainPage) {
        this.mainPage = mainPage;
        this.foodItem = foodItem;
        this.frame = new JFrame("Payment Page");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        frame.add(mainPanel);
        mainPanel.setLayout(new GridLayout(4, 2));

        // Card Number
        mainPanel.add(new JLabel("Card Number"));
        textFieldCardNumber = new JTextField();
        mainPanel.add(textFieldCardNumber);

        // Card Password
        mainPanel.add(new JLabel("Card Password"));
        passwordFieldCardPassword = new JPasswordField();
        mainPanel.add(passwordFieldCardPassword);

        // Amount
        mainPanel.add(new JLabel("Amount"));
        labelAmount = new JLabel("0.0");
        mainPanel.add(labelAmount);

        // Make Payment button
        mainPanel.add(new JPanel());
        buttonMakePayment = new JButton("Make Payment");
        mainPanel.add(buttonMakePayment);

        frame.setVisible(true);
    }

    public JTextField getTextFieldCardNumber() { return textFieldCardNumber; }
    public JPasswordField getPasswordFieldCardPassword() { return passwordFieldCardPassword; }
    public JLabel getLabelAmount() { return labelAmount; }
    public JButton getButtonMakePayment() { return buttonMakePayment; }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setNonVisible() {
        frame.setVisible(false);
    }

    public void setVisible() {
        frame.setVisible(true);
    }
    public MainPage getMainPage() {
        return mainPage;
    }

    public void setCardDetails(String s, String s1) {
        textFieldCardNumber.setText(s);
        passwordFieldCardPassword.setText(s1);


    }
}