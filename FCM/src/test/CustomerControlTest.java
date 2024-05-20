

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import app.*;
import control.*;
import gui.*;

class CustomerControlTest {

    CustomerControl customerControl;
    CustomerPage customerPage;
    List<FoodItem> testFoodList;

    @BeforeEach
    void setUp() {
        testFoodList = new ArrayList<>();
        testFoodList.add(new FoodItem("Apple", "Fruit", "2025-12-31", "USA", 1.0));
        Main.foodList = testFoodList; // Assigning the test list to the Main's foodList

        customerPage = new CustomerPage(); // Assuming you have default constructor or setup method
        customerControl = new CustomerControl(customerPage);
    }

    @Test
    void testFindFoodItemByNameValid() {
        FoodItem result = customerControl.findFoodItemByName("Apple");
        assertNotNull(result, "Food item should be found.");
        assertEquals("Apple", result.getName(), "The food item name should match.");
    }

    @Test
    void testFindFoodItemByNameInvalid() {
        FoodItem result = customerControl.findFoodItemByName("Banana");
        assertNull(result, "Food item should not be found.");
    }
    // This test assumes you can simulate button clicks or the effects of them.
    @Test
    void testMainMenuButtonAction() {
        // Simulate the MainMenu button click
        customerPage.getButtonMain().doClick(); // If you can simulate clicks
        // Check if the CustomerPage is set to non-visible
        assertFalse(customerPage.isVisible(), "Customer page should be set to non-visible after clicking Main menu.");
    }

    // Simulate the Submit button action when a valid food item is selected
    @Test
    void testSubmitButtonActionValidSelection() {
        // Set up the CustomerPage to return a valid food name
        customerPage.setSelectedFoodItemName("Apple");
        // Simulate the Submit button click
        customerPage.getButtonSubmit().doClick();
        // Check if the CustomerPage is set to non-visible
        assertFalse(customerPage.isVisible(), "Customer page should be set to non-visible after submitting a valid food item.");
}
}