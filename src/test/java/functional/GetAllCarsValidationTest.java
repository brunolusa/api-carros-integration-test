package functional;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static requestspecification.CarrosRequestSpecification.getRequestSpecification;

public class GetAllCarsValidationTest {

    @Test
    public void buscaTodosOsCarrosTest(){
        given().
            spec(getRequestSpecification()).
        when().
            get("/carros").
        then().
            statusCode(SC_OK);
    }

}
