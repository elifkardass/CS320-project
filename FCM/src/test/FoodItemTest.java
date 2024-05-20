import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.*;
import control.*;
import gui.*;

class FoodItemTest {

    FoodItem foodItem;

    @BeforeEach
    void setUp() {
        // Geçerli değerler ile FoodItem nesnesi oluşturuluyor.
        foodItem = new FoodItem("Apple", "Fruit", "2024-12-31", "USA", 1.20);
    }

    @Test
    void testFoodItemConstructor() {
        assertEquals("Apple", foodItem.getName());
        assertEquals("Fruit", foodItem.getCategory());
        assertEquals("2024-12-31", foodItem.getExpiryDate());
        assertEquals("USA", foodItem.getOrigin());
        assertEquals(1.20, foodItem.getPrice());
    }

    @Test
    void testSetName() {
        foodItem.setName("Banana");
        assertEquals("Banana", foodItem.getName());
    }

    @Test
    void testSetCategory() {
        foodItem.setCategory("Vegetable");
        assertEquals("Vegetable", foodItem.getCategory());
    }

    @Test
    void testSetExpiryDate() {
        foodItem.setExpiryDate("2025-01-01");
        assertEquals("2025-01-01", foodItem.getExpiryDate());
    }

    @Test
    void testSetOrigin() {
        foodItem.setOrigin("Canada");
        assertEquals("Canada", foodItem.getOrigin());
    }

    @Test
    void testSetPrice() {
        foodItem.setPrice(2.50);
        assertEquals(2.50, foodItem.getPrice());
    }

    @Test
    void testInvalidDate() {
        // Burada geçersiz tarih formatı için bir kontrol ekleyeceğim.
        Exception exception = assertThrows(IllegalArgumentException.class, () -> foodItem.setExpiryDate("31-12-2024"));
        assertTrue(exception.getMessage().contains("Date must be in the format yyyy-MM-dd"));
    }
}