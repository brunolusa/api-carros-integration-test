package basetest;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.lusa.carros.clients.DeleteCarrosClient;
import com.lusa.carros.clients.GetActuatorClient;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class})
public class BaseTest {

    private static RequestSpecification requestSpecification;
    public static DeleteCarrosClient deleteCarrosClient;
    public static GetActuatorClient getActuatorClient;

    @BeforeSuite
    public static void setUp() {
        deleteCarrosClient = new DeleteCarrosClient();
        getActuatorClient = new GetActuatorClient();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
