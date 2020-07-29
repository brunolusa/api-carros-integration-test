package basetest;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.lusa.carros.clients.DeleteCarrosClient;
import com.lusa.carros.clients.GetActuatorClient;
import com.lusa.carros.clients.GetCarrosClient;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class})
public class BaseTest {

    private static RequestSpecification requestSpecification;
    public static DeleteCarrosClient deleteCarrosClient;
    public static GetActuatorClient getActuatorClient;
    public static GetCarrosClient getCarrosClient;

    @BeforeSuite
    public static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        deleteCarrosClient = new DeleteCarrosClient();
        getActuatorClient = new GetActuatorClient();
        getCarrosClient = new GetCarrosClient();

    }
}
