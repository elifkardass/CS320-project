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
        paymentPage = new PaymentPage();
        paymentControl = new PaymentControl(paymentPage);
    }

    @Test
    void testValidPaymentMethod() {
        // Kart detaylarının doğru verildiği durum
        paymentPage.setCardDetails("1234567890", "1234");
        assertTrue(paymentControl.checkPaymentMethod(paymentPage), "Payment should be successful with correct details.");
    }

    @Test
    void testInvalidPaymentMethod() {
        // Kart numarasının veya şifrenin yanlış verildiği durum
        paymentPage.setCardDetails("1234567890", "wrongPassword");
        assertFalse(paymentControl.checkPaymentMethod(paymentPage), "Payment should fail with incorrect details.");
}
}