import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import app.*;
import control.*;
import gui.*;

class TransportationControlTest {

    TransportationControl transportationControl;
    TransportationPage transportationPage;
    FoodItem testFoodItem;

    @BeforeEach
    void setUp() {
        transportationPage = new TransportationPage(); // Assuming you can instantiate this
        transportationControl = new TransportationControl(transportationPage);
        testFoodItem = new FoodItem("Apple", "Fruit", "2024-12-31", "USA", 2.0);
        Main.foodList = new ArrayList<>(); // Assuming Main class has a static foodList
        Main.foodList.add(testFoodItem); // Add test item to list
    }

    @Test
    void testUpdateWithValidDetails() {
        // Setup valid inputs
        setupTransportationPage("CompanyX", "OfficeX", "FarmY", "MarketZ", "2024-12-31");

        assertTrue(transportationControl.updateFoodItemWithShippingDetails(), "Update should be successful with valid details.");
        assertEquals("CompanyX", testFoodItem.getTransporterCompany(), "Transporter Company should match.");
        assertEquals("MarketZ", testFoodItem.getFoodDestination(), "Food Destination should match.");
    }

    @Test
    void testUpdateWithInvalidDetails() {
        // Setup invalid inputs
        setupTransportationPage("", "", "FarmY", "MarketZ", "31-12-2024");

        assertFalse(transportationControl.updateFoodItemWithShippingDetails(), "Update should fail with invalid details.");
    }

    @Test
    void testUpdateWithEmptyList() {
        Main.foodList.clear(); // Clear the list to simulate no available food items
        setupTransportationPage("CompanyX", "OfficeX", "FarmY", "MarketZ", "2024-12-31");

        assertFalse(transportationControl.updateFoodItemWithShippingDetails(), "Update should fail with empty food list.");
    }

    private void setupTransportationPage(String company, String office, String source, String destination, String date) {
        transportationPage.getTextFieldCompanyName().setText(company);
        transportationPage.getTextFieldOfficeLocation().setText(office);
        transportationPage.getTextFieldFoodSource().setText(source);
        transportationPage.getTextFieldFoodDestination().setText(destination);
        transportationPage.getTextFieldExpectedDeliveryDate().setText(date);
    }
}