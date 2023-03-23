import config.VideoGameConfig;
import config.VideoGameEndpoints;
import objects.VideoGame;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class VideoGameTests extends VideoGameConfig {
    String gameBodyJSON = "{\n" +
            "  \"category\": \"Platform\",\n" +
            "  \"name\": \"Mario\",\n" +
            "  \"rating\": \"Mature\",\n" +
            "  \"releaseDate\": \"2012-05-04\",\n" +
            "  \"reviewScore\": 85\n" +
            "}";
    @Test
    public void getAllGames() {
        given()
                //.log().all()
                .when()
                .get(VideoGameEndpoints.ALL_VIDEO_GAMES)
                .then();
        // .log().all();
    }

    @Test
    public void createNewGameByJSON() {
        given()
                .body(gameBodyJSON)
                .when()
                .post(VideoGameEndpoints.ALL_VIDEO_GAMES)
                .then();
    }

    @Test
    public void createNewGameByXML(){
        String gameBodyXML = "<VideoGameRequest>\n" +
                "\t<category>Platform</category>\n" +
                "\t<name>Mario</name>\n" +
                "\t<rating>Mature</rating>\n" +
                "\t<releaseDate>2012-05-04</releaseDate>\n" +
                "\t<reviewScore>85</reviewScore>\n" +
                "</VideoGameRequest>";
        given()
                .contentType("application/xml")
                .accept("application/xml ")
                .body(gameBodyXML)
                .when()
                .post(VideoGameEndpoints.ALL_VIDEO_GAMES)
                .then();
    }

    @Test
    public void updateGame (){
        given()
                .body(gameBodyJSON)
                .when()
                .put("videogame/3")
                .then();
    }

    @Test
    public void deleteGame (){
        given()
                .accept("text/plain")
                .when()
                .delete("videogame/3")
                .then();
    }

    @Test
    public  void getSingleGame(){
        given()
                .pathParam("videoGameId",5)
                .when()
                .get(VideoGameEndpoints.SINGLE_VIDEO_GAME)
                .then()
                .body("name",equalTo("The Legend of Zelda: Ocarina of Time"));
    }

    @Test
    public void testVideoGameSerializationByJSON (){
        VideoGame videoGame = new VideoGame("Shooter", "MyGame", "Mature", "2022-13-02", 99);

        given()
                .body(videoGame)
                .when()
                .post(VideoGameEndpoints.ALL_VIDEO_GAMES)
                .then();

    }


}
