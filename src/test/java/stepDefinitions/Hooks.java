package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import com.example.MyMagentoProject.utilities.DriverManager;

public class Hooks {

    private static boolean isDriverInitialized = false;

    @Before
    public void setUp() {
        if (!isDriverInitialized) {
            DriverManager.getDriver(); // Initialize the driver if not already initialized
            isDriverInitialized = true;
        }
    }

    @After
    public void tearDown() {
        // Optionally, keep the browser session open for the entire test suite.
        // Uncomment the following line if you want to quit the browser after each scenario.
        // DriverManager.quitDriver(); 
    }

    // Global shutdown hook to ensure the driver quits once all tests are done
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            //DriverManager.quitDriver(); // Ensure driver quits on JVM shutdown
        }));
    }
}
