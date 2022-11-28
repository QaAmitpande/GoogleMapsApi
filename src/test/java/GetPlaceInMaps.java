import Places.MapPlaces;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetPlaceInMaps {
    @Test
    public void shouldGetPlaceInMaps(){
        //Arrange
       new MapPlaces().getPlace()
                .then()
                .header("Content-Type","application/json;charset=UTF-8")
                .log().body()
        //Assert
                .statusCode(200)
                .body("name",equalTo("Pande Bhavan"));

    }


}
