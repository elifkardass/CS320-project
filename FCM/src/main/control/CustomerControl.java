package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import app.FoodItem;
import app.Main;
import gui.CustomerPage;
import gui.PaymentPage;
import gui.RatePage;


public class CustomerControl {

	public CustomerControl(CustomerPage customerPage) {
		System.out.println("CustomerControl instantiated");
		customerPage.getButtonMain().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Instantiate and open MainPage
				System.out.println("MainMenu Button Clicked");
				customerPage.showMainPage();
				customerPage.setNonVisible();
			}
		});

		customerPage.getButtonSubmit().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedFoodName = customerPage.getSelectedFoodItemName();
				FoodItem selectedFoodItem = findFoodItemByName(selectedFoodName);
				if (selectedFoodItem != null) {

					PaymentPage paymentPage = new PaymentPage(selectedFoodItem, customerPage.getMainPage());
					try {
						new PaymentControl(paymentPage);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					customerPage.setNonVisible();
				}
			}
		});

	}

	private FoodItem findFoodItemByName(String foodName) {
		for (FoodItem foodItem : Main.foodList) { // Assuming foodList is accessible here
			if (foodItem.getName().equals(foodName)) {
				return foodItem;
			}
		}
		return null;
	}




}