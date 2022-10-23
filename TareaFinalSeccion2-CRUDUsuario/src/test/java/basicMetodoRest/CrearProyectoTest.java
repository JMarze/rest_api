package basicMetodoRest;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class CrearProyectoTest {

    @Test
    public void verificarCrearUsuario(){
        given()
                .auth()
                .preemptive()
                .basic("mmsalazar21k@outlook.com","12345")
                .body("{\n" +
                        "\"Email\":\"mmsalazar21k@outlook.com\",\n" +
                        "\"FullName\":\"PruebaCreaUsuario\",\n" +
                        "\"Password\":\"12345\"\n" +
                        "}")
                .log() .all()
                .when()
                .post("https://todo.ly/api/user.json")
                .then()
                .log() .all();

    }
}
