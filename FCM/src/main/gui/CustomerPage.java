package gui;
import javax.swing.*;

import app.FoodItem;

import java.awt.*;
import java.util.List;
import java.util.Vector;

public class CustomerPage extends BaseView {

    private JFrame frame; // Declare frame as a class member
    private JButton buttonMain;
    private JButton buttonBuy;
    private MainPage mainPage; // reference to mainPage

    private JComboBox<String> dropdownFoods;

    public CustomerPage(List<FoodItem> foodList, MainPage mainPage) {
        this.mainPage = mainPage;

        // frame initialization
        this.frame = new JFrame("Customer Page");
        int width = 450;
        int height = 300;
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // mainPanel initialization
        JPanel mainPanel = new JPanel();
        frame.add(mainPanel);
        mainPanel.setLayout(new FlowLayout());

        // attributes
        JLabel labelName = new JLabel("Select Product");
        mainPanel.add(labelName);

        // Convert foodList to String array or Vector for JComboBox
        Vector<String> foodOptions = new Vector<>();
        for (FoodItem food : foodList) {
            foodOptions.add(food.getName());
        }

        dropdownFoods = new JComboBox<>(foodOptions);
        mainPanel.add(dropdownFoods);

        // buttons
        this.buttonBuy = new JButton("Buy");
        mainPanel.add(buttonBuy);

        this.buttonMain = new JButton("Main Menu");
        mainPanel.add(buttonMain);

        frame.setVisible(true);
    }

    public JButton getButtonMain() {
        return buttonMain;
    }

    public JButton getButtonSubmit() {
        return buttonBuy;
    }

    public void showMainPage() {
        if (mainPage != null) {
            mainPage.setVisible();
        }
    }

    public void setNonVisible() {
        frame.setVisible(false);
    }

    public void setVisible() {
        frame.setVisible(true);
    }

    public String getSelectedFoodItemName() {
        return dropdownFoods.getSelectedItem().toString();
    }

    public void setSelectedFoodItemName(String name) {
        dropdownFoods.setSelectedItem(name);
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public boolean isVisible() {
        return frame.isVisible();
    }
}