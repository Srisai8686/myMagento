package stepDefinitions;

import com.example.MyMagentoProject.utilities.DriverManager;
import org.openqa.selenium.WebDriver;

public class BaseSteps {
    protected WebDriver driver;

    public BaseSteps() {
        this.driver = DriverManager.getDriver();
    }
}
