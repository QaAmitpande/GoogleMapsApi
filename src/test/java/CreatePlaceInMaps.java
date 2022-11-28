import Places.MapPlaces;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.equalTo;

public class CreatePlaceInMaps {

    @Test
    public void shouldCreatePlaceInMaps(){
        //Arrange
       String body = "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Pande Bhavan\",\n" +
                "  \"phone_number\": \"(+91) 9999999999\",\n" +
                "  \"address\": \"29, Chaubara Chowk Pusad\",\n" +
                "  \"types\": [\n" +
                "    \"Residence Address\",\n" +
                "    \"Wada\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"Marathi-IN\"\n" +
                "}";
        //Act
     String response =  new MapPlaces().createPlace(body)
                .then().log().body()
       //Assert
                .statusCode(200)
                .body("status",equalTo("OK")).extract().response().asString();

     //Parse the json to extract the body
        JsonPath js = new JsonPath(response);
    String place_id =  js.getString("place_id");
        System.out.println(place_id);
    }
}

