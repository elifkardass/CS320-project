import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import app.*;
import control.*;
import gui.*;

class RateControlTest {

    RateControl rateControl;
    RatePage ratePage;
    FoodItem foodItem;

    @BeforeEach
    void setUp() {
        // FoodItem and RatePage setup
        foodItem = new FoodItem("Apple", "Fruit", "2025-12-31", "USA", 1.0);
        ratePage = new RatePage(foodItem); // Assuming RatePage can be instantiated with a FoodItem
        rateControl = new RateControl(ratePage);
    }

    @Test
    void testUpdateFoodItemWithValidDetails() {
        // Setting up valid comment and rating
        ratePage.setTextFieldCommentFieldText("Great taste!"); // Assuming such a setter exists
        ratePage.setRatingDropdownSelection("5"); // Assuming such a setter exists

        assertTrue(rateControl.updateFoodItemWithRateDetails(), "Update should be successful with valid details.");
        assertEquals("Great taste!", foodItem.getComment(), "Comment should match the input.");
        assertEquals("5", foodItem.getRating(), "Rating should match the input.");
    }

    @Test
    void testUpdateFoodItemWithInvalidDetails() {
        // Setting up invalid comment (empty)
        ratePage.setTextFieldCommentFieldText(""); // Assuming such a setter exists
        ratePage.setRatingDropdownSelection("5"); // Assuming such a setter exists

        assertFalse(rateControl.updateFoodItemWithRateDetails(), "Update should fail with invalid comment.");
    }
}