import Places.MapPlaces;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePlaceInMaps {
 //private CreatePlaceInMaps createPlaceInMaps;
    @Test
    public void shouldUpdatePlaceInMaps(){
        //Arrange
        String body ="{\n" +
                "\"place_id\":\""+place_id+"\",\n" +
                "\"address\":\"70 winter walk, pusad\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";

        //Act
      new MapPlaces().updatePlace(body)

                .then().log().body()
       //Assert
                .statusCode(200)
                .body("msg",equalTo("Address successfully updated"));
    }
}
