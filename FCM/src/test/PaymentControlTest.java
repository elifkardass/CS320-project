import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import app.*;
import control.*;
import gui.*;
class PaymentControlTest {

    PaymentControl paymentControl;
    PaymentPage paymentPage;

    @BeforeEach
    void setUp() throws Exception {
        FoodItem testItem  = new FoodItem("Apple", "Fruit", "2025-12-31", "USA", 1.0);
        MainPage testPage = new MainPage();
        paymentPage = new PaymentPage(testItem,testPage);


    }

    @Test
    void testValidPaymentMethod() {
        // Kart detaylarının doğru verildiği durum
        paymentPage.setCardDetails("1234567890", "1234");
        paymentControl = new PaymentControl(paymentPage);
        assertTrue(paymentControl.checkPaymentMethod(paymentPage), "Payment should be successful with correct details.");
    }

    @Test
    void testInvalidPaymentMethod() {
        // Kart numarasının veya şifrenin yanlış verildiği durum
        paymentPage.setCardDetails("1234567890", "ErroredPAssword");
        assertFalse(paymentControl.checkPaymentMethod(paymentPage), "Payment should fail with incorrect details.");
}
}