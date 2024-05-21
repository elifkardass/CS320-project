import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import app.FoodItem;
import control.CustomerControl;
import gui.CustomerPage;
import gui.MainPage;

class CustomerControlTest {

    CustomerControl customerControl;
    CustomerPage customerPage;
    MainPage mainPage;
    List<FoodItem> testFoodList;

    @BeforeEach
    void setUp() {
        // Create a test list of FoodItems
        testFoodList = new ArrayList<>();
        testFoodList.add(new FoodItem("Apple", "Fruit", "2025-12-31", "USA", 1.0));

        // Create a MainPage instance for the CustomerPage constructor
        mainPage = new MainPage();

        // Create a CustomerPage instance with the test list and mainPage reference
        customerPage = new CustomerPage(testFoodList, mainPage);

        // Instantiate the CustomerControl with the CustomerPage
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

    @Test
    void testMainMenuButtonAction() {
        // Simulate the MainMenu button click
        customerPage.getButtonMain().doClick();
        // Check if the CustomerPage is set to non-visible
        assertFalse(customerPage.isVisible(), "Customer page should be set to non-visible after clicking Main menu.");
    }

    @Test
    void testSubmitButtonActionValidSelection() {
        // Set up the CustomerPage to select a valid food name
        customerPage.setSelectedFoodItemName("Apple");

        // Simulate the Submit button click
        customerPage.getButtonSubmit().doClick();

        // Check if the CustomerPage is set to non-visible
        assertFalse(customerPage.isVisible(), "Customer page should be set to non-visible after submitting a valid food item.");
    }
}