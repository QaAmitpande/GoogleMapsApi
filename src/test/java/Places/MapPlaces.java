package Places;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class MapPlaces {
    public static Response createPlace(String body) {
        return given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("key", "qaclick123")
                .body(body)
                .when().post("https://rahulshettyacademy.com/maps/api/place/add/json?key =qaclick123");
    }
    public static Response updatePlace(String body) {
        return given().accept(ContentType.JSON).contentType(ContentType.JSON)
                .queryParam("key", "qaclick123")
                .queryParam("place_id", "3a59c9cc299ac972bd0642955e6791cf")
                .body(body)
                .when().put("https://rahulshettyacademy.com/maps/api/place/update/json");
    }
    public static Response getPlace() {
        return given().queryParam("key", "qaclick123")
                .queryParam("place_id", "5a4769a8ce27b15949e9ad77af367bd4")
                //Act
                .when()
                .get("https://rahulshettyacademy.com/maps/api/place/get/json");
    }
}
