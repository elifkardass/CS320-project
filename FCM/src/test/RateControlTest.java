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
    MainPage mainPage;

    @BeforeEach
    void setUp() {
        // FoodItem and RatePage setup
        foodItem = new FoodItem("Apple", "Fruit", "2025-12-31", "USA", 1.0);
        mainPage = new MainPage(); // Assuming MainPage has a default constructor
        ratePage = new RatePage(foodItem, mainPage);
        rateControl = new RateControl(ratePage);
    }

    @Test
    void testUpdateFoodItemWithValidDetails() {
        // Setting up valid comment and rating
        ratePage.setTextFieldCommentFieldText("Great taste!");
        ratePage.setRatingDropdownSelection("5");

        assertTrue(rateControl.updateFoodItemWithRateDetails(), "Update should be successful with valid details.");
        assertEquals("Great taste!", foodItem.getComment(), "Comment should match the input.");
        assertEquals("5", foodItem.getRating(), "Rating should match the input.");
    }

    @Test
    void testUpdateFoodItemWithInvalidDetails() {
        // Setting up invalid comment (empty)
        ratePage.setTextFieldCommentFieldText("");
        ratePage.setRatingDropdownSelection("5");

        assertFalse(rateControl.updateFoodItemWithRateDetails(), "Update should fail with invalid comment.");
    }
}