import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import app.*;
import control.*;
import gui.*;

import java.sql.SQLException;

class MainControlTest {

    MainControl mainControl;
    MainPage mainPage;

    @BeforeEach
    void setUp() throws SQLException {
        mainPage = new MainPage();
        mainControl = new MainControl(mainPage);
    }

    @Test
    void testOpenFactoryPage() {
        mainPage.getButtonCreate().doClick();
        // Test to ensure the FactoryPage is opened
        assertTrue(mainPage.isNonVisible(), "MainPage should be non-visible after opening FactoryPage.");
    }
}