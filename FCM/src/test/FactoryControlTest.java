import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import app.*;
import control.*;
import gui.*;

class FactoryControlTest {

    FactoryControl factoryControl;
    FactoryPage factoryPage;

    @BeforeEach
    void setUp() {
        // FactoryPage ve FactoryControl sınıflarının başlatılması
        factoryPage = new FactoryPage(); // Bu sınıfın gerçek metodları kullanılırsa, burada bir mock nesne kullanmanız gerekebilir.
        factoryControl = new FactoryControl(factoryPage);
    }

    @Test
    void testValidFoodItemCreation() {
        // Test verileri
        factoryPage.setTextFieldName("Apple");
        factoryPage.setTextFieldCategory("Fruit");
        factoryPage.setTextFieldDate("2024-12-31");
        factoryPage.setTextFieldOrigin("USA");
        factoryPage.setTextFieldPrice("1.20");

        // Test işlemi
        boolean result = factoryControl.createAndAddFoodItem();
        assertTrue(result, "Food item should be created successfully.");

        // Sonucun doğrulanması
        FoodItem resultItem = Main.foodList.get(0);
        assertNotNull(resultItem, "Food item should be added to the list.");
        assertEquals("Apple", resultItem.getName(), "Name should match.");
    }

    @Test
    void testInvalidFoodItemCreation() {
        // Geçersiz tarih formatı
        factoryPage.setTextFieldName("Apple");
        factoryPage.setTextFieldCategory("Fruit");
        factoryPage.setTextFieldDate("31-12-2024");
        factoryPage.setTextFieldOrigin("USA");
        factoryPage.setTextFieldPrice("1.20");

        // Test işlemi
        boolean result = factoryControl.createAndAddFoodItem();
        assertFalse(result, "Food item creation should fail due to invalid date format.");
}
}