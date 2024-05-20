import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import app.*;
import control.*;
import gui.*;
import control.WarehouseControl;

class WarehouseControlTest {

    WarehouseControl warehouseControl;
    WarehousePage warehousePage;
    FoodItem testFoodItem;

    @BeforeEach
    void setUp() {
        warehousePage = new WarehousePage(); // Assuming you can instantiate this
        warehouseControl = new WarehouseControl(warehousePage);
        testFoodItem = new FoodItem("Apple", "Fruit", "2024-12-31", "USA", 2.0);
        Main.foodList = new ArrayList<>(); // Assuming Main class has a static foodList
        Main.foodList.add(testFoodItem); // Add test item to list
    }

    @Test
    void testUpdateWithValidDetails() {
        // Setup valid inputs
        setupWarehousePage("Warehouse A", "2024-12-31");

        assertTrue(warehouseControl.updateFoodItemWithWarehouseDetails(), "Update should be successful with valid details.");
        assertEquals("Warehouse A", testFoodItem.getWarehouseLocation(), "Warehouse Location should match.");
        assertEquals("2024-12-31", testFoodItem.getDateOfReceiving(), "Date of Receiving should match.");
    }

    @Test
    void testUpdateWithInvalidDetails() {
        // Setup invalid inputs
        setupWarehousePage("", "2024-12-31");

        assertFalse(warehouseControl.updateFoodItemWithWarehouseDetails(), "Update should fail with invalid warehouse location.");
    }

    @Test
    void testUpdateWithInvalidDateFormat() {
        // Setup invalid date format
        setupWarehousePage("Warehouse A", "31-12-2024");

        assertFalse(warehouseControl.updateFoodItemWithWarehouseDetails(), "Update should fail with invalid date format.");
    }

    @Test
    void testUpdateWithEmptyList() {
        Main.foodList.clear(); // Clear the list to simulate no available food items
        setupWarehousePage("Warehouse A", "2024-12-31");

        assertFalse(warehouseControl.updateFoodItemWithWarehouseDetails(), "Update should fail with empty food list.");
    }

    private void setupWarehousePage(String warehouse, String date) {
        warehousePage.getTextFieldName().setText(warehouse);
        warehousePage.getTextFieldCategory().setText(date);
    }
}